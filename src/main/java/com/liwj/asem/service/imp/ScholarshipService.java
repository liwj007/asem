package com.liwj.asem.service.imp;

import com.liwj.asem.bo.EntireScholarshipForm;
import com.liwj.asem.bo.FileBO;
import com.liwj.asem.bo.NewPrizeItem;
import com.liwj.asem.dao.FlowTemplateMapper;
import com.liwj.asem.dao.PrizeMapper;
import com.liwj.asem.dao.ScholarshipFileMapper;
import com.liwj.asem.dao.ScholarshipMapper;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.enums.LevelNumberEnum;
import com.liwj.asem.enums.LevelTypeEnum;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.enums.StatusEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IScholarshipService;
import com.liwj.asem.service.IUserService;
import com.liwj.asem.utils.PackingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScholarshipService implements IScholarshipService {
    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private ScholarshipFileMapper scholarshipFileMapper;

    @Autowired
    private PrizeMapper prizeMapper;

    @Autowired
    private FlowTemplateMapper flowTemplateMapper;

    @Autowired
    private IUserService userService;

    @Override
    @Transactional
    public void createNewScholarship(User user,EntireScholarshipForm scholarshipBO) {
        String name = scholarshipBO.getName();
        String requirement = scholarshipBO.getRequirement();
        Long templateId = scholarshipBO.getTemplateId();
        List<NewPrizeItem> prizes = scholarshipBO.getPrizes();
        LevelTypeEnum levelType = scholarshipBO.getLevelType();
        Double avgMoney = scholarshipBO.getAvgMoney();
        Integer avgNumber = scholarshipBO.getAvgNumber();
        List<FileBO> files = scholarshipBO.getFiles();

        FlowTemplate flowTemplate = flowTemplateMapper.selectByPrimaryKey(templateId);
        Integer flowType = flowTemplate.getFlowType();

        Scholarship scholarship = new Scholarship();
        scholarship.setName(name);
        scholarship.setRequirement(requirement);
        scholarship.setLevelType(levelType.code);
        scholarship.setFlowTemplateId(templateId);
        scholarship.setStatus(StatusEnum.NEW.code);
        scholarship.setScholarshipType(flowType);
        if (flowType == ScholarshipTypeEnum.COLLEGE.code){
            scholarship.setUnitId(user.getManageCollegeId());
        }
        scholarship.setCreateDate(new Date());

        scholarshipMapper.insertSelective(scholarship);

        for (FileBO file : files) {
            ScholarshipFile scholarshipFile = new ScholarshipFile();
            scholarshipFile.setName(file.getName());
            scholarshipFile.setOriginalName(file.getOriginalName());
            scholarshipFile.setScholarshipId(scholarship.getId());
            scholarshipFileMapper.insertSelective(scholarshipFile);
        }

        if (levelType == LevelTypeEnum.AVG) {
            Prize prize = new Prize();
            if (flowType == ScholarshipTypeEnum.SCHOOL.code){
                prize.setLevelNumber(LevelNumberEnum.SCHOOL.code);
            }else if (flowType == ScholarshipTypeEnum.COLLEGE.code){
                prize.setLevelNumber(LevelNumberEnum.COLLEGE.code);
                prize.setUnitId(user.getManageCollegeId());
            }
            prize.setStatus(StatusEnum.NEW.code);
            prize.setMoney(avgMoney);
            prize.setNumber(avgNumber);
            prize.setPrizeName("无");
            prize.setRestNumber(0);
            prize.setScholarshipId(scholarship.getId());
            prize.setScholarshipType(flowType);
            prize.setAllocationNumberStatus(false);
            prize.setAllocationTimeStatus(false);
            prize.setIsRoot(true);
            prizeMapper.insertSelective(prize);
        } else {
            for (NewPrizeItem bo : prizes) {
                Prize prize = new Prize();
                if (flowType == ScholarshipTypeEnum.SCHOOL.code){
                    prize.setLevelNumber(LevelNumberEnum.SCHOOL.code);
                }else if (flowType == ScholarshipTypeEnum.COLLEGE.code){
                    prize.setLevelNumber(LevelNumberEnum.COLLEGE.code);
                    prize.setUnitId(user.getManageCollegeId());
                }
                prize.setStatus(StatusEnum.NEW.code);
                prize.setMoney(bo.getMoney());
                prize.setNumber(bo.getNumber());
                prize.setPrizeName(bo.getPrizeName());
                prize.setRestNumber(0);
                prize.setScholarshipId(scholarship.getId());
                prize.setScholarshipType(flowType);
                prize.setAllocationNumberStatus(false);
                prize.setAllocationTimeStatus(false);
                prize.setIsRoot(true);
                prizeMapper.insertSelective(prize);
            }
        }
    }

    @Override
    @Transactional
    public EntireScholarshipForm getScholarshipDetailInfo(User user, Long id) throws WSPException {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(id);
        if (scholarship == null) {
            throw new WSPException(ErrorInfo.PARAMS_ERROR);
        }

        EntireScholarshipForm bo = new EntireScholarshipForm();
        bo.setId(scholarship.getId());
        bo.setLevelType(LevelTypeEnum.getByCode(scholarship.getLevelType()));
        bo.setName(scholarship.getName());
        bo.setRequirement(scholarship.getRequirement());
        bo.setTemplateId(scholarship.getFlowTemplateId());
        bo.setScholarshipTypeName(ScholarshipTypeEnum.getNameByCode(scholarship.getScholarshipType()));

        ScholarshipFileExample fileExample = new ScholarshipFileExample();
        fileExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
        List<ScholarshipFile> scholarshipFiles = scholarshipFileMapper.selectByExample(fileExample);
        List<FileBO> files = PackingUtil.packingFileBO(scholarshipFiles);
        bo.setFiles(files);

        PrizeExample prizeExample = new PrizeExample();
        if (userService.isSchoolUser(user)){
            prizeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
            .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code);
        }else if (userService.isCollegeManger(user)){
            if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code){
                prizeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code);
            }else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code){
                prizeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                .andUnitIdEqualTo(user.getManageCollegeId());
            }
        }

        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        if (scholarship.getLevelType() == LevelTypeEnum.AVG.code){
            Prize prize = prizes.get(0);
            bo.setAvgMoney(prize.getMoney());
            bo.setAvgNumber(prize.getNumber());
        } else if (scholarship.getLevelType() == LevelTypeEnum.MULTI.code){
            List<NewPrizeItem> prizeItems = new ArrayList<>();
            for (Prize prize: prizes){
                NewPrizeItem prizeItem = new NewPrizeItem();
                prizeItem.setId(prize.getId());
                prizeItem.setMoney(prize.getMoney());
                prizeItem.setNumber(prize.getNumber());
                prizeItem.setPrizeName(prize.getPrizeName());
                prizeItems.add(prizeItem);
            }
            bo.setPrizes(prizeItems);
        }
        return bo;
    }

    @Override
    @Transactional
    public void deleteScholarship(Long id) throws WSPException {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(id);
        PrizeExample prizeExample = new PrizeExample();
        prizeExample.createCriteria().andScholarshipIdEqualTo(id);
        List<Prize> list = prizeMapper.selectByExample(prizeExample);
        for (Prize prize:list){
            if (prize.getAllocationNumberStatus()==true||prize.getAllocationTimeStatus()==true){
                throw new WSPException(ErrorInfo.CAN_NOT_DELETE_OR_UPDATE);
            }
            prizeMapper.deleteByPrimaryKey(prize.getId());
        }
        ScholarshipFileExample fileExample = new ScholarshipFileExample();
        fileExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
        scholarshipFileMapper.deleteByExample(fileExample);

        scholarshipMapper.deleteByPrimaryKey(scholarship.getId());

    }

    @Override
    @Transactional
    public void updateScholarship(User user,EntireScholarshipForm scholarshipBO) throws WSPException {
        Long scholarshipId = scholarshipBO.getId();
        this.deleteScholarship(scholarshipId);
        this.createNewScholarship(user,scholarshipBO);
    }

    @Override
    @Transactional
    public void openToStudent(User user, Long scholarshipId) {

        PrizeExample prizeExample = new PrizeExample();
        prizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);

        Prize newPrize = new Prize();
        newPrize.setStatus(StatusEnum.OPEN.code);

        prizeMapper.updateByExampleSelective(newPrize,prizeExample);

        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
        scholarship.setStatus(StatusEnum.OPEN.code);
        scholarshipMapper.updateByPrimaryKeySelective(scholarship);
    }

}

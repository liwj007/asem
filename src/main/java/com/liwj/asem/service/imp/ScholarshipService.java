package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.EntireScholarshipForm;
import com.liwj.asem.bo.FileBO;
import com.liwj.asem.bo.NewPrizeItem;
import com.liwj.asem.bo.SelectOfScholarshipBO;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.*;
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
import java.util.HashMap;
import java.util.List;

@Service
public class ScholarshipService implements IScholarshipService {
    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private ScholarshipFileMapper scholarshipFileMapper;

    @Autowired
    private PrizeInfoMapper prizeInfoMapper;

    @Autowired
    private SchoolPrizeMapper schoolPrizeMapper;

    @Autowired
    private CollegePrizeMapper collegePrizeMapper;

    @Autowired
    private GradePrizeMapper gradePrizeMapper;

    @Autowired
    private FlowTemplateMapper flowTemplateMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;

    @Autowired
    private PrizeCollegeLimitTimeMapper prizeCollegeLimitTimeMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createNewScholarship(UserDTO user, EntireScholarshipForm scholarshipBO) {
        String name = scholarshipBO.getName();
        String requirement = scholarshipBO.getRequirement();
        Long templateId = scholarshipBO.getTemplateId();
        List<NewPrizeItem> prizes = scholarshipBO.getPrizes();
        LevelTypeEnum levelType = scholarshipBO.getLevelType();
        Double avgMoney = scholarshipBO.getAvgMoney();
        Integer avgNumber = scholarshipBO.getAvgNumber();
        List<FileBO> files = scholarshipBO.getFiles();
        Long primaryTeachingInstitutionId = scholarshipBO.getPrimaryTeachingInstitutionId();

        FlowTemplate flowTemplate = flowTemplateMapper.selectByPrimaryKey(templateId);
        Integer flowType = flowTemplate.getFlowType();

        Scholarship scholarship = new Scholarship();
        scholarship.setScholarshipName(name);
        scholarship.setRequirement(requirement);
        scholarship.setPrizeType(levelType.code);
        scholarship.setFlowTemplateId(templateId);
        scholarship.setStatus(StatusEnum.NEW.code);
        scholarship.setScholarshipType(flowType);
        if (flowType == ScholarshipTypeEnum.COLLEGE.code) {
            scholarship.setPrimaryTeachingInstitutionId(scholarshipBO.getPrimaryTeachingInstitutionId());
        }
        scholarship.setNeedGradeCheck(flowTemplate.getNeedGradeCheck());
        scholarship.setCreateDate(new Date());
        scholarship.setAllocationTimeStatus(false);
        scholarshipMapper.insertSelective(scholarship);

        for (FileBO file : files) {
            ScholarshipFile scholarshipFile = new ScholarshipFile();
            scholarshipFile.setName(file.getName());
            scholarshipFile.setOriginalName(file.getOriginalName());
            scholarshipFile.setScholarshipId(scholarship.getId());
            scholarshipFileMapper.insertSelective(scholarshipFile);
        }

        if (levelType == LevelTypeEnum.AVG) {
            PrizeInfo prizeInfo = new PrizeInfo();
            prizeInfo.setLevel(0);
            prizeInfo.setMoney(avgMoney);
            prizeInfo.setPrizeName("");
            prizeInfo.setScholarshipId(scholarship.getId());
            prizeInfo.setScholarshipType(scholarship.getScholarshipType());
            prizeInfoMapper.insertSelective(prizeInfo);

            if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                SchoolPrize schoolPrize = new SchoolPrize();
                schoolPrize.setStatus(StatusEnum.NEW.code);
                schoolPrize.setAllocationNumberStatus(false);
                schoolPrize.setCheckStatus(CheckStatusEnum.NEW.code);
                schoolPrize.setPrizeInfoId(prizeInfo.getId());
                schoolPrize.setNumber(avgNumber);
                schoolPrize.setRestNumber(0);
                schoolPrize.setScholarshipId(prizeInfo.getScholarshipId());
                schoolPrize.setScholarshipType(prizeInfo.getScholarshipType());
                schoolPrizeMapper.insertSelective(schoolPrize);
            } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                CollegePrize collegePrize = new CollegePrize();
                collegePrize.setStatus(StatusEnum.NEW.code);
                collegePrize.setAllocationNumberStatus(false);
                collegePrize.setPrizeInfoId(prizeInfo.getId());
                collegePrize.setNumber(avgNumber);
                collegePrize.setPrimaryTeachingInstitutionId(primaryTeachingInstitutionId);
                collegePrize.setRestNumber(0);
                collegePrize.setScholarshipId(prizeInfo.getScholarshipId());
                collegePrize.setScholarshipType(prizeInfo.getScholarshipType());
                collegePrizeMapper.insertSelective(collegePrize);

                PrizeCollegeLimitTime prizeCollegeLimitTime = new PrizeCollegeLimitTime();
                prizeCollegeLimitTime.setPrimaryTeachingInstitutionId(primaryTeachingInstitutionId);
                prizeCollegeLimitTime.setScholarshipId(scholarship.getId());
                prizeCollegeLimitTime.setAllocationTimeStatus(false);
                prizeCollegeLimitTimeMapper.insertSelective(prizeCollegeLimitTime);
            }
        } else {
            for (NewPrizeItem bo : prizes) {
                PrizeInfo prizeInfo = new PrizeInfo();
                prizeInfo.setLevel(bo.getLevel());
                prizeInfo.setMoney(bo.getMoney());
                prizeInfo.setPrizeName(bo.getPrizeName());
                prizeInfo.setScholarshipId(scholarship.getId());
                prizeInfo.setScholarshipType(scholarship.getScholarshipType());
                prizeInfoMapper.insertSelective(prizeInfo);

                if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                    SchoolPrize schoolPrize = new SchoolPrize();
                    schoolPrize.setStatus(StatusEnum.NEW.code);
                    schoolPrize.setAllocationNumberStatus(false);
                    schoolPrize.setCheckStatus(CheckStatusEnum.NEW.code);
                    schoolPrize.setPrizeInfoId(prizeInfo.getId());
                    schoolPrize.setNumber(bo.getNumber());
                    schoolPrize.setRestNumber(0);
                    schoolPrize.setScholarshipId(prizeInfo.getScholarshipId());
                    schoolPrize.setScholarshipType(prizeInfo.getScholarshipType());
                    schoolPrizeMapper.insertSelective(schoolPrize);
                } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                    CollegePrize collegePrize = new CollegePrize();
                    collegePrize.setStatus(StatusEnum.NEW.code);
                    collegePrize.setAllocationNumberStatus(false);
                    collegePrize.setPrizeInfoId(prizeInfo.getId());
                    collegePrize.setNumber(bo.getNumber());
                    collegePrize.setRestNumber(0);
                    collegePrize.setScholarshipId(prizeInfo.getScholarshipId());
                    collegePrize.setScholarshipType(prizeInfo.getScholarshipType());
                    collegePrize.setPrimaryTeachingInstitutionId(primaryTeachingInstitutionId);
                    collegePrizeMapper.insertSelective(collegePrize);

                    PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
                    limitTimeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                            .andPrimaryTeachingInstitutionIdEqualTo(primaryTeachingInstitutionId);
                    Long tmp = prizeCollegeLimitTimeMapper.countByExample(limitTimeExample);
                    if (tmp == 0) {
                        PrizeCollegeLimitTime prizeCollegeLimitTime = new PrizeCollegeLimitTime();
                        prizeCollegeLimitTime.setPrimaryTeachingInstitutionId(primaryTeachingInstitutionId);
                        prizeCollegeLimitTime.setScholarshipId(scholarship.getId());
                        prizeCollegeLimitTime.setAllocationTimeStatus(false);
                        prizeCollegeLimitTimeMapper.insertSelective(prizeCollegeLimitTime);
                    }
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EntireScholarshipForm getScholarshipDetailInfo(UserDTO user, Long id, Long unitId) throws WSPException {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(id);
        if (scholarship == null) {
            throw new WSPException(ErrorInfo.PARAMS_ERROR);
        }

        EntireScholarshipForm bo = new EntireScholarshipForm();
        bo.setId(scholarship.getId());
        bo.setLevelType(LevelTypeEnum.getByCode(scholarship.getPrizeType()));
        bo.setName(scholarship.getScholarshipName());
        bo.setRequirement(scholarship.getRequirement());
        bo.setTemplateId(scholarship.getFlowTemplateId());
        bo.setScholarshipTypeName(ScholarshipTypeEnum.getNameByCode(scholarship.getScholarshipType()));
        bo.setPrimaryTeachingInstitutionId(scholarship.getPrimaryTeachingInstitutionId());
        bo.setScholarshipType(ScholarshipTypeEnum.getByCode(scholarship.getScholarshipType()));

        PrimaryTeachingInstitution institution = primaryTeachingInstitutionMapper.selectByPrimaryKey(scholarship.getPrimaryTeachingInstitutionId());
        if (institution != null) {
            bo.setUnitName(institution.getName());
        }

        ScholarshipFileExample fileExample = new ScholarshipFileExample();
        fileExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
        List<ScholarshipFile> scholarshipFiles = scholarshipFileMapper.selectByExample(fileExample);
        List<FileBO> files = PackingUtil.packingFileBO(scholarshipFiles);
        bo.setFiles(files);

        if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
            List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            if (scholarship.getPrizeType() == LevelTypeEnum.AVG.code) {
                SchoolPrize schoolPrize = schoolPrizes.get(0);
                bo.setAvgNumber(schoolPrize.getNumber());
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
                bo.setAvgMoney(prizeInfo.getMoney());
            } else if (scholarship.getPrizeType() == LevelTypeEnum.MULTI.code) {
                List<NewPrizeItem> prizeItems = new ArrayList<>();
                for (SchoolPrize schoolPrize : schoolPrizes) {
                    NewPrizeItem prizeItem = new NewPrizeItem();
                    prizeItem.setId(schoolPrize.getId());
                    prizeItem.setNumber(schoolPrize.getNumber());
                    PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
                    prizeItem.setPrizeName(prizeInfo.getPrizeName());
                    prizeItem.setMoney(prizeInfo.getMoney());
                    prizeItems.add(prizeItem);
                }
                bo.setPrizes(prizeItems);
            }
        } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            if (scholarship.getPrizeType() == LevelTypeEnum.AVG.code) {
                CollegePrize collegePrize = collegePrizes.get(0);
                bo.setAvgNumber(collegePrize.getNumber());
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
                bo.setAvgMoney(prizeInfo.getMoney());
            } else if (scholarship.getPrizeType() == LevelTypeEnum.MULTI.code) {
                List<NewPrizeItem> prizeItems = new ArrayList<>();
                for (CollegePrize collegePrize : collegePrizes) {
                    NewPrizeItem prizeItem = new NewPrizeItem();
                    prizeItem.setId(collegePrize.getId());
                    prizeItem.setNumber(collegePrize.getNumber());
                    PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
                    prizeItem.setPrizeName(prizeInfo.getPrizeName());
                    prizeItem.setMoney(prizeInfo.getMoney());
                    prizeItems.add(prizeItem);
                }
                bo.setPrizes(prizeItems);
            }
        }
        return bo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteScholarship(Long id) throws WSPException {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(id);
        if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
            List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            for (SchoolPrize schoolPrize : schoolPrizes) {
                if (schoolPrize.getStatus() != StatusEnum.NEW.code) {
                    throw new WSPException(ErrorInfo.CAN_NOT_DELETE_OR_UPDATE);
                }
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
                prizeInfoMapper.deleteByPrimaryKey(prizeInfo.getId());

                schoolPrizeMapper.deleteByPrimaryKey(schoolPrize.getId());
            }
        } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            for (CollegePrize collegePrize : collegePrizes) {
                if (collegePrize.getStatus() != StatusEnum.NEW.code) {
                    throw new WSPException(ErrorInfo.CAN_NOT_DELETE_OR_UPDATE);
                }
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
                prizeInfoMapper.deleteByPrimaryKey(prizeInfo.getId());

                PrizeCollegeLimitTimeExample timeExample = new PrizeCollegeLimitTimeExample();
                timeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                        .andPrimaryTeachingInstitutionIdEqualTo(scholarship.getPrimaryTeachingInstitutionId());
                prizeCollegeLimitTimeMapper.deleteByExample(timeExample);

                collegePrizeMapper.deleteByPrimaryKey(collegePrize.getId());
            }
        }

        ScholarshipFileExample fileExample = new ScholarshipFileExample();
        fileExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
        scholarshipFileMapper.deleteByExample(fileExample);

        scholarshipMapper.deleteByPrimaryKey(scholarship.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateScholarship(UserDTO user, EntireScholarshipForm scholarshipBO) throws WSPException {
        Long scholarshipId = scholarshipBO.getId();
        this.deleteScholarship(scholarshipId);
        this.createNewScholarship(user, scholarshipBO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void openToStudent(UserDTO user, Long scholarshipId) {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
        if (scholarship.getAllocationTimeStatus() == false) {
            return;
        }
        scholarship.setStatus(StatusEnum.OPEN.code);
        scholarshipMapper.updateByPrimaryKeySelective(scholarship);

        if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);

            List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            for (SchoolPrize schoolPrize : schoolPrizes) {
                if (schoolPrize.getAllocationNumberStatus() == false) {
                    continue;
                }
                schoolPrize.setStatus(StatusEnum.OPEN.code);
                schoolPrizeMapper.updateByPrimaryKeySelective(schoolPrize);

                CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
                collegePrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);

                CollegePrize collegePrize = new CollegePrize();
                collegePrize.setStatus(StatusEnum.OPEN.code);

                collegePrizeMapper.updateByExampleSelective(collegePrize, collegePrizeExample);

                GradePrizeExample gradePrizeExample = new GradePrizeExample();
                gradePrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);

                GradePrize gradePrize = new GradePrize();
                gradePrize.setStatus(StatusEnum.OPEN.code);

                gradePrizeMapper.updateByExampleSelective(gradePrize, gradePrizeExample);
            }
        } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);

            for (CollegePrize collegePrize : collegePrizes) {
                if (collegePrize.getAllocationNumberStatus() == false) {
                    continue;
                }
                collegePrize.setStatus(StatusEnum.OPEN.code);
                collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);

                GradePrizeExample gradePrizeExample = new GradePrizeExample();
                gradePrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);

                GradePrize gradePrize = new GradePrize();
                gradePrize.setStatus(StatusEnum.OPEN.code);

                gradePrizeMapper.updateByExampleSelective(gradePrize, gradePrizeExample);
            }
        }


    }

    @Override
    public PageInfo getScholarshipsOfAward(UserDTO user, Integer pageNum, Integer pageSize) {
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andPrizeStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(example);
        if (applications.size() == 0) {
            return new PageInfo();
        }
        HashMap<Long, Integer> scholarshipMap = new HashMap<>();
        for (Application application : applications) {
            if (!scholarshipMap.containsKey(application.getScholarshipId())) {
                scholarshipMap.put(application.getScholarshipId(), 0);
            }
            scholarshipMap.put(application.getScholarshipId(), scholarshipMap.get(application.getScholarshipId()) + 1);
        }
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria().andIdIn(new ArrayList<>(scholarshipMap.keySet()));
        PageHelper.startPage(pageNum,pageSize);
        List<Scholarship> list = scholarshipMapper.selectByExample(scholarshipExample);
        PageInfo pageInfo = new PageInfo(list);
        List<SelectOfScholarshipBO> res = new ArrayList<>();
        for (Scholarship scholarship : list) {
            SelectOfScholarshipBO bo = new SelectOfScholarshipBO();
            bo.setId(scholarship.getId());
            bo.setName(scholarship.getScholarshipName());
            bo.setAwardNumber(scholarshipMap.get(scholarship.getId()));
            bo.setYear("暂无");
            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

}

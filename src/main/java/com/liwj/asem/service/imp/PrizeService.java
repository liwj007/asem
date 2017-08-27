package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.enums.*;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IPrizeService;
import com.liwj.asem.service.IUserService;
import com.liwj.asem.utils.PackingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PrizeService implements IPrizeService {
    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private PrizeMapper prizeMapper;


    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private SchoolTimeLimitMapper schoolTimeLimitMapper;

    @Autowired
    private CollegeTimeLimitMapper collegeTimeLimitMapper;

    @Autowired
    private FlowTemplateInfoMapper flowTemplateInfoMapper;


    @Override
    public PageInfo getManagePrizeLists(User user, Integer pageNum, Integer pageSize) {
        PrizeExample prizeExample = new PrizeExample();
        if (userService.isSchoolUser(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code);

        } else if (userService.isCollegeManger(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andUnitIdEqualTo(user.getManageCollegeId());
        }
        prizeExample.setOrderByClause("`id` ASC");
        PageHelper.startPage(pageNum, pageSize);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        PageInfo pageInfo = new PageInfo(prizes);
        List<PrizeForListBO>  res = packingPrizeForListBO(prizes, false);
        pageInfo.setList(res);
        return pageInfo;
    }

    //allocation number
    @Override
    public List<SelectOfPrizeBO> getSelectOfUnAllocationNumberPrizes(User user) {
        List<SelectOfPrizeBO> res = new ArrayList<>();
        PrizeExample prizeExample = new PrizeExample();
        if (userService.isSchoolUser(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code)
                    .andAllocationNumberStatusEqualTo(false);

        } else if (userService.isCollegeManger(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andUnitIdEqualTo(user.getManageCollegeId())
                    .andAllocationNumberStatusEqualTo(false);
        }
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        for (Prize prize : prizes) {
            PrizeExample example = new PrizeExample();
            example.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andParentPrizeIdEqualTo(prize.getId());
            long number = prizeMapper.countByExample(example);
            if (number == 0) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());
                SelectOfPrizeBO bo = new SelectOfPrizeBO();
                bo.setId(prize.getId());
                bo.setFullName(scholarship.getName() + prize.getPrizeName());
                bo.setScholarshipName(scholarship.getName());
                bo.setPrizeName(prize.getPrizeName());
                bo.setNumber(prize.getNumber());
                bo.setMoney(prize.getMoney());
                bo.setScholarshipId(prize.getScholarshipId());
                res.add(bo);
            }
        }

        return res;
    }

    @Override
    @Transactional
    public void allocationNumber(User user, EntireUnitPrizeForm entireUnitPrizeForm) {
        List<UnitPrizeBO> unitPrizeBOList = entireUnitPrizeForm.getList();
        for (UnitPrizeBO unitPrizeBO : unitPrizeBOList) {
            Prize prize = prizeMapper.selectByPrimaryKey(unitPrizeBO.getPrizeId());
            if (!prize.getAllocationNumberStatus()) {
                prize.setRestNumber(entireUnitPrizeForm.getRestNumber());
                prize.setAllocationRule(entireUnitPrizeForm.getAllocationRule().code);
                prize.setAllocationMethod(entireUnitPrizeForm.getAllocationMethod().code);
                prize.setAllocationNumberStatus(true);
                prizeMapper.updateByPrimaryKeySelective(prize);
            }

            Prize child = new Prize();
            child.setAllocationNumberStatus(false);
            child.setAllocationTimeStatus(false);
            child.setRestNumber(0);
            child.setNumber(unitPrizeBO.getNumber());
            child.setIsRoot(false);
            child.setScholarshipId(prize.getScholarshipId());
            child.setPrizeName(prize.getPrizeName());
            child.setParentPrizeId(prize.getId());
            child.setScholarshipType(prize.getScholarshipType());
            child.setMoney(prize.getMoney());
            if (prize.getLevelNumber() == LevelNumberEnum.SCHOOL.code) {
                child.setStatus(StatusEnum.UNREADY.code);
            } else {
                child.setStatus(StatusEnum.NEW.code);
            }
            child.setUnitId(unitPrizeBO.getUnitId());
            child.setLevelNumber(LevelNumberEnum.getByCode(prize.getLevelNumber() + 1).code);
            prizeMapper.insertSelective(child);
        }
    }

    @Override
    public PageInfo getAllocatedNumberPrizes(User user, Integer pageNum, Integer pageSize) {

        PrizeExample prizeExample = new PrizeExample();
        if (userService.isSchoolUser(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code)
                    .andAllocationNumberStatusEqualTo(true);
        } else if (userService.isCollegeManger(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andUnitIdEqualTo(user.getManageCollegeId())
                    .andAllocationNumberStatusEqualTo(true);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        PageInfo pageInfo = new PageInfo(prizes);
        List<PrizeForListBO> res = packingPrizeForListBO(prizes, true);
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public EntireUnitPrizeForm getAwardDetailOfAllocatedNumber(User user, Long prizeId) throws WSPException {
        EntireUnitPrizeForm form = new EntireUnitPrizeForm();
        Prize prize = prizeMapper.selectByPrimaryKey(prizeId);
        if (prize == null) {
            throw new WSPException(ErrorInfo.PARAMS_ERROR);
        }

        form.setAllocationMethod(AllocationMethodEnum.getByCode(prize.getAllocationMethod()));
        form.setAllocationRule(AllocationRuleEnum.getByCode(prize.getAllocationRule()));
        form.setPrizeName(prize.getPrizeName());
        form.setRestNumber(prize.getRestNumber());
        form.setId(prizeId);
        form.setNumber(prize.getNumber());

        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());
        form.setScholarshipName(scholarship.getName());

        PrizeExample childExample = new PrizeExample();
        childExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                .andParentPrizeIdEqualTo(prizeId);
        List<Prize> children = prizeMapper.selectByExample(childExample);

        for (Prize child : children) {
            UnitPrizeBO bo = new UnitPrizeBO();
            bo.setId(child.getId());
            bo.setNumber(child.getNumber());
            if (child.getLevelNumber() == LevelNumberEnum.COLLEGE.code) {
                College college = collegeMapper.selectByPrimaryKey(child.getUnitId());
                bo.setUnitName(college.getName());
                bo.setUnitNumber(college.getNumber());
            } else if (child.getLevelNumber() == LevelNumberEnum.GRADE.code) {
                Grade grade = gradeMapper.selectByPrimaryKey(child.getUnitId());
                bo.setUnitName(grade.getName());
                bo.setUnitNumber(grade.getNumber());
            }
            form.getList().add(bo);
        }
        return form;
    }

    @Override
    @Transactional
    public void updateAllocationNumber(User user, EntireUnitPrizeForm entireUnitPrizeForm) {
        Prize prize = prizeMapper.selectByPrimaryKey(entireUnitPrizeForm.getId());
        prize.setRestNumber(entireUnitPrizeForm.getRestNumber());
        prize.setAllocationMethod(entireUnitPrizeForm.getAllocationMethod().code);
        prize.setAllocationRule(entireUnitPrizeForm.getAllocationRule().code);
        prizeMapper.updateByPrimaryKeySelective(prize);

        for (UnitPrizeBO bo : entireUnitPrizeForm.getList()) {
            Prize child = prizeMapper.selectByPrimaryKey(bo.getId());
            child.setNumber(bo.getNumber());
            prizeMapper.updateByPrimaryKeySelective(child);
        }
    }


    //allocation time
    @Override
    public List<SelectOfScholarshipBO> getSelectOfUnAllocationTimeScholarships(User user, ScholarshipTypeEnum scholarshipType, Boolean needGrade) {
        List<SelectOfScholarshipBO> res = new ArrayList<>();

        PrizeExample prizeExample = new PrizeExample();
        if (userService.isSchoolUser(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code)
                    .andAllocationTimeStatusEqualTo(false);
        } else if (userService.isCollegeManger(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andUnitIdEqualTo(user.getManageCollegeId())
                    .andAllocationTimeStatusEqualTo(false);
        }
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        if (prizes.size() == 0) {
            return res;
        }
        Set<Long> tmp = new HashSet<>();
        for (Prize prize : prizes) {
            tmp.add(prize.getScholarshipId());
        }
        List<Long> scholarshipIds = new ArrayList<>();
        scholarshipIds.addAll(tmp);

        ScholarshipExample example = new ScholarshipExample();
        ScholarshipExample.Criteria criteria = example.createCriteria();
        criteria.andStatusNotEqualTo(StatusEnum.CLOSE.code).andIdIn(scholarshipIds);
        if (userService.isCollegeManger(user)) {
            FlowTemplateInfoExample flowTemplateInfoExample = new FlowTemplateInfoExample();
            flowTemplateInfoExample.createCriteria().andNeedGradeCheckEqualTo(needGrade);
            List<FlowTemplateInfo> flowTemplateInfos = flowTemplateInfoMapper.selectByExample(flowTemplateInfoExample);
            List<Long> flowTemplatesIds = new ArrayList<>();
            for (FlowTemplateInfo flowTemplateInfo : flowTemplateInfos) {
                flowTemplatesIds.add(flowTemplateInfo.getFlowTemplateId());
            }
            criteria.andFlowTemplateIdIn(flowTemplatesIds);

            criteria.andScholarshipTypeEqualTo(scholarshipType.code);
        }

        List<Scholarship> scholarships = scholarshipMapper.selectByExample(example);

        for (Scholarship scholarship : scholarships) {
            SelectOfScholarshipBO bo = new SelectOfScholarshipBO();
            bo.setId(scholarship.getId());
            bo.setName(scholarship.getName());
            res.add(bo);
        }
        return res;
    }

    @Override
    @Transactional
    public void allocationTime(User user, List<TimeLimitBO> list) throws WSPException {
        if (userService.isSchoolUser(user)) {
            for (TimeLimitBO bo : list) {
                if (bo.getScholarshipId() == null) {
                    throw new WSPException(ErrorInfo.PARAMS_ERROR);
                }

                PrizeExample prizeExample = new PrizeExample();
                prizeExample.createCriteria().andScholarshipIdEqualTo(bo.getScholarshipId())
                        .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code);
                List<Prize> prizes = prizeMapper.selectByExample(prizeExample);

                for (Prize prize : prizes) {

                    prize.setAllocationTimeStatus(true);
                    prizeMapper.updateByPrimaryKeySelective(prize);

                }

                SchoolTimeLimit schoolTimeLimit = new SchoolTimeLimit();
                schoolTimeLimit.setCollegeEndDate(bo.getCollegeEndDate());
                schoolTimeLimit.setStudentBeginDate(bo.getStudentStartDate());
                schoolTimeLimit.setScholarshipId(bo.getScholarshipId());
                schoolTimeLimitMapper.insertSelective(schoolTimeLimit);
            }
        } else if (userService.isCollegeManger(user)) {
            for (TimeLimitBO bo : list) {
                if (bo.getScholarshipId() == null) {
                    throw new WSPException(ErrorInfo.PARAMS_ERROR);
                }

                PrizeExample prizeExample = new PrizeExample();
                prizeExample.createCriteria().andScholarshipIdEqualTo(bo.getScholarshipId())
                        .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                        .andUnitIdEqualTo(user.getManageCollegeId());
                List<Prize> prizes = prizeMapper.selectByExample(prizeExample);

                for (Prize prize : prizes) {
                    prize.setAllocationTimeStatus(true);
                    prizeMapper.updateByPrimaryKeySelective(prize);
                }

                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(bo.getScholarshipId());
                CollegeTimeLimit collegeTimeLimit = new CollegeTimeLimit();
                collegeTimeLimit.setScholarshipId(bo.getScholarshipId());
                collegeTimeLimit.setUnitId(user.getManageCollegeId());
                if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                    collegeTimeLimit.setStudentEndDate(bo.getStudentEndDate());
                    collegeTimeLimit.setGradeEndDate(bo.getGradeEndDate());
                } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                    collegeTimeLimit.setStudentBeginDate(bo.getStudentStartDate());
                    collegeTimeLimit.setStudentEndDate(bo.getStudentEndDate());
                    collegeTimeLimit.setGradeEndDate(bo.getGradeEndDate());
                } else {
                    throw new WSPException(ErrorInfo.PARAMS_ERROR);
                }
                collegeTimeLimitMapper.insertSelective(collegeTimeLimit);
            }
        }
    }

    @Override
    public PageInfo getScholarshipsOfAllocatedTime(User user, Integer pageNum, Integer pageSize) {
        List<ScholarshipForListBO> res = new ArrayList<>();
        PageInfo pageInfo;
        if (userService.isSchoolUser(user)) {
            PrizeExample prizeExample = new PrizeExample();
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code)
                    .andAllocationTimeStatusEqualTo(true);
            List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
            List<Long> scholarshipIds = PackingUtil.extraScholarshipIds(prizes);
            if (scholarshipIds.size() == 0) {
                return new PageInfo();
            }
            ScholarshipExample scholarshipExample = new ScholarshipExample();
            scholarshipExample.createCriteria().andIdIn(scholarshipIds);
            PageHelper.startPage(pageNum, pageSize);
            List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
            pageInfo  = new PageInfo(scholarships);
            for (Scholarship scholarship : scholarships) {
                ScholarshipForListBO bo = new ScholarshipForListBO();
                bo.setId(scholarship.getId());
                bo.setScholarshipName(scholarship.getName());

                SchoolTimeLimitExample schoolTimeLimitExample = new SchoolTimeLimitExample();
                schoolTimeLimitExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
                List<SchoolTimeLimit> limitList = schoolTimeLimitMapper.selectByExample(schoolTimeLimitExample);
                if (limitList.size() == 1) {
                    SchoolTimeLimit schoolTimeLimit = limitList.get(0);
                    bo.setStudentBeginDate(schoolTimeLimit.getStudentBeginDate());
                    bo.setCollegeEndDate(schoolTimeLimit.getCollegeEndDate());
                }
                res.add(bo);
            }
        } else if (userService.isCollegeManger(user)) {
            PrizeExample prizeExample = new PrizeExample();
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andUnitIdEqualTo(user.getManageCollegeId())
                    .andAllocationTimeStatusEqualTo(true);
            List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
            List<Long> scholarshipIds = PackingUtil.extraScholarshipIds(prizes);
            if (scholarshipIds.size() == 0) {
                return new PageInfo();
            }
            ScholarshipExample scholarshipExample = new ScholarshipExample();
            scholarshipExample.createCriteria().andIdIn(scholarshipIds);
            PageHelper.startPage(pageNum, pageSize);
            List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
            pageInfo  = new PageInfo(scholarships);
            for (Scholarship scholarship : scholarships) {
                ScholarshipForListBO bo = new ScholarshipForListBO();
                bo.setId(scholarship.getId());
                bo.setScholarshipName(scholarship.getName());

                CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
                collegeTimeLimitExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
                List<CollegeTimeLimit> list = collegeTimeLimitMapper.selectByExample(collegeTimeLimitExample);
                if (list.size() == 1) {
                    CollegeTimeLimit collegeTimeLimit = list.get(0);
                    if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                        bo.setStudentBeginDate(collegeTimeLimit.getStudentBeginDate());
                        bo.setStudentEndDate(collegeTimeLimit.getStudentEndDate());
                        bo.setGradeEndDate(collegeTimeLimit.getGradeEndDate());
                    } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                        bo.setStudentEndDate(collegeTimeLimit.getStudentEndDate());
                        bo.setGradeEndDate(collegeTimeLimit.getGradeEndDate());

                        SchoolTimeLimitExample schoolTimeLimitExample = new SchoolTimeLimitExample();
                        schoolTimeLimitExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId());
                        List<SchoolTimeLimit> limitList = schoolTimeLimitMapper.selectByExample(schoolTimeLimitExample);
                        if (limitList.size() == 1) {
                            SchoolTimeLimit schoolTimeLimit = limitList.get(0);
                            bo.setStudentBeginDate(schoolTimeLimit.getStudentBeginDate());
                            bo.setCollegeEndDate(schoolTimeLimit.getCollegeEndDate());
                        }
                    }
                }
                res.add(bo);
            }
        }
        pageInfo  = new PageInfo(res);
        return pageInfo;
    }

    @Override
    public TimeLimitBO getDetailOfAllocatedTime(User user, Long id) {
        TimeLimitBO timeLimitBO = new TimeLimitBO();
        if (userService.isSchoolUser(user)) {
            SchoolTimeLimitExample schoolTimeLimitExample = new SchoolTimeLimitExample();
            schoolTimeLimitExample.createCriteria().andScholarshipIdEqualTo(id);
            List<SchoolTimeLimit> list = schoolTimeLimitMapper.selectByExample(schoolTimeLimitExample);
            if (list.size() == 1) {
                SchoolTimeLimit schoolTimeLimit = list.get(0);
                timeLimitBO.setCollegeEndDate(schoolTimeLimit.getCollegeEndDate());
                timeLimitBO.setStudentStartDate(schoolTimeLimit.getStudentBeginDate());
                timeLimitBO.setId(schoolTimeLimit.getId());
            }
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(id);
            timeLimitBO.setScholarshipName(scholarship.getName());
        } else if (userService.isCollegeManger(user)) {
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(id);
            timeLimitBO.setScholarshipName(scholarship.getName());
            if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                SchoolTimeLimitExample schoolTimeLimitExample = new SchoolTimeLimitExample();
                schoolTimeLimitExample.createCriteria().andScholarshipIdEqualTo(id);
                List<SchoolTimeLimit> list2 = schoolTimeLimitMapper.selectByExample(schoolTimeLimitExample);
                if (list2.size() == 1) {
                    SchoolTimeLimit schoolTimeLimit = list2.get(0);
                    timeLimitBO.setCollegeEndDate(schoolTimeLimit.getCollegeEndDate());
                    timeLimitBO.setStudentStartDate(schoolTimeLimit.getStudentBeginDate());
                }
            }

            CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
            collegeTimeLimitExample.createCriteria().andScholarshipIdEqualTo(id)
                    .andUnitIdEqualTo(user.getManageCollegeId());
            List<CollegeTimeLimit> list = collegeTimeLimitMapper.selectByExample(collegeTimeLimitExample);
            if (list.size() == 1) {
                CollegeTimeLimit collegeTimeLimit = list.get(0);
                timeLimitBO.setId(collegeTimeLimit.getId());
                if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                    timeLimitBO.setGradeEndDate(collegeTimeLimit.getGradeEndDate());
                    timeLimitBO.setStudentEndDate(collegeTimeLimit.getStudentEndDate());
                } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                    timeLimitBO.setGradeEndDate(collegeTimeLimit.getGradeEndDate());
                    timeLimitBO.setStudentEndDate(collegeTimeLimit.getStudentEndDate());
                    timeLimitBO.setStudentStartDate(collegeTimeLimit.getStudentBeginDate());
                    timeLimitBO.setId(collegeTimeLimit.getId());
                }
            }

            Boolean needGrade = needGrade(scholarship.getId());
            timeLimitBO.setNeedGrade(needGrade);
            timeLimitBO.setScholarshipType(ScholarshipTypeEnum.getByCode(scholarship.getScholarshipType()));
        }
        timeLimitBO.setScholarshipId(id);
        return timeLimitBO;
    }

    private Boolean needGrade(Long scholarshipId) {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
        FlowTemplateInfoExample flowTemplateInfoExample = new FlowTemplateInfoExample();
        flowTemplateInfoExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
        List<FlowTemplateInfo> list = flowTemplateInfoMapper.selectByExample(flowTemplateInfoExample);
        if (list.size() == 1) {
            FlowTemplateInfo info = list.get(0);
            return info.getNeedGradeCheck();
        }
        return false;
    }

    @Override
    @Transactional
    public void updateAllocationTime(User user, TimeLimitBO timeLimitBO) {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(timeLimitBO.getScholarshipId());
        if (userService.isSchoolUser(user)) {
            SchoolTimeLimit schoolTimeLimit = schoolTimeLimitMapper.selectByPrimaryKey(timeLimitBO.getId());
            schoolTimeLimit.setCollegeEndDate(timeLimitBO.getCollegeEndDate());
            schoolTimeLimit.setStudentBeginDate(timeLimitBO.getStudentStartDate());
            schoolTimeLimitMapper.updateByPrimaryKeySelective(schoolTimeLimit);
        } else if (userService.isCollegeManger(user)) {
            CollegeTimeLimit collegeTimeLimit = collegeTimeLimitMapper.selectByPrimaryKey(timeLimitBO.getId());
            if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                collegeTimeLimit.setGradeEndDate(timeLimitBO.getGradeEndDate());
                collegeTimeLimit.setStudentEndDate(timeLimitBO.getStudentEndDate());
            } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                collegeTimeLimit.setGradeEndDate(timeLimitBO.getGradeEndDate());
                collegeTimeLimit.setStudentEndDate(timeLimitBO.getStudentEndDate());
                collegeTimeLimit.setStudentBeginDate(timeLimitBO.getStudentStartDate());
            }
            collegeTimeLimitMapper.updateByPrimaryKey(collegeTimeLimit);
        }
    }

    @Override
    public void releaseToCollege(List<Long> prizeList) {
        for (Long id : prizeList) {
            Prize prize = prizeMapper.selectByPrimaryKey(id);
            prize.setStatus(StatusEnum.RELEASE.code);
            prizeMapper.updateByPrimaryKeySelective(prize);

            PrizeExample prizeExample = new PrizeExample();
            prizeExample.createCriteria().andParentPrizeIdEqualTo(prize.getId());

            Prize updatePrize = new Prize();
            updatePrize.setStatus(StatusEnum.NEW.code);

            prizeMapper.updateByExampleSelective(updatePrize, prizeExample);
        }
    }

    @Override
    public List<SelectOfScholarshipBO> getScholarshipSelectionForQuotaFeedback(User user) {
        Long unitId = user.getManageCollegeId();
        PrizeExample prizeExample = new PrizeExample();
        prizeExample.createCriteria().andUnitIdEqualTo(unitId).andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code)
                .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code).andStatusNotEqualTo(StatusEnum.UNREADY.code)
                .andStatusNotEqualTo(StatusEnum.CLOSE.code);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        HashMap<Long, SelectOfScholarshipBO> map = new HashMap<>();
        for (Prize prize : prizes) {
            Long scholarshipId = prize.getScholarshipId();
            if (!map.containsKey(scholarshipId)){
                map.put(scholarshipId,new SelectOfScholarshipBO());
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
                map.get(scholarshipId).setId(scholarshipId);
                map.get(scholarshipId).setName(scholarship.getName());
            }
            SelectOfPrizeBO selectOfPrizeBO = new SelectOfPrizeBO();
            selectOfPrizeBO.setId(prize.getId());
            selectOfPrizeBO.setPrizeName(prize.getPrizeName());
            map.get(scholarshipId).getPrizes().add(selectOfPrizeBO);
        }
        List<SelectOfScholarshipBO> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }


    private List<PrizeForListBO> packingPrizeForListBO(List<Prize> prizes, boolean needNumber) {
        List<PrizeForListBO> res = new ArrayList<>();
        for (Prize prize : prizes) {
            PrizeForListBO bo = new PrizeForListBO();
            bo.setId(prize.getId());
            bo.setPrizeName(prize.getPrizeName());
            bo.setScholarshipTypeName(ScholarshipTypeEnum.getNameByCode(prize.getScholarshipType()));
            bo.setScholarshipType(ScholarshipTypeEnum.getByCode(prize.getScholarshipType()).name());
            bo.setMoney(prize.getMoney());
            bo.setNumber(prize.getNumber());
            bo.setAllocationStatus(prize.getAllocationNumberStatus());
            bo.setTimeStatus(prize.getAllocationTimeStatus());
            bo.setStatus(StatusEnum.getNameByCode(prize.getStatus()));
            bo.setRestNumber(prize.getRestNumber());
            bo.setAvailableNumber(prize.getNumber() - prize.getRestNumber());
            if (needNumber) {
                PrizeExample prizeExample = new PrizeExample();
                prizeExample.createCriteria().andParentPrizeIdEqualTo(prize.getId());
                List<Prize> children = prizeMapper.selectByExample(prizeExample);
                Integer total = 0;
                for (Prize child : children) {
                    total += child.getNumber();
                }
                bo.setUsedNumber(total);
            }


            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());
            bo.setScholarshipName(scholarship.getName());
            bo.setScholarshipId(scholarship.getId());
            res.add(bo);
        }
        return res;
    }
}

package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.*;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IOrganizationService;
import com.liwj.asem.service.IPrizeService;
import com.liwj.asem.service.IUserService;
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
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private CollegeTimeLimitMapper collegeTimeLimitMapper;


    @Override
    public PageInfo getManagePrizeLists(UserDTO user, Integer pageNum, Integer pageSize, Long unitId) {
        PrizeExample prizeExample = new PrizeExample();
        if (userService.isSchoolUser(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code);

        } else if (userService.isCollegeManger(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andPrimaryTeachingInstitutionIdEqualTo(unitId);
        }
        prizeExample.setOrderByClause("`id` ASC");
        PageHelper.startPage(pageNum, pageSize);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        PageInfo pageInfo = new PageInfo(prizes);
        List<PrizeForListBO> res = packingPrizeForListBO(prizes, false, unitId);
        pageInfo.setList(res);
        return pageInfo;
    }

    //allocation number
    @Override
    public List<SelectOfPrizeBO> getSelectOfUnAllocationNumberPrizes(UserDTO user, Long unitId) {
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
                    .andPrimaryTeachingInstitutionIdEqualTo(unitId)
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
                bo.setFullName(scholarship.getScholarshipName() + prize.getPrizeName());
                bo.setScholarshipName(scholarship.getScholarshipName());
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
    public void allocationNumber(UserDTO user, EntireUnitPrizeForm entireUnitPrizeForm) {
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

            if (userService.isSchoolUser(user)) {
                child.setPrimaryTeachingInstitutionId(unitPrizeBO.getUnitId());
            } else if (userService.isCollegeManger(user)) {
                child.setPrimaryTeachingInstitutionId(prize.getPrimaryTeachingInstitutionId());
                child.setGradeId(unitPrizeBO.getUnitId());
            }


            child.setLevelNumber(LevelNumberEnum.getByCode(prize.getLevelNumber() + 1).code);
            prizeMapper.insertSelective(child);
        }
    }

    @Override
    public PageInfo getAllocatedNumberPrizes(UserDTO user, Integer pageNum, Integer pageSize, Long unitId) {

        PrizeExample prizeExample = new PrizeExample();
        if (userService.isSchoolUser(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.SCHOOL.code)
                    .andAllocationNumberStatusEqualTo(true);
        } else if (userService.isCollegeManger(user)) {
            prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andPrimaryTeachingInstitutionIdEqualTo(unitId)
                    .andAllocationNumberStatusEqualTo(true);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        PageInfo pageInfo = new PageInfo(prizes);
        List<PrizeForListBO> res = packingPrizeForListBO(prizes, true, unitId);
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public EntireUnitPrizeForm getAwardDetailOfAllocatedNumber(UserDTO user, Long prizeId) throws WSPException {
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
        form.setScholarshipName(scholarship.getScholarshipName());

        PrizeExample childExample = new PrizeExample();
        childExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                .andParentPrizeIdEqualTo(prizeId);
        List<Prize> children = prizeMapper.selectByExample(childExample);

        for (Prize child : children) {
            UnitPrizeBO bo = new UnitPrizeBO();
            bo.setId(child.getId());
            bo.setNumber(child.getNumber());
            if (child.getLevelNumber() == LevelNumberEnum.COLLEGE.code) {
                PrimaryTeachingInstitution college = primaryTeachingInstitutionMapper
                        .selectByPrimaryKey(child.getPrimaryTeachingInstitutionId());
                bo.setUnitName(college.getName());
                bo.setUnitNumber(organizationService.getNumberOfPrimaryTeachingInstitution(college.getId()));
            } else if (child.getLevelNumber() == LevelNumberEnum.GRADE.code) {
                Grade grade = gradeMapper.selectByPrimaryKey(child.getGradeId());
                bo.setUnitName(grade.getName());
                bo.setUnitNumber(organizationService.getNumberOfGrade(grade.getId()));
            }
            form.getList().add(bo);
        }
        return form;
    }

    @Override
    @Transactional
    public void updateAllocationNumber(UserDTO user, EntireUnitPrizeForm entireUnitPrizeForm) {
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
    public List<SelectOfScholarshipBO> getSelectOfUnAllocationTimeScholarships(UserDTO user,
                                                                               ScholarshipTypeEnum scholarshipType,
                                                                               Boolean needGrade, Long unitId) {
        List<SelectOfScholarshipBO> res = new ArrayList<>();
        List<Scholarship> scholarships = null;
        if (userService.isSchoolUser(user)) {
            ScholarshipExample example = new ScholarshipExample();
            ScholarshipExample.Criteria criteria = example.createCriteria();
            criteria.andStatusNotEqualTo(StatusEnum.CLOSE.code).andAllocationTimeStatusEqualTo(false)
                    .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code);
            scholarships = scholarshipMapper.selectByExample(example);

        } else if (userService.isCollegeManger(user)) {
            if (scholarshipType == ScholarshipTypeEnum.COLLEGE) {
                ScholarshipExample example = new ScholarshipExample();
                ScholarshipExample.Criteria criteria = example.createCriteria();
                criteria.andStatusNotEqualTo(StatusEnum.CLOSE.code).andAllocationTimeStatusEqualTo(false)
                        .andScholarshipTypeEqualTo(ScholarshipTypeEnum.COLLEGE.code).andNeedGradeCheckEqualTo(needGrade)
                        .andPrimaryTeachingInstitutionIdEqualTo(unitId);
                scholarships = scholarshipMapper.selectByExample(example);
            } else if (scholarshipType == ScholarshipTypeEnum.SCHOOL) {
                PrizeExample prizeExample = new PrizeExample();
                prizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                        .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                        .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                        .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code)
                        .andPrimaryTeachingInstitutionIdEqualTo(unitId)
                        .andAllocationCollegeTimeStatusEqualTo(false);
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
                criteria.andStatusNotEqualTo(StatusEnum.CLOSE.code).andIdIn(scholarshipIds)
                        .andNeedGradeCheckEqualTo(needGrade);

                scholarships = scholarshipMapper.selectByExample(example);
            }
        }

        if (scholarships != null) {
            for (Scholarship scholarship : scholarships) {
                SelectOfScholarshipBO bo = new SelectOfScholarshipBO();
                bo.setId(scholarship.getId());
                bo.setName(scholarship.getScholarshipName());
                res.add(bo);
            }
        }
        return res;
    }

    @Override
    @Transactional
    public void allocationTime(UserDTO user, List<TimeLimitBO> list) throws WSPException {
        if (userService.isSchoolUser(user)) {
            for (TimeLimitBO bo : list) {
                if (bo.getScholarshipId() == null) {
                    throw new WSPException(ErrorInfo.PARAMS_ERROR);
                }

                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(bo.getScholarshipId());
                scholarship.setAllocationTimeStatus(true);
                scholarship.setStudentBeginDate(bo.getStudentStartDate());
                scholarship.setCollegeEndDate(bo.getCollegeEndDate());
                scholarshipMapper.updateByPrimaryKeySelective(scholarship);
            }
        } else if (userService.isCollegeManger(user)) {
            for (TimeLimitBO bo : list) {
                if (bo.getScholarshipId() == null) {
                    throw new WSPException(ErrorInfo.PARAMS_ERROR);
                }

                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(bo.getScholarshipId());
                if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                    scholarship.setAllocationTimeStatus(true);
                    scholarship.setStudentBeginDate(bo.getStudentStartDate());
                    scholarshipMapper.updateByPrimaryKeySelective(scholarship);
                }

                CollegeTimeLimit collegeTimeLimit = new CollegeTimeLimit();
                collegeTimeLimit.setScholarshipId(bo.getScholarshipId());

                if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
                    collegeTimeLimit.setStudentEndDate(bo.getStudentEndDate());
                    collegeTimeLimit.setGradeEndDate(bo.getGradeEndDate());
                    collegeTimeLimit.setPrimaryTeachingInstitutionId(bo.getManageUnit());

                    PrizeExample prizeExample = new PrizeExample();
                    prizeExample.createCriteria()
                            .andPrimaryTeachingInstitutionIdEqualTo(bo.getManageUnit())
                            .andScholarshipIdEqualTo(scholarship.getId())
                            .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code);
                    List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
                    for (Prize prize:prizes){
                        prize.setAllocationCollegeTimeStatus(true);
                        prizeMapper.updateByPrimaryKeySelective(prize);
                    }
                } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                    collegeTimeLimit.setPrimaryTeachingInstitutionId(scholarship.getPrimaryTeachingInstitutionId());
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
    public PageInfo getScholarshipsOfAllocatedTime(UserDTO user, Integer pageNum, Integer pageSize, Long unitId) {
        List<ScholarshipForListBO> res = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();
        if (userService.isSchoolUser(user)) {

            ScholarshipExample scholarshipExample = new ScholarshipExample();
            scholarshipExample.createCriteria().andAllocationTimeStatusEqualTo(true)
                    .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code);
            PageHelper.startPage(pageNum, pageSize);
            List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
            pageInfo = new PageInfo(scholarships);
            for (Scholarship scholarship : scholarships) {
                ScholarshipForListBO bo = new ScholarshipForListBO();
                bo.setId(scholarship.getId());
                bo.setScholarshipName(scholarship.getScholarshipName());

                bo.setStudentBeginDate(scholarship.getStudentBeginDate());
                bo.setCollegeEndDate(scholarship.getCollegeEndDate());
                res.add(bo);
            }
        } else if (userService.isCollegeManger(user)) {
            CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
            collegeTimeLimitExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(unitId);
            List<CollegeTimeLimit> list = collegeTimeLimitMapper.selectByExample(collegeTimeLimitExample);
            List<Long> scholarshipIds = new ArrayList<>();
            if (list.size() > 0) {
                for (CollegeTimeLimit timeLimit : list) {
                    scholarshipIds.add(timeLimit.getScholarshipId());
                }

                ScholarshipExample scholarshipExample = new ScholarshipExample();
                scholarshipExample.createCriteria().andIdIn(scholarshipIds);
                PageHelper.startPage(pageNum, pageSize);
                List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
                for (Scholarship scholarship : scholarships) {
                    ScholarshipForListBO bo = new ScholarshipForListBO();
                    bo.setId(scholarship.getId());
                    bo.setScholarshipName(scholarship.getScholarshipName());
                    bo.setStudentBeginDate(scholarship.getStudentBeginDate());
                    bo.setCollegeEndDate(scholarship.getCollegeEndDate());

                    CollegeTimeLimitExample example = new CollegeTimeLimitExample();
                    example.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                            .andPrimaryTeachingInstitutionIdEqualTo(unitId);
                    List<CollegeTimeLimit> list2 = collegeTimeLimitMapper.selectByExample(example);
                    if (list2.size() == 1) {
                        CollegeTimeLimit collegeTimeLimit = list2.get(0);
                        bo.setStudentEndDate(collegeTimeLimit.getStudentEndDate());
                        bo.setGradeEndDate(collegeTimeLimit.getGradeEndDate());
                    }
                    res.add(bo);
                }
            }

        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public TimeLimitBO getDetailOfAllocatedTime(UserDTO user, Long scholarshipId, Long unitId) {
        TimeLimitBO timeLimitBO = new TimeLimitBO();

        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
        timeLimitBO.setCollegeEndDate(scholarship.getCollegeEndDate());
        timeLimitBO.setStudentStartDate(scholarship.getStudentBeginDate());
        timeLimitBO.setScholarshipId(scholarship.getId());
        timeLimitBO.setScholarshipName(scholarship.getScholarshipName());

        if (userService.isCollegeManger(user)) {

            CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
            collegeTimeLimitExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                    .andPrimaryTeachingInstitutionIdEqualTo(unitId);
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
                    timeLimitBO.setId(collegeTimeLimit.getId());
                }
            }

            Boolean needGrade = scholarship.getNeedGradeCheck();
            timeLimitBO.setNeedGrade(needGrade);
            timeLimitBO.setScholarshipType(ScholarshipTypeEnum.getByCode(scholarship.getScholarshipType()));
        }
        timeLimitBO.setScholarshipId(scholarshipId);
        return timeLimitBO;
    }

    @Override
    @Transactional
    public void updateAllocationTime(UserDTO user, TimeLimitBO timeLimitBO) {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(timeLimitBO.getScholarshipId());
        if (userService.isSchoolUser(user)) {
            scholarship.setCollegeEndDate(timeLimitBO.getCollegeEndDate());
            scholarship.setStudentBeginDate(timeLimitBO.getStudentStartDate());
            scholarshipMapper.updateByPrimaryKeySelective(scholarship);
        } else if (userService.isCollegeManger(user)) {
            CollegeTimeLimit collegeTimeLimit = collegeTimeLimitMapper.selectByPrimaryKey(timeLimitBO.getId());

            collegeTimeLimit.setGradeEndDate(timeLimitBO.getGradeEndDate());
            collegeTimeLimit.setStudentEndDate(timeLimitBO.getStudentEndDate());
            collegeTimeLimitMapper.updateByPrimaryKey(collegeTimeLimit);
            if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                scholarship.setCollegeEndDate(timeLimitBO.getCollegeEndDate());
                scholarship.setStudentBeginDate(timeLimitBO.getStudentStartDate());
                scholarshipMapper.updateByPrimaryKeySelective(scholarship);
            }

        }
    }

    @Override
    @Transactional
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
    public List<SelectOfScholarshipBO> getScholarshipSelectionForQuotaFeedback(UserDTO user, Long unitId) {
        PrizeExample prizeExample = new PrizeExample();
        prizeExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(unitId)
                .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code)
                .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code).andStatusNotEqualTo(StatusEnum.UNREADY.code)
                .andStatusNotEqualTo(StatusEnum.CLOSE.code);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        HashMap<Long, SelectOfScholarshipBO> map = new HashMap<>();
        for (Prize prize : prizes) {
            Long scholarshipId = prize.getScholarshipId();
            if (!map.containsKey(scholarshipId)) {
                map.put(scholarshipId, new SelectOfScholarshipBO());
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
                map.get(scholarshipId).setId(scholarshipId);
                map.get(scholarshipId).setName(scholarship.getScholarshipName());
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


    private List<PrizeForListBO> packingPrizeForListBO(List<Prize> prizes, boolean needNumber, Long unitId) {
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

            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());
            if (prize.getIsRoot() == true) {
                bo.setTimeStatus(scholarship.getAllocationTimeStatus());
            } else {
                bo.setTimeStatus(prize.getAllocationCollegeTimeStatus());
            }

            bo.setScholarshipName(scholarship.getScholarshipName());
            bo.setScholarshipId(scholarship.getId());

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


            res.add(bo);
        }
        return res;
    }
}

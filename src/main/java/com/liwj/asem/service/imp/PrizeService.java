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
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
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
    private PrizeInfoMapper prizeInfoMapper;

    @Autowired
    private SchoolPrizeMapper schoolPrizeMapper;

    @Autowired
    private CollegePrizeMapper collegePrizeMapper;

    @Autowired
    private GradePrizeMapper gradePrizeMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private PrizeCollegeLimitTimeMapper prizeCollegeLimitTimeMapper;


    /**
     * 学院或学校用户获取管理的奖学金（等级）列表
     * @param user
     * @param pageNum
     * @param pageSize
     * @param unitId
     * @return
     * @throws WSPException
     */
    @Override
    public PageInfo getManagePrizeLists(UserDTO user, Integer pageNum, Integer pageSize, Long unitId) throws WSPException {
        if (userService.isSchoolUser(user)) {
            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code);
            schoolPrizeExample.setOrderByClause("create_date desc, prize_info_id asc");
            PageHelper.startPage(pageNum, pageSize);
            List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            PageInfo pageInfo = new PageInfo(schoolPrizes);
            List<PrizeForListBO> res = packingSchoolPrizeForListBO(schoolPrizes, false);
            pageInfo.setList(res);
            return pageInfo;
        } else if (userService.isCollegeManger(user)) {
            if (unitId == null) {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andCollegeIdEqualTo(unitId)
                    .andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code);
            collegePrizeExample.setOrderByClause("create_date desc, prize_info_id asc");
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            PageInfo pageInfo = new PageInfo(collegePrizes);
            List<PrizeForListBO> res = packingCollegePrizeForListBO(collegePrizes, false, unitId);
            pageInfo.setList(res);
            return pageInfo;
        }
        return new PageInfo();
    }

    //allocation number
    @Override
    public List<SelectOfPrizeBO> getSelectOfUnAllocationNumberPrizes(UserDTO user, Long unitId) {
        List<SelectOfPrizeBO> res = new ArrayList<>();
        if (userService.isSchoolUser(user)) {
            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andAllocationNumberStatusEqualTo(false);
            List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            for (SchoolPrize schoolPrize : schoolPrizes) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(schoolPrize.getScholarshipId());
                SelectOfPrizeBO bo = new SelectOfPrizeBO();
                bo.setId(schoolPrize.getId());
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
                bo.setFullName(scholarship.getScholarshipName() + prizeInfo.getPrizeName());
                bo.setScholarshipName(scholarship.getScholarshipName());
                bo.setPrizeName(prizeInfo.getPrizeName());
                bo.setNumber(schoolPrize.getNumber());
                bo.setMoney(prizeInfo.getMoney());
                bo.setScholarshipId(schoolPrize.getScholarshipId());
                res.add(bo);
            }
        } else if (userService.isCollegeManger(user)) {
            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andCollegeIdEqualTo(unitId)
                    .andStatusNotEqualTo(StatusEnum.CLOSE.code).andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andAllocationNumberStatusEqualTo(false);
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            for (CollegePrize collegePrize : collegePrizes) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
                SelectOfPrizeBO bo = new SelectOfPrizeBO();
                bo.setId(collegePrize.getId());
                bo.setFullName(scholarship.getScholarshipName() + prizeInfo.getPrizeName());
                bo.setScholarshipName(scholarship.getScholarshipName());
                bo.setPrizeName(prizeInfo.getPrizeName());
                bo.setNumber(collegePrize.getNumber());
                bo.setMoney(prizeInfo.getMoney());
                bo.setScholarshipId(collegePrize.getScholarshipId());
                res.add(bo);
            }
        }
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allocationNumber(UserDTO user, EntireUnitPrizeForm entireUnitPrizeForm) {
        List<UnitPrizeBO> unitPrizeBOList = entireUnitPrizeForm.getList();
        if (userService.isSchoolUser(user)) {
            for (UnitPrizeBO unitPrizeBO : unitPrizeBOList) {
                SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(unitPrizeBO.getPrizeId());
                if (!schoolPrize.getAllocationNumberStatus()) {
                    schoolPrize.setRestNumber(entireUnitPrizeForm.getRestNumber());
                    schoolPrize.setAllocationRule(entireUnitPrizeForm.getAllocationRule().code);
                    schoolPrize.setAllocationMethod(entireUnitPrizeForm.getAllocationMethod().code);
                    schoolPrize.setAllocationNumberStatus(true);
                    schoolPrize.setAllocationDate(new Date());
                    schoolPrizeMapper.updateByPrimaryKeySelective(schoolPrize);
                }

                CollegePrize collegePrize = new CollegePrize();
                collegePrize.setAllocationNumberStatus(false);
                collegePrize.setRestNumber(0);
                collegePrize.setNumber(unitPrizeBO.getNumber());
                collegePrize.setPrizeInfoId(schoolPrize.getPrizeInfoId());
                collegePrize.setScholarshipId(schoolPrize.getScholarshipId());
                collegePrize.setCollegeId(unitPrizeBO.getUnitId());
                collegePrize.setScholarshipType(schoolPrize.getScholarshipType());
                collegePrize.setSchoolPrizeId(schoolPrize.getId());
                collegePrize.setStatus(StatusEnum.UNREADY.code);
                collegePrize.setCreateDate(new Date());
                collegePrizeMapper.insertSelective(collegePrize);
            }
        } else if (userService.isCollegeManger(user)) {
            for (UnitPrizeBO unitPrizeBO : unitPrizeBOList) {
                CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(unitPrizeBO.getPrizeId());
                if (!collegePrize.getAllocationNumberStatus()) {
                    collegePrize.setRestNumber(entireUnitPrizeForm.getRestNumber());
                    collegePrize.setAllocationRule(entireUnitPrizeForm.getAllocationRule().code);
                    collegePrize.setAllocationMethod(entireUnitPrizeForm.getAllocationMethod().code);
                    collegePrize.setAllocationNumberStatus(true);
                    collegePrize.setAllocationDate(new Date());
                    collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
                }

                GradePrize gradePrize = new GradePrize();
                gradePrize.setNumber(unitPrizeBO.getNumber());
                gradePrize.setPrizeInfoId(collegePrize.getPrizeInfoId());
                gradePrize.setScholarshipId(collegePrize.getScholarshipId());
                gradePrize.setCollegeId(collegePrize.getCollegeId());
                gradePrize.setGrade(unitPrizeBO.getUnitId().toString());
                gradePrize.setScholarshipType(collegePrize.getScholarshipType());
                if (collegePrize.getStatus()==StatusEnum.OPEN.code){
                    gradePrize.setStatus(StatusEnum.OPEN.code);
                }else{
                    gradePrize.setStatus(StatusEnum.NEW.code);
                }
                gradePrize.setCreateDate(new Date());
                gradePrize.setCollegePrizeId(collegePrize.getId());
                gradePrizeMapper.insertSelective(gradePrize);
            }
        }

    }

    @Override
    public PageInfo getAllocatedNumberPrizes(UserDTO user, Integer pageNum, Integer pageSize, Long unitId) {
        if (userService.isSchoolUser(user)) {
            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andAllocationNumberStatusEqualTo(true);
            schoolPrizeExample.setOrderByClause("allocation_date desc, prize_info_id asc");
            List<SchoolPrize> prizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            PageInfo pageInfo = new PageInfo(prizes);
            List<PrizeForListBO> res = packingSchoolPrizeForListBO(prizes, true);
            pageInfo.setList(res);
            return pageInfo;
        } else if (userService.isCollegeManger(user)) {
            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andCollegeIdEqualTo(unitId)
                    .andStatusNotEqualTo(StatusEnum.CLOSE.code)
                    .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                    .andAllocationNumberStatusEqualTo(true);
            collegePrizeExample.setOrderByClause("allocation_date desc, prize_info_id asc");
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            PageInfo pageInfo = new PageInfo(collegePrizes);
            List<PrizeForListBO> res = packingCollegePrizeForListBO(collegePrizes, true, unitId);
            pageInfo.setList(res);
            return pageInfo;
        }
        return null;
    }

    @Override
    public EntireUnitPrizeForm getAwardDetailOfAllocatedNumber(UserDTO user, Long prizeId) throws WSPException, RemoteException {
        EntireUnitPrizeForm form = new EntireUnitPrizeForm();
        if (userService.isSchoolUser(user)) {
            SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(prizeId);
            if (schoolPrize == null) {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            form.setAllocationMethod(AllocationMethodEnum.getByCode(schoolPrize.getAllocationMethod()));
            form.setAllocationRule(AllocationRuleEnum.getByCode(schoolPrize.getAllocationRule()));
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
            form.setPrizeName(prizeInfo.getPrizeName());
            form.setRestNumber(schoolPrize.getRestNumber());
            form.setId(prizeId);
            form.setNumber(schoolPrize.getNumber());

            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(schoolPrize.getScholarshipId());
            form.setScholarshipName(scholarship.getScholarshipName());

            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andSchoolPrizeIdEqualTo(schoolPrize.getId());
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            RemoteService rs = new RemoteService();
            for (CollegePrize child : collegePrizes) {
                UnitPrizeBO bo = new UnitPrizeBO();
                bo.setId(child.getId());
                bo.setNumber(child.getNumber());
                bo.setMax(schoolPrize.getNumber() - schoolPrize.getRestNumber());

                String collegeName = rs.findCollegeNameById(child.getCollegeId());
                bo.setUnitName(collegeName);

                Integer num = rs.findCollegeStudentCount(child.getCollegeId());
                bo.setUnitNumber(num);
                form.getList().add(bo);
            }
            return form;
        } else if (userService.isCollegeManger(user)) {
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(prizeId);
            if (collegePrize == null) {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            form.setAllocationMethod(AllocationMethodEnum.getByCode(collegePrize.getAllocationMethod()));
            form.setAllocationRule(AllocationRuleEnum.getByCode(collegePrize.getAllocationRule()));
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
            form.setPrizeName(prizeInfo.getPrizeName());
            form.setRestNumber(collegePrize.getRestNumber());
            form.setId(prizeId);
            form.setNumber(collegePrize.getNumber());

            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());
            form.setScholarshipName(scholarship.getScholarshipName());

            GradePrizeExample gradePrizeExample = new GradePrizeExample();
            gradePrizeExample.createCriteria().andCollegePrizeIdEqualTo(collegePrize.getId());
            List<GradePrize> gradePrizes = gradePrizeMapper.selectByExample(gradePrizeExample);

            RemoteService rs = new RemoteService();
            for (GradePrize child : gradePrizes) {
                UnitPrizeBO bo = new UnitPrizeBO();
                bo.setId(child.getId());
                bo.setMax(collegePrize.getNumber() - collegePrize.getRestNumber());
                bo.setNumber(child.getNumber());
                bo.setUnitName(child.getGrade());
                Integer num = rs.getStudentCountByCollegeAndGrade(child.getCollegeId(),child.getGrade());
                bo.setUnitNumber(num);
                form.getList().add(bo);
            }
            return form;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAllocationNumber(UserDTO user, EntireUnitPrizeForm entireUnitPrizeForm) {
        if (userService.isSchoolUser(user)) {
            SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(entireUnitPrizeForm.getId());
            schoolPrize.setRestNumber(entireUnitPrizeForm.getRestNumber());
            schoolPrize.setAllocationMethod(entireUnitPrizeForm.getAllocationMethod().code);
            schoolPrize.setAllocationRule(entireUnitPrizeForm.getAllocationRule().code);
            schoolPrizeMapper.updateByPrimaryKeySelective(schoolPrize);

            for (UnitPrizeBO bo : entireUnitPrizeForm.getList()) {
                CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(bo.getId());
                collegePrize.setNumber(bo.getNumber());
                collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
            }
        } else if (userService.isCollegeManger(user)) {
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(entireUnitPrizeForm.getId());
            collegePrize.setRestNumber(entireUnitPrizeForm.getRestNumber());
            collegePrize.setAllocationMethod(entireUnitPrizeForm.getAllocationMethod().code);
            collegePrize.setAllocationRule(entireUnitPrizeForm.getAllocationRule().code);
            collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);

            for (UnitPrizeBO bo : entireUnitPrizeForm.getList()) {
                GradePrize child = gradePrizeMapper.selectByPrimaryKey(bo.getId());
                child.setNumber(bo.getNumber());
                gradePrizeMapper.updateByPrimaryKeySelective(child);
            }
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
                        .andScholarshipTypeEqualTo(ScholarshipTypeEnum.COLLEGE.code)
                        .andNeedGradeCheckEqualTo(needGrade)
                        .andCollegeIdEqualTo(unitId);
                scholarships = scholarshipMapper.selectByExample(example);
            } else if (scholarshipType == ScholarshipTypeEnum.SCHOOL) {
                PrizeCollegeLimitTimeExample timeExample = new PrizeCollegeLimitTimeExample();
                timeExample.createCriteria().andCollegeIdEqualTo(unitId)
                        .andAllocationTimeStatusEqualTo(false);
                List<PrizeCollegeLimitTime> prizeCollegeLimitTimes = prizeCollegeLimitTimeMapper.selectByExample(timeExample);

                if (prizeCollegeLimitTimes.size() == 0) {
                    return res;
                }
                Set<Long> tmp = new HashSet<>();
                for (PrizeCollegeLimitTime limitTime : prizeCollegeLimitTimes) {
                    tmp.add(limitTime.getScholarshipId());
                }
                List<Long> scholarshipIds = new ArrayList<>();
                scholarshipIds.addAll(tmp);
                ScholarshipExample example = new ScholarshipExample();
                example.createCriteria().andStatusNotEqualTo(StatusEnum.CLOSE.code)
                        .andIdIn(scholarshipIds)
                        .andNeedGradeCheckEqualTo(needGrade)
                        .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code);

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
    @Transactional(rollbackFor = Exception.class)
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
                scholarship.setAllocationTimeDate(new Date());
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
                    scholarship.setAllocationTimeDate(new Date());
                    scholarshipMapper.updateByPrimaryKeySelective(scholarship);
                }

                PrizeCollegeLimitTimeExample timeExample = new PrizeCollegeLimitTimeExample();
                timeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                        .andCollegeIdEqualTo(bo.getManageUnit());
                List<PrizeCollegeLimitTime> limitTimes = prizeCollegeLimitTimeMapper.selectByExample(timeExample);
                if (limitTimes.size() == 1) {
                    PrizeCollegeLimitTime collegeLimitTime = limitTimes.get(0);
                    collegeLimitTime.setStudentEndDate(bo.getStudentEndDate());
                    collegeLimitTime.setGradeEndDate(bo.getGradeEndDate());
                    collegeLimitTime.setAllocationTimeStatus(true);
                    prizeCollegeLimitTimeMapper.updateByPrimaryKeySelective(collegeLimitTime);
                } else {
                    throw new WSPException(ErrorInfo.PARAMS_ERROR);
                }
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
            scholarshipExample.setOrderByClause("allocation_time_date desc");
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
            PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
            limitTimeExample.createCriteria().andCollegeIdEqualTo(unitId)
                    .andAllocationTimeStatusEqualTo(true);
            List<PrizeCollegeLimitTime> prizeCollegeLimitTimes = prizeCollegeLimitTimeMapper.selectByExample(limitTimeExample);
            List<Long> scholarshipIds = new ArrayList<>();
            if (prizeCollegeLimitTimes.size() > 0) {
                for (PrizeCollegeLimitTime limitTime : prizeCollegeLimitTimes) {
                    scholarshipIds.add(limitTime.getScholarshipId());
                }

                ScholarshipExample scholarshipExample = new ScholarshipExample();
                scholarshipExample.createCriteria().andIdIn(scholarshipIds).andStatusNotEqualTo(StatusEnum.CLOSE.code);
                scholarshipExample.setOrderByClause("allocation_time_date desc");
                PageHelper.startPage(pageNum, pageSize);
                List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
                pageInfo = new PageInfo(scholarships);
                for (Scholarship scholarship : scholarships) {
                    ScholarshipForListBO bo = new ScholarshipForListBO();
                    bo.setId(scholarship.getId());
                    bo.setScholarshipName(scholarship.getScholarshipName());
                    bo.setStudentBeginDate(scholarship.getStudentBeginDate());
                    bo.setCollegeEndDate(scholarship.getCollegeEndDate());

                    PrizeCollegeLimitTimeExample example = new PrizeCollegeLimitTimeExample();
                    example.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                            .andCollegeIdEqualTo(unitId);
                    List<PrizeCollegeLimitTime> list2 = prizeCollegeLimitTimeMapper.selectByExample(example);
                    if (list2.size() == 1) {
                        PrizeCollegeLimitTime limitTime = list2.get(0);
                        bo.setStudentEndDate(limitTime.getStudentEndDate());
                        bo.setGradeEndDate(limitTime.getGradeEndDate());
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
            PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
            limitTimeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                    .andCollegeIdEqualTo(unitId);
            List<PrizeCollegeLimitTime> list = prizeCollegeLimitTimeMapper.selectByExample(limitTimeExample);
            if (list.size() == 1) {
                PrizeCollegeLimitTime prizeCollegeLimitTime = list.get(0);
                timeLimitBO.setId(prizeCollegeLimitTime.getId());
                timeLimitBO.setGradeEndDate(prizeCollegeLimitTime.getGradeEndDate());
                timeLimitBO.setStudentEndDate(prizeCollegeLimitTime.getStudentEndDate());
            }

            Boolean needGrade = scholarship.getNeedGradeCheck();
            timeLimitBO.setNeedGrade(needGrade);
            timeLimitBO.setScholarshipType(ScholarshipTypeEnum.getByCode(scholarship.getScholarshipType()));
        }
        timeLimitBO.setScholarshipId(scholarshipId);
        return timeLimitBO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAllocationTime(UserDTO user, TimeLimitBO timeLimitBO) {
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(timeLimitBO.getScholarshipId());
        if (userService.isSchoolUser(user)) {
            scholarship.setCollegeEndDate(timeLimitBO.getCollegeEndDate());
            scholarship.setStudentBeginDate(timeLimitBO.getStudentStartDate());
            scholarshipMapper.updateByPrimaryKeySelective(scholarship);
        } else if (userService.isCollegeManger(user)) {

            if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                scholarship.setCollegeEndDate(timeLimitBO.getCollegeEndDate());
                scholarship.setStudentBeginDate(timeLimitBO.getStudentStartDate());
                scholarshipMapper.updateByPrimaryKeySelective(scholarship);
            }
            PrizeCollegeLimitTime prizeCollegeLimitTime = prizeCollegeLimitTimeMapper.selectByPrimaryKey(timeLimitBO.getId());

            prizeCollegeLimitTime.setGradeEndDate(timeLimitBO.getGradeEndDate());
            prizeCollegeLimitTime.setStudentEndDate(timeLimitBO.getStudentEndDate());
            prizeCollegeLimitTimeMapper.updateByPrimaryKey(prizeCollegeLimitTime);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void releaseToCollege(List<Long> prizeList) {
        for (Long id : prizeList) {
            SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(id);
            schoolPrize.setStatus(StatusEnum.RELEASE.code);
            schoolPrizeMapper.updateByPrimaryKeySelective(schoolPrize);

            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andSchoolPrizeIdEqualTo(schoolPrize.getId());
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            for (CollegePrize collegePrize : collegePrizes) {
                collegePrize.setStatus(StatusEnum.NEW.code);
                collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);

                PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
                limitTimeExample.createCriteria().andScholarshipIdEqualTo(collegePrize.getScholarshipId())
                        .andCollegeIdEqualTo(collegePrize.getCollegeId());
                Long tmp = prizeCollegeLimitTimeMapper.countByExample(limitTimeExample);
                if (tmp == 0) {
                    PrizeCollegeLimitTime limitTime = new PrizeCollegeLimitTime();
                    limitTime.setAllocationTimeStatus(false);
                    limitTime.setScholarshipId(collegePrize.getScholarshipId());
                    limitTime.setCollegeId(collegePrize.getCollegeId());
                    prizeCollegeLimitTimeMapper.insertSelective(limitTime);
                }
            }
        }
    }

    @Override
    public List<SelectOfScholarshipBO> getScholarshipSelectionForQuotaFeedback(UserDTO user, Long unitId) {
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria().andCollegeIdEqualTo(unitId)
                .andScholarshipTypeEqualTo(ScholarshipTypeEnum.SCHOOL.code)
                .andStatusNotEqualTo(StatusEnum.UNREADY.code)
                .andStatusNotEqualTo(StatusEnum.CLOSE.code);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        HashMap<Long, SelectOfScholarshipBO> map = new HashMap<>();
        for (CollegePrize collegePrize : collegePrizes) {
            Long scholarshipId = collegePrize.getScholarshipId();
            if (!map.containsKey(scholarshipId)) {
                map.put(scholarshipId, new SelectOfScholarshipBO());
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
                map.get(scholarshipId).setId(scholarshipId);
                map.get(scholarshipId).setName(scholarship.getScholarshipName());
            }
            SelectOfPrizeBO selectOfPrizeBO = new SelectOfPrizeBO();
            selectOfPrizeBO.setId(collegePrize.getId());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
            selectOfPrizeBO.setPrizeName(prizeInfo.getPrizeName());
            selectOfPrizeBO.setNumber(collegePrize.getNumber());
            map.get(scholarshipId).getPrizes().add(selectOfPrizeBO);
        }
        List<SelectOfScholarshipBO> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }

    @Override
    public List<SelectOfPrizeBO> getPrizesByScholarship(UserDTO user, Long scholarshipId) {
        if (scholarshipId == null || scholarshipId <= 0) {
            return new ArrayList<>();
        }
        PrizeInfoExample example = new PrizeInfoExample();
        example.createCriteria().andScholarshipIdEqualTo(scholarshipId);
        List<PrizeInfo> prizeInfos = prizeInfoMapper.selectByExample(example);
        List<SelectOfPrizeBO> res = new ArrayList<>();
        for (PrizeInfo prizeInfo : prizeInfos) {
            SelectOfPrizeBO bo = new SelectOfPrizeBO();
            bo.setId(prizeInfo.getId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            res.add(bo);
        }
        return res;
    }


    private List<PrizeForListBO> packingSchoolPrizeForListBO(List<SchoolPrize> schoolPrizes, boolean needNumber) {
        List<PrizeForListBO> res = new ArrayList<>();
        for (SchoolPrize schoolPrize : schoolPrizes) {
            PrizeForListBO bo = new PrizeForListBO();
            bo.setId(schoolPrize.getId());

            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            bo.setScholarshipTypeName(ScholarshipTypeEnum.getNameByCode(schoolPrize.getScholarshipType()));
            bo.setScholarshipType(ScholarshipTypeEnum.getByCode(schoolPrize.getScholarshipType()).name());
            bo.setMoney(prizeInfo.getMoney());
            bo.setNumber(schoolPrize.getNumber());
            bo.setAllocationStatus(schoolPrize.getAllocationNumberStatus());


            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(schoolPrize.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            bo.setScholarshipId(scholarship.getId());
            bo.setTimeStatus(scholarship.getAllocationTimeStatus());
            bo.setStatus(StatusEnum.getNameByCode(schoolPrize.getStatus()));
            bo.setRestNumber(schoolPrize.getRestNumber());
            bo.setAvailableNumber(schoolPrize.getNumber() - schoolPrize.getRestNumber());
            if (needNumber) {
                CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
                collegePrizeExample.createCriteria().andSchoolPrizeIdEqualTo(schoolPrize.getId());
                List<CollegePrize> children = collegePrizeMapper.selectByExample(collegePrizeExample);
                Integer total = 0;
                for (CollegePrize child : children) {
                    total += child.getNumber();
                }
                bo.setUsedNumber(total);
            }
            res.add(bo);
        }
        return res;
    }

    private List<PrizeForListBO> packingCollegePrizeForListBO(List<CollegePrize> prizes, boolean needNumber, Long unitId) {
        List<PrizeForListBO> res = new ArrayList<>();
        for (CollegePrize collegePrize : prizes) {
            PrizeForListBO bo = new PrizeForListBO();
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
            bo.setId(collegePrize.getId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            bo.setScholarshipTypeName(ScholarshipTypeEnum.getNameByCode(collegePrize.getScholarshipType()));
            bo.setScholarshipType(ScholarshipTypeEnum.getByCode(collegePrize.getScholarshipType()).name());
            bo.setMoney(prizeInfo.getMoney());
            bo.setNumber(collegePrize.getNumber());
            bo.setAllocationStatus(collegePrize.getAllocationNumberStatus());

            PrizeCollegeLimitTimeExample timeExample = new PrizeCollegeLimitTimeExample();
            timeExample.createCriteria().andScholarshipIdEqualTo(collegePrize.getScholarshipId())
                    .andCollegeIdEqualTo(collegePrize.getCollegeId());
            List<PrizeCollegeLimitTime> limitTimes = prizeCollegeLimitTimeMapper.selectByExample(timeExample);
            if (limitTimes.size()>0){
                PrizeCollegeLimitTime prizeCollegeLimitTime = limitTimes.get(0);
                bo.setTimeStatus(prizeCollegeLimitTime.getAllocationTimeStatus());
            }else{
                bo.setTimeStatus(false);
            }

            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            bo.setScholarshipId(scholarship.getId());

            bo.setStatus(StatusEnum.getNameByCode(collegePrize.getStatus()));
            bo.setRestNumber(collegePrize.getRestNumber());
            bo.setAvailableNumber(collegePrize.getNumber() - collegePrize.getRestNumber());
            if (needNumber) {
                GradePrizeExample gradePrizeExample = new GradePrizeExample();
                gradePrizeExample.createCriteria().andCollegePrizeIdEqualTo(collegePrize.getId());
                List<GradePrize> children = gradePrizeMapper.selectByExample(gradePrizeExample);
                Integer total = 0;
                for (GradePrize child : children) {
                    total += child.getNumber();
                }
                bo.setUsedNumber(total);
            }
            res.add(bo);
        }
        return res;
    }
}

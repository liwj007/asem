package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.dao.*;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.*;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IPublicityService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PublicityService implements IPublicityService {

    @Autowired
    private CollegePrizeMapper collegePrizeMapper;

    @Autowired
    private GradePrizeMapper gradePrizeMapper;

    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private PrizeInfoMapper prizeInfoMapper;


    @Autowired
    private ApplicationStepMapper applicationStepMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private SecondaryTeachingInstitutionMapper secondaryTeachingInstitutionMapper;

    @Autowired
    private RFlowTemplateStepAndUserRoleMapper rFlowTemplateStepAndUserRoleMapper;


    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;

    @Autowired
    private PublicityMapper publicityMapper;

    @Autowired
    private PublicityObjectionMapper publicityObjectionMapper;

    @Autowired
    private SchoolPrizeMapper schoolPrizeMapper;

    @Override
    public PageInfo getCollegePublicityList(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        status.add(StatusEnum.CLOSE.code);
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria()
                .andPrimaryTeachingInstitutionIdEqualTo(unitId)
                .andStatusIn(status);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        List<Long> scholarshipIds = new ArrayList<>();
        for (CollegePrize collegePrize : collegePrizes) {
            scholarshipIds.add(collegePrize.getScholarshipId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(scholarshipIds)
                .andCollegePublicityEqualTo(false)
                .andPrimaryTeachingInstitutionIdEqualTo(unitId);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);

        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        PageInfo pageInfo = new PageInfo(applicationSteps);
        List<PublicityBO> res = new ArrayList<>();
        for (ApplicationStep applicationStep : applicationSteps) {
            PublicityBO bo = new PublicityBO();
            bo.setApplicationId(applicationStep.getApplicationId());
            Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
            bo.setFileStatus(ApplicationFileStatusEnum.getByCode(application.getFileStatus()));
            bo.setPrizeStatus(ApplicationPrizeStatusEnum.getByCode(applicationStep.getStatus()));
            bo.setStepId(applicationStep.getId());
            User student = userService.getUserById(application.getUserId());

            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(application.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(application.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());

            if (student != null) {
                bo.setName(student.getName());
                bo.setSn(student.getSn());
            }

            if (student.getSecondaryTeachingInstitutionId() != null) {
                SecondaryTeachingInstitution secondaryTeachingInstitution = secondaryTeachingInstitutionMapper
                        .selectByPrimaryKey(student.getSecondaryTeachingInstitutionId());
                bo.setMajorName(secondaryTeachingInstitution.getName());
            }

            if (student.getGradeId() != null) {
                Grade grade = gradeMapper.selectByPrimaryKey(student.getGradeId());
                bo.setGradeName(grade.getName());
            }

            if (student.getClassesId() != null) {
                Classes classes = classesMapper.selectByPrimaryKey(student.getClassesId());
                bo.setClassName(classes.getName());
            }

            ApplicationExample applicationRecordsExample = new ApplicationExample();
            applicationRecordsExample.createCriteria().andUserIdEqualTo(application.getUserId())
                    .andPrizeStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
            List<Application> applicationRecords = applicationMapper.selectByExampleWithBLOBs(applicationRecordsExample);
            List<String> records = new ArrayList<>();
            for (Application app : applicationRecords) {
                Scholarship scho = scholarshipMapper.selectByPrimaryKey(app.getScholarshipId());
                String scholarName = scho.getScholarshipName();
                PrizeInfo info = prizeInfoMapper.selectByPrimaryKey(app.getPrizeInfoId());
                String prizeName = info.getPrizeName();
                String record = String.format("%s%s，获奖审核通过；",
                        scholarName, prizeName);
                records.add(record);
            }
            bo.setRecords(records);

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public List<SelectOfScholarshipBO> getCollegePublicityScholarshipList(UserDTO user, Long unitId) {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        status.add(StatusEnum.CLOSE.code);
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria()
                .andPrimaryTeachingInstitutionIdEqualTo(unitId)
                .andStatusIn(status);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        List<Long> scholarshipIds = new ArrayList<>();
        for (CollegePrize collegePrize : collegePrizes) {
            scholarshipIds.add(collegePrize.getScholarshipId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(scholarshipIds)
                .andCollegePublicityEqualTo(false)
                .andPrimaryTeachingInstitutionIdEqualTo(unitId);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        if (applications.size() == 0) {
            return null;
        }
        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);

        scholarshipIds.clear();
        for (ApplicationStep applicationStep : applicationSteps) {
            Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
            scholarshipIds.add(application.getScholarshipId());
        }
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria().andIdIn(scholarshipIds);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        List<SelectOfScholarshipBO> res = new ArrayList<>();
        for (Scholarship scholarship : scholarships) {
            SelectOfScholarshipBO bo = new SelectOfScholarshipBO();
            bo.setId(scholarship.getId());
            bo.setName(scholarship.getScholarshipName());
            res.add(bo);
        }
        return res;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void collegePublicity(UserDTO user, PublicityApplyBO publicityApplyBO) {
        for (Long id : publicityApplyBO.getScholarshipIds()) {
            Publicity publicity = new Publicity();
            publicity.setScholarshipId(id);
            publicity.setBeginDate(publicityApplyBO.getBeginDate());
            publicity.setEndDate(publicityApplyBO.getEndDate());
            publicity.setNeedClasses(publicityApplyBO.getClasses());
            publicity.setNeedCollege(publicityApplyBO.getCollege());
            publicity.setNeedFiles(publicityApplyBO.getFiles());
            publicity.setNeedGrade(publicityApplyBO.getGrade());
            publicity.setNeedMajor(publicityApplyBO.getMajor());
            publicity.setNeedName(publicityApplyBO.getName());
            publicity.setNeedSn(publicityApplyBO.getSn());
            publicity.setPrizeName(publicityApplyBO.getPrizeName());
            publicity.setNeedPrizeNumber(publicityApplyBO.getPrizeNumber());
            publicity.setScholarshipName(publicityApplyBO.getScholarshipName());
            publicity.setScholarshipType(ScholarshipTypeEnum.COLLEGE.code);
            publicity.setPrimaryTeachingInstitutionId(publicityApplyBO.getUnitId());
            publicity.setStatus(PublicityStatusEnum.OPEN.code);
            publicityMapper.insertSelective(publicity);
        }
        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(publicityApplyBO.getScholarshipIds())
                .andCollegePublicityEqualTo(false)
                .andPrimaryTeachingInstitutionIdEqualTo(publicityApplyBO.getUnitId());
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);

        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        for (ApplicationStep applicationStep : applicationSteps) {
            Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
            application.setCollegePublicity(true);
            applicationMapper.updateByPrimaryKeySelective(application);
        }
    }

    @Override
    public PageInfo getCollegeMangePublicityList(UserDTO user, Long unitId, Integer pageSize, Integer pageNum) {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
//        PublicityExample.Criteria criteria1 = publicityExample.createCriteria();
//        criteria1.andPrimaryTeachingInstitutionIdIsNull().andStatusIn(status);
        PublicityExample.Criteria criteria2 = publicityExample.createCriteria();
        criteria2.andPrimaryTeachingInstitutionIdEqualTo(unitId).andStatusIn(status);
//        publicityExample.or(criteria2);
        PageHelper.startPage(pageNum, pageSize);
        List<Publicity> res = publicityMapper.selectByExample(publicityExample);
        PageInfo pageInfo = new PageInfo(res);
        List<PublicityScholarshipBO> list = new ArrayList<>();
        for (Publicity publicity : res) {
            PublicityScholarshipBO bo = new PublicityScholarshipBO();
            bo.setId(publicity.getId());
            bo.setBeginDate(publicity.getBeginDate());
            bo.setEndDate(publicity.getEndDate());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(publicity.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            PrimaryTeachingInstitution primaryTeachingInstitution = primaryTeachingInstitutionMapper.selectByPrimaryKey(publicity.getPrimaryTeachingInstitutionId());
            bo.setUnitName(primaryTeachingInstitution.getName());
            list.add(bo);
        }
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo getMangePublicityDetailList(UserDTO user, Long publicityId,
                                                Integer pageSize, Integer pageNum) {
        Publicity publicity = publicityMapper.selectByPrimaryKey(publicityId);
        Long scholarshipId = publicity.getScholarshipId();
        Long primaryTeachingInstitutionId = publicity.getPrimaryTeachingInstitutionId();

        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);

        ApplicationExample applicationExample = new ApplicationExample();
        if (userService.isSchoolUser(user)){
            applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                    .andSchoolPublicityEqualTo(true);
        }else if (userService.isCollegeManger(user)){
            applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                    .andCollegePublicityEqualTo(true)
                    .andPrimaryTeachingInstitutionIdEqualTo(primaryTeachingInstitutionId);
        }else {
            if (primaryTeachingInstitutionId==null){
                applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                        .andSchoolPublicityEqualTo(true);
            }else {
                applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                        .andCollegePublicityEqualTo(true)
                        .andPrimaryTeachingInstitutionIdEqualTo(primaryTeachingInstitutionId);
            }
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        PageInfo pageInfo = new PageInfo(applications);
        List<PublicityBO> res = new ArrayList<>();
        for (Application application : applications) {
            PublicityBO bo = new PublicityBO();

            User student = userService.getUserById(application.getUserId());

            bo.setScholarshipName(scholarship.getScholarshipName());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(application.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());

            if (student != null) {
                if (publicity.getNeedName()) {
                    bo.setName(student.getName());
                }
                if (publicity.getNeedSn())
                    bo.setSn(student.getSn());
            }

            if (student.getSecondaryTeachingInstitutionId() != null) {
                if (publicity.getNeedMajor()) {
                    SecondaryTeachingInstitution secondaryTeachingInstitution = secondaryTeachingInstitutionMapper
                            .selectByPrimaryKey(student.getSecondaryTeachingInstitutionId());
                    bo.setMajorName(secondaryTeachingInstitution.getName());
                }
            }

            if (student.getGradeId() != null) {
                if (publicity.getNeedGrade()) {
                    Grade grade = gradeMapper.selectByPrimaryKey(student.getGradeId());
                    bo.setGradeName(grade.getName());
                }
            }

            if (student.getClassesId() != null) {
                if (publicity.getNeedClasses()) {
                    Classes classes = classesMapper.selectByPrimaryKey(student.getClassesId());
                    bo.setClassName(classes.getName());
                }
            }

            if (publicity.getNeedCollege()) {
                PrimaryTeachingInstitution unit = primaryTeachingInstitutionMapper.selectByPrimaryKey(application.getPrimaryTeachingInstitutionId());
                bo.setCollegeName(unit.getName());
            }

            List<String> records = new ArrayList<>();
            if (publicity.getNeedPrizeNumber()) {
                ApplicationExample applicationRecordsExample = new ApplicationExample();
                applicationRecordsExample.createCriteria().andUserIdEqualTo(application.getUserId())
                        .andPrizeStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
                List<Application> applicationRecords = applicationMapper.selectByExampleWithBLOBs(applicationRecordsExample);

                for (Application app : applicationRecords) {
                    Scholarship scho = scholarshipMapper.selectByPrimaryKey(app.getScholarshipId());
                    String scholarName = scho.getScholarshipName();
                    PrizeInfo info = prizeInfoMapper.selectByPrimaryKey(app.getPrizeInfoId());
                    String prizeName = info.getPrizeName();
                    String record = String.format("%s%s，获奖审核通过；",
                            scholarName, prizeName);
                    records.add(record);
                }
            }
            bo.setRecords(records);

            if (publicity.getNeedFiles()) {
                bo.setApplicationId(application.getId());
            }

            res.add(bo);
        }
        pageInfo.setList(res);

        return pageInfo;
    }

    @Override
    public PageInfo getStudentMangePublicityList(UserDTO user, Integer pageSize, Integer pageNum) {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andStatusIn(status);
        PageHelper.startPage(pageNum, pageSize);
        List<Publicity> res = publicityMapper.selectByExample(publicityExample);
        PageInfo pageInfo = new PageInfo(res);
        List<PublicityScholarshipBO> list = new ArrayList<>();
        for (Publicity publicity : res) {
            PublicityScholarshipBO bo = new PublicityScholarshipBO();
            bo.setId(publicity.getId());
            bo.setBeginDate(publicity.getBeginDate());
            bo.setEndDate(publicity.getEndDate());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(publicity.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());

            if (publicity.getPrimaryTeachingInstitutionId()!=null){
                PrimaryTeachingInstitution primaryTeachingInstitution = primaryTeachingInstitutionMapper.selectByPrimaryKey(publicity.getPrimaryTeachingInstitutionId());
                bo.setUnitName(primaryTeachingInstitution.getName());
            }else{
                bo.setUnitName("学校");
            }

            list.add(bo);
        }
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public void addObjection(UserDTO user, Long publicityId, String content) {
        PublicityObjectionWithBLOBs publicityObjection = new PublicityObjectionWithBLOBs();
        publicityObjection.setUserId(user.getId());
        publicityObjection.setCreateTime(new Date());
        publicityObjection.setContent(content);
        publicityObjection.setPublicityId(publicityId);
        publicityObjectionMapper.insertSelective(publicityObjection);
    }

    @Override
    public List<PublicityScholarshipBO> getAllStudentMangePublicityList(UserDTO user) {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andStatusIn(status);
        List<Publicity> res = publicityMapper.selectByExample(publicityExample);
        List<PublicityScholarshipBO> list = new ArrayList<>();
        for (Publicity publicity : res) {
            PublicityScholarshipBO bo = new PublicityScholarshipBO();
            bo.setId(publicity.getId());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(publicity.getScholarshipId());

            if (publicity.getPrimaryTeachingInstitutionId()!=null){
                PrimaryTeachingInstitution primaryTeachingInstitution = primaryTeachingInstitutionMapper.selectByPrimaryKey(publicity.getPrimaryTeachingInstitutionId());
                bo.setScholarshipName(scholarship.getScholarshipName() + "-" + primaryTeachingInstitution.getName());
            }else{
                bo.setScholarshipName(scholarship.getScholarshipName() + "-学校");
            }

            list.add(bo);
        }
        return list;
    }

    @Override
    public PageInfo getStudentObjections(UserDTO user, Integer pageSize, Integer pageNum) {
        PublicityObjectionExample example = new PublicityObjectionExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        PageHelper.startPage(pageNum, pageSize);
        List<PublicityObjectionWithBLOBs> list = publicityObjectionMapper.selectByExampleWithBLOBs(example);
        PageInfo pageInfo = new PageInfo(list);
        List<PublicityObjectionBO> res = new ArrayList<>();
        for (PublicityObjectionWithBLOBs objection : list) {
            PublicityObjectionBO bo = new PublicityObjectionBO();
            bo.setContent(objection.getContent());
            bo.setFeedback(objection.getFeedback());
            bo.setId(objection.getId());
            bo.setCreateTime(objection.getCreateTime());
            User myself = userService.getUserById(objection.getUserId());

            if (myself != null) {
                bo.setName(myself.getName());
                bo.setSn(myself.getSn());
            }

            if (myself.getSecondaryTeachingInstitutionId() != null) {
                SecondaryTeachingInstitution secondaryTeachingInstitution = secondaryTeachingInstitutionMapper
                        .selectByPrimaryKey(myself.getSecondaryTeachingInstitutionId());
                bo.setMajorName(secondaryTeachingInstitution.getName());
            }

            if (myself.getGradeId() != null) {
                Grade grade = gradeMapper.selectByPrimaryKey(myself.getGradeId());
                bo.setGradeName(grade.getName());
            }

            if (myself.getClassesId() != null) {
                Classes classes = classesMapper.selectByPrimaryKey(myself.getClassesId());
                bo.setClassName(classes.getName());
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public void feedbackObjection(UserDTO user, Long publicityId, String content) {
        PublicityObjectionWithBLOBs publicity = publicityObjectionMapper.selectByPrimaryKey(publicityId);
        publicity.setFeedback(content);
        publicity.setFeedbackTime(new Date());
        publicityObjectionMapper.updateByPrimaryKeyWithBLOBs(publicity);
    }

    @Override
    public PageInfo getCollegeObjections(UserDTO user, Long unitId, Integer pageSize, Integer pageNum) {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(unitId)
                .andStatusIn(status);
        List<Publicity> publicities = publicityMapper.selectByExample(publicityExample);
        List<Long> publicityIds = new ArrayList<>();
        for (Publicity publicity : publicities) {
            publicityIds.add(publicity.getId());
        }
        PublicityObjectionExample example = new PublicityObjectionExample();
        example.createCriteria().andPublicityIdIn(publicityIds);
        PageHelper.startPage(pageNum, pageSize);
        List<PublicityObjectionWithBLOBs> list = publicityObjectionMapper.selectByExampleWithBLOBs(example);
        PageInfo pageInfo = new PageInfo(list);
        List<PublicityObjectionBO> res = new ArrayList<>();
        for (PublicityObjectionWithBLOBs objection : list) {
            PublicityObjectionBO bo = new PublicityObjectionBO();
            bo.setContent(objection.getContent());
            bo.setFeedback(objection.getFeedback());
            bo.setId(objection.getId());
            bo.setCreateTime(objection.getCreateTime());
            User myself = userService.getUserById(objection.getUserId());

            if (myself != null) {
                bo.setName(myself.getName());
                bo.setSn(myself.getSn());
            }

            if (myself.getSecondaryTeachingInstitutionId() != null) {
                SecondaryTeachingInstitution secondaryTeachingInstitution = secondaryTeachingInstitutionMapper
                        .selectByPrimaryKey(myself.getSecondaryTeachingInstitutionId());
                bo.setMajorName(secondaryTeachingInstitution.getName());
            }

            if (myself.getGradeId() != null) {
                Grade grade = gradeMapper.selectByPrimaryKey(myself.getGradeId());
                bo.setGradeName(grade.getName());
            }

            if (myself.getClassesId() != null) {
                Classes classes = classesMapper.selectByPrimaryKey(myself.getClassesId());
                bo.setClassName(classes.getName());
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public PageInfo getSchoolPublicityList(UserDTO user, Integer pageNum, Integer pageSize) {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        status.add(StatusEnum.CLOSE.code);
        SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
        schoolPrizeExample.createCriteria()
                .andStatusIn(status);
        List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
        List<Long> scholarshipIds = new ArrayList<>();
        for (SchoolPrize schoolPrize : schoolPrizes) {
            scholarshipIds.add(schoolPrize.getScholarshipId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(scholarshipIds)
                .andSchoolPublicityEqualTo(false);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);

        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        PageInfo pageInfo = new PageInfo(applicationSteps);
        List<PublicityBO> res = new ArrayList<>();
        for (ApplicationStep applicationStep : applicationSteps) {
            PublicityBO bo = new PublicityBO();
            bo.setApplicationId(applicationStep.getApplicationId());
            Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
            bo.setFileStatus(ApplicationFileStatusEnum.getByCode(application.getFileStatus()));
            bo.setPrizeStatus(ApplicationPrizeStatusEnum.getByCode(applicationStep.getStatus()));
            bo.setStepId(applicationStep.getId());
            User student = userService.getUserById(application.getUserId());

            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(application.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(application.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());

            if (student != null) {
                bo.setName(student.getName());
                bo.setSn(student.getSn());
            }

            if (student.getSecondaryTeachingInstitutionId() != null) {
                SecondaryTeachingInstitution secondaryTeachingInstitution = secondaryTeachingInstitutionMapper
                        .selectByPrimaryKey(student.getSecondaryTeachingInstitutionId());
                bo.setMajorName(secondaryTeachingInstitution.getName());
            }

            if (student.getGradeId() != null) {
                Grade grade = gradeMapper.selectByPrimaryKey(student.getGradeId());
                bo.setGradeName(grade.getName());
            }

            if (student.getClassesId() != null) {
                Classes classes = classesMapper.selectByPrimaryKey(student.getClassesId());
                bo.setClassName(classes.getName());
            }

            ApplicationExample applicationRecordsExample = new ApplicationExample();
            applicationRecordsExample.createCriteria().andUserIdEqualTo(application.getUserId())
                    .andPrizeStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
            List<Application> applicationRecords = applicationMapper.selectByExampleWithBLOBs(applicationRecordsExample);
            List<String> records = new ArrayList<>();
            for (Application app : applicationRecords) {
                Scholarship scho = scholarshipMapper.selectByPrimaryKey(app.getScholarshipId());
                String scholarName = scho.getScholarshipName();
                PrizeInfo info = prizeInfoMapper.selectByPrimaryKey(app.getPrizeInfoId());
                String prizeName = info.getPrizeName();
                String record = String.format("%s%s，获奖审核通过；",
                        scholarName, prizeName);
                records.add(record);
            }
            bo.setRecords(records);

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public List<SelectOfScholarshipBO> getSchoolPublicityScholarshipList(UserDTO user) {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        status.add(StatusEnum.CLOSE.code);
        SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
        schoolPrizeExample.createCriteria()
                .andStatusIn(status);
        List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
        List<Long> scholarshipIds = new ArrayList<>();
        for (SchoolPrize schoolPrize : schoolPrizes) {
            scholarshipIds.add(schoolPrize.getScholarshipId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(scholarshipIds)
                .andSchoolPublicityEqualTo(false);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        if (applications.size() == 0) {
            return null;
        }
        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);

        scholarshipIds.clear();
        for (ApplicationStep applicationStep : applicationSteps) {
            Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
            scholarshipIds.add(application.getScholarshipId());
        }
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria().andIdIn(scholarshipIds);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        List<SelectOfScholarshipBO> res = new ArrayList<>();
        for (Scholarship scholarship : scholarships) {
            SelectOfScholarshipBO bo = new SelectOfScholarshipBO();
            bo.setId(scholarship.getId());
            bo.setName(scholarship.getScholarshipName());
            res.add(bo);
        }
        return res;
    }

    @Override
    public void schoolPublicity(UserDTO user, PublicityApplyBO publicityApplyBO) {
        for (Long id : publicityApplyBO.getScholarshipIds()) {
            Publicity publicity = new Publicity();
            publicity.setScholarshipId(id);
            publicity.setBeginDate(publicityApplyBO.getBeginDate());
            publicity.setEndDate(publicityApplyBO.getEndDate());
            publicity.setNeedClasses(publicityApplyBO.getClasses());
            publicity.setNeedCollege(publicityApplyBO.getCollege());
            publicity.setNeedFiles(publicityApplyBO.getFiles());
            publicity.setNeedGrade(publicityApplyBO.getGrade());
            publicity.setNeedMajor(publicityApplyBO.getMajor());
            publicity.setNeedName(publicityApplyBO.getName());
            publicity.setNeedSn(publicityApplyBO.getSn());
            publicity.setPrizeName(publicityApplyBO.getPrizeName());
            publicity.setNeedPrizeNumber(publicityApplyBO.getPrizeNumber());
            publicity.setScholarshipName(publicityApplyBO.getScholarshipName());
            publicity.setScholarshipType(ScholarshipTypeEnum.SCHOOL.code);
            publicity.setStatus(PublicityStatusEnum.OPEN.code);
            publicityMapper.insertSelective(publicity);
        }
        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(publicityApplyBO.getScholarshipIds())
                .andSchoolPublicityEqualTo(false);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);

        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        for (ApplicationStep applicationStep : applicationSteps) {
            Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
            application.setSchoolPublicity(true);
            applicationMapper.updateByPrimaryKeySelective(application);
        }
    }

    @Override
    public PageInfo getSchoolMangePublicityList(UserDTO user, Integer pageSize, Integer pageNum) {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        PublicityExample.Criteria criteria1 = publicityExample.createCriteria();
        criteria1.andPrimaryTeachingInstitutionIdIsNull().andStatusIn(status);
        PageHelper.startPage(pageNum, pageSize);
        List<Publicity> res = publicityMapper.selectByExample(publicityExample);
        PageInfo pageInfo = new PageInfo(res);
        List<PublicityScholarshipBO> list = new ArrayList<>();
        for (Publicity publicity : res) {
            PublicityScholarshipBO bo = new PublicityScholarshipBO();
            bo.setId(publicity.getId());
            bo.setBeginDate(publicity.getBeginDate());
            bo.setEndDate(publicity.getEndDate());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(publicity.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            bo.setUnitName("学校");
            list.add(bo);
        }
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo getSchoolObjections(UserDTO user, Integer pageSize, Integer pageNum) {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andPrimaryTeachingInstitutionIdIsNull()
                .andStatusIn(status);
        List<Publicity> publicities = publicityMapper.selectByExample(publicityExample);
        List<Long> publicityIds = new ArrayList<>();
        for (Publicity publicity : publicities) {
            publicityIds.add(publicity.getId());
        }
        PublicityObjectionExample example = new PublicityObjectionExample();
        example.createCriteria().andPublicityIdIn(publicityIds);
        PageHelper.startPage(pageNum, pageSize);
        List<PublicityObjectionWithBLOBs> list = publicityObjectionMapper.selectByExampleWithBLOBs(example);
        PageInfo pageInfo = new PageInfo(list);
        List<PublicityObjectionBO> res = new ArrayList<>();
        for (PublicityObjectionWithBLOBs objection : list) {
            PublicityObjectionBO bo = new PublicityObjectionBO();
            bo.setContent(objection.getContent());
            bo.setFeedback(objection.getFeedback());
            bo.setId(objection.getId());
            bo.setCreateTime(objection.getCreateTime());
            User myself = userService.getUserById(objection.getUserId());

            if (myself != null) {
                bo.setName(myself.getName());
                bo.setSn(myself.getSn());
            }

            if (myself.getSecondaryTeachingInstitutionId() != null) {
                SecondaryTeachingInstitution secondaryTeachingInstitution = secondaryTeachingInstitutionMapper
                        .selectByPrimaryKey(myself.getSecondaryTeachingInstitutionId());
                bo.setMajorName(secondaryTeachingInstitution.getName());
            }

            if (myself.getGradeId() != null) {
                Grade grade = gradeMapper.selectByPrimaryKey(myself.getGradeId());
                bo.setGradeName(grade.getName());
            }

            if (myself.getClassesId() != null) {
                Classes classes = classesMapper.selectByPrimaryKey(myself.getClassesId());
                bo.setClassName(classes.getName());
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }


}

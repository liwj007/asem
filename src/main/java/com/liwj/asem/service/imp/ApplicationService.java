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
import com.liwj.asem.service.IApplicationService;
import com.liwj.asem.service.IFlowTemplateService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationService implements IApplicationService {

    @Autowired
    private CollegePrizeMapper collegePrizeMapper;

    @Autowired
    private GradePrizeMapper gradePrizeMapper;

    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationReasonMapper applicationReasonMapper;

    @Autowired
    private ApplicationFileMapper applicationFileMapper;

    @Autowired
    private PrizeInfoMapper prizeInfoMapper;

    @Autowired
    private AssessmentRecordMapper assessmentRecordMapper;

    @Autowired
    private IFlowTemplateService flowTemplateService;

    @Autowired
    private ApplicationStepMapper applicationStepMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private SchoolPrizeMapper schoolPrizeMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private SecondaryTeachingInstitutionMapper secondaryTeachingInstitutionMapper;

    @Autowired
    private RFlowTemplateStepAndUserRoleMapper rFlowTemplateStepAndUserRoleMapper;

    @Autowired
    private PrizeCollegeLimitTimeMapper prizeCollegeLimitTimeMapper;

    @Autowired
    private FlowTemplateStepMapper flowTemplateStepMapper;

    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createApplication(UserDTO user, EntireApplicationForm applicationForm) throws WSPException {
        for (Long prizeId : applicationForm.getPrizeIds()) {
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(prizeId);
            if (collegePrize == null) {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            Application application = new Application();
            application.setPrizeId(prizeId);
            application.setScholarshipId(collegePrize.getScholarshipId());
            application.setStatus(ApplicationStatusEnum.SUBMIT.code);
            application.setFileStatus(ApplicationFileStatusEnum.SUBMIT.code);
            application.setPrizeStatus(ApplicationPrizeStatusEnum.SUBMIT.code);
            application.setUserId(user.getId());
            application.setCreateDate(new Date());
            application.setEvaluation(applicationForm.getEvaluation());
            application.setPrizeInfoId(collegePrize.getPrizeInfoId());
            application.setPrimaryTeachingInstitutionId(user.getPrimaryTeachingInstitution().getId());
            application.setGradeId(user.getGrade().getId());
            applicationMapper.insertSelective(application);

            for (ApplicationReasonBO reason : applicationForm.getReasons()) {
                ApplicationReason applicationReason = new ApplicationReason();
                applicationReason.setReason(reason.getReason());
                applicationReason.setApplicationId(application.getId());
                applicationReasonMapper.insertSelective(applicationReason);
            }

            for (FileBO fileBO : applicationForm.getFiles()) {
                ApplicationFile file = new ApplicationFile();
                file.setName(fileBO.getName());
                file.setOriginalName(fileBO.getOriginalName());
                file.setApplicationId(application.getId());
                applicationFileMapper.insertSelective(file);
            }

            //模板流程
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(application.getScholarshipId());
            FlowTemplateStep firstStep = flowTemplateService.findTheNextStep(scholarship.getFlowTemplateId(), null);
            ApplicationStep applicationStep = new ApplicationStep();
            applicationStep.setApplicationId(application.getId());
            applicationStep.setPrizeId(collegePrize.getId());
            applicationStep.setPrimaryTeachingInstitutionId(user.getPrimaryTeachingInstitution().getId());
            applicationStep.setGradeId(user.getGrade().getId());
            applicationStep.setFlowTemplateStepId(firstStep.getId());
            applicationStep.setStatus(ApplicationPrizeStatusEnum.SUBMIT.code);
            applicationStepMapper.insertSelective(applicationStep);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateApplication(UserDTO user, EntireApplicationForm applicationForm) {
        Long applicationId = applicationForm.getId();
        Application application = applicationMapper.selectByPrimaryKey(applicationId);
        application.setFileStatus(ApplicationFileStatusEnum.RESUBMIT.code);
        application.setStatus(ApplicationStatusEnum.RESUBMIT.code);
        application.setEvaluation(applicationForm.getEvaluation());
        applicationMapper.updateByPrimaryKeySelective(application);

        ApplicationReasonExample reasonExample = new ApplicationReasonExample();
        reasonExample.createCriteria().andApplicationIdEqualTo(applicationId);
        applicationReasonMapper.deleteByExample(reasonExample);

        for (ApplicationReasonBO reason : applicationForm.getReasons()) {
            ApplicationReason applicationReason = new ApplicationReason();
            applicationReason.setReason(reason.getReason());
            applicationReason.setApplicationId(application.getId());
            applicationReasonMapper.insertSelective(applicationReason);
        }

        ApplicationFileExample fileExample = new ApplicationFileExample();
        fileExample.createCriteria().andApplicationIdEqualTo(applicationId);
        applicationFileMapper.deleteByExample(fileExample);

        for (FileBO fileBO : applicationForm.getFiles()) {
            ApplicationFile file = new ApplicationFile();
            file.setName(fileBO.getName());
            file.setOriginalName(fileBO.getOriginalName());
            file.setApplicationId(application.getId());
            applicationFileMapper.insertSelective(file);
        }
    }

    @Override
    public PageInfo getPrizeWhichCanSubmit(UserDTO user, Integer pageNum, Integer pageSize) {
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria().andStatusEqualTo(StatusEnum.OPEN.code)
//                .andApplyStatusEqualTo(true)
                .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId());
        PageHelper.startPage(pageNum, pageSize);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        PageInfo pageInfo = new PageInfo(collegePrizes);
        List<PrizeForApplicationBO> res = new ArrayList<>();
        for (CollegePrize collegePrize : collegePrizes) {
            PrizeForApplicationBO bo = new PrizeForApplicationBO();
            bo.setPrizeId(collegePrize.getId());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());

            bo.setApplyStatus(collegePrize.getApplyStatus());

            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andUserIdEqualTo(user.getId())
                    .andPrizeIdEqualTo(collegePrize.getId());
            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            if (applications.size() == 1) {
                Application application = applications.get(0);
                bo.setStatus(ApplicationStatusEnum.getByCode(application.getStatus()));
                bo.setFileStatus(ApplicationFileStatusEnum.getByCode(application.getFileStatus()));
                bo.setPrizeStatus(ApplicationPrizeStatusEnum.getByCode(application.getPrizeStatus()));
                bo.setApplicationId(application.getId());
            } else {
                bo.setStatus(ApplicationStatusEnum.NO);
                bo.setFileStatus(ApplicationFileStatusEnum.NO);
                bo.setPrizeStatus(ApplicationPrizeStatusEnum.NO);
            }
            PrizeCollegeLimitTimeExample prizeCollegeLimitTimeExample = new PrizeCollegeLimitTimeExample();
            prizeCollegeLimitTimeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                    .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId());
            List<PrizeCollegeLimitTime> prizeCollegeLimitTimes = prizeCollegeLimitTimeMapper.selectByExample(prizeCollegeLimitTimeExample);
            if (prizeCollegeLimitTimes.size() == 1) {
                PrizeCollegeLimitTime limitTime = prizeCollegeLimitTimes.get(0);
                bo.setEndDate(limitTime.getStudentEndDate());
            }
            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public MyselfEvaluationBO getMyselfEvaluation(UserDTO user) {
        MyselfEvaluationBO bo = new MyselfEvaluationBO();
        AssessmentRecordExample example = new AssessmentRecordExample();
        example.createCriteria().andSnEqualTo(user.getSn());
        List<AssessmentRecord> list = assessmentRecordMapper.selectByExample(example);
        if (list.size() == 1) {
            AssessmentRecord evaluation = list.get(0);
            bo.setEvaluation(String.format("综合排名%d/%d，综合分数%.02f，智育分数%.02f", evaluation.getOverallRank(),
                    evaluation.getMajorTotal(), evaluation.getOverallScore(), evaluation.getIntellectualScore()));
        } else {
            bo.setEvaluation("");
        }
        return bo;
    }

    @Override
    public ApplicationBO getApplicationDetail(UserDTO user, Long id) throws WSPException {
        ApplicationBO bo = new ApplicationBO();

        Application application = applicationMapper.selectByPrimaryKey(id);

        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(application.getScholarshipId());
        bo.setScholarshipName(scholarship.getScholarshipName());
        CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(application.getPrizeId());
        PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
        bo.setPrizeName(prizeInfo.getPrizeName());

        bo.setEvaluation(application.getEvaluation());

        ApplicationFileExample fileExample = new ApplicationFileExample();
        fileExample.createCriteria().andApplicationIdEqualTo(application.getId());
        List<ApplicationFile> applicationFiles = applicationFileMapper.selectByExample(fileExample);
        List<FileBO> files = new ArrayList<>();
        for (ApplicationFile applicationFile : applicationFiles) {
            FileBO fileBO = new FileBO();
            fileBO.setId(applicationFile.getId());
            fileBO.setOriginalName(applicationFile.getOriginalName());
            fileBO.setName(applicationFile.getName());
            files.add(fileBO);
        }
        bo.setFiles(files);

        ApplicationReasonExample reasonExample = new ApplicationReasonExample();
        reasonExample.createCriteria().andApplicationIdEqualTo(application.getId());
        List<ApplicationReason> applicationReasons = applicationReasonMapper.selectByExample(reasonExample);
        List<ApplicationReasonBO> reasons = new ArrayList<>();
        for (ApplicationReason reason : applicationReasons) {
            ApplicationReasonBO reasonBO = new ApplicationReasonBO();
            reasonBO.setId(reason.getId());
            reasonBO.setReason(reason.getReason());
            reasons.add(reasonBO);
        }
        bo.setReasons(reasons);

        return bo;
    }

    @Override
    public PageInfo getPrizeForFileCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) throws WSPException {
        if (userService.isGradeManger(user)) {
            if (user.getManageGrades().size() == 0) {
                return new PageInfo();
            }

            ScholarshipExample scholarshipExample = new ScholarshipExample();
            scholarshipExample.createCriteria().andNeedGradeCheckEqualTo(true)
                    .andStatusEqualTo(StatusEnum.OPEN.code);
            List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
            if (scholarships.size() == 0) {
                return new PageInfo();
            }
            List<Long> scholarshipIds = new ArrayList<>();
            for (Scholarship scholarship : scholarships) {
                scholarshipIds.add(scholarship.getId());
            }

            List<Integer> status = new ArrayList<>();
            status.add(StatusEnum.OPEN.code);
            GradePrizeExample gradePrizeExample = new GradePrizeExample();
            gradePrizeExample.createCriteria().andGradeIdIn(user.getMangeGradeId())
                    .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                    .andStatusIn(status)
                    .andScholarshipIdIn(scholarshipIds);
            List<GradePrize> gradePrizes = gradePrizeMapper.selectByExample(gradePrizeExample);
            if (gradePrizes.size() == 0) {
                return new PageInfo();
            }
            List<Long> prizeInfoIds = new ArrayList<>();
            for (GradePrize gradePrize : gradePrizes) {
                prizeInfoIds.add(gradePrize.getPrizeInfoId());
            }

            PrizeInfoExample prizeInfoExample = new PrizeInfoExample();
            prizeInfoExample.createCriteria().andIdIn(prizeInfoIds);
            PageHelper.startPage(pageNum, pageSize);
            List<PrizeInfo> prizeInfos = prizeInfoMapper.selectByExample(prizeInfoExample);
            PageInfo pageInfo = new PageInfo(prizeInfos);
            List<ApplicationFileCheckListBO> res = new ArrayList<>();
            for (PrizeInfo prizeInfo : prizeInfos) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prizeInfo.getScholarshipId());

                ApplicationFileCheckListBO bo = new ApplicationFileCheckListBO();
                bo.setScholarshipName(scholarship.getScholarshipName());
                bo.setPrizeName(prizeInfo.getPrizeName());

                CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
                collegePrizeExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                        .andPrizeInfoIdEqualTo(prizeInfo.getId());
                List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
                CollegePrize collegePrize;
                if (collegePrizes.size() == 1) {
                    collegePrize = collegePrizes.get(0);
                } else {
                    throw new WSPException(ErrorInfo.PARAMS_ERROR);
                }

                bo.setPrizeId(collegePrize.getId());

                ApplicationExample applicationExample = new ApplicationExample();
                applicationExample.createCriteria().andPrizeIdEqualTo(collegePrize.getId())
                        .andGradeIdIn(user.getMangeGradeId());
                Long num1 = applicationMapper.countByExample(applicationExample);
                bo.setApplyNumber(num1);

                applicationExample.clear();
                List<Integer> statuses = new ArrayList<>();
                statuses.add(ApplicationFileStatusEnum.REJECT.code);
                statuses.add(ApplicationFileStatusEnum.RESUBMIT.code);
                applicationExample.createCriteria().andPrizeIdEqualTo(collegePrize.getId())
                        .andFileStatusIn(statuses)
                        .andGradeIdIn(user.getMangeGradeId());
                Long num2 = applicationMapper.countByExample(applicationExample);
                bo.setRejectNumber(num2);

                applicationExample.clear();

                applicationExample.createCriteria().andPrizeIdEqualTo(collegePrize.getId())
                        .andFileStatusEqualTo(ApplicationFileStatusEnum.RESUBMIT.code)
                        .andGradeIdIn(user.getMangeGradeId());
                Long num3 = applicationMapper.countByExample(applicationExample);
                bo.setReSubmitNumber(num3);
                res.add(bo);
            }
            pageInfo.setList(res);
            return pageInfo;
        } else if (userService.isCollegeManger(user)) {
            RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code);
            List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                    .selectByExample(roleExample);
            List<Long> flowTemplateStepIds = new ArrayList<>();
            for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
                flowTemplateStepIds.add(role.getFlowTemplateStepId());
            }
            if (flowTemplateStepIds.size() == 0) {
                return new PageInfo();
            }

            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andStatusEqualTo(StatusEnum.OPEN.code)
                    .andPrimaryTeachingInstitutionIdEqualTo(unitId);
            PageHelper.startPage(pageNum, pageSize);
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            if (collegePrizes.size() == 0) {
                return new PageInfo();
            }
            PageInfo pageInfo = new PageInfo(collegePrizes);

            List<ApplicationFileCheckListBO> res = new ArrayList<>();
            for (CollegePrize collegePrize : collegePrizes) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());

                ApplicationFileCheckListBO bo = new ApplicationFileCheckListBO();
                bo.setScholarshipName(scholarship.getScholarshipName());
                bo.setPrizeId(collegePrize.getId());
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
                bo.setPrizeName(prizeInfo.getPrizeName());


                ApplicationExample applicationExample = new ApplicationExample();
                applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                        .andPrimaryTeachingInstitutionIdEqualTo(unitId);
                List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
                if (applications.size() == 0) {
                    bo.setApplyNumber(0L);
                    bo.setRejectNumber(0L);
                    bo.setReSubmitNumber(0L);
                } else {
                    List<Long> applicationIds = new ArrayList<>();
                    for (Application application : applications) {
                        applicationIds.add(application.getId());
                    }
                    ApplicationStepExample stepExample = new ApplicationStepExample();
                    stepExample.createCriteria().andApplicationIdIn(applicationIds)
                            .andFlowTemplateStepIdIn(flowTemplateStepIds);
                    Long num1 = applicationStepMapper.countByExample(stepExample);
                    bo.setApplyNumber(num1);

                    List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
                    List<Long> tmp = new ArrayList<>();
                    for (ApplicationStep step : applicationSteps) {
                        tmp.add(step.getApplicationId());
                    }
                    if (tmp.size() == 0) {
                        bo.setRejectNumber(0L);
                        bo.setReSubmitNumber(0L);
                    } else {
                        applicationExample.clear();
                        List<Integer> statuses = new ArrayList<>();
                        statuses.add(ApplicationFileStatusEnum.REJECT.code);
                        statuses.add(ApplicationFileStatusEnum.RESUBMIT.code);
                        applicationExample.createCriteria().andPrizeIdEqualTo(collegePrize.getId())
                                .andFileStatusIn(statuses).andIdIn(tmp);
                        Long num2 = applicationMapper.countByExample(applicationExample);
                        bo.setRejectNumber(num2);

                        applicationExample.clear();

                        applicationExample.createCriteria().andPrizeIdEqualTo(collegePrize.getId())
                                .andFileStatusEqualTo(ApplicationFileStatusEnum.RESUBMIT.code)
                                .andIdIn(tmp);
                        Long num3 = applicationMapper.countByExample(applicationExample);
                        bo.setReSubmitNumber(num3);
                    }


                }
                res.add(bo);
            }
            pageInfo.setList(res);
            return pageInfo;
        } else if (userService.isSchoolUser(user)) {
            RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code);
            List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                    .selectByExample(roleExample);
            List<Long> flowTemplateStepIds = new ArrayList<>();
            for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
                flowTemplateStepIds.add(role.getFlowTemplateStepId());
            }
            if (flowTemplateStepIds.size() == 0) {
                return new PageInfo();
            }

            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andStatusEqualTo(StatusEnum.OPEN.code);
            PageHelper.startPage(pageNum, pageSize);
            List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            if (schoolPrizes.size() == 0) {
                return new PageInfo();
            }
            PageInfo pageInfo = new PageInfo(schoolPrizes);

            List<ApplicationFileCheckListBO> res = new ArrayList<>();
            for (SchoolPrize schoolPrize : schoolPrizes) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(schoolPrize.getScholarshipId());

                ApplicationFileCheckListBO bo = new ApplicationFileCheckListBO();
                bo.setScholarshipName(scholarship.getScholarshipName());
                bo.setPrizeId(schoolPrize.getId());
                PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
                bo.setPrizeName(prizeInfo.getPrizeName());

                CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
                collegePrizeExample.createCriteria().andSchoolPrizeIdEqualTo(schoolPrize.getId());
                List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
                List<Long> collegePrizeIds = new ArrayList<>();
                for (CollegePrize collegePrize : collegePrizes) {
                    collegePrizeIds.add(collegePrize.getId());
                }
                if (collegePrizeIds.size() == 0) {
                    continue;
                }

                ApplicationExample applicationExample = new ApplicationExample();
                applicationExample.createCriteria().andPrizeIdIn(collegePrizeIds);
                List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
                if (applications.size() == 0) {
                    bo.setApplyNumber(0L);
                    bo.setRejectNumber(0L);
                    bo.setReSubmitNumber(0L);
                } else {
                    List<Long> applicationIds = new ArrayList<>();
                    for (Application application : applications) {
                        applicationIds.add(application.getId());
                    }
                    ApplicationStepExample stepExample = new ApplicationStepExample();
                    stepExample.createCriteria().andApplicationIdIn(applicationIds)
                            .andFlowTemplateStepIdIn(flowTemplateStepIds);
                    Long num1 = applicationStepMapper.countByExample(stepExample);
                    bo.setApplyNumber(num1);

                    List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
                    List<Long> tmp = new ArrayList<>();
                    for (ApplicationStep step : applicationSteps) {
                        tmp.add(step.getApplicationId());
                    }
                    if (tmp.size() == 0) {
                        bo.setRejectNumber(0L);
                        bo.setReSubmitNumber(0L);
                    } else {
                        applicationExample.clear();
                        List<Integer> statuses = new ArrayList<>();
                        statuses.add(ApplicationFileStatusEnum.REJECT.code);
                        statuses.add(ApplicationFileStatusEnum.RESUBMIT.code);
                        applicationExample.createCriteria().andPrizeIdIn(collegePrizeIds)
                                .andFileStatusIn(statuses).andIdIn(tmp);
                        Long num2 = applicationMapper.countByExample(applicationExample);
                        bo.setRejectNumber(num2);

                        applicationExample.clear();

                        applicationExample.createCriteria().andPrizeIdIn(collegePrizeIds)
                                .andFileStatusEqualTo(ApplicationFileStatusEnum.RESUBMIT.code)
                                .andIdIn(tmp);
                        Long num3 = applicationMapper.countByExample(applicationExample);
                        bo.setReSubmitNumber(num3);
                    }
                }

                res.add(bo);
            }
            pageInfo.setList(res);
            return pageInfo;
        }
        return new PageInfo();
    }

    @Override
    public PageInfo getPrizeDetailForFileCheck(UserDTO user, Long prizeId, List<Long> studentIds, List<Integer> status, Integer pageNum, Integer pageSize) {
        if (studentIds.size() == 0) {
            return new PageInfo();
        }
        PrizeInfo prizeInfo;
        if (userService.isSchoolUser(user)) {
            SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(prizeId);
            prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
        } else {
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(prizeId);
            prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
        }
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prizeInfo.getScholarshipId());

        ApplicationExample applicationExample = new ApplicationExample();
        if (userService.isSchoolUser(user)) {
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                    .andUserIdIn(studentIds);
            if (status != null && !status.contains(0)) {
                applicationExample.getOredCriteria().get(0).andFileStatusIn(status);
            }
        } else {
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(prizeId);
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                    .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId())
                    .andUserIdIn(studentIds);
            if (userService.isGradeManger(user)){
                applicationExample.getOredCriteria().get(0).andGradeIdIn(user.getMangeGradeId());
            }
            if (status != null && !status.contains(0)) {
                applicationExample.getOredCriteria().get(0).andFileStatusIn(status);
            }
        }
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        List<Long> applicationIds = new ArrayList<>();
        if (applications.size() == 0) {
            return new PageInfo();
        }
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }


        FlowTemplateStepExample flowTemplateStepExample = new FlowTemplateStepExample();
        flowTemplateStepExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
        List<FlowTemplateStep> flowTemplateSteps = flowTemplateStepMapper.selectByExample(flowTemplateStepExample);
        List<Long> stepIds = new ArrayList<>();
        for (FlowTemplateStep step : flowTemplateSteps) {
            stepIds.add(step.getId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        if (userService.isGradeManger(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.GRADE_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        } else if (userService.isCollegeManger(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        } else if (userService.isSchoolUser(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        }

        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        if (rFlowTemplateStepAndUserRoles.size() == 1) {
            RFlowTemplateStepAndUserRole role = rFlowTemplateStepAndUserRoles.get(0);

            ApplicationStepExample applicationStepExample = new ApplicationStepExample();
            if (!userService.isSchoolUser(user)) {
                CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(prizeId);
                applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                        .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId())
                        .andApplicationIdIn(applicationIds);
            } else {
                applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                        .andApplicationIdIn(applicationIds);
            }
            PageHelper.startPage(pageNum, pageSize);
            List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(applicationStepExample);
            PageInfo pageInfo = new PageInfo(applicationSteps);
            List<ApplicationFileCheckDetailBO> res = new ArrayList<>();
            for (ApplicationStep applicationStep : applicationSteps) {
                Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
                ApplicationFileCheckDetailBO bo = new ApplicationFileCheckDetailBO();
                bo.setApplicationId(application.getId());
                bo.setStatus(ApplicationFileStatusEnum.getByCode(application.getFileStatus()));

                User student = userService.getUserById(application.getUserId());
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

                res.add(bo);
            }
            pageInfo.setList(res);
            return pageInfo;
        }
        return new PageInfo();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void checkApplicationFile(UserDTO user, List<Long> ids, ApplicationFileStatusEnum result) {
        Application application = new Application();
        application.setFileStatus(result.code);

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andIdIn(ids);

        applicationMapper.updateByExampleSelective(application, applicationExample);
    }

    @Override
    public PageInfo getPrizeForAwardCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) throws WSPException {
        if (userService.isGradeManger(user)) {
            PageInfo pageInfo = getPrizeForGradeCheck(user, unitId, pageNum, pageSize);
            return pageInfo;
        } else if (userService.isCollegeManger(user)) {
            PageInfo pageInfo = getPrizeForCollegeCheck(user, unitId, pageNum, pageSize);
            return pageInfo;
        } else if (userService.isSchoolUser(user)) {
            PageInfo pageInfo = getPrizeForSchoolCheck(user, unitId, pageNum, pageSize);
            return pageInfo;
        }
        return null;
    }

    @Override
    public PageInfo getPrizeDetailForAwardCheck(UserDTO user, Long prizeId, List<Long> studentIds, List<Integer> fileStatus, List<Integer> prizeStatus, Integer pageNum, Integer pageSize) {
        if (studentIds.size() == 0) {
            return new PageInfo();
        }
        PrizeInfo prizeInfo;
        CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(prizeId);
        prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prizeInfo.getScholarshipId());

        ApplicationExample applicationExample = new ApplicationExample();
        if (userService.isSchoolUser(user)) {
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                    .andUserIdIn(studentIds);
            if (fileStatus != null && !fileStatus.contains(0)) {
                applicationExample.getOredCriteria().get(0).andFileStatusIn(fileStatus);
            }
        } else {
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                    .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId())
                    .andUserIdIn(studentIds);
            if (userService.isGradeManger(user)){
                applicationExample.getOredCriteria().get(0).andGradeIdIn(user.getMangeGradeId());
            }
            if (fileStatus != null && !fileStatus.contains(0)) {
                applicationExample.getOredCriteria().get(0).andFileStatusIn(fileStatus);
            }
        }
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        List<Long> applicationIds = new ArrayList<>();
        if (applications.size() == 0) {
            return new PageInfo();
        }
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }

        FlowTemplateStepExample flowTemplateStepExample = new FlowTemplateStepExample();
        flowTemplateStepExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
        List<FlowTemplateStep> flowTemplateSteps = flowTemplateStepMapper.selectByExample(flowTemplateStepExample);
        List<Long> stepIds = new ArrayList<>();
        for (FlowTemplateStep step : flowTemplateSteps) {
            stepIds.add(step.getId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        if (userService.isGradeManger(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.GRADE_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        } else if (userService.isCollegeManger(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        } else if (userService.isSchoolUser(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        }

        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        if (rFlowTemplateStepAndUserRoles.size() == 1) {
            RFlowTemplateStepAndUserRole role = rFlowTemplateStepAndUserRoles.get(0);

            ApplicationStepExample applicationStepExample = new ApplicationStepExample();
            applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                    .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId())
                    .andApplicationIdIn(applicationIds);
            if (prizeStatus != null && !prizeStatus.contains(0)) {
                applicationStepExample.getOredCriteria().get(0).andStatusIn(prizeStatus);
            }
            PageHelper.startPage(pageNum, pageSize);
            List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(applicationStepExample);
            PageInfo pageInfo = new PageInfo(applicationSteps);
            List<ApplicationAwardCheckDetailBO> res = new ArrayList<>();
            for (ApplicationStep applicationStep : applicationSteps) {
                Application application = applicationMapper.selectByPrimaryKey(applicationStep.getApplicationId());
                ApplicationAwardCheckDetailBO bo = new ApplicationAwardCheckDetailBO();
                bo.setApplicationId(application.getId());
                bo.setFileStatus(ApplicationFileStatusEnum.getByCode(application.getFileStatus()));
                bo.setPrizeStatus(ApplicationPrizeStatusEnum.getByCode(applicationStep.getStatus()));
                bo.setStepId(applicationStep.getId());
                User student = userService.getUserById(application.getUserId());
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

                ApplicationExample applicationExample2 = new ApplicationExample();
                applicationExample2.createCriteria().andUserIdEqualTo(application.getUserId());
                List<Application> applications2 = applicationMapper.selectByExampleWithBLOBs(applicationExample2);
                List<String> records = new ArrayList<>();
                for (Application app : applications2) {
                    Scholarship scho = scholarshipMapper.selectByPrimaryKey(app.getScholarshipId());
                    String scholarName = scho.getScholarshipName();
                    PrizeInfo info = prizeInfoMapper.selectByPrimaryKey(app.getPrizeInfoId());
                    String prizeName = info.getPrizeName();
                    String record = String.format("%s%s，材料%s，获奖%s；",
                            scholarName, prizeName, ApplicationFileStatusEnum.getNameByCode(app.getFileStatus()),
                            ApplicationPrizeStatusEnum.getNameByCode(app.getPrizeStatus()));
                    records.add(record);
                }
                bo.setRecords(records);

                res.add(bo);
            }
            pageInfo.setList(res);
            return pageInfo;
        }

        return new PageInfo();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void checkApplicationPrize(UserDTO user, List<Long> ids, ApplicationPrizeStatusEnum result) throws WSPException {
        if (result == ApplicationPrizeStatusEnum.REJECT) {
            for (Long id : ids) {
                ApplicationStep step = applicationStepMapper.selectByPrimaryKey(id);
                step.setStatus(result.code);
                step.setOperatorId(user.getId());
                step.setOperationDate(new Date());
                applicationStepMapper.updateByPrimaryKeySelective(step);

                Application application = applicationMapper.selectByPrimaryKey(step.getApplicationId());
                application.setPrizeStatus(result.code);
                applicationMapper.updateByPrimaryKeySelective(application);
            }
        } else if (result == ApplicationPrizeStatusEnum.PASS) {
            if (ids.size() > 0) {
                Long id = ids.get(0);
                ApplicationStep step = applicationStepMapper.selectByPrimaryKey(id);
                Application application = applicationMapper.selectByPrimaryKey(step.getApplicationId());
                if (userService.isGradeManger(user)) {
                    CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
                    collegePrizeExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(step.getPrimaryTeachingInstitutionId())
                            .andPrizeInfoIdEqualTo(application.getPrizeInfoId());
                    List<CollegePrize> tmp = collegePrizeMapper.selectByExample(collegePrizeExample);
                    if (tmp.size() == 1) {
                        CollegePrize collegePrize = tmp.get(0);
                        if (collegePrize.getSubmitStatus() == false) {
                            throw new WSPException(ErrorInfo.CLOSE_COLLEGE_SUBMIT);
                        }
                    } else {
                        throw new WSPException(ErrorInfo.PARAMS_ERROR);
                    }
                } else if (userService.isCollegeManger(user)) {
                    SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
                    schoolPrizeExample.createCriteria().andPrizeInfoIdEqualTo(application.getPrizeInfoId());
                    List<SchoolPrize> tmp = schoolPrizeMapper.selectByExample(schoolPrizeExample);
                    if (tmp.size() == 1) {
                        SchoolPrize schoolPrize = tmp.get(0);
                        if (schoolPrize.getSubmitStatus() == false) {
                            throw new WSPException(ErrorInfo.CLOSE_COLLEGE_SUBMIT);
                        }
                    } else {
                        throw new WSPException(ErrorInfo.PARAMS_ERROR);
                    }
                }
            } else {
                return;
            }
            for (Long id : ids) {
                ApplicationStep step = applicationStepMapper.selectByPrimaryKey(id);
                FlowTemplateStep flowTemplateStep = flowTemplateStepMapper.selectByPrimaryKey(step.getFlowTemplateStepId());
                FlowTemplateStep nextStep = flowTemplateService.findTheNextStep(flowTemplateStep.getFlowTemplateId(),
                        flowTemplateStep.getId());

                Application application = applicationMapper.selectByPrimaryKey(step.getApplicationId());
                if (userService.isGradeManger(user)) {
                    GradePrizeExample gradePrizeExample = new GradePrizeExample();
                    gradePrizeExample.createCriteria().andPrizeInfoIdEqualTo(application.getPrizeInfoId())
                            .andPrimaryTeachingInstitutionIdEqualTo(application.getPrimaryTeachingInstitutionId())
                            .andGradeIdEqualTo(application.getGradeId());
                    List<GradePrize> gradePrizes = gradePrizeMapper.selectByExample(gradePrizeExample);
                    if (gradePrizes.size() == 1) {
                        GradePrize gradePrize = gradePrizes.get(0);

                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
                        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                        ApplicationStepExample stepExample = new ApplicationStepExample();
                        stepExample.createCriteria().andFlowTemplateStepIdEqualTo(step.getFlowTemplateStepId())
                                .andPrimaryTeachingInstitutionIdEqualTo(step.getPrimaryTeachingInstitutionId())
                                .andGradeIdEqualTo(step.getGradeId())
                                .andPrizeIdEqualTo(gradePrize.getCollegePrizeId())
                                .andStatusIn(tmp);
                        Long usedNumber = applicationStepMapper.countByExample(stepExample);

                        if (gradePrize.getNumber() <= usedNumber) {
                            throw new WSPException(ErrorInfo.FULL_NUMBER);
                        }
                    }

                } else if (userService.isCollegeManger(user)) {
                    CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(application.getPrizeId());
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(ApplicationPrizeStatusEnum.PASS.code);
                    tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                    ApplicationStepExample stepExample = new ApplicationStepExample();
                    stepExample.createCriteria().andFlowTemplateStepIdEqualTo(step.getFlowTemplateStepId())
                            .andPrimaryTeachingInstitutionIdEqualTo(step.getPrimaryTeachingInstitutionId())
                            .andGradeIdEqualTo(step.getGradeId())
                            .andPrizeIdEqualTo(collegePrize.getId())
                            .andStatusIn(tmp);
                    Long usedNumber = applicationStepMapper.countByExample(stepExample);

                    if (collegePrize.getNumber() - collegePrize.getRestNumber() <= usedNumber) {
                        throw new WSPException(ErrorInfo.FULL_NUMBER);
                    }
                } else if (userService.isSchoolUser(user)) {
                    CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(application.getPrizeId());
                    SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(collegePrize.getSchoolPrizeId());
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(ApplicationPrizeStatusEnum.PASS.code);
                    tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                    ApplicationStepExample stepExample = new ApplicationStepExample();
                    stepExample.createCriteria().andFlowTemplateStepIdEqualTo(step.getFlowTemplateStepId())
                            .andPrimaryTeachingInstitutionIdEqualTo(step.getPrimaryTeachingInstitutionId())
                            .andGradeIdEqualTo(step.getGradeId())
                            .andPrizeIdEqualTo(collegePrize.getId())
                            .andStatusIn(tmp);
                    Long usedNumber = applicationStepMapper.countByExample(stepExample);

                    if (schoolPrize.getNumber() - schoolPrize.getRestNumber() <= usedNumber) {
                        throw new WSPException(ErrorInfo.FULL_NUMBER);
                    }
                }

                if (nextStep == null) {

                    step.setStatus(ApplicationPrizeStatusEnum.PASS.code);
                    step.setOperatorId(user.getId());
                    step.setOperationDate(new Date());
                    applicationStepMapper.updateByPrimaryKeySelective(step);

                    application.setPrizeStatus(result.code);
                    applicationMapper.updateByPrimaryKeySelective(application);
                } else {
                    step.setStatus(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                    step.setOperatorId(user.getId());
                    step.setOperationDate(new Date());
                    applicationStepMapper.updateByPrimaryKeySelective(step);

                    application.setPrizeStatus(ApplicationPrizeStatusEnum.SUBMIT.code);
                    applicationMapper.updateByPrimaryKeySelective(application);

                }
            }
        }

    }

    @Override
    public PageInfo getCollegePrizeForAwardCheck(UserDTO user, Long prizeId, Integer pageNum, Integer pageSize) {
        SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(prizeId);
        PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId());
        PageHelper.startPage(pageNum, pageSize);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        PageInfo pageInfo = new PageInfo(collegePrizes);
        if (collegePrizes.size() == 0) {
            return new PageInfo();
        }
        List<ApplicationAwardCheckListBO> res = new ArrayList<>();
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prizeInfo.getScholarshipId());
        for (CollegePrize collegePrize : collegePrizes) {
            ApplicationAwardCheckListBO bo = new ApplicationAwardCheckListBO();
            bo.setPrizeInfoId(prizeInfo.getId());
            bo.setPrizeId(collegePrize.getId());
            bo.setAvailableNumber(collegePrize.getNumber().longValue());

            bo.setEndDate(scholarship.getCollegeEndDate());

            PrimaryTeachingInstitution primaryTeachingInstitution = primaryTeachingInstitutionMapper
                    .selectByPrimaryKey(collegePrize.getPrimaryTeachingInstitutionId());
            bo.setUnitName(primaryTeachingInstitution.getName());
            bo.setUnitId(primaryTeachingInstitution.getId());

            RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code);
            List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                    .selectByExample(roleExample);
            List<Long> flowTemplateStepIds = new ArrayList<>();
            for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
                flowTemplateStepIds.add(role.getFlowTemplateStepId());
            }
            if (flowTemplateStepIds.size() == 0) {
                continue;
            }

            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                    .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId());
            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            if (applications.size() == 0) {
                bo.setApplyNumber(0L);
                bo.setUsedNumber(0L);
            } else {
                List<Long> applicationIds = new ArrayList<>();
                for (Application application : applications) {
                    applicationIds.add(application.getId());
                }
                ApplicationStepExample stepExample = new ApplicationStepExample();
                stepExample.createCriteria().andApplicationIdIn(applicationIds)
                        .andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num1 = applicationStepMapper.countByExample(stepExample);
                bo.setApplyNumber(num1);

                stepExample.clear();
                stepExample.createCriteria()
                        .andStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code)
                        .andApplicationIdIn(applicationIds).andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num2 = applicationStepMapper.countByExample(stepExample);
                bo.setUsedNumber(num2);
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public PageInfo getStudentWinningRecord(UserDTO user, Integer pageNum, Integer pageSize) {
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andUserIdEqualTo(user.getId())
//                .andStatusEqualTo(ApplicationStatusEnum.PASS.code)
                .andPrizeStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
        PageHelper.startPage(pageNum, pageSize);
        List<Application> list = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        PageInfo pageInfo = new PageInfo(list);
        List<WinningRecordBO> res = new ArrayList<>();
        for (Application application : list) {
            WinningRecordBO bo = new WinningRecordBO();
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(application.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(application.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            bo.setMoney(prizeInfo.getMoney());
            bo.setYear("暂无");
            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void closeSubmit(UserDTO user, Long id, Long unitId) throws WSPException {
        Scholarship scholarship;
        ApplicationExample applicationExample = new ApplicationExample();

        if (userService.isSchoolUser(user)) {
            SchoolPrize schoolPrize = schoolPrizeMapper.selectByPrimaryKey(id);
            schoolPrize.setSubmitStatus(false);
            schoolPrizeMapper.updateByPrimaryKeySelective(schoolPrize);

            scholarship = scholarshipMapper.selectByPrimaryKey(schoolPrize.getScholarshipId());
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(schoolPrize.getPrizeInfoId());
        } else if (userService.isCollegeManger(user)) {
            CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(id);
            collegePrize.setSubmitStatus(false);
            collegePrize.setApplyStatus(false);
            collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
            scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(collegePrize.getPrizeInfoId())
                    .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId());
        } else {
            return;
        }

        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        List<Long> applicationIds = new ArrayList<>();
        if (applications.size() == 0) {
            return;
        }
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }

        FlowTemplateStepExample flowTemplateStepExample = new FlowTemplateStepExample();
        flowTemplateStepExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
        List<FlowTemplateStep> flowTemplateSteps = flowTemplateStepMapper.selectByExample(flowTemplateStepExample);
        List<Long> stepIds = new ArrayList<>();
        for (FlowTemplateStep step : flowTemplateSteps) {
            stepIds.add(step.getId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        if (userService.isCollegeManger(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.GRADE_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        } else if (userService.isSchoolUser(user)) {
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);
        }

        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        if (rFlowTemplateStepAndUserRoles.size() == 1) {


            RFlowTemplateStepAndUserRole role = rFlowTemplateStepAndUserRoles.get(0);
            ApplicationStepExample applicationStepExample = new ApplicationStepExample();
            if (userService.isSchoolUser(user)) {
                applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                        .andStatusEqualTo(ApplicationPrizeStatusEnum.WAIT_PASS.code)
                        .andApplicationIdIn(applicationIds);
            } else if (userService.isCollegeManger(user)) {
                CollegePrize collegePrize = collegePrizeMapper.selectByPrimaryKey(id);
                applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                        .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId())
                        .andStatusEqualTo(ApplicationPrizeStatusEnum.WAIT_PASS.code)
                        .andApplicationIdIn(applicationIds);
            }
            List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(applicationStepExample);

            for (ApplicationStep step : applicationSteps) {
                step.setStatus(ApplicationPrizeStatusEnum.PASS.code);
                applicationStepMapper.updateByPrimaryKeySelective(step);

                FlowTemplateStep flowTemplateStep = flowTemplateStepMapper.selectByPrimaryKey(step.getFlowTemplateStepId());
                FlowTemplateStep nextStep = flowTemplateService.findTheNextStep(flowTemplateStep.getFlowTemplateId(),
                        flowTemplateStep.getId());

                ApplicationStep applicationStep = new ApplicationStep();
                applicationStep.setFlowTemplateStepId(nextStep.getId());
                applicationStep.setStatus(ApplicationPrizeStatusEnum.SUBMIT.code);
                applicationStep.setPrimaryTeachingInstitutionId(step.getPrimaryTeachingInstitutionId());
                applicationStep.setGradeId(step.getGradeId());
                applicationStep.setPrizeId(step.getPrizeId());
                applicationStep.setApplicationId(step.getApplicationId());
                applicationStepMapper.insertSelective(applicationStep);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void closeCollegeSubmitForSchedule(Long scholarshipId) {
        SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
        schoolPrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId).andSubmitStatusEqualTo(true);
        List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
        for (SchoolPrize schoolPrize : schoolPrizes) {
            schoolPrize.setSubmitStatus(false);
            schoolPrizeMapper.updateByPrimaryKeySelective(schoolPrize);

            ApplicationExample applicationExample = new ApplicationExample();
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(schoolPrize.getScholarshipId());
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(schoolPrize.getPrizeInfoId());

            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            List<Long> applicationIds = new ArrayList<>();
            if (applications.size() == 0) {
                return;
            }
            for (Application application : applications) {
                applicationIds.add(application.getId());
            }

            FlowTemplateStepExample flowTemplateStepExample = new FlowTemplateStepExample();
            flowTemplateStepExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
            List<FlowTemplateStep> flowTemplateSteps = flowTemplateStepMapper.selectByExample(flowTemplateStepExample);
            List<Long> stepIds = new ArrayList<>();
            for (FlowTemplateStep step : flowTemplateSteps) {
                stepIds.add(step.getId());
            }

            RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);

            List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                    .selectByExample(roleExample);
            if (rFlowTemplateStepAndUserRoles.size() == 1) {


                RFlowTemplateStepAndUserRole role = rFlowTemplateStepAndUserRoles.get(0);
                ApplicationStepExample applicationStepExample = new ApplicationStepExample();
                applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                        .andStatusEqualTo(ApplicationPrizeStatusEnum.WAIT_PASS.code)
                        .andApplicationIdIn(applicationIds);
                List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(applicationStepExample);

                for (ApplicationStep step : applicationSteps) {
                    step.setStatus(ApplicationPrizeStatusEnum.PASS.code);
                    applicationStepMapper.updateByPrimaryKeySelective(step);

                    FlowTemplateStep flowTemplateStep = flowTemplateStepMapper.selectByPrimaryKey(step.getFlowTemplateStepId());
                    FlowTemplateStep nextStep = flowTemplateService.findTheNextStep(flowTemplateStep.getFlowTemplateId(),
                            flowTemplateStep.getId());

                    ApplicationStep applicationStep = new ApplicationStep();
                    applicationStep.setFlowTemplateStepId(nextStep.getId());
                    applicationStep.setStatus(ApplicationPrizeStatusEnum.SUBMIT.code);
                    applicationStep.setPrimaryTeachingInstitutionId(step.getPrimaryTeachingInstitutionId());
                    applicationStep.setGradeId(step.getGradeId());
                    applicationStep.setPrizeId(step.getPrizeId());
                    applicationStep.setApplicationId(step.getApplicationId());
                    applicationStepMapper.insertSelective(applicationStep);
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void closeGradeSubmitForSchedule(Long scholarshipId, Long unitId) {
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria().andSchoolPrizeIdEqualTo(scholarshipId)
                .andPrimaryTeachingInstitutionIdEqualTo(unitId);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        for (CollegePrize collegePrize : collegePrizes) {
            ApplicationExample applicationExample = new ApplicationExample();
            collegePrize.setSubmitStatus(false);
            collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(collegePrize.getPrizeInfoId())
                    .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId());

            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            List<Long> applicationIds = new ArrayList<>();
            if (applications.size() == 0) {
                return;
            }
            for (Application application : applications) {
                applicationIds.add(application.getId());
            }

            FlowTemplateStepExample flowTemplateStepExample = new FlowTemplateStepExample();
            flowTemplateStepExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
            List<FlowTemplateStep> flowTemplateSteps = flowTemplateStepMapper.selectByExample(flowTemplateStepExample);
            List<Long> stepIds = new ArrayList<>();
            for (FlowTemplateStep step : flowTemplateSteps) {
                stepIds.add(step.getId());
            }

            RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.GRADE_ADVISER.code)
                    .andFlowTemplateStepIdIn(stepIds);

            List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                    .selectByExample(roleExample);
            if (rFlowTemplateStepAndUserRoles.size() == 1) {
                RFlowTemplateStepAndUserRole role = rFlowTemplateStepAndUserRoles.get(0);
                ApplicationStepExample applicationStepExample = new ApplicationStepExample();
                applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                        .andPrimaryTeachingInstitutionIdEqualTo(collegePrize.getPrimaryTeachingInstitutionId())
                        .andStatusEqualTo(ApplicationPrizeStatusEnum.WAIT_PASS.code)
                        .andApplicationIdIn(applicationIds);
                List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(applicationStepExample);

                for (ApplicationStep step : applicationSteps) {
                    step.setStatus(ApplicationPrizeStatusEnum.PASS.code);
                    applicationStepMapper.updateByPrimaryKeySelective(step);

                    FlowTemplateStep flowTemplateStep = flowTemplateStepMapper.selectByPrimaryKey(step.getFlowTemplateStepId());
                    FlowTemplateStep nextStep = flowTemplateService.findTheNextStep(flowTemplateStep.getFlowTemplateId(),
                            flowTemplateStep.getId());

                    ApplicationStep applicationStep = new ApplicationStep();
                    applicationStep.setFlowTemplateStepId(nextStep.getId());
                    applicationStep.setStatus(ApplicationPrizeStatusEnum.SUBMIT.code);
                    applicationStep.setPrimaryTeachingInstitutionId(step.getPrimaryTeachingInstitutionId());
                    applicationStep.setGradeId(step.getGradeId());
                    applicationStep.setPrizeId(step.getPrizeId());
                    applicationStep.setApplicationId(step.getApplicationId());
                    applicationStepMapper.insertSelective(applicationStep);
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void closeApplyForSchedule(Long scholarshipId, Long unitId) {
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria().andSchoolPrizeIdEqualTo(scholarshipId)
                .andPrimaryTeachingInstitutionIdEqualTo(unitId);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        for (CollegePrize collegePrize : collegePrizes) {
            ApplicationExample applicationExample = new ApplicationExample();
            collegePrize.setApplyStatus(false);
            collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
        }
    }

    @Override
    public PageInfo getAwardApplicationsByScholarship(UserDTO user, Long scholarshipId, List<Long> studentIds, Integer pageNum, Integer pageSize) {
        if (studentIds.size() == 0) {
            return new PageInfo();
        }
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andScholarshipIdEqualTo(scholarshipId)
//                .andStatusEqualTo(ApplicationStatusEnum.PASS.code)
                .andPrizeStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
        if (studentIds != null && studentIds.size() > 0) {
            criteria.andUserIdIn(studentIds);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Application> list = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        PageInfo pageInfo = new PageInfo(list);
        List<WinningRecordDetailBO> res = new ArrayList<>();
        for (Application application : list) {
            WinningRecordDetailBO bo = new WinningRecordDetailBO();
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(application.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(application.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());
            bo.setApplicationId(application.getId());
            User student = userService.getUserById(application.getUserId());
            if (student != null) {
                bo.setName(student.getName());
                bo.setSn(student.getSn());
            }

            if (student.getPrimaryTeachingInstitutionId() != null) {
                PrimaryTeachingInstitution primaryTeachingInstitution = primaryTeachingInstitutionMapper
                        .selectByPrimaryKey(student.getPrimaryTeachingInstitutionId());
                bo.setCollegeName(primaryTeachingInstitution.getName());
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

            ApplicationExample applicationExample2 = new ApplicationExample();
            applicationExample2.createCriteria().andUserIdEqualTo(application.getUserId())
                    .andPrizeStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
            List<Application> applications2 = applicationMapper.selectByExampleWithBLOBs(applicationExample2);
            List<String> records = new ArrayList<>();
            for (Application app : applications2) {
                Scholarship scho = scholarshipMapper.selectByPrimaryKey(app.getScholarshipId());
                String scholarName = scho.getScholarshipName();
                PrizeInfo info = prizeInfoMapper.selectByPrimaryKey(app.getPrizeInfoId());
                String prizeName = info.getPrizeName();
                String record = String.format("%s%s，材料%s，获奖%s；",
                        scholarName, prizeName, ApplicationFileStatusEnum.getNameByCode(app.getFileStatus()),
                        ApplicationPrizeStatusEnum.getNameByCode(app.getPrizeStatus()));
                records.add(record);
            }
            bo.setRecords(records);
            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }


    private PageInfo getPrizeForGradeCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) throws WSPException {
        if (user.getManageGrades().size() == 0) {
            return new PageInfo();
        }
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        scholarshipExample.createCriteria().andNeedGradeCheckEqualTo(true)
                .andStatusEqualTo(StatusEnum.OPEN.code);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        if (scholarships.size() == 0) {
            return new PageInfo();
        }
        List<Long> scholarshipIds = new ArrayList<>();
        for (Scholarship scholarship : scholarships) {
            scholarshipIds.add(scholarship.getId());
        }

        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        GradePrizeExample gradePrizeExample = new GradePrizeExample();
        gradePrizeExample.createCriteria().andGradeIdIn(user.getMangeGradeId())
                .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                .andStatusIn(status).andScholarshipIdIn(scholarshipIds);
        List<GradePrize> gradePrizes = gradePrizeMapper.selectByExample(gradePrizeExample);
        if (gradePrizes.size() == 0) {
            return new PageInfo();
        }

        List<Long> prizeInfoIds = new ArrayList<>();
        for (GradePrize gradePrize : gradePrizes) {
            prizeInfoIds.add(gradePrize.getPrizeInfoId());
        }

        PrizeInfoExample prizeInfoExample = new PrizeInfoExample();
        prizeInfoExample.createCriteria().andIdIn(prizeInfoIds);
        PageHelper.startPage(pageNum, pageSize);
        List<PrizeInfo> prizeInfos = prizeInfoMapper.selectByExample(prizeInfoExample);
        PageInfo pageInfo = new PageInfo(prizeInfos);

        List<ApplicationAwardCheckListBO> res = new ArrayList<>();
        for (PrizeInfo prizeInfo : prizeInfos) {
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prizeInfo.getScholarshipId());

            ApplicationAwardCheckListBO bo = new ApplicationAwardCheckListBO();
            bo.setScholarshipName(scholarship.getScholarshipName());
            bo.setPrizeInfoId(prizeInfo.getId());
            bo.setPrizeName(prizeInfo.getPrizeName());

            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                    .andPrizeInfoIdEqualTo(prizeInfo.getId());
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            CollegePrize collegePrize;
            if (collegePrizes.size() == 1) {
                collegePrize = collegePrizes.get(0);
            } else {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            bo.setPrizeId(collegePrize.getId());
            bo.setSubmitStatus(collegePrize.getSubmitStatus());
            bo.setApplyStatus(collegePrize.getApplyStatus());

            GradePrizeExample gradePrizeExample2 = new GradePrizeExample();
            gradePrizeExample2.createCriteria().andGradeIdIn(user.getMangeGradeId())
                    .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                    .andStatusIn(status).andPrizeInfoIdEqualTo(prizeInfo.getId());
            List<GradePrize> mangeGradePrizes = gradePrizeMapper.selectByExample(gradePrizeExample2);
            Long availableNumber = 0L;
            for (GradePrize gradePrize : mangeGradePrizes) {
                availableNumber += gradePrize.getNumber();
            }
            bo.setAvailableNumber(availableNumber);

            PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
            limitTimeExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                    .andScholarshipIdEqualTo(prizeInfo.getScholarshipId());
            List<PrizeCollegeLimitTime> prizeCollegeLimitTimes = prizeCollegeLimitTimeMapper.selectByExample(limitTimeExample);
            if (prizeCollegeLimitTimes.size() == 1) {
                PrizeCollegeLimitTime prizeCollegeLimitTime = prizeCollegeLimitTimes.get(0);
                bo.setEndDate(prizeCollegeLimitTime.getStudentEndDate());
            }

            RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.GRADE_ADVISER.code);
            List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                    .selectByExample(roleExample);
            List<Long> flowTemplateStepIds = new ArrayList<>();
            for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
                flowTemplateStepIds.add(role.getFlowTemplateStepId());
            }
            if (flowTemplateStepIds.size() == 0) {
                continue;
            }

            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                    .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                    .andGradeIdIn(user.getMangeGradeId());
            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            if (applications.size() == 0) {
                bo.setApplyNumber(0L);
                bo.setUsedNumber(0L);
            } else {
                List<Long> applicationIds = new ArrayList<>();
                for (Application application : applications) {
                    applicationIds.add(application.getId());
                }
                ApplicationStepExample stepExample = new ApplicationStepExample();
                stepExample.createCriteria().andApplicationIdIn(applicationIds)
                        .andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num1 = applicationStepMapper.countByExample(stepExample);
                bo.setApplyNumber(num1);

                stepExample.clear();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(ApplicationPrizeStatusEnum.PASS.code);
                tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                stepExample.createCriteria()
                        .andStatusIn(tmp)
                        .andApplicationIdIn(applicationIds).andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num2 = applicationStepMapper.countByExample(stepExample);
                bo.setUsedNumber(num2);
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }


    private PageInfo getPrizeForCollegeCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) {
        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SPECIAL_ADVISER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }
        if (flowTemplateStepIds.size() == 0) {
            return new PageInfo();
        }

        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        collegePrizeExample.createCriteria()
                .andPrimaryTeachingInstitutionIdEqualTo(unitId)
                .andStatusIn(status);
        PageHelper.startPage(pageNum, pageSize);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        if (collegePrizes.size() == 0) {
            return new PageInfo();
        }
        PageInfo pageInfo = new PageInfo(collegePrizes);

        List<ApplicationAwardCheckListBO> res = new ArrayList<>();
        for (CollegePrize collegePrize : collegePrizes) {
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(collegePrize.getScholarshipId());

            ApplicationAwardCheckListBO bo = new ApplicationAwardCheckListBO();
            bo.setScholarshipName(scholarship.getScholarshipName());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(collegePrize.getPrizeInfoId());
            bo.setPrizeInfoId(prizeInfo.getId());
            bo.setPrizeName(prizeInfo.getPrizeName());

            bo.setPrizeId(collegePrize.getId());
            bo.setSubmitStatus(collegePrize.getSubmitStatus());
            bo.setApplyStatus(collegePrize.getApplyStatus());

            bo.setAvailableNumber(collegePrize.getNumber().longValue());

            bo.setEndDate(scholarship.getCollegeEndDate());

            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId())
                    .andPrimaryTeachingInstitutionIdEqualTo(unitId);
            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            if (applications.size() == 0) {
                bo.setApplyNumber(0L);
                bo.setUsedNumber(0L);
            } else {
                List<Long> applicationIds = new ArrayList<>();
                for (Application application : applications) {
                    applicationIds.add(application.getId());
                }
                ApplicationStepExample stepExample = new ApplicationStepExample();
                stepExample.createCriteria().andApplicationIdIn(applicationIds)
                        .andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num1 = applicationStepMapper.countByExample(stepExample);
                bo.setApplyNumber(num1);

                stepExample.clear();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(ApplicationPrizeStatusEnum.PASS.code);
                tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                stepExample.createCriteria()
                        .andStatusIn(tmp)
                        .andApplicationIdIn(applicationIds).andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num2 = applicationStepMapper.countByExample(stepExample);
                bo.setUsedNumber(num2);
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    private PageInfo getPrizeForSchoolCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) {
        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL_USER.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }
        if (flowTemplateStepIds.size() == 0) {
            return new PageInfo();
        }

        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
        schoolPrizeExample.createCriteria().andStatusIn(status);
        PageHelper.startPage(pageNum, pageSize);
        List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
        if (schoolPrizes.size() == 0) {
            return new PageInfo();
        }
        PageInfo pageInfo = new PageInfo(schoolPrizes);

        List<ApplicationAwardCheckListBO> res = new ArrayList<>();
        for (SchoolPrize schoolPrize : schoolPrizes) {
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(schoolPrize.getScholarshipId());

            ApplicationAwardCheckListBO bo = new ApplicationAwardCheckListBO();
            bo.setScholarshipName(scholarship.getScholarshipName());
            bo.setPrizeInfoId(schoolPrize.getPrizeInfoId());
            PrizeInfo prizeInfo = prizeInfoMapper.selectByPrimaryKey(schoolPrize.getPrizeInfoId());
            bo.setPrizeName(prizeInfo.getPrizeName());

            bo.setPrizeId(schoolPrize.getId());
            bo.setSubmitStatus(schoolPrize.getSubmitStatus());

            bo.setAvailableNumber(schoolPrize.getNumber().longValue());

            bo.setEndDate(scholarship.getCollegeEndDate());

            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andPrizeInfoIdEqualTo(prizeInfo.getId());
            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            if (applications.size() == 0) {
                bo.setApplyNumber(0L);
                bo.setUsedNumber(0L);
            } else {
                List<Long> applicationIds = new ArrayList<>();
                for (Application application : applications) {
                    applicationIds.add(application.getId());
                }
                ApplicationStepExample stepExample = new ApplicationStepExample();
                stepExample.createCriteria().andApplicationIdIn(applicationIds)
                        .andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num1 = applicationStepMapper.countByExample(stepExample);
                bo.setApplyNumber(num1);

                stepExample.clear();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(ApplicationPrizeStatusEnum.PASS.code);
                tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                stepExample.createCriteria()
                        .andStatusIn(tmp)
                        .andApplicationIdIn(applicationIds).andFlowTemplateStepIdIn(flowTemplateStepIds);
                Long num2 = applicationStepMapper.countByExample(stepExample);
                bo.setUsedNumber(num2);
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }
}

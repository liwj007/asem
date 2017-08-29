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
    private PrizeMapper prizeMapper;

    @Autowired
    private ScholarshipMapper scholarshipMapper;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationReasonMapper applicationReasonMapper;

    @Autowired
    private ApplicationFileMapper applicationFileMapper;

    @Autowired
    private CollegeTimeLimitMapper collegeTimeLimitMapper;

    @Autowired
    private AssessmentRecordMapper assessmentRecordMapper;

    @Autowired
    private IFlowTemplateService flowTemplateService;

    @Autowired
    private ApplicationStepMapper applicationStepMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;


    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private SecondaryTeachingInstitutionMapper secondaryTeachingInstitutionMapper;

    @Autowired
    private RFlowTemplateStepAndUserRoleMapper rFlowTemplateStepAndUserRoleMapper;

    @Override
    @Transactional
    public void createApplication(UserDTO user, EntireApplicationForm applicationForm) throws WSPException {
        for (Long prizeId : applicationForm.getPrizeIds()) {
            Prize prize = prizeMapper.selectByPrimaryKey(prizeId);
            if (prize == null) {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            Application application = new Application();
            application.setPrizeId(prizeId);
            application.setScholarshipId(prize.getScholarshipId());
            application.setStatus(ApplicationStatusEnum.SUBMIT.code);
            application.setFileStatus(ApplicationFileStatusEnum.SUBMIT.code);
            application.setPrizeStatus(ApplicationPrizeStatusEnum.SUBMIT.code);
            application.setUserId(user.getId());
            application.setCreateDate(new Date());
            application.setEvaluation(applicationForm.getEvaluation());
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
            applicationStep.setPrimaryTeachingInstitutionId(user.getPrimaryTeachingInstitution().getId());
            applicationStep.setGradeId(user.getGrade().getId());
            applicationStep.setFlowTemplateStepId(firstStep.getId());
            if (scholarship.getNeedGradeCheck()) {
                applicationStep.setStatus(ApplicationStepStatusEnum.GRADE.code);
            } else {
                applicationStep.setStatus(ApplicationStepStatusEnum.COLLEGE.code);
            }
            applicationStepMapper.insertSelective(applicationStep);
        }
    }

    @Override
    @Transactional
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
    public PageInfo getPrizeForAwardCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) {
        if (userService.isGradeManger(user)) {
            PrizeExample prizeExample = new PrizeExample();
            List<Integer> status = new ArrayList<>();
            status.add(StatusEnum.OPEN.code);
            status.add(StatusEnum.CLOSE.code);
            prizeExample.createCriteria()
                    .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                    .andGradeIdIn(user.getMangeGradeId())
                    .andLevelNumberEqualTo(LevelNumberEnum.GRADE.code)
                    .andStatusIn(status);
            PageHelper.startPage(pageNum, pageSize);
            List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
            PageInfo pageInfo = new PageInfo(prizes);

            List<ApplicationAwardCheckListBO> res = new ArrayList<>();
            for (Prize prize : prizes) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());

                ApplicationAwardCheckListBO bo = new ApplicationAwardCheckListBO();
                bo.setScholarshipName(scholarship.getScholarshipName());
                bo.setPrizeId(prize.getId());
                bo.setPrizeName(prize.getPrizeName());
                bo.setAvaibleNumber(prize.getNumber().longValue());

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

                ApplicationStepExample stepExample = new ApplicationStepExample();
                stepExample.createCriteria().andFlowTemplateStepIdIn(flowTemplateStepIds)
                        .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                        .andGradeIdIn(user.getMangeGradeId());
                Long num1 = applicationStepMapper.countByExample(stepExample);
                bo.setApplyNumber(num1);

                stepExample.clear();
                stepExample.createCriteria().andFlowTemplateStepIdIn(flowTemplateStepIds)
                        .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                        .andGradeIdIn(user.getMangeGradeId()).andStatusEqualTo(ApplicationPrizeStatusEnum.PASS.code);
                Long num2 = applicationStepMapper.countByExample(stepExample);
                bo.setUsedNumber(num2);

                CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
                collegeTimeLimitExample.createCriteria()
                        .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                        .andScholarshipIdEqualTo(scholarship.getId());
                List<CollegeTimeLimit> limits = collegeTimeLimitMapper.selectByExample(collegeTimeLimitExample);
                if (limits.size()==1){
                    CollegeTimeLimit collegeTimeLimit = limits.get(0);
                    bo.setEndDate(collegeTimeLimit.getGradeEndDate());
                }

                res.add(bo);
            }
            pageInfo.setList(res);
            return pageInfo;
        }
        return null;
    }


    @Override
    public PageInfo getPrizeWhichCanSubmit(UserDTO user, Integer pageNum, Integer pageSize) {
        PrizeExample prizeExample = new PrizeExample();
        prizeExample.createCriteria().andStatusEqualTo(StatusEnum.OPEN.code)
                .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId())
                .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code);
        PageHelper.startPage(pageNum, pageSize);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        PageInfo pageInfo = new PageInfo(prizes);
        List<PrizeForApplicationBO> res = new ArrayList<>();
        for (Prize prize : prizes) {
            PrizeForApplicationBO bo = new PrizeForApplicationBO();
            bo.setPrizeId(prize.getId());
            bo.setPrizeName(prize.getPrizeName());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());

            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andUserIdEqualTo(user.getId())
                    .andPrizeIdEqualTo(prize.getId());
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

            CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
            collegeTimeLimitExample.createCriteria().andPrimaryTeachingInstitutionIdEqualTo(prize.getPrimaryTeachingInstitutionId())
                    .andScholarshipIdEqualTo(prize.getScholarshipId());
            List<CollegeTimeLimit> collegeTimeLimits = collegeTimeLimitMapper.selectByExample(collegeTimeLimitExample);
            if (collegeTimeLimits.size() == 1) {
                CollegeTimeLimit collegeTimeLimit = collegeTimeLimits.get(0);
                bo.setEndDate(collegeTimeLimit.getStudentEndDate());
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
        Prize prize = prizeMapper.selectByPrimaryKey(application.getPrizeId());
        bo.setPrizeName(prize.getPrizeName());

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
    public PageInfo getPrizeForFileCheck(UserDTO user, Long unitId, Integer pageNum, Integer pageSize) {
        if (userService.isGradeManger(user)) {
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

            PrizeExample prizeExample = new PrizeExample();
            prizeExample.createCriteria().andScholarshipIdIn(scholarshipIds)
                    .andStatusEqualTo(StatusEnum.OPEN.code)
                    .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code)
                    .andPrimaryTeachingInstitutionIdEqualTo(user.getPrimaryTeachingInstitution().getId());
            PageHelper.startPage(pageNum, pageSize);
            List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
            if (prizes.size() == 0) {
                return new PageInfo();
            }
            PageInfo pageInfo = new PageInfo(prizes);

            List<ApplicationFileCheckListBO> res = new ArrayList<>();
            for (Prize prize : prizes) {
                Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());

                ApplicationFileCheckListBO bo = new ApplicationFileCheckListBO();
                bo.setScholarshipName(scholarship.getScholarshipName());
                bo.setPrizeId(prize.getId());
                bo.setPrizeName(prize.getPrizeName());

                ApplicationExample applicationExample = new ApplicationExample();
                applicationExample.createCriteria().andPrizeIdEqualTo(prize.getId());
                Long num1 = applicationMapper.countByExample(applicationExample);
                bo.setApplyNumber(num1);

                applicationExample.clear();
                List<Integer> statuses = new ArrayList<>();
                statuses.add(ApplicationFileStatusEnum.REJECT.code);
                statuses.add(ApplicationFileStatusEnum.RESUBMIT.code);
                applicationExample.createCriteria().andPrizeIdEqualTo(prize.getId())
                        .andFileStatusIn(statuses);
                Long num2 = applicationMapper.countByExample(applicationExample);
                bo.setRejectNumber(num2);

                applicationExample.clear();
                ;
                applicationExample.createCriteria().andPrizeIdEqualTo(prize.getId())
                        .andFileStatusEqualTo(ApplicationFileStatusEnum.RESUBMIT.code);
                Long num3 = applicationMapper.countByExample(applicationExample);
                bo.setReSubmitNumber(num3);

                res.add(bo);
            }
            pageInfo.setList(res);
            return pageInfo;
        }
        return null;
    }

    @Override
    public PageInfo getPrizeDetailForFileCheck(UserDTO user, Long prizeId, Integer pageNum, Integer pageSize) {
        List<User> students = userService.getStudents(user.getPrimaryTeachingInstitution().getId(),
                user.getMangeGradeId());
        if (students.size() == 0) {
            return new PageInfo();
        }
        List<Long> userIds = new ArrayList<>();
        for (User student : students) {
            userIds.add(student.getId());
        }
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andPrizeIdEqualTo(prizeId)
                .andUserIdIn(userIds);
        PageHelper.startPage(pageNum, pageSize);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        PageInfo pageInfo = new PageInfo(applications);
        List<ApplicationFileCheckDetailBO> res = new ArrayList<>();
        for (Application application : applications) {
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

    @Override
    @Transactional
    public void checkApplicationFile(UserDTO user, List<Long> ids, ApplicationFileStatusEnum result) {
        Application application = new Application();
        application.setFileStatus(result.code);

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andIdIn(ids);

        applicationMapper.updateByExampleSelective(application, applicationExample);
    }


    private PageInfo getPrizeForGradeCheck(UserDTO user, Integer pageNum, Integer pageSize) {
        return null;
    }
}

package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.enums.*;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IApplicationService;
import com.liwj.asem.service.IFlowTemplateService;
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
    private ComprehensiveEvaluationMapper comprehensiveEvaluationMapper;

    @Autowired
    private IFlowTemplateService flowTemplateService;

    @Autowired
    private ApplicationStepMapper applicationStepMapper;

    @Override
    @Transactional
    public void createApplication(User user, EntireApplicationForm applicationForm) throws WSPException {
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
            StepTemplate firstStep = flowTemplateService.findTheNextStep(scholarship.getFlowTemplateId(), null);
            ApplicationStep applicationStep = new ApplicationStep();
            applicationStep.setApplicationId(application.getId());
            applicationStep.setCollegeId(user.getCollegeId());
            applicationStep.setGradeId(user.getGradeId());
            applicationStep.setStepTemplateId(firstStep.getId());
            if (flowTemplateService.needGradeCheck(scholarship.getFlowTemplateId())) {
                applicationStep.setStatus(ApplicationStepStatusEnum.GRADE.code);
            } else {
                applicationStep.setStatus(ApplicationStepStatusEnum.COLLEGE.code);
            }
            applicationStepMapper.insertSelective(applicationStep);
        }
    }

    @Override
    public PageInfo getPrizeWhichCanSubmit(User user, Integer pageNum, Integer pageSize) {
        PrizeExample prizeExample = new PrizeExample();
        prizeExample.createCriteria().andStatusEqualTo(StatusEnum.OPEN.code)
                .andUnitIdEqualTo(user.getCollegeId())
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
            bo.setScholarshipName(scholarship.getName());

            ApplicationExample applicationExample = new ApplicationExample();
            applicationExample.createCriteria().andUserIdEqualTo(user.getId())
                    .andPrizeIdEqualTo(prize.getId());
            List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
            if (applications.size() == 1) {
                Application application = applications.get(0);
                bo.setStatus(ApplicationStatusEnum.getByCode(application.getStatus()));
                bo.setFileStatus(ApplicationFileStatusEnum.getByCode(application.getFileStatus()));
                bo.setPrizeStatus(ApplicationPrizeStatusEnum.getByCode(application.getPrizeStatus()));
            } else {
                bo.setStatus(ApplicationStatusEnum.NO);
                bo.setFileStatus(ApplicationFileStatusEnum.NO);
                bo.setPrizeStatus(ApplicationPrizeStatusEnum.NO);
            }

            CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
            collegeTimeLimitExample.createCriteria().andUnitIdEqualTo(prize.getUnitId())
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
    public MyselfEvaluationBO getMyselfEvaluation(User user) {
        MyselfEvaluationBO bo = new MyselfEvaluationBO();
        ComprehensiveEvaluationExample example = new ComprehensiveEvaluationExample();
        example.createCriteria().andNoEqualTo(user.getStudentNumber());
        List<ComprehensiveEvaluation> list = comprehensiveEvaluationMapper.selectByExample(example);
        if (list.size() == 1) {
            ComprehensiveEvaluation evaluation = list.get(0);
            bo.setEvaluation(String.format("综合测评排名%d/%d，智育排名%d/%d", evaluation.getCompositeRank(),
                    evaluation.getMajorNumber(), evaluation.getIntellectualRank(), evaluation.getMajorNumber()));
        } else {
            bo.setEvaluation("");
        }
        return bo;
    }

    @Override
    public ApplicationBO getApplicationDetail(User user, Long id) throws WSPException {
        ApplicationBO bo = new ApplicationBO();

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andUserIdEqualTo(user.getId())
                .andPrizeIdEqualTo(id);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);

        if (applications.size() != 1) {
            throw new WSPException(ErrorInfo.PARAMS_ERROR);
        }
        Application application = applications.get(0);

        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(application.getScholarshipId());
        bo.setScholarshipName(scholarship.getName());
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
    public PageInfo getPrizeForCheck(User user, Integer pageNum, Integer pageSize) {
        return null;
    }

    private PageInfo getPrizeForGradeCheck(User user, Integer pageNum, Integer pageSize) {
        List<Long> templateIds = flowTemplateService.getTemplateIdForGradeCheck();
        if (templateIds.size() == 0) {
            return new PageInfo();
        }
        ScholarshipExample scholarshipExample = new ScholarshipExample();
        List<Integer> statusEnums = new ArrayList<>();
        statusEnums.add(StatusEnum.OPEN.code);
        statusEnums.add(StatusEnum.CHECK.code);
        statusEnums.add(StatusEnum.CLOSE.code);
        scholarshipExample.createCriteria().andFlowTemplateIdIn(templateIds)
                .andUnitIdEqualTo(user.getManageGradeId()).andStatusIn(statusEnums);
        List<Scholarship> scholarships = scholarshipMapper.selectByExample(scholarshipExample);
        if (scholarships.size() == 0) {
            return new PageInfo();
        }
        List<Long> scholarshipIds = new ArrayList<>();
        for (Scholarship scholarship : scholarships) {
            scholarshipIds.add(scholarship.getId());
        }

        PrizeExample prizeExample = new PrizeExample();
        prizeExample.createCriteria().andScholarshipIdIn(scholarshipIds).andStatusIn(statusEnums)
                .andLevelNumberEqualTo(LevelNumberEnum.COLLEGE.code);
        PageHelper.startPage(pageNum, pageSize);
        List<Prize> prizes = prizeMapper.selectByExample(prizeExample);
        PageInfo pageInfo = new PageInfo(prizes);
        List<PrizeForApplicationCheckBO> res = new ArrayList<>();
        for (Prize prize : prizes) {
            PrizeForApplicationCheckBO bo = new PrizeForApplicationCheckBO();
            bo.setPrizeId(prize.getId());
            bo.setPrizeName(prize.getPrizeName());

            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(prize.getScholarshipId());
            bo.setScholarshipName(scholarship.getName());

            CollegeTimeLimitExample collegeTimeLimitExample = new CollegeTimeLimitExample();
            collegeTimeLimitExample.createCriteria().andUnitIdEqualTo(prize.getUnitId())
                    .andScholarshipIdEqualTo(prize.getScholarshipId());
            List<CollegeTimeLimit> collegeTimeLimits = collegeTimeLimitMapper.selectByExample(collegeTimeLimitExample);
            if (collegeTimeLimits.size() == 1) {
                CollegeTimeLimit collegeTimeLimit = collegeTimeLimits.get(0);
                bo.setEndDate(collegeTimeLimit.getStudentEndDate());
            }

//            bo.setStatus(prize);
        }
        return null;
    }
}

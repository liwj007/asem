package com.liwj.asem.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.*;
import com.liwj.asem.dao.*;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.*;
import com.liwj.asem.model.*;
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
import com.liwj.asem.remote.bo.NewStudent;
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
    private RFlowTemplateStepAndUserRoleMapper rFlowTemplateStepAndUserRoleMapper;

    @Autowired
    private PublicityMapper publicityMapper;

    @Autowired
    private PublicityObjectionMapper publicityObjectionMapper;

    @Autowired
    private SchoolPrizeMapper schoolPrizeMapper;

    @Override
    public PageInfo getCollegePublicityList(UserDTO user, Long unitId, List<Long> studentIds, Long scholarshipId, Long prizeId, Integer pageNum, Integer pageSize) throws RemoteException {
        if (studentIds.size() == 0) {
            return new PageInfo();
        }
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        status.add(StatusEnum.CLOSE.code);
        CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
        CollegePrizeExample.Criteria criteria = collegePrizeExample.createCriteria();
        criteria.andCollegeIdEqualTo(unitId)
                .andStatusIn(status);
        if (prizeId != null && prizeId > 0) {
            criteria.andPrizeInfoIdEqualTo(prizeId);
        }
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        List<Long> scholarshipIds = new ArrayList<>();
        for (CollegePrize collegePrize : collegePrizes) {
            scholarshipIds.add(collegePrize.getScholarshipId());
        }
        if (scholarshipIds.size() == 0) {
            return new PageInfo();
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.COLLEGE.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria1 = applicationExample.createCriteria();
        criteria1.andScholarshipIdIn(scholarshipIds)
                .andCollegePublicityEqualTo(false)
                .andCollegeIdEqualTo(unitId);
        if (studentIds.size() > 0) {
            criteria1.andUserIdIn(studentIds);
        }
        if (prizeId != null && prizeId > 0) {
            criteria1.andPrizeInfoIdEqualTo(prizeId);
        }
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        if (applications.size() == 0) {
            return new PageInfo();
        }
        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
//        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        PageInfo pageInfo = new PageInfo(applicationSteps);
        List<PublicityBO> res = new ArrayList<>();
        RemoteService rs = new RemoteService();
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

                NewStudent temp = rs.findStudentInfoBySn(student.getSn());
                bo.setMajorName(temp.getMajorName());
                bo.setGradeName(temp.getGrade());
                bo.setClassName(temp.getClassName());
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
                .andCollegeIdEqualTo(unitId)
                .andStatusIn(status);
        List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
        List<Long> scholarshipIds = new ArrayList<>();
        for (CollegePrize collegePrize : collegePrizes) {
            scholarshipIds.add(collegePrize.getScholarshipId());
        }
        if (scholarshipIds.size() == 0) {
            return null;
        }
        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.COLLEGE.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(scholarshipIds)
                .andCollegePublicityEqualTo(false)
                .andCollegeIdEqualTo(unitId);
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
//        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        if (applicationSteps.size() == 0)
            return null;
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
    @Transactional(rollbackFor = Exception.class)
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
            publicity.setCollegeId(publicityApplyBO.getUnitId());
            publicity.setStatus(PublicityStatusEnum.OPEN.code);
            publicityMapper.insertSelective(publicity);
        }
        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.COLLEGE.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andScholarshipIdIn(publicityApplyBO.getScholarshipIds())
                .andCollegePublicityEqualTo(false)
                .andCollegeIdEqualTo(publicityApplyBO.getUnitId());
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);

        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
//        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
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
    public PageInfo getCollegeMangePublicityList(UserDTO user, Long unitId, Integer pageSize, Integer pageNum) throws RemoteException {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
//        PublicityExample.Criteria criteria1 = publicityExample.createCriteria();
//        criteria1.andPrimaryTeachingInstitutionIdIsNull().andStatusIn(status);
        PublicityExample.Criteria criteria2 = publicityExample.createCriteria();
        criteria2.andCollegeIdEqualTo(unitId).andStatusIn(status);
//        publicityExample.or(criteria2);
        PageHelper.startPage(pageNum, pageSize);
        List<Publicity> res = publicityMapper.selectByExample(publicityExample);
        PageInfo pageInfo = new PageInfo(res);
        List<PublicityScholarshipBO> list = new ArrayList<>();
        RemoteService rs = new RemoteService();
        for (Publicity publicity : res) {
            PublicityScholarshipBO bo = new PublicityScholarshipBO();
            bo.setId(publicity.getId());
            bo.setBeginDate(publicity.getBeginDate());
            bo.setEndDate(publicity.getEndDate());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(publicity.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());
            String name = rs.findCollegeNameById(publicity.getCollegeId());
            bo.setUnitName(name);
            list.add(bo);
        }
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo getMangePublicityDetailList(UserDTO user, Long publicityId,
                                                Integer pageSize, Integer pageNum) throws RemoteException {
        Publicity publicity = publicityMapper.selectByPrimaryKey(publicityId);
        Long scholarshipId = publicity.getScholarshipId();
        Long primaryTeachingInstitutionId = publicity.getCollegeId();

        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);

        ApplicationExample applicationExample = new ApplicationExample();
        if (userService.isSchoolUser(user)) {
            applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                    .andSchoolPublicityEqualTo(true);
        } else if (userService.isCollegeManger(user)) {
            applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                    .andCollegePublicityEqualTo(true)
                    .andCollegeIdEqualTo(primaryTeachingInstitutionId);
        } else {
            if (primaryTeachingInstitutionId == null) {
                applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                        .andSchoolPublicityEqualTo(true);
            } else {
                applicationExample.createCriteria().andScholarshipIdEqualTo(scholarshipId)
                        .andCollegePublicityEqualTo(true)
                        .andCollegeIdEqualTo(primaryTeachingInstitutionId);
            }
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        PageInfo pageInfo = new PageInfo(applications);
        List<PublicityBO> res = new ArrayList<>();
        RemoteService rs = new RemoteService();
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

                NewStudent temp = rs.findStudentInfoBySn(student.getSn());
                if (publicity.getNeedMajor()) {
                    bo.setMajorName(temp.getMajorName());
                }
                if (publicity.getNeedGrade()) {
                    bo.setGradeName(temp.getGrade());
                }
                if (publicity.getNeedClasses()) {
                    bo.setClassName(temp.getClassName());
                }

                if (publicity.getNeedCollege()) {
                    bo.setCollegeName(temp.getCollegeName());
                }
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
    public PageInfo getStudentMangePublicityList(UserDTO user, Integer pageSize, Integer pageNum) throws RemoteException {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andStatusIn(status);
        PageHelper.startPage(pageNum, pageSize);
        List<Publicity> res = publicityMapper.selectByExample(publicityExample);
        PageInfo pageInfo = new PageInfo(res);
        List<PublicityScholarshipBO> list = new ArrayList<>();
        RemoteService rs = new RemoteService();
        for (Publicity publicity : res) {
            PublicityScholarshipBO bo = new PublicityScholarshipBO();
            bo.setId(publicity.getId());
            bo.setBeginDate(publicity.getBeginDate());
            bo.setEndDate(publicity.getEndDate());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(publicity.getScholarshipId());
            bo.setScholarshipName(scholarship.getScholarshipName());

            if (publicity.getCollegeId() != null) {
                String name = rs.findCollegeNameById(publicity.getCollegeId());
                bo.setUnitName(name);
            } else {
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
    public List<PublicityScholarshipBO> getAllStudentMangePublicityList(UserDTO user) throws RemoteException {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andStatusIn(status);
        List<Publicity> res = publicityMapper.selectByExample(publicityExample);
        List<PublicityScholarshipBO> list = new ArrayList<>();
        RemoteService rs = new RemoteService();
        for (Publicity publicity : res) {
            PublicityScholarshipBO bo = new PublicityScholarshipBO();
            bo.setId(publicity.getId());
            Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(publicity.getScholarshipId());

            if (publicity.getCollegeId() != null) {
                String name = rs.findCollegeNameById(publicity.getCollegeId());
                bo.setScholarshipName(scholarship.getScholarshipName() + "-" + name);
            } else {
                bo.setScholarshipName(scholarship.getScholarshipName() + "-学校");
            }

            list.add(bo);
        }
        return list;
    }

    @Override
    public PageInfo getStudentObjections(UserDTO user, Integer pageSize, Integer pageNum) throws RemoteException {
        PublicityObjectionExample example = new PublicityObjectionExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        PageHelper.startPage(pageNum, pageSize);
        List<PublicityObjectionWithBLOBs> list = publicityObjectionMapper.selectByExampleWithBLOBs(example);
        PageInfo pageInfo = new PageInfo(list);
        List<PublicityObjectionBO> res = new ArrayList<>();
        RemoteService rs = new RemoteService();
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

                NewStudent temp = rs.findStudentInfoBySn(myself.getSn());
                bo.setMajorName(temp.getMajorName());
                bo.setGradeName(temp.getGrade());
                bo.setClassName(temp.getClassName());
                bo.setCollegeName(temp.getCollegeName());
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
    public PageInfo getCollegeObjections(UserDTO user, Long unitId, Integer pageSize, Integer pageNum) throws RemoteException {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andCollegeIdEqualTo(unitId)
                .andStatusIn(status);
        List<Publicity> publicities = publicityMapper.selectByExample(publicityExample);

        if (publicities.size()==0){
            return  new PageInfo();
        }
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
        RemoteService rs = new RemoteService();
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

                NewStudent temp = rs.findStudentInfoBySn(myself.getSn());
                bo.setMajorName(temp.getMajorName());
                bo.setGradeName(temp.getGrade());
                bo.setClassName(temp.getClassName());
            }

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public PageInfo getSchoolPublicityList(UserDTO user, List<Long> studentIds, Long scholarshipId, Long prizeId, Integer pageNum, Integer pageSize) throws RemoteException {
        List<Integer> status = new ArrayList<>();
        status.add(StatusEnum.OPEN.code);
        status.add(StatusEnum.CLOSE.code);
        SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
        SchoolPrizeExample.Criteria criteria = schoolPrizeExample.createCriteria();
        criteria.andStatusIn(status);
        if (prizeId != null && prizeId > 0) {
            criteria.andPrizeInfoIdEqualTo(prizeId);
        }
        List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
        if (schoolPrizes.size() == 0) {
            return new PageInfo();
        }
        List<Long> scholarshipIds = new ArrayList<>();
        for (SchoolPrize schoolPrize : schoolPrizes) {
            scholarshipIds.add(schoolPrize.getScholarshipId());
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL.code);
        List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                .selectByExample(roleExample);
        List<Long> flowTemplateStepIds = new ArrayList<>();
        for (RFlowTemplateStepAndUserRole role : rFlowTemplateStepAndUserRoles) {
            flowTemplateStepIds.add(role.getFlowTemplateStepId());
        }

        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria1 = applicationExample.createCriteria();
        criteria1.andScholarshipIdIn(scholarshipIds)
                .andSchoolPublicityEqualTo(false);
        if (prizeId != null && prizeId > 0) {
            criteria1.andPrizeInfoIdEqualTo(prizeId);
        }
        if (studentIds.size() > 0) {
            criteria1.andUserIdIn(studentIds);
        }
        List<Application> applications = applicationMapper.selectByExampleWithBLOBs(applicationExample);
        if (applications.size() == 0) {
            return new PageInfo();
        }
        List<Long> applicationIds = new ArrayList<>();
        for (Application application : applications) {
            applicationIds.add(application.getId());
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(ApplicationPrizeStatusEnum.PASS.code);
//        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        PageHelper.startPage(pageNum, pageSize);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        PageInfo pageInfo = new PageInfo(applicationSteps);
        List<PublicityBO> res = new ArrayList<>();
        RemoteService rs = new RemoteService();
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

                NewStudent temp = rs.findStudentInfoBySn(student.getSn());
                bo.setMajorName(temp.getMajorName());
                bo.setGradeName(temp.getGrade());
                bo.setClassName(temp.getClassName());
                bo.setCollegeName(temp.getCollegeName());
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
        if (scholarshipIds.size() == 0) {
            return null;
        }

        RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL.code);
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
//        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
        ApplicationStepExample stepExample = new ApplicationStepExample();
        stepExample.createCriteria().andApplicationIdIn(applicationIds)
                .andStatusIn(tmp)
                .andFlowTemplateStepIdIn(flowTemplateStepIds);
        List<ApplicationStep> applicationSteps = applicationStepMapper.selectByExample(stepExample);
        if (applicationSteps.size()==0){
            return null;
        }
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
        roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL.code);
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
//        tmp.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
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
        criteria1.andCollegeIdIsNull().andStatusIn(status);
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
            if (scholarship == null)
                continue;
            bo.setScholarshipName(scholarship.getScholarshipName());
            bo.setUnitName("学校");
            list.add(bo);
        }
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo getSchoolObjections(UserDTO user, Integer pageSize, Integer pageNum) throws RemoteException {
        PublicityExample publicityExample = new PublicityExample();
        List<Integer> status = new ArrayList<>();
        status.add(PublicityStatusEnum.OPEN.code);
        status.add(PublicityStatusEnum.CLOSE.code);
        publicityExample.createCriteria().andCollegeIdIsNull()
                .andStatusIn(status);
        List<Publicity> publicities = publicityMapper.selectByExample(publicityExample);
        if (publicities.size() == 0) {
            return new PageInfo();
        }
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
        RemoteService rs = new RemoteService();
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

                NewStudent temp = rs.findStudentInfoBySn(myself.getSn());
                bo.setMajorName(temp.getMajorName());
                bo.setGradeName(temp.getGrade());
                bo.setClassName(temp.getClassName());
            }



            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }


}

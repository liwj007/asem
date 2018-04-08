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
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
import com.liwj.asem.remote.bo.College;
import com.liwj.asem.service.IScholarshipService;
import com.liwj.asem.utils.PackingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    private ApplicationMapper applicationMapper;


    @Autowired
    private PrizeCollegeLimitTimeMapper prizeCollegeLimitTimeMapper;


    @Autowired
    private FlowTemplateStepMapper flowTemplateStepMapper;

    @Autowired
    private RFlowTemplateStepAndUserRoleMapper rFlowTemplateStepAndUserRoleMapper;

    @Autowired
    private ApplicationStepMapper applicationStepMapper;

    /**
     * 创建奖学金，包括奖学金Scholarship，奖学金等级信息PrizeInfo，学院奖学金等级CollegePrize，学校奖学金SchoolPrize
     * @param user
     * @param scholarshipBO
     */
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
        Long collegeId = scholarshipBO.getPrimaryTeachingInstitutionId();

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
            scholarship.setCollegeId(collegeId);
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
                schoolPrize.setCreateDate(scholarship.getCreateDate());
                schoolPrize.setScholarshipId(prizeInfo.getScholarshipId());
                schoolPrize.setScholarshipType(prizeInfo.getScholarshipType());
                schoolPrizeMapper.insertSelective(schoolPrize);
            } else if (scholarship.getScholarshipType() == ScholarshipTypeEnum.COLLEGE.code) {
                CollegePrize collegePrize = new CollegePrize();
                collegePrize.setStatus(StatusEnum.NEW.code);
                collegePrize.setAllocationNumberStatus(false);
                collegePrize.setPrizeInfoId(prizeInfo.getId());
                collegePrize.setNumber(avgNumber);
                collegePrize.setCollegeId(collegeId);
                collegePrize.setRestNumber(0);
                collegePrize.setCreateDate(scholarship.getCreateDate());
                collegePrize.setScholarshipId(prizeInfo.getScholarshipId());
                collegePrize.setScholarshipType(prizeInfo.getScholarshipType());
                collegePrizeMapper.insertSelective(collegePrize);

                PrizeCollegeLimitTime prizeCollegeLimitTime = new PrizeCollegeLimitTime();
                prizeCollegeLimitTime.setCollegeId(collegeId);
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
                    schoolPrize.setCreateDate(scholarship.getCreateDate());
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
                    collegePrize.setCreateDate(scholarship.getCreateDate());
                    collegePrize.setScholarshipId(prizeInfo.getScholarshipId());
                    collegePrize.setScholarshipType(prizeInfo.getScholarshipType());
                    collegePrize.setCollegeId(collegeId);
                    collegePrizeMapper.insertSelective(collegePrize);

                    PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
                    limitTimeExample.createCriteria().andScholarshipIdEqualTo(scholarship.getId())
                            .andCollegeIdEqualTo(collegeId);
                    Long tmp = prizeCollegeLimitTimeMapper.countByExample(limitTimeExample);
                    if (tmp == 0) {
                        PrizeCollegeLimitTime prizeCollegeLimitTime = new PrizeCollegeLimitTime();
                        prizeCollegeLimitTime.setCollegeId(collegeId);
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
    public EntireScholarshipForm getScholarshipDetailInfo(UserDTO user, Long id, Long unitId)
            throws WSPException, RemoteException {
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
        bo.setPrimaryTeachingInstitutionId(scholarship.getCollegeId());
        bo.setScholarshipType(ScholarshipTypeEnum.getByCode(scholarship.getScholarshipType()));



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
            RemoteService rs = new RemoteService();
            String collegeName = rs.findCollegeNameById(scholarship.getCollegeId());
            if (collegeName != null) {
                bo.setUnitName(collegeName);
            }

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
                        .andCollegeIdEqualTo(scholarship.getCollegeId());
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
                List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
                for (CollegePrize collegePrize: collegePrizes){
                    collegePrize.setStatus(StatusEnum.OPEN.code);
                    collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);

                    PrizeCollegeLimitTimeExample limitTimeExample = new PrizeCollegeLimitTimeExample();
                    limitTimeExample.createCriteria().andScholarshipIdEqualTo(collegePrize.getScholarshipId())
                            .andCollegeIdEqualTo(collegePrize.getCollegeId());
                    Long tmp = prizeCollegeLimitTimeMapper.countByExample(limitTimeExample);
                    if (tmp == 0) {
                        PrizeCollegeLimitTime limitTime = new PrizeCollegeLimitTime();
                        limitTime.setAllocationTimeStatus(true);
                        limitTime.setScholarshipId(collegePrize.getScholarshipId());
                        limitTime.setCollegeId(collegePrize.getCollegeId());
                        limitTime.setStudentEndDate(scholarship.getCollegeEndDate());
                        if (scholarship.getNeedGradeCheck()){
                            limitTime.setGradeEndDate(scholarship.getCollegeEndDate());
                        }
                        prizeCollegeLimitTimeMapper.insertSelective(limitTime);
                    }
                }

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
        scholarshipExample.setOrderByClause("create_date desc");
        PageHelper.startPage(pageNum, pageSize);
        List<Scholarship> list = scholarshipMapper.selectByExample(scholarshipExample);
        PageInfo pageInfo = new PageInfo(list);
        List<SelectOfScholarshipBO> res = new ArrayList<>();
        for (Scholarship scholarship : list) {
            SelectOfScholarshipBO bo = new SelectOfScholarshipBO();
            bo.setId(scholarship.getId());
            bo.setName(scholarship.getScholarshipName());
            bo.setAwardNumber(scholarshipMap.get(scholarship.getId()));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            bo.setYear(simpleDateFormat.format(scholarship.getCreateDate()));
            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void closeScholarship(UserDTO user, Long scholarshipId) throws WSPException{
        Scholarship scholarship = scholarshipMapper.selectByPrimaryKey(scholarshipId);
        if (scholarship == null) {
            return;
        }

        if (scholarship.getScholarshipType() == ScholarshipTypeEnum.SCHOOL.code) {
            SchoolPrizeExample schoolPrizeExample = new SchoolPrizeExample();
            schoolPrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);
            List<SchoolPrize> schoolPrizes = schoolPrizeMapper.selectByExample(schoolPrizeExample);
            for (SchoolPrize schoolPrize : schoolPrizes) {
                FlowTemplateStepExample flowTemplateStepExample = new FlowTemplateStepExample();
                flowTemplateStepExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
                List<FlowTemplateStep> flowTemplateSteps = flowTemplateStepMapper.selectByExample(flowTemplateStepExample);
                List<Long> stepIds = new ArrayList<>();
                for (FlowTemplateStep step : flowTemplateSteps) {
                    stepIds.add(step.getId());
                }
                RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
                roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.SCHOOL.code)
                        .andFlowTemplateStepIdIn(stepIds);
                List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                        .selectByExample(roleExample);
                if (rFlowTemplateStepAndUserRoles.size() == 1) {
                    RFlowTemplateStepAndUserRole role = rFlowTemplateStepAndUserRoles.get(0);
                    List<Integer> status = new ArrayList<>();
                    status.add(ApplicationPrizeStatusEnum.SUBMIT.code);
//                    status.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                    ApplicationStepExample applicationStepExample = new ApplicationStepExample();
                    applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                            .andStatusIn(status);
                    Long count = applicationStepMapper.countByExample(applicationStepExample);
                    if (count != 0) {
                        throw new WSPException(ErrorInfo.CAN_NOT_CLOSE);
                    }
                }

                CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
                collegePrizeExample.createCriteria().andSchoolPrizeIdEqualTo(schoolPrize.getId());
                List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
                for (CollegePrize collegePrize : collegePrizes) {
                    GradePrizeExample gradePrizeExample = new GradePrizeExample();
                    gradePrizeExample.createCriteria().andCollegePrizeIdEqualTo(collegePrize.getId());
                    List<GradePrize> gradePrizes = gradePrizeMapper.selectByExample(gradePrizeExample);
                    for (GradePrize gradePrize : gradePrizes) {
                        gradePrize.setStatus(StatusEnum.CLOSE.code);
                        gradePrizeMapper.updateByPrimaryKeySelective(gradePrize);
                    }

                    collegePrize.setStatus(StatusEnum.CLOSE.code);
                    collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
                }

                schoolPrize.setStatus(StatusEnum.CLOSE.code);
                schoolPrizeMapper.updateByPrimaryKeySelective(schoolPrize);
            }
        }else if (scholarship.getScholarshipType()==ScholarshipTypeEnum.COLLEGE.code){
            FlowTemplateStepExample flowTemplateStepExample = new FlowTemplateStepExample();
            flowTemplateStepExample.createCriteria().andFlowTemplateIdEqualTo(scholarship.getFlowTemplateId());
            List<FlowTemplateStep> flowTemplateSteps = flowTemplateStepMapper.selectByExample(flowTemplateStepExample);
            List<Long> stepIds = new ArrayList<>();
            for (FlowTemplateStep step : flowTemplateSteps) {
                stepIds.add(step.getId());
            }
            RFlowTemplateStepAndUserRoleExample roleExample = new RFlowTemplateStepAndUserRoleExample();
            roleExample.createCriteria().andRoleTypeEqualTo(RoleTypeEnum.COLLEGE.code)
                    .andFlowTemplateStepIdIn(stepIds);
            List<RFlowTemplateStepAndUserRole> rFlowTemplateStepAndUserRoles = rFlowTemplateStepAndUserRoleMapper
                    .selectByExample(roleExample);
            if (rFlowTemplateStepAndUserRoles.size() == 1) {
                RFlowTemplateStepAndUserRole role = rFlowTemplateStepAndUserRoles.get(0);
                List<Integer> status = new ArrayList<>();
                status.add(ApplicationPrizeStatusEnum.SUBMIT.code);
//                status.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                ApplicationStepExample applicationStepExample = new ApplicationStepExample();
                applicationStepExample.createCriteria().andFlowTemplateStepIdEqualTo(role.getFlowTemplateStepId())
                        .andStatusIn(status);
                Long count = applicationStepMapper.countByExample(applicationStepExample);
                if (count != 0) {
                    throw new WSPException(ErrorInfo.CAN_NOT_CLOSE);
                }
            }

            CollegePrizeExample collegePrizeExample = new CollegePrizeExample();
            collegePrizeExample.createCriteria().andScholarshipIdEqualTo(scholarshipId);
            List<CollegePrize> collegePrizes = collegePrizeMapper.selectByExample(collegePrizeExample);
            for (CollegePrize collegePrize : collegePrizes) {
                GradePrizeExample gradePrizeExample = new GradePrizeExample();
                gradePrizeExample.createCriteria().andCollegePrizeIdEqualTo(collegePrize.getId());
                List<GradePrize> gradePrizes = gradePrizeMapper.selectByExample(gradePrizeExample);
                for (GradePrize gradePrize : gradePrizes) {
                    gradePrize.setStatus(StatusEnum.CLOSE.code);
                    gradePrizeMapper.updateByPrimaryKeySelective(gradePrize);
                }

                collegePrize.setStatus(StatusEnum.CLOSE.code);
                collegePrizeMapper.updateByPrimaryKeySelective(collegePrize);
            }
        }

        scholarship.setStatus(StatusEnum.CLOSE.code);
        scholarshipMapper.updateByPrimaryKeySelective(scholarship);
    }

}

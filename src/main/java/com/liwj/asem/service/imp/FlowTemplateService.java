package com.liwj.asem.service.imp;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FlowTemplateBO;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.enums.UserRightEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IFlowTemplateService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class FlowTemplateService implements IFlowTemplateService {

    @Autowired
    private FlowTemplateMapper flowTemplateMapper;

    @Autowired
    private FlowLinkMapper flowLinkMapper;

    @Autowired
    private StepTemplateMapper stepTemplateMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRightMapper userRightMapper;

    @Autowired
    private RStepRightMapper rStepRightMapper;

    @Autowired
    private FlowTemplateInfoMapper flowTemplateInfoMapper;

    @Autowired
    private IUserService userService;


    @Override
    public StepTemplate findTheNextStep(Long flowTemplateId, Long fromStepTemplateId) {
        FlowLinkExample example = new FlowLinkExample();
        if (fromStepTemplateId == null) {
            example.createCriteria().andFlowTemplateIdEqualTo(flowTemplateId).andFromStepIdIsNull();
        } else {
            example.createCriteria().andFlowTemplateIdEqualTo(flowTemplateId).andFromStepIdEqualTo(fromStepTemplateId);
        }
        List<FlowLink> list = flowLinkMapper.selectByExample(example);
        if (list.size() == 1) {
            FlowLink flowLink = list.get(0);
            Long toStepId = flowLink.getToStepId();
            StepTemplate stepTemplate = stepTemplateMapper.selectByPrimaryKey(toStepId);
            return stepTemplate;
        }
        return null;
    }

    @Override
    public Boolean needGradeCheck(Long flowTemplateId){
        FlowTemplateInfoExample example = new FlowTemplateInfoExample();
        example.createCriteria().andFlowTemplateIdEqualTo(flowTemplateId);
        List<FlowTemplateInfo> list = flowTemplateInfoMapper.selectByExample(example);
        if (list.size()==1){
            FlowTemplateInfo info = list.get(0);
            return info.getNeedGradeCheck();
        }
        return false;
    }

    @Override
    @Transactional
    public void createNewFlowTemplateBySchoolUser(String name, ScholarshipTypeEnum type, Boolean needGradeCheck, Boolean gradeStudent, Boolean collegeStudent) {

        FlowTemplate flowTemplate = new FlowTemplate();
        flowTemplate.setName(name);
        flowTemplate.setFlowType(type.code);
        flowTemplate.setVersion(1);
        flowTemplateMapper.insertSelective(flowTemplate);

        Long templateId = flowTemplate.getId();

        Long stepId1 = null;
        Long stepId2 = null;

        if (needGradeCheck) {
            stepId2 = insertNewStepTemplate("年级审核", templateId);
            addStepRight(stepId2, UserRightEnum.GRADE_INSTRUCTOR.code);
            if (gradeStudent) {
                addStepRight(stepId2, UserRightEnum.GRADE_STUDENT.code);
            }
            addFlowLink(templateId, stepId1, stepId2);
            stepId1 = stepId2;
            stepId2 = null;
        }

        stepId2 = insertNewStepTemplate("学院审核", templateId);
        addStepRight(stepId2, UserRightEnum.SPECIAL_INSTRUCTOR.code);
        if (collegeStudent) {
            addStepRight(stepId2, UserRightEnum.COLLEGE_STUDENT.code);
        }
        addFlowLink(templateId, stepId1, stepId2);
        stepId1 = stepId2;
        stepId2 = null;

        if (type == ScholarshipTypeEnum.SCHOOL) {
            stepId2 = insertNewStepTemplate("学校审核", templateId);
            addStepRight(stepId2, UserRightEnum.SCHOOL.code);
            addFlowLink(templateId, stepId1, stepId2);
            stepId1 = stepId2;
            stepId2 = null;
        }
        addFlowLink(templateId, stepId1, stepId2);

        Boolean gradeInstructor = needGradeCheck;
        Boolean schoolUser = type == ScholarshipTypeEnum.SCHOOL ? true : false;
        FlowTemplateInfo info = new FlowTemplateInfo(null, needGradeCheck, gradeInstructor, gradeStudent, true, collegeStudent, schoolUser, templateId);
        flowTemplateInfoMapper.insertSelective(info);
    }

    private void addFlowLink(Long templateId, Long fromStepId, Long toStepId) {
        FlowLink flowLink = new FlowLink();
        flowLink.setFlowTemplateId(templateId);
        flowLink.setFromStepId(fromStepId);
        flowLink.setToStepId(toStepId);
        flowLinkMapper.insertSelective(flowLink);
    }

    private void addStepRight(Long stepId, Integer rightId) {
        RStepRight rStepRight = new RStepRight();
        rStepRight.setUserRight(rightId);
        rStepRight.setStepTemplateId(stepId);
        rStepRightMapper.insertSelective(rStepRight);
    }

    private Long insertNewStepTemplate(String name, Long templateId) {
        StepTemplate stepTemplate = new StepTemplate();
        stepTemplate.setFlowTemplateId(templateId);
        stepTemplate.setName(name);
        stepTemplateMapper.insertSelective(stepTemplate);
        return stepTemplate.getId();
    }

    private Long getNextStepIdFromFLowLink(Long templateId, Long fromStepId) {
        FlowLinkExample flowLinkExample = new FlowLinkExample();
        flowLinkExample.createCriteria().andFlowTemplateIdEqualTo(templateId).andFromStepIdEqualTo(fromStepId);
        List<FlowLink> lst = flowLinkMapper.selectByExample(flowLinkExample);
        if (lst.size() == 0) {
            return 0L;
        } else {
            return lst.get(0).getToStepId();
        }
    }

    @Override
    public PageInfo getFlowTemplates(Integer pageNum, Integer pageSize) throws WSPException {
        FlowTemplateExample example = new FlowTemplateExample();
        example.createCriteria().andVersionGreaterThan(0);
        PageHelper.startPage(pageNum, pageSize);
        List<FlowTemplate> lst = flowTemplateMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(lst);
        List<FlowTemplateBO> res = new ArrayList<>();
        for (FlowTemplate flowTemplate : lst) {
            FlowTemplateBO bo = new FlowTemplateBO();
            bo.setId(flowTemplate.getId());
            bo.setCreateDate(flowTemplate.getCreateDate());
            bo.setName(flowTemplate.getName());
            bo.setTypeName(ScholarshipTypeEnum.getNameByCode(flowTemplate.getFlowType()));

            FlowTemplateInfoExample infoExample = new FlowTemplateInfoExample();
            infoExample.createCriteria().andFlowTemplateIdEqualTo(flowTemplate.getId());
            List<FlowTemplateInfo> tmp = flowTemplateInfoMapper.selectByExample(infoExample);
            if (tmp.size() != 1) {
                throw new WSPException(ErrorInfo.PARAMS_ERROR);
            }
            FlowTemplateInfo info = tmp.get(0);
            bo.setCollegeStudent(info.getCollegeStudent());
            bo.setGradeInstructor(info.getGradeInstructor());
            bo.setGradeStudent(info.getGradeStudent());
            bo.setNeedGradeCheck(info.getNeedGradeCheck());
            bo.setSchoolUser(info.getSchoolUser());
            bo.setSpecialInstructor(info.getSpecialInstructor());

            res.add(bo);
        }
        pageInfo.setList(res);
        return pageInfo;
    }

    @Override
    public void deleteTemplate(Long id) throws WSPException {
        FlowTemplate template = flowTemplateMapper.selectByPrimaryKey(id);
        if (template == null) {
            throw new WSPException(ErrorInfo.PARAMS_ERROR);
        }
        template.setVersion(0);
        flowTemplateMapper.updateByPrimaryKeySelective(template);
    }

    @Override
    public List<FlowTemplate> getAllFlowTemplatesByUserType(User user) throws WSPException {
        Integer flowType = 0;
        if (userService.isSchoolUser(user)) {
            flowType = ScholarshipTypeEnum.SCHOOL.code;
        } else if (userService.isCollegeManger(user)) {
            flowType = ScholarshipTypeEnum.COLLEGE.code;
        } else {
            throw new WSPException(ErrorInfo.PARAMS_ERROR);
        }
        FlowTemplateExample example = new FlowTemplateExample();
        example.createCriteria().andVersionGreaterThan(0).andFlowTypeEqualTo(flowType);
        return flowTemplateMapper.selectByExample(example);
    }

    @Override
    public List<Long> getTemplateIdForGradeCheck(){
        FlowTemplateInfoExample infoExample = new FlowTemplateInfoExample();
        infoExample.createCriteria().andNeedGradeCheckEqualTo(true);
        List<FlowTemplateInfo> infos = flowTemplateInfoMapper.selectByExample(infoExample);
        HashSet<Long> tmpSet = new HashSet<>();
        for (FlowTemplateInfo info: infos){
            tmpSet.add(info.getFlowTemplateId());
        }
        List<Long> templateIds = new ArrayList<>();
        templateIds.addAll(tmpSet);
        return templateIds;
    }

}

package com.liwj.asem.service.imp;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FlowTemplateBO;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.RoleTypeEnum;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IFlowTemplateService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowTemplateService implements IFlowTemplateService {

    @Autowired
    private FlowTemplateMapper flowTemplateMapper;

    @Autowired
    private FlowTemplateLinkMapper flowTemplateLinkMapper;

    @Autowired
    private FlowTemplateStepMapper flowTemplateStepMapper;

    @Autowired
    private RFlowTemplateStepAndUserRoleMapper rFlowTemplateStepAndUserRoleMapper;


    @Autowired
    private IUserService userService;


    @Override
    public FlowTemplateStep findTheNextStep(Long flowTemplateId, Long fromStepTemplateId) {
        FlowTemplateLinkExample example = new FlowTemplateLinkExample();
        if (fromStepTemplateId == null) {
            example.createCriteria().andFlowTemplateIdEqualTo(flowTemplateId).andFromStepIdIsNull();
        } else {
            example.createCriteria().andFlowTemplateIdEqualTo(flowTemplateId).andFromStepIdEqualTo(fromStepTemplateId);
        }
        List<FlowTemplateLink> list = flowTemplateLinkMapper.selectByExample(example);
        if (list.size() == 1) {
            FlowTemplateLink flowLink = list.get(0);
            Long toStepId = flowLink.getToStepId();
            FlowTemplateStep stepTemplate = flowTemplateStepMapper.selectByPrimaryKey(toStepId);
            return stepTemplate;
        }
        return null;
    }



    @Override
    @Transactional
    public void createNewFlowTemplateBySchoolUser(String name, ScholarshipTypeEnum type, Boolean needGradeCheck,
                                                  Boolean gradeStudent, Boolean collegeStudent) {

        FlowTemplate flowTemplate = new FlowTemplate();
        flowTemplate.setName(name);
        flowTemplate.setFlowType(type.code);
        flowTemplate.setVersion(1);
        flowTemplate.setNeedGradeCheck(needGradeCheck);
        flowTemplate.setGradeInstructor(needGradeCheck);
        flowTemplate.setGradeStudent(gradeStudent);
        Boolean schoolUser = type == ScholarshipTypeEnum.SCHOOL ? true : false;
        flowTemplate.setSchoolUser(schoolUser);
        flowTemplate.setCollegeStudent(collegeStudent);
        flowTemplate.setSpecialInstructor(true);
        flowTemplateMapper.insertSelective(flowTemplate);

        Long templateId = flowTemplate.getId();

        Long stepId1 = null;
        Long stepId2 = null;

        if (needGradeCheck) {
            stepId2 = insertNewStepTemplate("年级审核", templateId);
            addStepRight(stepId2, RoleTypeEnum.GRADE_ADVISER.code);
            if (gradeStudent) {
                addStepRight(stepId2, RoleTypeEnum.SCHOOL_ASSISTANT.code);
            }
            addFlowLink(templateId, stepId1, stepId2);
            stepId1 = stepId2;
            stepId2 = null;
        }

        stepId2 = insertNewStepTemplate("学院审核", templateId);
        addStepRight(stepId2, RoleTypeEnum.SPECIAL_ADVISER.code);
        if (collegeStudent) {
            addStepRight(stepId2, RoleTypeEnum.SCHOOL_ASSISTANT.code);
        }
        addFlowLink(templateId, stepId1, stepId2);
        stepId1 = stepId2;
        stepId2 = null;

        if (type == ScholarshipTypeEnum.SCHOOL) {
            stepId2 = insertNewStepTemplate("学校审核", templateId);
            addStepRight(stepId2, RoleTypeEnum.SCHOOL_USER.code);
            addFlowLink(templateId, stepId1, stepId2);
            stepId1 = stepId2;
            stepId2 = null;
        }
        addFlowLink(templateId, stepId1, stepId2);
    }

    private void addFlowLink(Long templateId, Long fromStepId, Long toStepId) {
        FlowTemplateLink flowLink = new FlowTemplateLink();
        flowLink.setFlowTemplateId(templateId);
        flowLink.setFromStepId(fromStepId);
        flowLink.setToStepId(toStepId);
        flowTemplateLinkMapper.insertSelective(flowLink);
    }

    private void addStepRight(Long stepId, Integer rightId) {
        RFlowTemplateStepAndUserRole role = new RFlowTemplateStepAndUserRole();
        role.setRoleType(rightId);
        role.setFlowTemplateStepId(stepId);
        rFlowTemplateStepAndUserRoleMapper.insertSelective(role);
    }

    private Long insertNewStepTemplate(String name, Long templateId) {
        FlowTemplateStep stepTemplate = new FlowTemplateStep();
        stepTemplate.setFlowTemplateId(templateId);
        stepTemplate.setName(name);
        flowTemplateStepMapper.insertSelective(stepTemplate);
        return stepTemplate.getId();
    }

    private Long getNextStepIdFromFLowLink(Long templateId, Long fromStepId) {
        FlowTemplateLinkExample flowLinkExample = new FlowTemplateLinkExample();
        flowLinkExample.createCriteria().andFlowTemplateIdEqualTo(templateId).andFromStepIdEqualTo(fromStepId);
        List<FlowTemplateLink> lst = flowTemplateLinkMapper.selectByExample(flowLinkExample);
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

            bo.setCollegeStudent(flowTemplate.getCollegeStudent());
            bo.setGradeInstructor(flowTemplate.getGradeInstructor());
            bo.setGradeStudent(flowTemplate.getGradeStudent());
            bo.setNeedGradeCheck(flowTemplate.getNeedGradeCheck());
            bo.setSchoolUser(flowTemplate.getSchoolUser());
            bo.setSpecialInstructor(flowTemplate.getSpecialInstructor());

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
    public List<FlowTemplate> getAllFlowTemplatesByUserType(UserDTO user) throws WSPException {
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


}

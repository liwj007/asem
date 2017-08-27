package com.liwj.asem.service;


import com.github.pagehelper.PageInfo;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.FlowTemplate;
import com.liwj.asem.model.StepTemplate;
import com.liwj.asem.model.User;

import java.util.List;

public interface IFlowTemplateService {
    StepTemplate findTheNextStep(Long flowTemplateId, Long fromStepTemplateId);

    Boolean needGradeCheck(Long flowTemplateId);

    void createNewFlowTemplateBySchoolUser(String name, ScholarshipTypeEnum type, Boolean needGradeCheck, Boolean gradeStudent, Boolean collegeStudent);



    PageInfo getFlowTemplates(Integer pageNum, Integer pageSize) throws WSPException;

    void deleteTemplate(Long id) throws WSPException;


    List<FlowTemplate> getAllFlowTemplatesByUserType(User user) throws WSPException;

    List<Long> getTemplateIdForGradeCheck();
}

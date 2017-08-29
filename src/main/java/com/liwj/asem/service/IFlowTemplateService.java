package com.liwj.asem.service;


import com.github.pagehelper.PageInfo;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.FlowTemplate;
import com.liwj.asem.model.FlowTemplateStep;

import java.util.List;

public interface IFlowTemplateService {
    FlowTemplateStep findTheNextStep(Long flowTemplateId, Long fromStepTemplateId);

    void createNewFlowTemplateBySchoolUser(String name, ScholarshipTypeEnum type, Boolean needGradeCheck, Boolean gradeStudent, Boolean collegeStudent);


    PageInfo getFlowTemplates(Integer pageNum, Integer pageSize) throws WSPException;

    void deleteTemplate(Long id) throws WSPException;

    List<FlowTemplate> getAllFlowTemplatesByUserType(UserDTO user) throws WSPException;

}

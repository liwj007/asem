package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FlowTemplateBO;
import com.liwj.asem.data.ResponseData;


import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.FlowTemplate;
import com.liwj.asem.model.User;
import com.liwj.asem.service.IFlowTemplateService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/template")
public class FlowTemplateController {

    @Autowired
    private IFlowTemplateService flowTemplateService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData createBySchool(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "type") ScholarshipTypeEnum type,
                                       @RequestParam(value = "needGradeCheck") Boolean needGradeCheck,
                                       @RequestParam(value = "gradeStudent") Boolean gradeStudent,
                                       @RequestParam(value = "collegeStudent") Boolean collegeStudent) throws WSPException {
        flowTemplateService.createNewFlowTemplateBySchoolUser(name, type, needGradeCheck, gradeStudent, collegeStudent);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseData delete(@PathVariable Long id) throws WSPException {
        flowTemplateService.deleteTemplate(id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }


    @RequestMapping(value = "/flow_templates", method = RequestMethod.GET)
    public ResponseData getFlowTemplates(@RequestParam(value = "pageSize") Integer pageSize,
                                         @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {

        PageInfo pageInfo = flowTemplateService.getFlowTemplates(pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseData getAllFlowTemplates(@RequestParam(value = "token") String token) throws WSPException {
        User user = userService.getUserByToken(token);
        List<FlowTemplate> lists = flowTemplateService.getAllFlowTemplatesByUserType(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(lists);
        return responseData;
    }

}

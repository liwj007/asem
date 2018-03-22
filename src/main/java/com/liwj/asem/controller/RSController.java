package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.SelectionBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.Grade;
import com.liwj.asem.service.IOrganizationService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rs")
public class RSController {
    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getColleges", method = RequestMethod.GET)
    public ResponseData getColleges(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getColleges(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }


    @RequestMapping(value = "/getMajorsByCollege", method = RequestMethod.GET)
    public ResponseData getMajorsByCollege(@RequestParam(value = "token") String token,
                                    @RequestParam(value = "id") Long id) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getMajorsByCollege(id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getGradesByMajor", method = RequestMethod.GET)
    public ResponseData getGradesByMajor(@RequestParam(value = "token") String token,
                                    @RequestParam(value = "id") Long id) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getGradesByMajor(id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getManageGrades", method = RequestMethod.GET)
    public ResponseData getManageGrades(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getManageGrades(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getClassByGradeAndMajor", method = RequestMethod.GET)
    public ResponseData getClassByGradeAndMajor(@RequestParam(value = "token") String token,
                                         @RequestParam(value = "majorId") Long majorId,
                                           @RequestParam(value = "gradeId") Long gradeId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getClassByGradeAndMajor(majorId,gradeId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/getManageClassByGrade", method = RequestMethod.GET)
    public ResponseData getManageClassByGrade(@RequestParam(value = "token") String token,
                                                @RequestParam(value = "gradeId") Long gradeId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getManageClassByGrade(user,gradeId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }
}

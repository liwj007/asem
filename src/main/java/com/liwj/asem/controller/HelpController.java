package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.SelectionBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.service.IOrganizationService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/help")
public class HelpController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IOrganizationService organizationService;

    @RequestMapping(value = "/year_selection", method = RequestMethod.GET)
    public ResponseData getYears(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getYears(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/college_selection", method = RequestMethod.GET)
    public ResponseData getColleges(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getColleges(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/major_selection", method = RequestMethod.GET)
    public ResponseData getMajors(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getMajors(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/grade_selection", method = RequestMethod.GET)
    public ResponseData getGrades(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectionBO> res = organizationService.getGrades(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }
}

package com.liwj.asem.controller;

import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IOrganizationService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData create(@RequestParam(value = "name") String name,
                               @RequestParam(value = "type") String type,
                               @RequestParam(value = "collegeId", required = false) Long collegeId,
                               @RequestParam(value = "gradeId", required = false) Long gradeId,
                               @RequestParam(value = "majorId", required = false) Long majorId) throws WSPException {
        organizationService.createNewOrganization(name, type, collegeId, gradeId, majorId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/delete/{id}/{type}", method = RequestMethod.DELETE)
    public ResponseData delete(@PathVariable long id,
                               @PathVariable String type) throws WSPException {
        organizationService.deleteOrganization(id, type);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseData getAll() throws WSPException {
        HashMap<String, List> res = organizationService.getAllOrganization();
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    public ResponseData getUnitForAllocation(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "type") String type) throws WSPException {
        User user = userService.getUserByToken(token);
        List<UnitBO> res = organizationService.getUnitsForAllocation(user, type);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/colleges", method = RequestMethod.GET)
    public ResponseData getAllColleges() throws WSPException {
        List<College> res = organizationService.getAllColleges();
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    public ResponseData getAllGrades() throws WSPException {
        List<Grade> res = organizationService.getAllGrades();
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/majors/", method = RequestMethod.GET)
    public ResponseData getAllMajors() throws WSPException {
        List<Major> res = organizationService.getAllMajors();
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/majors/{collegeId}/{gradeId}", method = RequestMethod.GET)
    public ResponseData getMajorsByCollegeAndGrade(@PathVariable long collegeId, @PathVariable long gradeId) throws WSPException {
        List<Major> res = organizationService.getMajorsByCollegeAndGrade(collegeId, gradeId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public ResponseData getAllClasses() throws WSPException {
        List<Classes> res = organizationService.getAllClasses();
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }
}

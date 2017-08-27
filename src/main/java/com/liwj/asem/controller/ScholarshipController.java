package com.liwj.asem.controller;

import com.liwj.asem.bo.EntireScholarshipForm;
import com.liwj.asem.bo.SelectOfScholarshipBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import com.liwj.asem.service.IScholarshipService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/scholarships")
public class ScholarshipController {
    @Autowired
    private IScholarshipService scholarshipService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData create(@RequestParam(value = "token") String token,
                               @RequestBody EntireScholarshipForm scholarshipBO) throws WSPException {
        User user = userService.getUserByToken(token);
        scholarshipService.createNewScholarship(user,scholarshipBO);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseData update(@RequestParam(value = "token") String token,
                               @RequestBody EntireScholarshipForm scholarshipBO) throws WSPException {
        User user = userService.getUserByToken(token);
        scholarshipService.updateScholarship(user,scholarshipBO);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseData getScholarshipInfo(@RequestParam(value = "token") String token,
                                           @RequestParam(value = "id") Long id) throws WSPException {
        User user = userService.getUserByToken(token);
        EntireScholarshipForm bo = scholarshipService.getScholarshipDetailInfo(user,id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(bo);
        return responseData;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseData deleteScholarship(@PathVariable Long id) throws WSPException {
        scholarshipService.deleteScholarship(id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/open_to_student", method = RequestMethod.POST)
    public ResponseData openToStudent(@RequestParam(value = "token") String token,
                                      @RequestParam(value = "id") Long scholarshipId) throws WSPException {
        User user = userService.getUserByToken(token);
        scholarshipService.openToStudent(user,scholarshipId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }


}

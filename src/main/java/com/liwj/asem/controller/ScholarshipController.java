package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.EntireScholarshipForm;
import com.liwj.asem.bo.SelectOfScholarshipBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.service.IApplicationService;
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

    @Autowired
    private IApplicationService applicationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData create(@RequestParam(value = "token") String token,
                               @RequestBody EntireScholarshipForm scholarshipBO) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        scholarshipService.createNewScholarship(user, scholarshipBO);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseData update(@RequestParam(value = "token") String token,
                               @RequestBody EntireScholarshipForm scholarshipBO) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        scholarshipService.updateScholarship(user, scholarshipBO);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseData getScholarshipInfo(@RequestParam(value = "token") String token,
                                           @RequestParam(value = "id") Long scholarshipId,
                                           @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        EntireScholarshipForm bo = scholarshipService.getScholarshipDetailInfo(user, scholarshipId, unitId);
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
        UserDTO user = userService.getUserByToken(token);
        scholarshipService.openToStudent(user, scholarshipId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/getScholarshipsOfAward", method = RequestMethod.GET)
    public ResponseData getScholarshipsOfAward(@RequestParam(value = "token") String token,
                                               @RequestParam(value = "pageSize") Integer pageSize,
                                               @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = scholarshipService.getScholarshipsOfAward(user, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/getAwardApplicationsByScholarship", method = RequestMethod.GET)
    public ResponseData getAwardApplicationsByScholarship(@RequestParam(value = "token") String token,
                                                          @RequestParam(value = "id") Long scholarshipId,
                                                          @RequestParam(value = "pageSize") Integer pageSize,
                                                          @RequestParam(value = "pageNum") Integer pageNum,
                                                          @RequestParam(value = "collegeId", required = false) Long collegeId,
                                                          @RequestParam(value = "majorId", required = false) Long majorId,
                                                          @RequestParam(value = "gradeId", required = false) Long gradeId,
                                                          @RequestParam(value = "classId", required = false) Long classId,
                                                          @RequestParam(value = "content", required = false) String content) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<Long> studentIds = userService.selectStudentsByFilters(collegeId,majorId,gradeId,classId,content);
        PageInfo pageInfo = applicationService.getAwardApplicationsByScholarship(user, scholarshipId,studentIds,pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }
}

package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.EntireApplicationForm;
import com.liwj.asem.bo.PublicityApplyBO;
import com.liwj.asem.bo.PublicityScholarshipBO;
import com.liwj.asem.bo.SelectOfScholarshipBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.ApplicationFileStatusEnum;
import com.liwj.asem.enums.ApplicationPrizeStatusEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.service.IApplicationService;
import com.liwj.asem.service.IPublicityService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/applications")
public class ApplicationCheckController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IApplicationService applicationService;

    @Autowired
    private IPublicityService publicityService;

    @RequestMapping(value = "/prize_for_file_check_list", method = RequestMethod.GET)
    public ResponseData getPrizeForFileCheck(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "pageSize") Integer pageSize,
                                             @RequestParam(value = "pageNum") Integer pageNum,
                                             @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = applicationService.getPrizeForFileCheck(user, unitId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/prize_for_file_check_detail_list", method = RequestMethod.GET)
    public ResponseData getPrizeDetailForFileCheck(@RequestParam(value = "token") String token,
                                                   @RequestParam(value = "pageSize") Integer pageSize,
                                                   @RequestParam(value = "pageNum") Integer pageNum,
                                                   @RequestParam(value = "prizeId") Long prizeId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = applicationService.getPrizeDetailForFileCheck(user, prizeId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/check_file_status", method = RequestMethod.POST)
    public ResponseData checkFileStatus(@RequestParam(value = "token") String token,
                                        @RequestParam(value = "ids") List<Long> ids,
                                        @RequestParam(value = "result") ApplicationFileStatusEnum result) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        applicationService.checkApplicationFile(user, ids, result);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/prize_for_award_check_list", method = RequestMethod.GET)
    public ResponseData getPrizeForAwardCheck(@RequestParam(value = "token") String token,
                                              @RequestParam(value = "pageSize") Integer pageSize,
                                              @RequestParam(value = "pageNum") Integer pageNum,
                                              @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = applicationService.getPrizeForAwardCheck(user, unitId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/prize_for_award_check_detail_list", method = RequestMethod.GET)
    public ResponseData getPrizeDetailForAwardCheck(@RequestParam(value = "token") String token,
                                                    @RequestParam(value = "pageSize") Integer pageSize,
                                                    @RequestParam(value = "pageNum") Integer pageNum,
                                                    @RequestParam(value = "prizeId") Long prizeId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = applicationService.getPrizeDetailForAwardCheck(user, prizeId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/check_prize_status", method = RequestMethod.POST)
    public ResponseData checkPrizeStatus(@RequestParam(value = "token") String token,
                                         @RequestParam(value = "ids") List<Long> ids,
                                         @RequestParam(value = "result") ApplicationPrizeStatusEnum result) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        applicationService.checkApplicationPrize(user, ids, result);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/close_submit", method = RequestMethod.POST)
    public ResponseData closeSubmit(@RequestParam(value = "token") String token,
                                         @RequestParam(value = "id") Long id,
                                         @RequestParam(value = "manageUnit", required = false) Long unitId)throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        applicationService.closeSubmit(user, id, unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/prize_for_award_check_college_list", method = RequestMethod.GET)
    public ResponseData getCollegePrizeForAwardCheck(@RequestParam(value = "token") String token,
                                                     @RequestParam(value = "pageSize") Integer pageSize,
                                                     @RequestParam(value = "pageNum") Integer pageNum,
                                                     @RequestParam(value = "prizeId") Long prizeId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = applicationService.getCollegePrizeForAwardCheck(user, prizeId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }


    @RequestMapping(value = "/college_publicity_list", method = RequestMethod.GET)
    public ResponseData getCollegePublicityList(@RequestParam(value = "token") String token,
                                                @RequestParam(value = "pageSize") Integer pageSize,
                                                @RequestParam(value = "pageNum") Integer pageNum,
                                                @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getCollegePublicityList(user, unitId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/college_publicity_scholarship_list", method = RequestMethod.GET)
    public ResponseData getCollegePublicityScholarshipList(@RequestParam(value = "token") String token,
                                                           @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectOfScholarshipBO> res = publicityService.getCollegePublicityScholarshipList(user, unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/college_publicity", method = RequestMethod.POST)
    public ResponseData collegePublicity(@RequestParam(value = "token") String token,
                                         @RequestBody PublicityApplyBO publicityApplyBO) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        publicityService.collegePublicity(user, publicityApplyBO);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/college_manage_publicity_list", method = RequestMethod.GET)
    public ResponseData getCollegeMangePublicityList(@RequestParam(value = "token") String token,
                                                     @RequestParam(value = "pageSize") Integer pageSize,
                                                     @RequestParam(value = "pageNum") Integer pageNum,
                                                     @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getCollegeMangePublicityList(user, unitId, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/manage_publicity_detail_list", method = RequestMethod.GET)
    public ResponseData getCollegeMangePublicityDetailList(@RequestParam(value = "token") String token,
                                                           @RequestParam(value = "pageSize") Integer pageSize,
                                                           @RequestParam(value = "pageNum") Integer pageNum,
                                                           @RequestParam(value = "publicityId") Long publicityId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getMangePublicityDetailList(user, publicityId, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/student_manage_publicity_list", method = RequestMethod.GET)
    public ResponseData getStudentMangePublicityList(@RequestParam(value = "token") String token,
                                                     @RequestParam(value = "pageSize") Integer pageSize,
                                                     @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getStudentMangePublicityList(user, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/all_student_manage_publicity_list", method = RequestMethod.GET)
    public ResponseData getAllStudentMangePublicityList(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<PublicityScholarshipBO> res = publicityService.getAllStudentMangePublicityList(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/add_objection", method = RequestMethod.POST)
    public ResponseData addObjection(@RequestParam(value = "token") String token,
                                     @RequestParam(value = "publicityId") Long publicityId,
                                     @RequestParam(value = "content") String content) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        publicityService.addObjection(user, publicityId,content);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/student_objection", method = RequestMethod.GET)
    public ResponseData getStudentObjections(@RequestParam(value = "token") String token,
                                     @RequestParam(value = "pageSize") Integer pageSize,
                                     @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getStudentObjections(user,pageSize,pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/feedback_objection", method = RequestMethod.POST)
    public ResponseData feedbackObjection(@RequestParam(value = "token") String token,
                                     @RequestParam(value = "publicityId") Long publicityId,
                                     @RequestParam(value = "content") String content) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        publicityService.feedbackObjection(user, publicityId,content);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/college_objection", method = RequestMethod.GET)
    public ResponseData getCollegeObjections(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "pageSize") Integer pageSize,
                                             @RequestParam(value = "pageNum") Integer pageNum,
                                             @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getCollegeObjections(user,unitId,pageSize,pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }
}

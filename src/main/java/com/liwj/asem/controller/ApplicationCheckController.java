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
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.service.IApplicationService;
import com.liwj.asem.service.IPublicityService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
                                                   @RequestParam(value = "prizeId") Long prizeId,
                                                   @RequestParam(value = "collegeId", required = false) Long collegeId,
                                                   @RequestParam(value = "majorId", required = false) Long majorId,
                                                   @RequestParam(value = "gradeId", required = false) String grade,
                                                   @RequestParam(value = "classId", required = false) Long classId,
                                                   @RequestParam(value = "content", required = false) String content,
                                                   @RequestParam(value = "status", required = false) Integer status) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        List<Long> studentIds = userService.selectStudentsByFilters(collegeId, majorId, grade, classId, content);
        List<Integer> statusCodes = new ArrayList<>();
        switch (status) {
            case 0:
                statusCodes.add(0);
            case 1:
                statusCodes.add(ApplicationFileStatusEnum.SUBMIT.code);
                statusCodes.add(ApplicationFileStatusEnum.RESUBMIT.code);
                break;
            case 2:
                statusCodes.add(ApplicationFileStatusEnum.PASS.code);
                break;
            case 3:
                statusCodes.add(ApplicationFileStatusEnum.REJECT.code);
                break;
        }
        PageInfo pageInfo = applicationService.getPrizeDetailForFileCheck(user, prizeId, studentIds, statusCodes, pageNum, pageSize);
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
                                                    @RequestParam(value = "prizeId") Long prizeId,
                                                    @RequestParam(value = "collegeId", required = false) Long collegeId,
                                                    @RequestParam(value = "majorId", required = false) Long majorId,
                                                    @RequestParam(value = "gradeId", required = false) String grade,
                                                    @RequestParam(value = "classId", required = false) Long classId,
                                                    @RequestParam(value = "content", required = false) String content,
                                                    @RequestParam(value = "fileStatus", required = false) Integer fileStatus,
                                                    @RequestParam(value = "prizeStatus", required = false) Integer prizeStatus) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        List<Long> ids = userService.selectStudentsByFilters(collegeId, majorId, grade, classId, content);
        List<Integer> fileStatusCodes = new ArrayList<>();
        switch (fileStatus) {
            case 0:
                fileStatusCodes.add(0);
                break;
            case 1:
                fileStatusCodes.add(ApplicationFileStatusEnum.SUBMIT.code);
                fileStatusCodes.add(ApplicationFileStatusEnum.RESUBMIT.code);
                break;
            case 2:
                fileStatusCodes.add(ApplicationFileStatusEnum.PASS.code);
                break;
            case 3:
                fileStatusCodes.add(ApplicationFileStatusEnum.REJECT.code);
                break;
        }
        List<Integer> prizeStatusCodes = new ArrayList<>();
        switch (prizeStatus) {
            case 0:
                prizeStatusCodes.add(0);
                break;
            case 1:
                prizeStatusCodes.add(ApplicationPrizeStatusEnum.SUBMIT.code);
                break;
            case 2:
                prizeStatusCodes.add(ApplicationPrizeStatusEnum.PASS.code);
//                prizeStatusCodes.add(ApplicationPrizeStatusEnum.WAIT_PASS.code);
                break;
            case 3:
                prizeStatusCodes.add(ApplicationPrizeStatusEnum.REJECT.code);
                break;
        }
        PageInfo pageInfo = applicationService.getPrizeDetailForAwardCheck(user, prizeId, ids, fileStatusCodes, prizeStatusCodes, pageNum, pageSize);
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
                                    @RequestParam(value = "unitId", required = false) Long unitId) throws WSPException {
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
                                                     @RequestParam(value = "prizeId") Long prizeId) throws WSPException, RemoteException {
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
                                                @RequestParam(value = "manageUnit", required = false) Long unitId,
                                                @RequestParam(value = "collegeId", required = false) Long collegeId,
                                                @RequestParam(value = "majorId", required = false) Long majorId,
                                                @RequestParam(value = "gradeId", required = false) String grade,
                                                @RequestParam(value = "classId", required = false) Long classId,
                                                @RequestParam(value = "content", required = false) String content,
                                                @RequestParam(value = "prizeId", required = false) Long prizeId,
                                                @RequestParam(value = "scholarshipId", required = false) Long scholarshipId
    ) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        List<Long> studentIds = userService.selectStudentsByFilters(collegeId, majorId, grade, classId, content);
        PageInfo pageInfo = publicityService.getCollegePublicityList(user, unitId, studentIds, scholarshipId, prizeId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/school_publicity_list", method = RequestMethod.GET)
    public ResponseData getSchoolPublicityList(@RequestParam(value = "token") String token,
                                               @RequestParam(value = "pageSize") Integer pageSize,
                                               @RequestParam(value = "pageNum") Integer pageNum,
                                               @RequestParam(value = "collegeId", required = false) Long collegeId,
                                               @RequestParam(value = "majorId", required = false) Long majorId,
                                               @RequestParam(value = "gradeId", required = false) String grade,
                                               @RequestParam(value = "classId", required = false) Long classId,
                                               @RequestParam(value = "content", required = false) String content,
                                               @RequestParam(value = "prizeId", required = false) Long prizeId,
                                               @RequestParam(value = "scholarshipId", required = false) Long scholarshipId
    ) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        List<Long> studentIds = userService.selectStudentsByFilters(collegeId, majorId, grade, classId, content);
        PageInfo pageInfo = publicityService.getSchoolPublicityList(user, studentIds, scholarshipId, prizeId, pageNum, pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/school_publicity_scholarship_list", method = RequestMethod.GET)
    public ResponseData getSchoolPublicityScholarshipList(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectOfScholarshipBO> res = publicityService.getSchoolPublicityScholarshipList(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
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

    @RequestMapping(value = "/school_publicity", method = RequestMethod.POST)
    public ResponseData schoolPublicity(@RequestParam(value = "token") String token,
                                        @RequestBody PublicityApplyBO publicityApplyBO) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        publicityService.schoolPublicity(user, publicityApplyBO);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/college_manage_publicity_list", method = RequestMethod.GET)
    public ResponseData getCollegeMangePublicityList(@RequestParam(value = "token") String token,
                                                     @RequestParam(value = "pageSize") Integer pageSize,
                                                     @RequestParam(value = "pageNum") Integer pageNum,
                                                     @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getCollegeMangePublicityList(user, unitId, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/school_manage_publicity_list", method = RequestMethod.GET)
    public ResponseData getSchoolMangePublicityList(@RequestParam(value = "token") String token,
                                                    @RequestParam(value = "pageSize") Integer pageSize,
                                                    @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getSchoolMangePublicityList(user, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/manage_publicity_detail_list", method = RequestMethod.GET)
    public ResponseData getCollegeMangePublicityDetailList(@RequestParam(value = "token") String token,
                                                           @RequestParam(value = "pageSize") Integer pageSize,
                                                           @RequestParam(value = "pageNum") Integer pageNum,
                                                           @RequestParam(value = "publicityId") Long publicityId) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getMangePublicityDetailList(user, publicityId, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/student_manage_publicity_list", method = RequestMethod.GET)
    public ResponseData getStudentMangePublicityList(@RequestParam(value = "token") String token,
                                                     @RequestParam(value = "pageSize") Integer pageSize,
                                                     @RequestParam(value = "pageNum") Integer pageNum) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getStudentMangePublicityList(user, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/all_student_manage_publicity_list", method = RequestMethod.GET)
    public ResponseData getAllStudentMangePublicityList(@RequestParam(value = "token") String token) throws WSPException, RemoteException {
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
        publicityService.addObjection(user, publicityId, content);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/student_objection", method = RequestMethod.GET)
    public ResponseData getStudentObjections(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "pageSize") Integer pageSize,
                                             @RequestParam(value = "pageNum") Integer pageNum) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getStudentObjections(user, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/feedback_objection", method = RequestMethod.POST)
    public ResponseData feedbackObjection(@RequestParam(value = "token") String token,
                                          @RequestParam(value = "publicityId") Long publicityId,
                                          @RequestParam(value = "content") String content) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        publicityService.feedbackObjection(user, publicityId, content);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/college_objection", method = RequestMethod.GET)
    public ResponseData getCollegeObjections(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "pageSize") Integer pageSize,
                                             @RequestParam(value = "pageNum") Integer pageNum,
                                             @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getCollegeObjections(user, unitId, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/school_objection", method = RequestMethod.GET)
    public ResponseData getSchoolObjections(@RequestParam(value = "token") String token,
                                            @RequestParam(value = "pageSize") Integer pageSize,
                                            @RequestParam(value = "pageNum") Integer pageNum) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = publicityService.getSchoolObjections(user, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }
}

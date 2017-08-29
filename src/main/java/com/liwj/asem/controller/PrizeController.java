package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.FeedbackBO;
import com.liwj.asem.bo.SelectOfScholarshipBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.FeedbackStatusEnum;
import com.liwj.asem.enums.FeedbackTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.service.IFeedbackService;
import com.liwj.asem.service.IPrizeService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/prizes")
public class PrizeController {

    @Autowired
    private IPrizeService prizeService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFeedbackService feedbackService;

    //读取学校用户＼学院用户可管理的奖项列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseData getManagePrizeLists(@RequestParam(value = "token") String token,
                                            @RequestParam(value = "pageSize") Integer pageSize,
                                            @RequestParam(value = "pageNum") Integer pageNum,
                                            @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = prizeService.getManagePrizeLists(user, pageNum, pageSize,unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/release_to_college", method = RequestMethod.POST)
    public ResponseData releaseToCollege(@RequestBody List<Long> prizeList) throws WSPException {
        prizeService.releaseToCollege(prizeList);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/selection_for_quota_feedback", method = RequestMethod.GET)
    public ResponseData getScholarshipSelectionForQuotaFeedback(@RequestParam(value = "token") String token,
                                                                @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectOfScholarshipBO> bo = prizeService.getScholarshipSelectionForQuotaFeedback(user,unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(bo);
        return responseData;
    }

    @RequestMapping(value = "/quota_apply", method = RequestMethod.POST)
    public ResponseData applyQuota(@RequestParam(value = "token") String token,
                                   @RequestBody List<FeedbackBO> feedbackBOList) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        feedbackService.applyQuota(user, feedbackBOList);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/quota_apply_list", method = RequestMethod.GET)
    public ResponseData getApplyQuotaList(@RequestParam(value = "token") String token,
                                          @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = feedbackService.getQuotaList(user, FeedbackTypeEnum.APPLY, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/quota_back", method = RequestMethod.POST)
    public ResponseData backQuota(@RequestParam(value = "token") String token,
                                  @RequestBody List<FeedbackBO> feedbackBOList) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        feedbackService.applyBack(user, feedbackBOList);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/quota_back_list", method = RequestMethod.GET)
    public ResponseData getBackQuotaList(@RequestParam(value = "token") String token,
                                         @RequestParam(value = "pageSize") Integer pageSize,
                                         @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = feedbackService.getQuotaList(user, FeedbackTypeEnum.BACK, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/all_quota_back_list", method = RequestMethod.GET)
    public ResponseData getAllBackQuotaList(@RequestParam(value = "token") String token,
                                            @RequestParam(value = "pageSize") Integer pageSize,
                                            @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = feedbackService.getAllQuotaList(user, FeedbackTypeEnum.BACK, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/all_quota_apply_list", method = RequestMethod.GET)
    public ResponseData getAllApplyQuotaList(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "pageSize") Integer pageSize,
                                             @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = feedbackService.getAllQuotaList(user, FeedbackTypeEnum.APPLY, pageSize, pageNum);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/check_quota_apply", method = RequestMethod.POST)
    public ResponseData getAllApplyQuotaList(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "ids") List<Long> ids,
                                             @RequestParam(value = "result") FeedbackStatusEnum result) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        feedbackService.checkApplyBatch(ids, result);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }
}

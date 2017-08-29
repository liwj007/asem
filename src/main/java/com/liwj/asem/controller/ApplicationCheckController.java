package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.EntireApplicationForm;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.ApplicationFileStatusEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.service.IApplicationService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/applications")
public class ApplicationCheckController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IApplicationService applicationService;

    @RequestMapping(value = "/prize_for_file_check_list", method = RequestMethod.GET)
    public ResponseData getPrizeForFileCheck(@RequestParam(value = "token") String token,
                                         @RequestParam(value = "pageSize") Integer pageSize,
                                         @RequestParam(value = "pageNum") Integer pageNum,
                                         @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = applicationService.getPrizeForFileCheck(user,unitId,pageNum,pageSize);
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
        PageInfo pageInfo = applicationService.getPrizeDetailForFileCheck(user,prizeId,pageNum,pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/check_file_status", method = RequestMethod.POST)
    public ResponseData create(@RequestParam(value = "token") String token,
                               @RequestParam(value = "ids") List<Long> ids,
                               @RequestParam(value = "result")ApplicationFileStatusEnum result) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        applicationService.checkApplicationFile(user,ids,result);
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
        PageInfo pageInfo = applicationService.getPrizeForAwardCheck(user,unitId,pageNum,pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }
}

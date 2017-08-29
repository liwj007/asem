package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.ApplicationBO;
import com.liwj.asem.bo.EntireApplicationForm;
import com.liwj.asem.bo.MyselfEvaluationBO;
import com.liwj.asem.bo.PrizeForApplicationBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import com.liwj.asem.service.IApplicationService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/applications")
public class ApplicationController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IApplicationService applicationService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData create(@RequestParam(value = "token") String token,
                               @RequestBody EntireApplicationForm applicationForm) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        applicationService.createApplication(user,applicationForm);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/update_file", method = RequestMethod.POST)
    public ResponseData updateFile(@RequestParam(value = "token") String token,
                               @RequestBody EntireApplicationForm applicationForm) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        applicationService.updateApplication(user,applicationForm);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/prize_list", method = RequestMethod.GET)
    public ResponseData getPrizeWhichCanSubmit(@RequestParam(value = "token") String token,
                               @RequestParam(value = "pageSize") Integer pageSize,
                               @RequestParam(value = "pageNum") Integer pageNum) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = applicationService.getPrizeWhichCanSubmit(user,pageNum,pageSize);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    @RequestMapping(value = "/get_evaluation_template", method = RequestMethod.GET)
    public ResponseData getMyselfEvaluation(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        MyselfEvaluationBO res = applicationService.getMyselfEvaluation(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseData getApplicationDetail(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "id") Long id) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        ApplicationBO res = applicationService.getApplicationDetail(user,id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }


}

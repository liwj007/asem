package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.EntireUnitPrizeForm;
import com.liwj.asem.bo.PrizeForListBO;
import com.liwj.asem.bo.SelectOfPrizeBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import com.liwj.asem.service.IPrizeService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/prizes")
public class AllocationNumberController {

    @Autowired
    private IPrizeService prizeService;

    @Autowired
    private IUserService userService;


    //读取为安排过名额的奖项列表
    @RequestMapping(value = "/select_list_un_allocation_number", method = RequestMethod.GET)
    public ResponseData getSelectOfUnAllocationNumber(@RequestParam(value = "token") String token,
                                            @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectOfPrizeBO> res = prizeService.getSelectOfUnAllocationNumberPrizes(user,unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    //分配名额
    @RequestMapping(value = "/allocation_number", method = RequestMethod.POST)
    public ResponseData allocationNumber(@RequestParam(value = "token") String token,
                                         @RequestBody EntireUnitPrizeForm entireUnitPrizeForm) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        prizeService.allocationNumber(user, entireUnitPrizeForm);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    //读取已分配名额的列表
    @RequestMapping(value = "/allocated_number_list", method = RequestMethod.GET)
    public ResponseData getAwardsOfAllocatedNumber(@RequestParam(value = "token") String token,
                                                   @RequestParam(value = "pageSize") Integer pageSize,
                                                   @RequestParam(value = "pageNum") Integer pageNum,
                                                   @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = prizeService.getAllocatedNumberPrizes(user, pageNum, pageSize,unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    //读取已分配名额的奖项的详细信息
    @RequestMapping(value = "/allocated_number_detail", method = RequestMethod.GET)
    public ResponseData getAwardDetailOfAllocatedNumber(@RequestParam(value = "token") String token,
                                                  @RequestParam(value = "prizeId") Long prizeId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        EntireUnitPrizeForm res = prizeService.getAwardDetailOfAllocatedNumber(user, prizeId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    //更新已分配名额的奖项分配方案
    @RequestMapping(value = "/update_allocation_number", method = RequestMethod.POST)
    public ResponseData updateAllocationCollegeAward(@RequestParam(value = "token") String token,
                                                     @RequestBody EntireUnitPrizeForm entireUnitPrizeForm) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        prizeService.updateAllocationNumber(user, entireUnitPrizeForm);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

}

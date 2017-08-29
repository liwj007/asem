package com.liwj.asem.controller;

import com.github.pagehelper.PageInfo;
import com.liwj.asem.bo.ScholarshipForListBO;
import com.liwj.asem.bo.SelectOfScholarshipBO;
import com.liwj.asem.bo.TimeLimitBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.ScholarshipTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import com.liwj.asem.service.IPrizeService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/prizes")
public class AllocationTimeController {

    @Autowired
    private IPrizeService prizeService;

    @Autowired
    private IUserService userService;


    //读取未被安排时间的奖学金列表
    @RequestMapping(value = "/select_list_un_allocation_time", method = RequestMethod.GET)
    public ResponseData getSelectOfUnAllocationTime(@RequestParam(value = "token") String token,
                                                    @RequestParam(value = "scholarshipType", required = false) ScholarshipTypeEnum scholarshipType,
                                                    @RequestParam(value = "needGrade", required = false) Boolean needGrade,
                                                    @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<SelectOfScholarshipBO> res = prizeService.
                getSelectOfUnAllocationTimeScholarships(user, scholarshipType, needGrade, unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    //分配评定时间
    @RequestMapping(value = "/allocation_time", method = RequestMethod.POST)
    public ResponseData allocationTime(@RequestParam(value = "token") String token,
                                       @RequestBody List<TimeLimitBO> list) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        prizeService.allocationTime(user, list);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    //读取已分配时间的奖学金列表
    @RequestMapping(value = "/allocated_time_list", method = RequestMethod.GET)
    public ResponseData getScholarshipsOfAllocatedTime(@RequestParam(value = "token") String token,
                                                       @RequestParam(value = "pageSize") Integer pageSize,
                                                       @RequestParam(value = "pageNum") Integer pageNum,
                                                       @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        PageInfo pageInfo = prizeService.getScholarshipsOfAllocatedTime(user, pageNum, pageSize,unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(pageInfo);
        return responseData;
    }

    //读取已分配时间的奖学金时间详情
    @RequestMapping(value = "/allocated_time_detail", method = RequestMethod.GET)
    public ResponseData getCollegeAwardInfo(@RequestParam(value = "token") String token,
                                            @RequestParam(value = "scholarshipId") Long scholarshipId,
                                            @RequestParam(value = "manageUnit", required = false) Long unitId) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        TimeLimitBO bo = prizeService.getDetailOfAllocatedTime(user, scholarshipId,unitId);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(bo);
        return responseData;
    }

    //修改评定时间
    @RequestMapping(value = "/update_allocation_time", method = RequestMethod.POST)
    public ResponseData updateAllocationCollegeTime(@RequestParam(value = "token") String token,
                                                    @RequestBody TimeLimitBO timeLimitBO) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        prizeService.updateAllocationTime(user, timeLimitBO);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }


}

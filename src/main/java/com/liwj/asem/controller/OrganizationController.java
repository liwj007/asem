package com.liwj.asem.controller;

import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.UnitTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
import com.liwj.asem.remote.bo.College;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {



    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    public ResponseData getUnitForAllocation(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "type") String type,
                                             @RequestParam(value = "collegeId", required = false) Long collegeId) throws WSPException, RemoteException {
        UserDTO user = userService.getUserByToken(token);
        List<UnitBO> res = new ArrayList<>();

        RemoteService rs = new RemoteService();

        if (type.equals(UnitTypeEnum.SCHOOL.name())) {
            List<College> tmp = rs.getAllColleges();
            for (College item: tmp){
                int num = rs.getStudentCountByCollege(item.getId());
                UnitBO bo = new UnitBO(item.getId(),item.getName(), num);
                res.add(bo);
            }
        }else if (type.equals(UnitTypeEnum.COLLEGE.name())){
            List<String> tmp = rs.getGradesByCollege(collegeId);
            for (String grade: tmp){
                int num = rs.getStudentCountByCollegeAndGrade(collegeId,grade);
                UnitBO bo = new UnitBO(Long.parseLong(grade),grade,num);
                res.add(bo);
            }
        }

        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/manage_college", method = RequestMethod.GET)
    public ResponseData getManageCollege(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(user.getManageColleges());
        return responseData;
    }

}

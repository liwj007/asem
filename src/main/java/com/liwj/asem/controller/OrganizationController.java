package com.liwj.asem.controller;

import com.liwj.asem.bo.UnitBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.service.IOrganizationService;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    public ResponseData getUnitForAllocation(@RequestParam(value = "token") String token,
                                             @RequestParam(value = "type") String type) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        List<UnitBO> res = organizationService.getUnitsForAllocation(user, type);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/manage_college", method = RequestMethod.GET)
    public ResponseData getManageCollege(@RequestParam(value = "token") String token) throws WSPException {
        UserDTO user = userService.getUserByToken(token);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(user.getManagePrimaryTeachingInstitutions());
        return responseData;
    }

}

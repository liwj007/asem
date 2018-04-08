package com.liwj.asem.controller;

import com.liwj.asem.bo.UserBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.RoleTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController{

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestParam(value = "username") String nickName,
                               @RequestParam(value = "password") String password,
                              @RequestParam(value = "type") int type) throws WSPException {
        UserDTO user = userService.login(nickName,password,type);
        UserBO bo = new UserBO(user.getName(),user.getToken(), user.getUserRole().desc);
        bo.setUserType(user.getUserRole().name());
        bo.setManageColleges(user.getManageColleges());
        bo.setManageGrades(user.getManageGrades());
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(bo);
        return responseData;
    }


}

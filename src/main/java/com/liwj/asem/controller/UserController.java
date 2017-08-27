package com.liwj.asem.controller;

import com.liwj.asem.bo.UserBO;
import com.liwj.asem.data.ResponseData;
import com.liwj.asem.enums.UserRightEnum;
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
                               @RequestParam(value = "password") String password) throws WSPException {
        User user = userService.login(nickName,password);
        UserBO bo = new UserBO(user.getUsername(),user.getName(),user.getToken(), UserRightEnum.getNameByCode(user.getUserType()));
        bo.setUserType(UserRightEnum.getByCode(user.getUserType()).name());
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(bo);
        return responseData;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseData create(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "userType") UserRightEnum userType,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "mobile", required = false) String mobile,
                               @RequestParam(value = "password", required = false) String password) throws WSPException {
        User user = new User(userName,  password,  name, mobile, email, userType.code);
        userService.createUser(user);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseData getAll() throws WSPException {
        List<UserBO> res = userService.getAllUsers();
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(res);
        return responseData;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseData delete(@PathVariable long id) throws WSPException {
        userService.deleteUser(id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccessData(null);
        return responseData;
    }

}

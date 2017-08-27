package com.liwj.asem.service;

import com.liwj.asem.bo.UserBO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;

import java.util.List;

public interface IUserService {
    User getUserByToken(String token) throws WSPException;

    void createUser(User user);

    List<UserBO> getAllUsers();

    void deleteUser(long id);

    User login(String nickName, String password) throws WSPException;

    Boolean isSchoolUser(User user);

    Boolean isCollegeManger(User user);
}

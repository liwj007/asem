package com.liwj.asem.service;

import com.liwj.asem.bo.UserBO;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);

    User getUserBySN(String SN);

    UserDTO getUserByToken(String token) throws WSPException;

    UserDTO login(String nickName, String password) throws WSPException;

    List<User> getStudents(Long primaryTeachingInstitutionId, List<Long> grades);

    Boolean isSchoolUser(UserDTO user);

    Boolean isCollegeManger(UserDTO user);

    Boolean isGradeManger(UserDTO user);
}

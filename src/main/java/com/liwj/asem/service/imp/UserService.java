package com.liwj.asem.service.imp;

import com.liwj.asem.annotation.Rights;
import com.liwj.asem.bo.UserBO;
import com.liwj.asem.dao.UserMapper;
import com.liwj.asem.data.CommonVariable;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.enums.UserRightEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.User;
import com.liwj.asem.model.UserExample;
import com.liwj.asem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    private String generateToken(User user) {
        String token = user.getUsername() + UUID.randomUUID().toString().replace("-", "");
        return token;
    }

    @Override
    public User getUserByToken(String token) throws WSPException {
        UserExample example = new UserExample();
        example.createCriteria().andTokenEqualTo(token);
        List<User> res = userMapper.selectByExample(example);
        if (res.size()!=1){
            throw new WSPException(ErrorInfo.NO_LOGIN);
        }
        User user = res.get(0);
        return user;
    }

    @Override
    public void createUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public List<UserBO> getAllUsers() {
        List<User> list =  userMapper.selectByExample(new UserExample());
        List<UserBO> res = new ArrayList<>();
        for (User user: list){
            UserBO bo = new UserBO();
            bo.setName(user.getName());
            bo.setUserName(user.getUsername());
            bo.setUserTypeName(UserRightEnum.getNameByCode(user.getUserType()));
            bo.setMobile(user.getMobile());
            bo.setEmail(user.getEmail());
            bo.setId(user.getId());
            res.add(bo);
        }
        return res;
    }

    @Override
    public void deleteUser(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User login(String nickName, String password) throws WSPException {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(nickName).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 1) {
            User user = users.get(0);
            Date date = new Date();
            user.setToken(generateToken(user));
            user.setExpire(date.getTime() + CommonVariable.tokenOutPeriod);
            userMapper.updateByPrimaryKeySelective(user);
            return user;
        } else {
            throw new WSPException(ErrorInfo.ERROR_USER_LOGIN);
        }
    }

    @Override
    public Boolean isSchoolUser(User user){
        return user.getUserType()== UserRightEnum.SCHOOL.code;
    }

    @Override
    public Boolean isCollegeManger(User user){
        return user.getUserType()==UserRightEnum.SPECIAL_INSTRUCTOR.code ||
                user.getUserType()==UserRightEnum.COLLEGE_STUDENT.code;
    }
}

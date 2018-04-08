package com.liwj.asem.service.imp;

import com.liwj.asem.bo.Unit;
import com.liwj.asem.dao.*;
import com.liwj.asem.data.CommonVariable;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.RoleTypeEnum;
import com.liwj.asem.enums.UserTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
import com.liwj.asem.remote.RemoteException;
import com.liwj.asem.remote.RemoteService;
import com.liwj.asem.remote.bo.Item;
import com.liwj.asem.remote.bo.NewStudent;
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

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RUserAndGradeMapper rUserAndGradeMapper;

    @Autowired
    private RUserAndCollegeMapper rUserAndCollegeMapper;

    private String generateToken(User user) {
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserBySN(String SN) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andSnEqualTo(SN);
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() == 1) {
            User user = list.get(0);
            return user;
        }
        return null;
    }

    @Override
    public UserDTO getUserByToken(String token) throws WSPException {
        UserExample example = new UserExample();
        example.createCriteria().andTokenEqualTo(token);
        List<User> res = userMapper.selectByExample(example);
        if (res.size() != 1) {
            throw new WSPException(ErrorInfo.NO_LOGIN);
        }
        User user = res.get(0);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setPhone(user.getPhone());
        userDTO.setToken(user.getToken());
        userDTO.setSn(user.getSn());
        userDTO.setExpire(user.getExpire());
        userDTO.setUserRole(RoleTypeEnum.getByCode(user.getUserRole()));
        userDTO.setCollegeId(user.getCollegeId());
        userDTO.setGrade(user.getGrade());

        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(user.getId());
        List<UserRole> roles = userRoleMapper.selectByExample(userRoleExample);
        for (UserRole role : roles) {
            userDTO.getRoles().add(RoleTypeEnum.getByCode(role.getRoleType()));
        }

        if (user.getUserRole()==RoleTypeEnum.COLLEGE.code){
            RUserAndCollegeExample example1=new RUserAndCollegeExample();
            example1.createCriteria().andUserIdEqualTo(user.getId());
            List<RUserAndCollege> list1 = rUserAndCollegeMapper.selectByExample(example1);
            RemoteService rs = new RemoteService();
            for (RUserAndCollege item : list1) {
                try {
                    String name = rs.findCollegeNameById(item.getCollegeId());
                    Unit  unit = new Unit();
                    unit.setId(item.getCollegeId());
                    unit.setName(name);
                    userDTO.getManageColleges().add(unit);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        }

        if (user.getUserRole()==RoleTypeEnum.GRADE.code){
            RUserAndGradeExample rUserAndGradeExample = new RUserAndGradeExample();
            rUserAndGradeExample.createCriteria().andUserIdEqualTo(user.getId());
            List<RUserAndGrade> list2 = rUserAndGradeMapper.selectByExample(rUserAndGradeExample);
            for (RUserAndGrade item : list2) {
                userDTO.getManageGrades().add(item.getGrade());
            }
            Unit unit = new Unit();
            unit.setId(user.getCollegeId());
            userDTO.getManageColleges().add(unit);
        }

        return userDTO;
    }


    @Override
    public UserDTO login(String sn, String password, int type) throws WSPException {
        //待换成授权登录
        UserExample example = new UserExample();
        example.createCriteria().andSnEqualTo(sn);
        RemoteService rs = new RemoteService();

        try {
            List<Integer> role = rs.findRoleBySn(sn);
            if (role == null || role.size()==0) {
                throw new WSPException(ErrorInfo.ERROR_USER_LOGIN);
            }

            User user;
            List<User> users = userMapper.selectByExample(example);
            if (users.size() == 1) {
                user = users.get(0);
                Date date = new Date();
                user.setToken(generateToken(user));
                user.setExpire(date.getTime() + CommonVariable.tokenOutPeriod);
                userMapper.updateByPrimaryKeySelective(user);
            }else{
                user = new User();
                user.setSn(sn);
                Date date = new Date();
                user.setToken(generateToken(user));
                user.setExpire(date.getTime() + CommonVariable.tokenOutPeriod);
                String name = rs.findUserNameBySn(sn);
                user.setName(name);
                userMapper.insertSelective(user);
            }

            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(user.getId());
            userRoleMapper.deleteByExample(userRoleExample);

            RUserAndCollegeExample rUserAndCollegeExample = new RUserAndCollegeExample();
            rUserAndCollegeExample.createCriteria().andUserIdEqualTo(user.getId());
            rUserAndCollegeMapper.deleteByExample(rUserAndCollegeExample);

            RUserAndGradeExample rUserAndGradeExample = new RUserAndGradeExample();
            rUserAndGradeExample.createCriteria().andUserIdEqualTo(user.getId());
            rUserAndGradeMapper.deleteByExample(rUserAndGradeExample);

            if (type==UserTypeEnum.STUDENT.code && role.contains(UserTypeEnum.STUDENT.code)) {
                NewStudent student = rs.findStudentInfoBySn(sn);
                user.setCollegeId((long) student.getCollegeID());
                user.setMajorId((long) student.getMajorID());
                user.setClassesId((long) student.getClassID());
                user.setGrade(student.getGrade());
                user.setUserRole(RoleTypeEnum.STUDENT.code);
                userMapper.updateByPrimaryKeySelective(user);

                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleType(RoleTypeEnum.STUDENT.code);
                userRoleMapper.insertSelective(userRole);
            } else if (type==UserTypeEnum.GRADE_INSTRUCTOR.code && role.contains(UserTypeEnum.GRADE_INSTRUCTOR.code)) {
                user.setUserRole(RoleTypeEnum.GRADE.code);
                userMapper.updateByPrimaryKeySelective(user);

                List<Item> manageGrades = rs.findGradeByAdvisor(sn);
                Long collegeId = null;
                for (Item item: manageGrades){
                    RUserAndGrade tmp = new RUserAndGrade();
                    tmp.setUserId(user.getId());
                    tmp.setGrade(item.getName());
                    tmp.setCollegeId((long) item.getId());
                    rUserAndGradeMapper.insertSelective(tmp);

                    collegeId=tmp.getCollegeId();
                }

                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleType(RoleTypeEnum.GRADE.code);
                userRoleMapper.insertSelective(userRole);

                user.setCollegeId(collegeId);
                userMapper.updateByPrimaryKeySelective(user);
            } else if ((type==UserTypeEnum.COLLEGE_USER.code && role.contains(UserTypeEnum.COLLEGE_USER.code) )||
                    (type==UserTypeEnum.SPECIAL_INSTRUCTOR.code && role.contains(UserTypeEnum.SPECIAL_INSTRUCTOR.code))) {
                user.setUserRole(RoleTypeEnum.COLLEGE.code);
                userMapper.updateByPrimaryKeySelective(user);

                List<Item> manageColleges = rs.findManageCollegesBySn(sn);
                for (Item item: manageColleges){
                    RUserAndCollege tmp = new RUserAndCollege();
                    tmp.setUserId(user.getId());
                    tmp.setCollegeId((long) item.getId());
                    tmp.setCollegeName(item.getName());
                    rUserAndCollegeMapper.insertSelective(tmp);
                }

                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleType(RoleTypeEnum.COLLEGE.code);
                userRoleMapper.insertSelective(userRole);
            } else if (type==UserTypeEnum.SCHOOL_USER.code &&role.contains(UserTypeEnum.SCHOOL_USER.code)) {
                user.setUserRole(RoleTypeEnum.SCHOOL.code);
                userMapper.updateByPrimaryKeySelective(user);

                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleType(RoleTypeEnum.SCHOOL.code);
                userRoleMapper.insertSelective(userRole);
            }else{
                throw new WSPException(ErrorInfo.ROLE_ERROR);
            }

            return getUserByToken(user.getToken());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public Boolean isSchoolUser(UserDTO user) {
//        return user.getRoles() == RoleTypeEnum.SCHOOL_USER;
        return user.getRoles().contains(RoleTypeEnum.SCHOOL);
    }

    @Override
    public Boolean isCollegeManger(UserDTO user) {
//        return user.getUserType() == RoleTypeEnum.SPECIAL_ADVISER;
        return user.getRoles().contains(RoleTypeEnum.COLLEGE);
    }

    @Override
    public Boolean isGradeManger(UserDTO user) {
//        return user.getUserType() == RoleTypeEnum.GRADE_ADVISER;
        return user.getRoles().contains(RoleTypeEnum.GRADE);
    }

    @Override
    public List<Long> selectStudentsByFilters(Long collegeId, Long majorId, String grade, Long classId, String content) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (collegeId != null && collegeId > 0) {
            criteria.andCollegeIdEqualTo(collegeId);
        }
        if (majorId != null && majorId > 0) {
            criteria.andMajorIdEqualTo(majorId);
        }
        if (grade!=null && !"0".equals(grade) && !"".equals(grade)) {
            criteria.andGradeEqualTo(grade);
        }
        if (classId != null && classId > 0) {
            criteria.andClassesIdEqualTo(classId);
        }

        criteria.andUserRoleEqualTo(RoleTypeEnum.STUDENT.code);
        List<User> students = userMapper.selectByExample(example);
        List<Long> ids = new ArrayList<>();
        for (User user : students) {
            ids.add(user.getId());
        }

        if (content != null && !"".equals(content)) {
            if (ids.size() == 0) {
                return ids;
            }
            content = content.replace("%", "\\%");
            example.clear();
            UserExample.Criteria criteria1 = example.createCriteria();
            criteria1.andNameLike("%" + content + "%").andIdIn(ids);
            UserExample.Criteria criteria2 = example.createCriteria();
            criteria2.andSnLike("%" + content + "%").andIdIn(ids);
            example.or(criteria2);
            List<User> tmp = userMapper.selectByExample(example);
            List<Long> res = new ArrayList<>();
            for (User user : tmp) {
                res.add(user.getId());
            }
            return res;
        } else {
            return ids;
        }
    }
}

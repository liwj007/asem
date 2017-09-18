package com.liwj.asem.service.imp;

import com.liwj.asem.dao.*;
import com.liwj.asem.data.CommonVariable;
import com.liwj.asem.data.ErrorInfo;
import com.liwj.asem.dto.UserDTO;
import com.liwj.asem.enums.RoleTypeEnum;
import com.liwj.asem.exception.WSPException;
import com.liwj.asem.model.*;
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
    private RUserAndPrimaryTeachingInstitutionMapper rUserAndPrimaryTeachingInstitutionMapper;

    @Autowired
    private RUserAndGradeMapper rUserAndGradeMapper;

    @Autowired
    private PrimaryTeachingInstitutionMapper primaryTeachingInstitutionMapper;

    @Autowired
    private GradeMapper gradeMapper;

    private String generateToken(User user) {
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;
    }

    @Override
    public User getUserById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserBySN(String SN){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andSnEqualTo(SN);
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size()==1){
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
        userDTO.setUserType(RoleTypeEnum.getByCode(user.getUserType()));

        PrimaryTeachingInstitution institution = primaryTeachingInstitutionMapper.selectByPrimaryKey(user.getPrimaryTeachingInstitutionId());
        userDTO.setPrimaryTeachingInstitution(institution);
        Grade grade2 = gradeMapper.selectByPrimaryKey(user.getGradeId());
        userDTO.setGrade(grade2);

        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(user.getId());
        List<UserRole> roles = userRoleMapper.selectByExample(userRoleExample);
        for (UserRole role : roles) {
            userDTO.getRoles().add(RoleTypeEnum.getByCode(role.getRoleType()));
        }

        RUserAndPrimaryTeachingInstitutionExample rUserAndPrimaryTeachingInstitutionExample
                = new RUserAndPrimaryTeachingInstitutionExample();
        rUserAndPrimaryTeachingInstitutionExample.createCriteria().andUserIdEqualTo(user.getId());
        List<RUserAndPrimaryTeachingInstitution> list1 = rUserAndPrimaryTeachingInstitutionMapper
                .selectByExample(rUserAndPrimaryTeachingInstitutionExample);
        for (RUserAndPrimaryTeachingInstitution item: list1){
            PrimaryTeachingInstitution primaryTeachingInstitution = primaryTeachingInstitutionMapper.selectByPrimaryKey(item.getPrimaryTeachingInstitutionId());
            userDTO.getManagePrimaryTeachingInstitutions().add(primaryTeachingInstitution);
        }

        RUserAndGradeExample rUserAndGradeExample=  new RUserAndGradeExample();
        rUserAndGradeExample.createCriteria().andUserIdEqualTo(user.getId());
        List<RUserAndGrade> list2 = rUserAndGradeMapper.selectByExample(rUserAndGradeExample);
        for (RUserAndGrade item: list2){
            Grade grade = gradeMapper.selectByPrimaryKey(item.getGradeId());
            userDTO.getManageGrades().add(grade);
        }

        return userDTO;
    }



    @Override
    public UserDTO login(String nickName, String password) throws WSPException {
        UserExample example = new UserExample();
        example.createCriteria().andSnEqualTo(nickName).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 1) {
            User user = users.get(0);
            Date date = new Date();
            user.setToken(generateToken(user));
            user.setExpire(date.getTime() + CommonVariable.tokenOutPeriod);
            userMapper.updateByPrimaryKeySelective(user);
            return getUserByToken(user.getToken());
        } else {
            throw new WSPException(ErrorInfo.ERROR_USER_LOGIN);
        }
    }

    @Override
    public List<User> getStudents(Long primaryTeachingInstitutionId, List<Long> grades){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (primaryTeachingInstitutionId!=null && primaryTeachingInstitutionId>0){
            criteria.andPrimaryTeachingInstitutionIdEqualTo(primaryTeachingInstitutionId);
        }

        if (grades!=null && grades.size()>0){
            criteria.andGradeIdIn(grades);
        }
        List<User> res = userMapper.selectByExample(userExample);
        return res;
    }

    @Override
    public List<User> getStudents(List<Long> primaryTeachingInstitutions, List<Long> grades){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (primaryTeachingInstitutions!=null && primaryTeachingInstitutions.size()>0){
            criteria.andPrimaryTeachingInstitutionIdIn(primaryTeachingInstitutions);
        }

        if (grades!=null && grades.size()>0){
            criteria.andGradeIdIn(grades);
        }
        List<User> res = userMapper.selectByExample(userExample);
        return res;
    }

    @Override
    public Boolean isSchoolUser(UserDTO user) {
        return  user.getUserType()==RoleTypeEnum.SCHOOL_USER;
//        return user.getRoles().contains(RoleTypeEnum.SCHOOL_USER);
    }

    @Override
    public Boolean isCollegeManger(UserDTO user) {
        return  user.getUserType()==RoleTypeEnum.SPECIAL_ADVISER;
//        return user.getRoles().contains(RoleTypeEnum.SPECIAL_ADVISER);
    }

    @Override
    public Boolean isGradeManger(UserDTO user) {
        return  user.getUserType()==RoleTypeEnum.GRADE_ADVISER;
//        return user.getRoles().contains(RoleTypeEnum.SPECIAL_ADVISER);
    }

    @Override
    public List<Long> selectStudentsByFilters(Long collegeId, Long majorId, Long gradeId, Long classId, String content){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (collegeId!=null && collegeId>0){
            criteria.andPrimaryTeachingInstitutionIdEqualTo(collegeId);
        }
        if (majorId!=null && majorId>0){
            criteria.andSecondaryTeachingInstitutionIdEqualTo(majorId);
        }
        if (gradeId!=null && gradeId>0){
            criteria.andGradeIdEqualTo(gradeId);
        }
        if (classId!=null && classId>0){
            criteria.andClassesIdEqualTo(classId);
        }

        criteria.andUserTypeEqualTo(RoleTypeEnum.STUDENT.code);
        List<User> students = userMapper.selectByExample(example);
        List<Long> ids = new ArrayList<>();
        for (User user: students){
            ids.add(user.getId());
        }

        if (content!=null && !"".equals(content)){
            if (ids.size()==0){
                return ids;
            }
            example.clear();
            UserExample.Criteria criteria1 = example.createCriteria();
            criteria1.andNameLike("%"+content+"%").andIdIn(ids);
            UserExample.Criteria criteria2 = example.createCriteria();
            criteria2.andSnLike("%"+content+"%").andIdIn(ids);
            example.or(criteria2);
            List<User> tmp = userMapper.selectByExample(example);
            List<Long> res = new ArrayList<>();
            for (User user: tmp){
                res.add(user.getId());
            }
            return res;
        }else {
            return ids;
        }
    }
}

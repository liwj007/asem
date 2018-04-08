package com.liwj.asem.dto;

import com.liwj.asem.bo.Unit;
import com.liwj.asem.enums.RoleTypeEnum;
import com.liwj.asem.enums.UserTypeEnum;
import com.liwj.asem.model.*;
import com.liwj.asem.remote.bo.College;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDTO {
    private Long id;

    private String sn;

    private RoleTypeEnum userRole;

    private String name;

    private String email;

    private String phone;

    private Integer gender;

    private String token;

    private Long collegeId;
//
//    private Major major;
//
    private String grade;
//
//    private String classes;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    private List<RoleTypeEnum> roles;

    private List<Unit> manageColleges;

    private List<String> manageGrades;

    private Long expire;

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }


    public UserDTO() {
        manageGrades = new ArrayList<>();
        manageColleges = new ArrayList<>();
        roles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public RoleTypeEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleTypeEnum userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public List<RoleTypeEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleTypeEnum> roles) {
        this.roles = roles;
    }

    public List<Unit> getManageColleges() {
        return manageColleges;
    }

    public List<Long> getManageCollegeIDs() {
        List<Long> res = new ArrayList<>();
        for (Unit unit: manageColleges){
            res.add(unit.getId());
        }
        return res;
    }

    public void setManageColleges(List<Unit> manageColleges) {
        this.manageColleges = manageColleges;
    }

    public List<String> getManageGrades() {
        return manageGrades;
    }

    public void setManageGrades(List<String> manageGrades) {
        this.manageGrades = manageGrades;
    }
}

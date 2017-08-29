package com.liwj.asem.dto;

import com.liwj.asem.enums.RoleTypeEnum;
import com.liwj.asem.enums.UserTypeEnum;
import com.liwj.asem.model.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDTO {
    private Long id;

    private String sn;

    private RoleTypeEnum userType;

    private String name;

    private String email;

    private String phone;

    private Integer gender;

    private String token;

    private PrimaryTeachingInstitution primaryTeachingInstitution;

    private SecondaryTeachingInstitution secondaryTeachingInstitution;

    private Grade grade;

    private Classes classes;

    private List<RoleTypeEnum> roles;

    private List<PrimaryTeachingInstitution> managePrimaryTeachingInstitutions;

    private List<Grade> manageGrades;

    private Long expire;

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public List<Long> getManageCollegeId(){
        List<Long> res = new ArrayList<>();
        for (PrimaryTeachingInstitution institution: managePrimaryTeachingInstitutions){
            res.add(institution.getId());
        }
        return res;
    }

    public List<Long> getMangeGradeId(){
        List<Long> res = new ArrayList<>();
        for (Grade grade: manageGrades){
            res.add(grade.getId());
        }
        return res;
    }

    public UserDTO() {
        manageGrades = new ArrayList<>();
        managePrimaryTeachingInstitutions = new ArrayList<>();
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

    public RoleTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(RoleTypeEnum userType) {
        this.userType = userType;
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

    public PrimaryTeachingInstitution getPrimaryTeachingInstitution() {
        return primaryTeachingInstitution;
    }

    public void setPrimaryTeachingInstitution(PrimaryTeachingInstitution primaryTeachingInstitution) {
        this.primaryTeachingInstitution = primaryTeachingInstitution;
    }

    public SecondaryTeachingInstitution getSecondaryTeachingInstitution() {
        return secondaryTeachingInstitution;
    }

    public void setSecondaryTeachingInstitution(SecondaryTeachingInstitution secondaryTeachingInstitution) {
        this.secondaryTeachingInstitution = secondaryTeachingInstitution;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<RoleTypeEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleTypeEnum> roles) {
        this.roles = roles;
    }

    public List<PrimaryTeachingInstitution> getManagePrimaryTeachingInstitutions() {
        return managePrimaryTeachingInstitutions;
    }

    public void setManagePrimaryTeachingInstitutions(List<PrimaryTeachingInstitution> managePrimaryTeachingInstitutions) {
        this.managePrimaryTeachingInstitutions = managePrimaryTeachingInstitutions;
    }

    public List<Grade> getManageGrades() {
        return manageGrades;
    }

    public void setManageGrades(List<Grade> manageGrades) {
        this.manageGrades = manageGrades;
    }
}

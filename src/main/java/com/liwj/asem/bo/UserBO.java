package com.liwj.asem.bo;

import com.liwj.asem.model.Grade;
import com.liwj.asem.model.PrimaryTeachingInstitution;

import java.util.List;

public class UserBO {
    private String name;
    private String token;
    private String userType;

    private String userTypeName;

    private String mobile;
    private String email;
    private Long id;

    private List<PrimaryTeachingInstitution> managePrimaryTeachingInstitutions;
    private List<Grade> manageGrades;

    public List<Grade> getManageGrades() {
        return manageGrades;
    }

    public void setManageGrades(List<Grade> manageGrades) {
        this.manageGrades = manageGrades;
    }

    public List<PrimaryTeachingInstitution> getManagePrimaryTeachingInstitutions() {
        return managePrimaryTeachingInstitutions;
    }

    public void setManagePrimaryTeachingInstitutions(List<PrimaryTeachingInstitution> managePrimaryTeachingInstitutions) {
        this.managePrimaryTeachingInstitutions = managePrimaryTeachingInstitutions;
    }

    public UserBO() {
    }

    public UserBO(String name, String token, String userTypeName) {
        this.name = name;
        this.token = token;
        this.userType=userTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

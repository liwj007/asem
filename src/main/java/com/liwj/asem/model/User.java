package com.liwj.asem.model;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;

    private String username;

    private Long collegeId;

    private Long gradeId;

    private String studentNumber;

    private String token;

    private Integer userType;

    private String password;

    private Long majorId;

    private Long classId;

    private String name;

    private Long manageCollegeId;

    private Long manageGradeId;

    private String mobile;

    private String email;

    private String apiToken;

    private Long expire;

    private static final long serialVersionUID = 1L;

    public User(Long id, String username, Long collegeId, Long gradeId, String studentNumber, String token, Integer userType, String password, Long majorId, Long classId, String name, Long manageCollegeId, Long manageGradeId, String mobile, String email, String apiToken, Long expire) {
        this.id = id;
        this.username = username;
        this.collegeId = collegeId;
        this.gradeId = gradeId;
        this.studentNumber = studentNumber;
        this.token = token;
        this.userType = userType;
        this.password = password;
        this.majorId = majorId;
        this.classId = classId;
        this.name = name;
        this.manageCollegeId = manageCollegeId;
        this.manageGradeId = manageGradeId;
        this.mobile = mobile;
        this.email = email;
        this.apiToken = apiToken;
        this.expire = expire;
    }

    public User() {
        super();
    }

    public User(String userName, String password, String name, String mobile, String email, int userType) {
        this.username=userName;
        this.password=password;
        this.name = name;
        this.mobile=mobile;
        this.email=email;
        this.userType=userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getManageCollegeId() {
        return manageCollegeId;
    }

    public void setManageCollegeId(Long manageCollegeId) {
        this.manageCollegeId = manageCollegeId;
    }

    public Long getManageGradeId() {
        return manageGradeId;
    }

    public void setManageGradeId(Long manageGradeId) {
        this.manageGradeId = manageGradeId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken == null ? null : apiToken.trim();
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getStudentNumber() == null ? other.getStudentNumber() == null : this.getStudentNumber().equals(other.getStudentNumber()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getManageCollegeId() == null ? other.getManageCollegeId() == null : this.getManageCollegeId().equals(other.getManageCollegeId()))
            && (this.getManageGradeId() == null ? other.getManageGradeId() == null : this.getManageGradeId().equals(other.getManageGradeId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getApiToken() == null ? other.getApiToken() == null : this.getApiToken().equals(other.getApiToken()))
            && (this.getExpire() == null ? other.getExpire() == null : this.getExpire().equals(other.getExpire()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getStudentNumber() == null) ? 0 : getStudentNumber().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getManageCollegeId() == null) ? 0 : getManageCollegeId().hashCode());
        result = prime * result + ((getManageGradeId() == null) ? 0 : getManageGradeId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getApiToken() == null) ? 0 : getApiToken().hashCode());
        result = prime * result + ((getExpire() == null) ? 0 : getExpire().hashCode());
        return result;
    }
}
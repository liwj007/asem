package com.liwj.asem.model;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;

    private String sn;

    private String password;

    private Integer userType;

    private String name;

    private String email;

    private String phone;

    private Integer gender;

    private String token;

    private Long primaryTeachingInstitutionId;

    private Long secondaryTeachingInstitutionId;

    private Long gradeId;

    private Long classesId;

    private Long expire;

    private static final long serialVersionUID = 1L;

    public User(Long id, String sn, String password, Integer userType, String name, String email, String phone, Integer gender, String token, Long primaryTeachingInstitutionId, Long secondaryTeachingInstitutionId, Long gradeId, Long classesId, Long expire) {
        this.id = id;
        this.sn = sn;
        this.password = password;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.token = token;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.secondaryTeachingInstitutionId = secondaryTeachingInstitutionId;
        this.gradeId = gradeId;
        this.classesId = classesId;
        this.expire = expire;
    }

    public User() {
        super();
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
        this.sn = sn == null ? null : sn.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
        this.token = token == null ? null : token.trim();
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Long getSecondaryTeachingInstitutionId() {
        return secondaryTeachingInstitutionId;
    }

    public void setSecondaryTeachingInstitutionId(Long secondaryTeachingInstitutionId) {
        this.secondaryTeachingInstitutionId = secondaryTeachingInstitutionId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
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
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getSecondaryTeachingInstitutionId() == null ? other.getSecondaryTeachingInstitutionId() == null : this.getSecondaryTeachingInstitutionId().equals(other.getSecondaryTeachingInstitutionId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getClassesId() == null ? other.getClassesId() == null : this.getClassesId().equals(other.getClassesId()))
            && (this.getExpire() == null ? other.getExpire() == null : this.getExpire().equals(other.getExpire()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getSecondaryTeachingInstitutionId() == null) ? 0 : getSecondaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getClassesId() == null) ? 0 : getClassesId().hashCode());
        result = prime * result + ((getExpire() == null) ? 0 : getExpire().hashCode());
        return result;
    }
}
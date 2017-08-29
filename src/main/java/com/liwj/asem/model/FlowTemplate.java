package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class FlowTemplate implements Serializable {
    private Long id;

    private String name;

    private Integer flowType;

    private Long createUserId;

    private Date createDate;

    private Long modifyUserId;

    private Date modifyDate;

    private Integer version;

    private Long primaryTeachingInstitutionId;

    private Boolean needGradeCheck;

    private Boolean gradeInstructor;

    private Boolean gradeStudent;

    private Boolean specialInstructor;

    private Boolean collegeStudent;

    private Boolean schoolUser;

    private static final long serialVersionUID = 1L;

    public FlowTemplate(Long id, String name, Integer flowType, Long createUserId, Date createDate, Long modifyUserId, Date modifyDate, Integer version, Long primaryTeachingInstitutionId, Boolean needGradeCheck, Boolean gradeInstructor, Boolean gradeStudent, Boolean specialInstructor, Boolean collegeStudent, Boolean schoolUser) {
        this.id = id;
        this.name = name;
        this.flowType = flowType;
        this.createUserId = createUserId;
        this.createDate = createDate;
        this.modifyUserId = modifyUserId;
        this.modifyDate = modifyDate;
        this.version = version;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.needGradeCheck = needGradeCheck;
        this.gradeInstructor = gradeInstructor;
        this.gradeStudent = gradeStudent;
        this.specialInstructor = specialInstructor;
        this.collegeStudent = collegeStudent;
        this.schoolUser = schoolUser;
    }

    public FlowTemplate() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFlowType() {
        return flowType;
    }

    public void setFlowType(Integer flowType) {
        this.flowType = flowType;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Boolean getNeedGradeCheck() {
        return needGradeCheck;
    }

    public void setNeedGradeCheck(Boolean needGradeCheck) {
        this.needGradeCheck = needGradeCheck;
    }

    public Boolean getGradeInstructor() {
        return gradeInstructor;
    }

    public void setGradeInstructor(Boolean gradeInstructor) {
        this.gradeInstructor = gradeInstructor;
    }

    public Boolean getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(Boolean gradeStudent) {
        this.gradeStudent = gradeStudent;
    }

    public Boolean getSpecialInstructor() {
        return specialInstructor;
    }

    public void setSpecialInstructor(Boolean specialInstructor) {
        this.specialInstructor = specialInstructor;
    }

    public Boolean getCollegeStudent() {
        return collegeStudent;
    }

    public void setCollegeStudent(Boolean collegeStudent) {
        this.collegeStudent = collegeStudent;
    }

    public Boolean getSchoolUser() {
        return schoolUser;
    }

    public void setSchoolUser(Boolean schoolUser) {
        this.schoolUser = schoolUser;
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
        FlowTemplate other = (FlowTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFlowType() == null ? other.getFlowType() == null : this.getFlowType().equals(other.getFlowType()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifyUserId() == null ? other.getModifyUserId() == null : this.getModifyUserId().equals(other.getModifyUserId()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getNeedGradeCheck() == null ? other.getNeedGradeCheck() == null : this.getNeedGradeCheck().equals(other.getNeedGradeCheck()))
            && (this.getGradeInstructor() == null ? other.getGradeInstructor() == null : this.getGradeInstructor().equals(other.getGradeInstructor()))
            && (this.getGradeStudent() == null ? other.getGradeStudent() == null : this.getGradeStudent().equals(other.getGradeStudent()))
            && (this.getSpecialInstructor() == null ? other.getSpecialInstructor() == null : this.getSpecialInstructor().equals(other.getSpecialInstructor()))
            && (this.getCollegeStudent() == null ? other.getCollegeStudent() == null : this.getCollegeStudent().equals(other.getCollegeStudent()))
            && (this.getSchoolUser() == null ? other.getSchoolUser() == null : this.getSchoolUser().equals(other.getSchoolUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFlowType() == null) ? 0 : getFlowType().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifyUserId() == null) ? 0 : getModifyUserId().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getNeedGradeCheck() == null) ? 0 : getNeedGradeCheck().hashCode());
        result = prime * result + ((getGradeInstructor() == null) ? 0 : getGradeInstructor().hashCode());
        result = prime * result + ((getGradeStudent() == null) ? 0 : getGradeStudent().hashCode());
        result = prime * result + ((getSpecialInstructor() == null) ? 0 : getSpecialInstructor().hashCode());
        result = prime * result + ((getCollegeStudent() == null) ? 0 : getCollegeStudent().hashCode());
        result = prime * result + ((getSchoolUser() == null) ? 0 : getSchoolUser().hashCode());
        return result;
    }
}
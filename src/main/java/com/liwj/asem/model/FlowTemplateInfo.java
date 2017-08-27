package com.liwj.asem.model;

import java.io.Serializable;

public class FlowTemplateInfo implements Serializable {
    private Long id;

    private Boolean needGradeCheck;

    private Boolean gradeInstructor;

    private Boolean gradeStudent;

    private Boolean specialInstructor;

    private Boolean collegeStudent;

    private Boolean schoolUser;

    private Long flowTemplateId;

    private static final long serialVersionUID = 1L;

    public FlowTemplateInfo(Long id, Boolean needGradeCheck, Boolean gradeInstructor, Boolean gradeStudent, Boolean specialInstructor, Boolean collegeStudent, Boolean schoolUser, Long flowTemplateId) {
        this.id = id;
        this.needGradeCheck = needGradeCheck;
        this.gradeInstructor = gradeInstructor;
        this.gradeStudent = gradeStudent;
        this.specialInstructor = specialInstructor;
        this.collegeStudent = collegeStudent;
        this.schoolUser = schoolUser;
        this.flowTemplateId = flowTemplateId;
    }

    public FlowTemplateInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getFlowTemplateId() {
        return flowTemplateId;
    }

    public void setFlowTemplateId(Long flowTemplateId) {
        this.flowTemplateId = flowTemplateId;
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
        FlowTemplateInfo other = (FlowTemplateInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNeedGradeCheck() == null ? other.getNeedGradeCheck() == null : this.getNeedGradeCheck().equals(other.getNeedGradeCheck()))
            && (this.getGradeInstructor() == null ? other.getGradeInstructor() == null : this.getGradeInstructor().equals(other.getGradeInstructor()))
            && (this.getGradeStudent() == null ? other.getGradeStudent() == null : this.getGradeStudent().equals(other.getGradeStudent()))
            && (this.getSpecialInstructor() == null ? other.getSpecialInstructor() == null : this.getSpecialInstructor().equals(other.getSpecialInstructor()))
            && (this.getCollegeStudent() == null ? other.getCollegeStudent() == null : this.getCollegeStudent().equals(other.getCollegeStudent()))
            && (this.getSchoolUser() == null ? other.getSchoolUser() == null : this.getSchoolUser().equals(other.getSchoolUser()))
            && (this.getFlowTemplateId() == null ? other.getFlowTemplateId() == null : this.getFlowTemplateId().equals(other.getFlowTemplateId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNeedGradeCheck() == null) ? 0 : getNeedGradeCheck().hashCode());
        result = prime * result + ((getGradeInstructor() == null) ? 0 : getGradeInstructor().hashCode());
        result = prime * result + ((getGradeStudent() == null) ? 0 : getGradeStudent().hashCode());
        result = prime * result + ((getSpecialInstructor() == null) ? 0 : getSpecialInstructor().hashCode());
        result = prime * result + ((getCollegeStudent() == null) ? 0 : getCollegeStudent().hashCode());
        result = prime * result + ((getSchoolUser() == null) ? 0 : getSchoolUser().hashCode());
        result = prime * result + ((getFlowTemplateId() == null) ? 0 : getFlowTemplateId().hashCode());
        return result;
    }
}
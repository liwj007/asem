package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class Scholarship implements Serializable {
    private Long id;

    private Long flowTemplateId;

    private String requirement;

    private Integer status;

    private Date createDate;

    private Long primaryTeachingInstitutionId;

    private String scholarshipName;

    private Integer scholarshipType;

    private Integer prizeType;

    private Boolean allocationTimeStatus;

    private Boolean needGradeCheck;

    private Date studentBeginDate;

    private Date collegeEndDate;

    private static final long serialVersionUID = 1L;

    public Scholarship(Long id, Long flowTemplateId, String requirement, Integer status, Date createDate, Long primaryTeachingInstitutionId, String scholarshipName, Integer scholarshipType, Integer prizeType, Boolean allocationTimeStatus, Boolean needGradeCheck, Date studentBeginDate, Date collegeEndDate) {
        this.id = id;
        this.flowTemplateId = flowTemplateId;
        this.requirement = requirement;
        this.status = status;
        this.createDate = createDate;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.scholarshipName = scholarshipName;
        this.scholarshipType = scholarshipType;
        this.prizeType = prizeType;
        this.allocationTimeStatus = allocationTimeStatus;
        this.needGradeCheck = needGradeCheck;
        this.studentBeginDate = studentBeginDate;
        this.collegeEndDate = collegeEndDate;
    }

    public Scholarship() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlowTemplateId() {
        return flowTemplateId;
    }

    public void setFlowTemplateId(Long flowTemplateId) {
        this.flowTemplateId = flowTemplateId;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName == null ? null : scholarshipName.trim();
    }

    public Integer getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(Integer scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public Integer getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(Integer prizeType) {
        this.prizeType = prizeType;
    }

    public Boolean getAllocationTimeStatus() {
        return allocationTimeStatus;
    }

    public void setAllocationTimeStatus(Boolean allocationTimeStatus) {
        this.allocationTimeStatus = allocationTimeStatus;
    }

    public Boolean getNeedGradeCheck() {
        return needGradeCheck;
    }

    public void setNeedGradeCheck(Boolean needGradeCheck) {
        this.needGradeCheck = needGradeCheck;
    }

    public Date getStudentBeginDate() {
        return studentBeginDate;
    }

    public void setStudentBeginDate(Date studentBeginDate) {
        this.studentBeginDate = studentBeginDate;
    }

    public Date getCollegeEndDate() {
        return collegeEndDate;
    }

    public void setCollegeEndDate(Date collegeEndDate) {
        this.collegeEndDate = collegeEndDate;
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
        Scholarship other = (Scholarship) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlowTemplateId() == null ? other.getFlowTemplateId() == null : this.getFlowTemplateId().equals(other.getFlowTemplateId()))
            && (this.getRequirement() == null ? other.getRequirement() == null : this.getRequirement().equals(other.getRequirement()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getScholarshipName() == null ? other.getScholarshipName() == null : this.getScholarshipName().equals(other.getScholarshipName()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getPrizeType() == null ? other.getPrizeType() == null : this.getPrizeType().equals(other.getPrizeType()))
            && (this.getAllocationTimeStatus() == null ? other.getAllocationTimeStatus() == null : this.getAllocationTimeStatus().equals(other.getAllocationTimeStatus()))
            && (this.getNeedGradeCheck() == null ? other.getNeedGradeCheck() == null : this.getNeedGradeCheck().equals(other.getNeedGradeCheck()))
            && (this.getStudentBeginDate() == null ? other.getStudentBeginDate() == null : this.getStudentBeginDate().equals(other.getStudentBeginDate()))
            && (this.getCollegeEndDate() == null ? other.getCollegeEndDate() == null : this.getCollegeEndDate().equals(other.getCollegeEndDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlowTemplateId() == null) ? 0 : getFlowTemplateId().hashCode());
        result = prime * result + ((getRequirement() == null) ? 0 : getRequirement().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getScholarshipName() == null) ? 0 : getScholarshipName().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getPrizeType() == null) ? 0 : getPrizeType().hashCode());
        result = prime * result + ((getAllocationTimeStatus() == null) ? 0 : getAllocationTimeStatus().hashCode());
        result = prime * result + ((getNeedGradeCheck() == null) ? 0 : getNeedGradeCheck().hashCode());
        result = prime * result + ((getStudentBeginDate() == null) ? 0 : getStudentBeginDate().hashCode());
        result = prime * result + ((getCollegeEndDate() == null) ? 0 : getCollegeEndDate().hashCode());
        return result;
    }
}
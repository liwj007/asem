package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class CollegePrize implements Serializable {
    private Long id;

    private Long primaryTeachingInstitutionId;

    private Integer number;

    private Integer restNumber;

    private Long prizeInfoId;

    private Long scholarshipId;

    private Integer scholarshipType;

    private Integer status;

    private Integer allocationRule;

    private Integer allocationMethod;

    private Boolean allocationNumberStatus;

    private Long schoolPrizeId;

    private Boolean submitStatus;

    private Boolean applyStatus;

    private Date createDate;

    private Date allocationDate;

    private static final long serialVersionUID = 1L;

    public CollegePrize(Long id, Long primaryTeachingInstitutionId, Integer number, Integer restNumber, Long prizeInfoId, Long scholarshipId, Integer scholarshipType, Integer status, Integer allocationRule, Integer allocationMethod, Boolean allocationNumberStatus, Long schoolPrizeId, Boolean submitStatus, Boolean applyStatus, Date createDate, Date allocationDate) {
        this.id = id;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.number = number;
        this.restNumber = restNumber;
        this.prizeInfoId = prizeInfoId;
        this.scholarshipId = scholarshipId;
        this.scholarshipType = scholarshipType;
        this.status = status;
        this.allocationRule = allocationRule;
        this.allocationMethod = allocationMethod;
        this.allocationNumberStatus = allocationNumberStatus;
        this.schoolPrizeId = schoolPrizeId;
        this.submitStatus = submitStatus;
        this.applyStatus = applyStatus;
        this.createDate = createDate;
        this.allocationDate = allocationDate;
    }

    public CollegePrize() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(Integer restNumber) {
        this.restNumber = restNumber;
    }

    public Long getPrizeInfoId() {
        return prizeInfoId;
    }

    public void setPrizeInfoId(Long prizeInfoId) {
        this.prizeInfoId = prizeInfoId;
    }

    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Integer getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(Integer scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAllocationRule() {
        return allocationRule;
    }

    public void setAllocationRule(Integer allocationRule) {
        this.allocationRule = allocationRule;
    }

    public Integer getAllocationMethod() {
        return allocationMethod;
    }

    public void setAllocationMethod(Integer allocationMethod) {
        this.allocationMethod = allocationMethod;
    }

    public Boolean getAllocationNumberStatus() {
        return allocationNumberStatus;
    }

    public void setAllocationNumberStatus(Boolean allocationNumberStatus) {
        this.allocationNumberStatus = allocationNumberStatus;
    }

    public Long getSchoolPrizeId() {
        return schoolPrizeId;
    }

    public void setSchoolPrizeId(Long schoolPrizeId) {
        this.schoolPrizeId = schoolPrizeId;
    }

    public Boolean getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(Boolean submitStatus) {
        this.submitStatus = submitStatus;
    }

    public Boolean getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Boolean applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
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
        CollegePrize other = (CollegePrize) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getRestNumber() == null ? other.getRestNumber() == null : this.getRestNumber().equals(other.getRestNumber()))
            && (this.getPrizeInfoId() == null ? other.getPrizeInfoId() == null : this.getPrizeInfoId().equals(other.getPrizeInfoId()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAllocationRule() == null ? other.getAllocationRule() == null : this.getAllocationRule().equals(other.getAllocationRule()))
            && (this.getAllocationMethod() == null ? other.getAllocationMethod() == null : this.getAllocationMethod().equals(other.getAllocationMethod()))
            && (this.getAllocationNumberStatus() == null ? other.getAllocationNumberStatus() == null : this.getAllocationNumberStatus().equals(other.getAllocationNumberStatus()))
            && (this.getSchoolPrizeId() == null ? other.getSchoolPrizeId() == null : this.getSchoolPrizeId().equals(other.getSchoolPrizeId()))
            && (this.getSubmitStatus() == null ? other.getSubmitStatus() == null : this.getSubmitStatus().equals(other.getSubmitStatus()))
            && (this.getApplyStatus() == null ? other.getApplyStatus() == null : this.getApplyStatus().equals(other.getApplyStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getAllocationDate() == null ? other.getAllocationDate() == null : this.getAllocationDate().equals(other.getAllocationDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getRestNumber() == null) ? 0 : getRestNumber().hashCode());
        result = prime * result + ((getPrizeInfoId() == null) ? 0 : getPrizeInfoId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAllocationRule() == null) ? 0 : getAllocationRule().hashCode());
        result = prime * result + ((getAllocationMethod() == null) ? 0 : getAllocationMethod().hashCode());
        result = prime * result + ((getAllocationNumberStatus() == null) ? 0 : getAllocationNumberStatus().hashCode());
        result = prime * result + ((getSchoolPrizeId() == null) ? 0 : getSchoolPrizeId().hashCode());
        result = prime * result + ((getSubmitStatus() == null) ? 0 : getSubmitStatus().hashCode());
        result = prime * result + ((getApplyStatus() == null) ? 0 : getApplyStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getAllocationDate() == null) ? 0 : getAllocationDate().hashCode());
        return result;
    }
}
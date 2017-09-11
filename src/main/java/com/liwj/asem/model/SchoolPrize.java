package com.liwj.asem.model;

import java.io.Serializable;

public class SchoolPrize implements Serializable {
    private Long id;

    private Integer status;

    private Integer number;

    private Long scholarshipId;

    private Integer scholarshipType;

    private Integer restNumber;

    private Integer allocationRule;

    private Integer allocationMethod;

    private Boolean allocationNumberStatus;

    private Integer checkStatus;

    private Long prizeInfoId;

    private Boolean submitStatus;

    private static final long serialVersionUID = 1L;

    public SchoolPrize(Long id, Integer status, Integer number, Long scholarshipId, Integer scholarshipType, Integer restNumber, Integer allocationRule, Integer allocationMethod, Boolean allocationNumberStatus, Integer checkStatus, Long prizeInfoId, Boolean submitStatus) {
        this.id = id;
        this.status = status;
        this.number = number;
        this.scholarshipId = scholarshipId;
        this.scholarshipType = scholarshipType;
        this.restNumber = restNumber;
        this.allocationRule = allocationRule;
        this.allocationMethod = allocationMethod;
        this.allocationNumberStatus = allocationNumberStatus;
        this.checkStatus = checkStatus;
        this.prizeInfoId = prizeInfoId;
        this.submitStatus = submitStatus;
    }

    public SchoolPrize() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Integer getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(Integer restNumber) {
        this.restNumber = restNumber;
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

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Long getPrizeInfoId() {
        return prizeInfoId;
    }

    public void setPrizeInfoId(Long prizeInfoId) {
        this.prizeInfoId = prizeInfoId;
    }

    public Boolean getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(Boolean submitStatus) {
        this.submitStatus = submitStatus;
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
        SchoolPrize other = (SchoolPrize) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getRestNumber() == null ? other.getRestNumber() == null : this.getRestNumber().equals(other.getRestNumber()))
            && (this.getAllocationRule() == null ? other.getAllocationRule() == null : this.getAllocationRule().equals(other.getAllocationRule()))
            && (this.getAllocationMethod() == null ? other.getAllocationMethod() == null : this.getAllocationMethod().equals(other.getAllocationMethod()))
            && (this.getAllocationNumberStatus() == null ? other.getAllocationNumberStatus() == null : this.getAllocationNumberStatus().equals(other.getAllocationNumberStatus()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getPrizeInfoId() == null ? other.getPrizeInfoId() == null : this.getPrizeInfoId().equals(other.getPrizeInfoId()))
            && (this.getSubmitStatus() == null ? other.getSubmitStatus() == null : this.getSubmitStatus().equals(other.getSubmitStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getRestNumber() == null) ? 0 : getRestNumber().hashCode());
        result = prime * result + ((getAllocationRule() == null) ? 0 : getAllocationRule().hashCode());
        result = prime * result + ((getAllocationMethod() == null) ? 0 : getAllocationMethod().hashCode());
        result = prime * result + ((getAllocationNumberStatus() == null) ? 0 : getAllocationNumberStatus().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getPrizeInfoId() == null) ? 0 : getPrizeInfoId().hashCode());
        result = prime * result + ((getSubmitStatus() == null) ? 0 : getSubmitStatus().hashCode());
        return result;
    }
}
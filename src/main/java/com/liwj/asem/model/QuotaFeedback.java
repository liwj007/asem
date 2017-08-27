package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class QuotaFeedback implements Serializable {
    private Long id;

    private Long unitId;

    private Long userId;

    private Date applyDate;

    private Long scholarshipId;

    private Long prizeId;

    private Integer allocationNumber;

    private Integer applyNumber;

    private Integer status;

    private Integer applyType;

    private static final long serialVersionUID = 1L;

    public QuotaFeedback(Long id, Long unitId, Long userId, Date applyDate, Long scholarshipId, Long prizeId, Integer allocationNumber, Integer applyNumber, Integer status, Integer applyType) {
        this.id = id;
        this.unitId = unitId;
        this.userId = userId;
        this.applyDate = applyDate;
        this.scholarshipId = scholarshipId;
        this.prizeId = prizeId;
        this.allocationNumber = allocationNumber;
        this.applyNumber = applyNumber;
        this.status = status;
        this.applyType = applyType;
    }

    public QuotaFeedback() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getAllocationNumber() {
        return allocationNumber;
    }

    public void setAllocationNumber(Integer allocationNumber) {
        this.allocationNumber = allocationNumber;
    }

    public Integer getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(Integer applyNumber) {
        this.applyNumber = applyNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
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
        QuotaFeedback other = (QuotaFeedback) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getAllocationNumber() == null ? other.getAllocationNumber() == null : this.getAllocationNumber().equals(other.getAllocationNumber()))
            && (this.getApplyNumber() == null ? other.getApplyNumber() == null : this.getApplyNumber().equals(other.getApplyNumber()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getAllocationNumber() == null) ? 0 : getAllocationNumber().hashCode());
        result = prime * result + ((getApplyNumber() == null) ? 0 : getApplyNumber().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        return result;
    }
}
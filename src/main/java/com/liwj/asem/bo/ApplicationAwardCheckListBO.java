package com.liwj.asem.bo;


import java.util.Date;

public class ApplicationAwardCheckListBO {
    private String scholarshipName;
    private String prizeName;
    private Long prizeId;

    private Long applyNumber;
    private Long availableNumber;
    private Long usedNumber;
    private Date endDate;

    private Long prizeInfoId;

    private String unitName;
    private Long unitId;

    private Boolean submitStatus;
    private Boolean applyStatus;

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Long getPrizeInfoId() {
        return prizeInfoId;
    }

    public void setPrizeInfoId(Long prizeInfoId) {
        this.prizeInfoId = prizeInfoId;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public Long getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(Long applyNumber) {
        this.applyNumber = applyNumber;
    }

    public Long getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(Long availableNumber) {
        this.availableNumber = availableNumber;
    }

    public Long getUsedNumber() {
        return usedNumber;
    }

    public void setUsedNumber(Long usedNumber) {
        this.usedNumber = usedNumber;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

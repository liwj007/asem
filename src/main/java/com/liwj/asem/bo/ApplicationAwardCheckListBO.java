package com.liwj.asem.bo;

import java.util.Date;

public class ApplicationAwardCheckListBO {
    private String scholarshipName;
    private String prizeName;
    private Long prizeId;

    private Long applyNumber;
    private Long avaibleNumber;
    private Long usedNumber;
    private Date endDate;

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

    public Long getAvaibleNumber() {
        return avaibleNumber;
    }

    public void setAvaibleNumber(Long avaibleNumber) {
        this.avaibleNumber = avaibleNumber;
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

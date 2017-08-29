package com.liwj.asem.bo;

import com.liwj.asem.enums.ApplicationFileStatusEnum;
import com.liwj.asem.enums.ApplicationPrizeStatusEnum;
import com.liwj.asem.enums.ApplicationStatusEnum;

import java.util.Date;

public class PrizeForApplicationBO {
    private String scholarshipName;
    private String prizeName;
    private Long prizeId;
    private Date endDate;
    private ApplicationStatusEnum status;
    private ApplicationFileStatusEnum fileStatus;
    private ApplicationPrizeStatusEnum prizeStatus;

    private Long applicationId;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ApplicationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatusEnum status) {
        this.status = status;
    }

    public ApplicationFileStatusEnum getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(ApplicationFileStatusEnum fileStatus) {
        this.fileStatus = fileStatus;
    }

    public ApplicationPrizeStatusEnum getPrizeStatus() {
        return prizeStatus;
    }

    public void setPrizeStatus(ApplicationPrizeStatusEnum prizeStatus) {
        this.prizeStatus = prizeStatus;
    }
}

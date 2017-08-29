package com.liwj.asem.bo;

public class ApplicationFileCheckListBO {
    private String scholarshipName;
    private String prizeName;
    private Long prizeId;

    private Long applyNumber;
    private Long rejectNumber;
    private Long reSubmitNumber;

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

    public Long getRejectNumber() {
        return rejectNumber;
    }

    public void setRejectNumber(Long rejectNumber) {
        this.rejectNumber = rejectNumber;
    }

    public Long getReSubmitNumber() {
        return reSubmitNumber;
    }

    public void setReSubmitNumber(Long reSubmitNumber) {
        this.reSubmitNumber = reSubmitNumber;
    }
}

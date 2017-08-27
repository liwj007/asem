package com.liwj.asem.bo;

import java.util.Date;

public class PrizeForListBO {
    private Long id;
    private String scholarshipName;
    private String prizeName;
    private String scholarshipTypeName;
    private Integer number;
    private Double money;

    private Long scholarshipId;//用来做详情和删除用
    private String scholarshipType;

    private Boolean allocationStatus;
    private Boolean timeStatus;
    private String status;

    private Integer restNumber;
    private Integer availableNumber;
    private Integer usedNumber;

    public String getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getScholarshipTypeName() {
        return scholarshipTypeName;
    }

    public void setScholarshipTypeName(String scholarshipTypeName) {
        this.scholarshipTypeName = scholarshipTypeName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Boolean getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(Boolean allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public Boolean getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(Boolean timeStatus) {
        this.timeStatus = timeStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(Integer restNumber) {
        this.restNumber = restNumber;
    }

    public Integer getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(Integer availableNumber) {
        this.availableNumber = availableNumber;
    }

    public Integer getUsedNumber() {
        return usedNumber;
    }

    public void setUsedNumber(Integer usedNumber) {
        this.usedNumber = usedNumber;
    }


}

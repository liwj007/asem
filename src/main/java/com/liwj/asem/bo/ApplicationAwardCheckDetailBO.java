package com.liwj.asem.bo;

import com.liwj.asem.enums.ApplicationFileStatusEnum;
import com.liwj.asem.enums.ApplicationPrizeStatusEnum;
import com.liwj.asem.model.Application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationAwardCheckDetailBO {
    private String name;
    private String Sn;
    private String majorName;
    private String gradeName;
    private String className;
    private ApplicationFileStatusEnum fileStatus;
    private Long applicationId;
    private ApplicationPrizeStatusEnum prizeStatus;
    private List<String> records;
    private Long stepId;

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
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

    public List<String> getRecords() {
        return records;
    }

    public void setRecords(List<String> records) {
        this.records = records;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return Sn;
    }

    public void setSn(String sn) {
        this.Sn = sn;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}

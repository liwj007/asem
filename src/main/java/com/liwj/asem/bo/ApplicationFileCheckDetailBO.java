package com.liwj.asem.bo;

import com.liwj.asem.enums.ApplicationFileStatusEnum;

public class ApplicationFileCheckDetailBO {
    private String name;
    private String Sn;
    private String majorName;
    private String gradeName;
    private String className;
    private ApplicationFileStatusEnum status;
    private Long applicationId;

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

    public ApplicationFileStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ApplicationFileStatusEnum status) {
        this.status = status;
    }
}

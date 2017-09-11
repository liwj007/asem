package com.liwj.asem.bo;

import java.util.Date;
import java.util.List;

public class PublicityApplyBO {
    private List<Long> scholarshipIds;
    private Date beginDate;
    private Date endDate;
    private Boolean scholarshipName;
    private Boolean prizeName;
    private Boolean sn;
    private Boolean name;
    private Boolean classes;
    private Boolean grade;
    private Boolean major;
    private Boolean college;
    private Boolean prizeNumber;
    private Boolean files;
    private Long unitId;

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public List<Long> getScholarshipIds() {
        return scholarshipIds;
    }

    public void setScholarshipIds(List<Long> scholarshipIds) {
        this.scholarshipIds = scholarshipIds;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(Boolean scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public Boolean getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(Boolean prizeName) {
        this.prizeName = prizeName;
    }

    public Boolean getSn() {
        return sn;
    }

    public void setSn(Boolean sn) {
        this.sn = sn;
    }

    public Boolean getName() {
        return name;
    }

    public void setName(Boolean name) {
        this.name = name;
    }

    public Boolean getClasses() {
        return classes;
    }

    public void setClasses(Boolean classes) {
        this.classes = classes;
    }

    public Boolean getGrade() {
        return grade;
    }

    public void setGrade(Boolean grade) {
        this.grade = grade;
    }

    public Boolean getMajor() {
        return major;
    }

    public void setMajor(Boolean major) {
        this.major = major;
    }

    public Boolean getCollege() {
        return college;
    }

    public void setCollege(Boolean college) {
        this.college = college;
    }

    public Boolean getPrizeNumber() {
        return prizeNumber;
    }

    public void setPrizeNumber(Boolean prizeNumber) {
        this.prizeNumber = prizeNumber;
    }

    public Boolean getFiles() {
        return files;
    }

    public void setFiles(Boolean files) {
        this.files = files;
    }
}

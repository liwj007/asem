package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class Publicity implements Serializable {
    private Long id;

    private Long scholarshipId;

    private Integer scholarshipType;

    private Boolean scholarshipName;

    private Boolean prizeName;

    private Boolean needName;

    private Boolean needSn;

    private Boolean needClasses;

    private Boolean needGrade;

    private Boolean needMajor;

    private Boolean needCollege;

    private Boolean needPrizeNumber;

    private Boolean needFiles;

    private Date beginDate;

    private Date endDate;

    private Long primaryTeachingInstitutionId;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Publicity(Long id, Long scholarshipId, Integer scholarshipType, Boolean scholarshipName, Boolean prizeName, Boolean needName, Boolean needSn, Boolean needClasses, Boolean needGrade, Boolean needMajor, Boolean needCollege, Boolean needPrizeNumber, Boolean needFiles, Date beginDate, Date endDate, Long primaryTeachingInstitutionId, Integer status) {
        this.id = id;
        this.scholarshipId = scholarshipId;
        this.scholarshipType = scholarshipType;
        this.scholarshipName = scholarshipName;
        this.prizeName = prizeName;
        this.needName = needName;
        this.needSn = needSn;
        this.needClasses = needClasses;
        this.needGrade = needGrade;
        this.needMajor = needMajor;
        this.needCollege = needCollege;
        this.needPrizeNumber = needPrizeNumber;
        this.needFiles = needFiles;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.status = status;
    }

    public Publicity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getNeedName() {
        return needName;
    }

    public void setNeedName(Boolean needName) {
        this.needName = needName;
    }

    public Boolean getNeedSn() {
        return needSn;
    }

    public void setNeedSn(Boolean needSn) {
        this.needSn = needSn;
    }

    public Boolean getNeedClasses() {
        return needClasses;
    }

    public void setNeedClasses(Boolean needClasses) {
        this.needClasses = needClasses;
    }

    public Boolean getNeedGrade() {
        return needGrade;
    }

    public void setNeedGrade(Boolean needGrade) {
        this.needGrade = needGrade;
    }

    public Boolean getNeedMajor() {
        return needMajor;
    }

    public void setNeedMajor(Boolean needMajor) {
        this.needMajor = needMajor;
    }

    public Boolean getNeedCollege() {
        return needCollege;
    }

    public void setNeedCollege(Boolean needCollege) {
        this.needCollege = needCollege;
    }

    public Boolean getNeedPrizeNumber() {
        return needPrizeNumber;
    }

    public void setNeedPrizeNumber(Boolean needPrizeNumber) {
        this.needPrizeNumber = needPrizeNumber;
    }

    public Boolean getNeedFiles() {
        return needFiles;
    }

    public void setNeedFiles(Boolean needFiles) {
        this.needFiles = needFiles;
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

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        Publicity other = (Publicity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getScholarshipName() == null ? other.getScholarshipName() == null : this.getScholarshipName().equals(other.getScholarshipName()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getNeedName() == null ? other.getNeedName() == null : this.getNeedName().equals(other.getNeedName()))
            && (this.getNeedSn() == null ? other.getNeedSn() == null : this.getNeedSn().equals(other.getNeedSn()))
            && (this.getNeedClasses() == null ? other.getNeedClasses() == null : this.getNeedClasses().equals(other.getNeedClasses()))
            && (this.getNeedGrade() == null ? other.getNeedGrade() == null : this.getNeedGrade().equals(other.getNeedGrade()))
            && (this.getNeedMajor() == null ? other.getNeedMajor() == null : this.getNeedMajor().equals(other.getNeedMajor()))
            && (this.getNeedCollege() == null ? other.getNeedCollege() == null : this.getNeedCollege().equals(other.getNeedCollege()))
            && (this.getNeedPrizeNumber() == null ? other.getNeedPrizeNumber() == null : this.getNeedPrizeNumber().equals(other.getNeedPrizeNumber()))
            && (this.getNeedFiles() == null ? other.getNeedFiles() == null : this.getNeedFiles().equals(other.getNeedFiles()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getScholarshipName() == null) ? 0 : getScholarshipName().hashCode());
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getNeedName() == null) ? 0 : getNeedName().hashCode());
        result = prime * result + ((getNeedSn() == null) ? 0 : getNeedSn().hashCode());
        result = prime * result + ((getNeedClasses() == null) ? 0 : getNeedClasses().hashCode());
        result = prime * result + ((getNeedGrade() == null) ? 0 : getNeedGrade().hashCode());
        result = prime * result + ((getNeedMajor() == null) ? 0 : getNeedMajor().hashCode());
        result = prime * result + ((getNeedCollege() == null) ? 0 : getNeedCollege().hashCode());
        result = prime * result + ((getNeedPrizeNumber() == null) ? 0 : getNeedPrizeNumber().hashCode());
        result = prime * result + ((getNeedFiles() == null) ? 0 : getNeedFiles().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
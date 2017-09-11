package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    private Long id;

    private Long prizeId;

    private Long scholarshipId;

    private Integer status;

    private Integer fileStatus;

    private Integer prizeStatus;

    private Long userId;

    private Date createDate;

    private Long primaryTeachingInstitutionId;

    private Long gradeId;

    private Long prizeInfoId;

    private Boolean collegePublicity;

    private Boolean schoolPublicity;

    private String evaluation;

    private static final long serialVersionUID = 1L;

    public Application(Long id, Long prizeId, Long scholarshipId, Integer status, Integer fileStatus, Integer prizeStatus, Long userId, Date createDate, Long primaryTeachingInstitutionId, Long gradeId, Long prizeInfoId, Boolean collegePublicity, Boolean schoolPublicity, String evaluation) {
        this.id = id;
        this.prizeId = prizeId;
        this.scholarshipId = scholarshipId;
        this.status = status;
        this.fileStatus = fileStatus;
        this.prizeStatus = prizeStatus;
        this.userId = userId;
        this.createDate = createDate;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.gradeId = gradeId;
        this.prizeInfoId = prizeInfoId;
        this.collegePublicity = collegePublicity;
        this.schoolPublicity = schoolPublicity;
        this.evaluation = evaluation;
    }

    public Application() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }

    public Integer getPrizeStatus() {
        return prizeStatus;
    }

    public void setPrizeStatus(Integer prizeStatus) {
        this.prizeStatus = prizeStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getPrizeInfoId() {
        return prizeInfoId;
    }

    public void setPrizeInfoId(Long prizeInfoId) {
        this.prizeInfoId = prizeInfoId;
    }

    public Boolean getCollegePublicity() {
        return collegePublicity;
    }

    public void setCollegePublicity(Boolean collegePublicity) {
        this.collegePublicity = collegePublicity;
    }

    public Boolean getSchoolPublicity() {
        return schoolPublicity;
    }

    public void setSchoolPublicity(Boolean schoolPublicity) {
        this.schoolPublicity = schoolPublicity;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
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
        Application other = (Application) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFileStatus() == null ? other.getFileStatus() == null : this.getFileStatus().equals(other.getFileStatus()))
            && (this.getPrizeStatus() == null ? other.getPrizeStatus() == null : this.getPrizeStatus().equals(other.getPrizeStatus()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getPrizeInfoId() == null ? other.getPrizeInfoId() == null : this.getPrizeInfoId().equals(other.getPrizeInfoId()))
            && (this.getCollegePublicity() == null ? other.getCollegePublicity() == null : this.getCollegePublicity().equals(other.getCollegePublicity()))
            && (this.getSchoolPublicity() == null ? other.getSchoolPublicity() == null : this.getSchoolPublicity().equals(other.getSchoolPublicity()))
            && (this.getEvaluation() == null ? other.getEvaluation() == null : this.getEvaluation().equals(other.getEvaluation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFileStatus() == null) ? 0 : getFileStatus().hashCode());
        result = prime * result + ((getPrizeStatus() == null) ? 0 : getPrizeStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getPrizeInfoId() == null) ? 0 : getPrizeInfoId().hashCode());
        result = prime * result + ((getCollegePublicity() == null) ? 0 : getCollegePublicity().hashCode());
        result = prime * result + ((getSchoolPublicity() == null) ? 0 : getSchoolPublicity().hashCode());
        result = prime * result + ((getEvaluation() == null) ? 0 : getEvaluation().hashCode());
        return result;
    }
}
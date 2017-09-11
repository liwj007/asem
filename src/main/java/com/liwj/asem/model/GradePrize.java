package com.liwj.asem.model;

import java.io.Serializable;

public class GradePrize implements Serializable {
    private Long id;

    private Long primaryTeachingInstitutionId;

    private Integer number;

    private Long prizeInfoId;

    private Long scholarshipId;

    private Integer scholarshipType;

    private Long gradeId;

    private Integer status;

    private Long collegePrizeId;

    private static final long serialVersionUID = 1L;

    public GradePrize(Long id, Long primaryTeachingInstitutionId, Integer number, Long prizeInfoId, Long scholarshipId, Integer scholarshipType, Long gradeId, Integer status, Long collegePrizeId) {
        this.id = id;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.number = number;
        this.prizeInfoId = prizeInfoId;
        this.scholarshipId = scholarshipId;
        this.scholarshipType = scholarshipType;
        this.gradeId = gradeId;
        this.status = status;
        this.collegePrizeId = collegePrizeId;
    }

    public GradePrize() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getPrizeInfoId() {
        return prizeInfoId;
    }

    public void setPrizeInfoId(Long prizeInfoId) {
        this.prizeInfoId = prizeInfoId;
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

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCollegePrizeId() {
        return collegePrizeId;
    }

    public void setCollegePrizeId(Long collegePrizeId) {
        this.collegePrizeId = collegePrizeId;
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
        GradePrize other = (GradePrize) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getPrizeInfoId() == null ? other.getPrizeInfoId() == null : this.getPrizeInfoId().equals(other.getPrizeInfoId()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCollegePrizeId() == null ? other.getCollegePrizeId() == null : this.getCollegePrizeId().equals(other.getCollegePrizeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getPrizeInfoId() == null) ? 0 : getPrizeInfoId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCollegePrizeId() == null) ? 0 : getCollegePrizeId().hashCode());
        return result;
    }
}
package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class CollegeTimeLimit implements Serializable {
    private Long id;

    private Long scholarshipId;

    private Long primaryTeachingInstitutionId;

    private Date studentEndDate;

    private Date gradeEndDate;

    private Long prizeId;

    private static final long serialVersionUID = 1L;

    public CollegeTimeLimit(Long id, Long scholarshipId, Long primaryTeachingInstitutionId, Date studentEndDate, Date gradeEndDate, Long prizeId) {
        this.id = id;
        this.scholarshipId = scholarshipId;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.studentEndDate = studentEndDate;
        this.gradeEndDate = gradeEndDate;
        this.prizeId = prizeId;
    }

    public CollegeTimeLimit() {
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

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Date getStudentEndDate() {
        return studentEndDate;
    }

    public void setStudentEndDate(Date studentEndDate) {
        this.studentEndDate = studentEndDate;
    }

    public Date getGradeEndDate() {
        return gradeEndDate;
    }

    public void setGradeEndDate(Date gradeEndDate) {
        this.gradeEndDate = gradeEndDate;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
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
        CollegeTimeLimit other = (CollegeTimeLimit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getStudentEndDate() == null ? other.getStudentEndDate() == null : this.getStudentEndDate().equals(other.getStudentEndDate()))
            && (this.getGradeEndDate() == null ? other.getGradeEndDate() == null : this.getGradeEndDate().equals(other.getGradeEndDate()))
            && (this.getPrizeId() == null ? other.getPrizeId() == null : this.getPrizeId().equals(other.getPrizeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getStudentEndDate() == null) ? 0 : getStudentEndDate().hashCode());
        result = prime * result + ((getGradeEndDate() == null) ? 0 : getGradeEndDate().hashCode());
        result = prime * result + ((getPrizeId() == null) ? 0 : getPrizeId().hashCode());
        return result;
    }
}
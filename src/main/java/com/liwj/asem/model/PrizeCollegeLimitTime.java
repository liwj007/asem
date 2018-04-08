package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class PrizeCollegeLimitTime implements Serializable {
    private Long id;

    private Date studentEndDate;

    private Date gradeEndDate;

    private Long collegeId;

    private Long scholarshipId;

    private Boolean allocationTimeStatus;

    private static final long serialVersionUID = 1L;

    public PrizeCollegeLimitTime(Long id, Date studentEndDate, Date gradeEndDate, Long collegeId, Long scholarshipId, Boolean allocationTimeStatus) {
        this.id = id;
        this.studentEndDate = studentEndDate;
        this.gradeEndDate = gradeEndDate;
        this.collegeId = collegeId;
        this.scholarshipId = scholarshipId;
        this.allocationTimeStatus = allocationTimeStatus;
    }

    public PrizeCollegeLimitTime() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Boolean getAllocationTimeStatus() {
        return allocationTimeStatus;
    }

    public void setAllocationTimeStatus(Boolean allocationTimeStatus) {
        this.allocationTimeStatus = allocationTimeStatus;
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
        PrizeCollegeLimitTime other = (PrizeCollegeLimitTime) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStudentEndDate() == null ? other.getStudentEndDate() == null : this.getStudentEndDate().equals(other.getStudentEndDate()))
            && (this.getGradeEndDate() == null ? other.getGradeEndDate() == null : this.getGradeEndDate().equals(other.getGradeEndDate()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getAllocationTimeStatus() == null ? other.getAllocationTimeStatus() == null : this.getAllocationTimeStatus().equals(other.getAllocationTimeStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStudentEndDate() == null) ? 0 : getStudentEndDate().hashCode());
        result = prime * result + ((getGradeEndDate() == null) ? 0 : getGradeEndDate().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getAllocationTimeStatus() == null) ? 0 : getAllocationTimeStatus().hashCode());
        return result;
    }
}
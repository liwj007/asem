package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class SchoolTimeLimit implements Serializable {
    private Long id;

    private Long scholarshipId;

    private Date studentBeginDate;

    private Date collegeEndDate;

    private static final long serialVersionUID = 1L;

    public SchoolTimeLimit(Long id, Long scholarshipId, Date studentBeginDate, Date collegeEndDate) {
        this.id = id;
        this.scholarshipId = scholarshipId;
        this.studentBeginDate = studentBeginDate;
        this.collegeEndDate = collegeEndDate;
    }

    public SchoolTimeLimit() {
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

    public Date getStudentBeginDate() {
        return studentBeginDate;
    }

    public void setStudentBeginDate(Date studentBeginDate) {
        this.studentBeginDate = studentBeginDate;
    }

    public Date getCollegeEndDate() {
        return collegeEndDate;
    }

    public void setCollegeEndDate(Date collegeEndDate) {
        this.collegeEndDate = collegeEndDate;
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
        SchoolTimeLimit other = (SchoolTimeLimit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getStudentBeginDate() == null ? other.getStudentBeginDate() == null : this.getStudentBeginDate().equals(other.getStudentBeginDate()))
            && (this.getCollegeEndDate() == null ? other.getCollegeEndDate() == null : this.getCollegeEndDate().equals(other.getCollegeEndDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getStudentBeginDate() == null) ? 0 : getStudentBeginDate().hashCode());
        result = prime * result + ((getCollegeEndDate() == null) ? 0 : getCollegeEndDate().hashCode());
        return result;
    }
}
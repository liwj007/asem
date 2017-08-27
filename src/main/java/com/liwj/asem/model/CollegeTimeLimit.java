package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class CollegeTimeLimit implements Serializable {
    private Long id;

    private Long scholarshipId;

    private Long unitId;

    private Date studentBeginDate;

    private Date studentEndDate;

    private Date gradeEndDate;

    private static final long serialVersionUID = 1L;

    public CollegeTimeLimit(Long id, Long scholarshipId, Long unitId, Date studentBeginDate, Date studentEndDate, Date gradeEndDate) {
        this.id = id;
        this.scholarshipId = scholarshipId;
        this.unitId = unitId;
        this.studentBeginDate = studentBeginDate;
        this.studentEndDate = studentEndDate;
        this.gradeEndDate = gradeEndDate;
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

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Date getStudentBeginDate() {
        return studentBeginDate;
    }

    public void setStudentBeginDate(Date studentBeginDate) {
        this.studentBeginDate = studentBeginDate;
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
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getStudentBeginDate() == null ? other.getStudentBeginDate() == null : this.getStudentBeginDate().equals(other.getStudentBeginDate()))
            && (this.getStudentEndDate() == null ? other.getStudentEndDate() == null : this.getStudentEndDate().equals(other.getStudentEndDate()))
            && (this.getGradeEndDate() == null ? other.getGradeEndDate() == null : this.getGradeEndDate().equals(other.getGradeEndDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getStudentBeginDate() == null) ? 0 : getStudentBeginDate().hashCode());
        result = prime * result + ((getStudentEndDate() == null) ? 0 : getStudentEndDate().hashCode());
        result = prime * result + ((getGradeEndDate() == null) ? 0 : getGradeEndDate().hashCode());
        return result;
    }
}
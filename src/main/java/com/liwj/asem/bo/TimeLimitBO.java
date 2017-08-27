package com.liwj.asem.bo;

import com.liwj.asem.enums.ScholarshipTypeEnum;

import java.util.Date;

public class TimeLimitBO {
    private Long scholarshipId;
    private Date studentStartDate;
    private Date collegeEndDate;
    private Date studentEndDate;
    private Date gradeEndDate;

    private Boolean needGrade;
    private ScholarshipTypeEnum scholarshipType;

    private Long id;
    private String scholarshipName;

    public Boolean getNeedGrade() {
        return needGrade;
    }

    public void setNeedGrade(Boolean needGrade) {
        this.needGrade = needGrade;
    }

    public ScholarshipTypeEnum getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(ScholarshipTypeEnum scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }


    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Date getStudentStartDate() {
        return studentStartDate;
    }

    public void setStudentStartDate(Date studentStartDate) {
        this.studentStartDate = studentStartDate;
    }

    public Date getCollegeEndDate() {
        return collegeEndDate;
    }

    public void setCollegeEndDate(Date collegeEndDate) {
        this.collegeEndDate = collegeEndDate;
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
}

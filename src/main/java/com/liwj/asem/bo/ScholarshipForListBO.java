package com.liwj.asem.bo;

import java.util.Date;

public class ScholarshipForListBO {
    private Long id;
    private String scholarshipName;
    private Integer number;
    private Double money;

    private String status;

    private Date studentBeginDate;
    private Date studentEndDate;
    private Date gradeEndDate;
    private Date collegeEndDate;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getCollegeEndDate() {
        return collegeEndDate;
    }

    public void setCollegeEndDate(Date collegeEndDate) {
        this.collegeEndDate = collegeEndDate;
    }
}

package com.liwj.asem.bo;

import java.util.Date;

public class FlowTemplateBO {
    private Long id;

    private String name;

    private String typeName;

    private Date createDate;

    private Boolean needGradeCheck;

    private Boolean gradeInstructor;

    private Boolean gradeStudent;

    private Boolean specialInstructor;

    private Boolean collegeStudent;

    private Boolean schoolUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getNeedGradeCheck() {
        return needGradeCheck;
    }

    public void setNeedGradeCheck(Boolean needGradeCheck) {
        this.needGradeCheck = needGradeCheck;
    }

    public Boolean getGradeInstructor() {
        return gradeInstructor;
    }

    public void setGradeInstructor(Boolean gradeInstructor) {
        this.gradeInstructor = gradeInstructor;
    }

    public Boolean getGradeStudent() {
        return gradeStudent;
    }

    public void setGradeStudent(Boolean gradeStudent) {
        this.gradeStudent = gradeStudent;
    }

    public Boolean getSpecialInstructor() {
        return specialInstructor;
    }

    public void setSpecialInstructor(Boolean specialInstructor) {
        this.specialInstructor = specialInstructor;
    }

    public Boolean getCollegeStudent() {
        return collegeStudent;
    }

    public void setCollegeStudent(Boolean collegeStudent) {
        this.collegeStudent = collegeStudent;
    }

    public Boolean getSchoolUser() {
        return schoolUser;
    }

    public void setSchoolUser(Boolean schoolUser) {
        this.schoolUser = schoolUser;
    }


}

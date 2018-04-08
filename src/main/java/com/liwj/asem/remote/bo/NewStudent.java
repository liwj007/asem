package com.liwj.asem.remote.bo;

public class NewStudent {
    public int id;
    public int collegeID;
    public int majorID;
    public int classID;
    public String sn;
    public String name;
    public String grade;

    public String collegeName;
    public String majorName;
    public String className;

    public NewStudent(int id, int collegeID, int majorID, int classID, String sn, String name, String grade) {
        this.id = id;
        this.collegeID = collegeID;
        this.majorID = majorID;
        this.classID = classID;
        this.sn = sn;
        this.name = name;
        this.grade = grade;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public int getMajorID() {
        return majorID;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}

package com.liwj.asem.model;

import java.io.Serializable;

public class ComprehensiveEvaluation implements Serializable {
    private Long id;

    private String name;

    private String no;

    private Integer majorNumber;

    private Double compositeScore;

    private Integer compositeRank;

    private Double intellectualScore;

    private Integer intellectualRank;

    private String academicYear;

    private String collegeName;

    private String majorName;

    private String gradeName;

    private static final long serialVersionUID = 1L;

    public ComprehensiveEvaluation(Long id, String name, String no, Integer majorNumber, Double compositeScore, Integer compositeRank, Double intellectualScore, Integer intellectualRank, String academicYear, String collegeName, String majorName, String gradeName) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.majorNumber = majorNumber;
        this.compositeScore = compositeScore;
        this.compositeRank = compositeRank;
        this.intellectualScore = intellectualScore;
        this.intellectualRank = intellectualRank;
        this.academicYear = academicYear;
        this.collegeName = collegeName;
        this.majorName = majorName;
        this.gradeName = gradeName;
    }

    public ComprehensiveEvaluation() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Integer getMajorNumber() {
        return majorNumber;
    }

    public void setMajorNumber(Integer majorNumber) {
        this.majorNumber = majorNumber;
    }

    public Double getCompositeScore() {
        return compositeScore;
    }

    public void setCompositeScore(Double compositeScore) {
        this.compositeScore = compositeScore;
    }

    public Integer getCompositeRank() {
        return compositeRank;
    }

    public void setCompositeRank(Integer compositeRank) {
        this.compositeRank = compositeRank;
    }

    public Double getIntellectualScore() {
        return intellectualScore;
    }

    public void setIntellectualScore(Double intellectualScore) {
        this.intellectualScore = intellectualScore;
    }

    public Integer getIntellectualRank() {
        return intellectualRank;
    }

    public void setIntellectualRank(Integer intellectualRank) {
        this.intellectualRank = intellectualRank;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear == null ? null : academicYear.trim();
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
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
        ComprehensiveEvaluation other = (ComprehensiveEvaluation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNo() == null ? other.getNo() == null : this.getNo().equals(other.getNo()))
            && (this.getMajorNumber() == null ? other.getMajorNumber() == null : this.getMajorNumber().equals(other.getMajorNumber()))
            && (this.getCompositeScore() == null ? other.getCompositeScore() == null : this.getCompositeScore().equals(other.getCompositeScore()))
            && (this.getCompositeRank() == null ? other.getCompositeRank() == null : this.getCompositeRank().equals(other.getCompositeRank()))
            && (this.getIntellectualScore() == null ? other.getIntellectualScore() == null : this.getIntellectualScore().equals(other.getIntellectualScore()))
            && (this.getIntellectualRank() == null ? other.getIntellectualRank() == null : this.getIntellectualRank().equals(other.getIntellectualRank()))
            && (this.getAcademicYear() == null ? other.getAcademicYear() == null : this.getAcademicYear().equals(other.getAcademicYear()))
            && (this.getCollegeName() == null ? other.getCollegeName() == null : this.getCollegeName().equals(other.getCollegeName()))
            && (this.getMajorName() == null ? other.getMajorName() == null : this.getMajorName().equals(other.getMajorName()))
            && (this.getGradeName() == null ? other.getGradeName() == null : this.getGradeName().equals(other.getGradeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNo() == null) ? 0 : getNo().hashCode());
        result = prime * result + ((getMajorNumber() == null) ? 0 : getMajorNumber().hashCode());
        result = prime * result + ((getCompositeScore() == null) ? 0 : getCompositeScore().hashCode());
        result = prime * result + ((getCompositeRank() == null) ? 0 : getCompositeRank().hashCode());
        result = prime * result + ((getIntellectualScore() == null) ? 0 : getIntellectualScore().hashCode());
        result = prime * result + ((getIntellectualRank() == null) ? 0 : getIntellectualRank().hashCode());
        result = prime * result + ((getAcademicYear() == null) ? 0 : getAcademicYear().hashCode());
        result = prime * result + ((getCollegeName() == null) ? 0 : getCollegeName().hashCode());
        result = prime * result + ((getMajorName() == null) ? 0 : getMajorName().hashCode());
        result = prime * result + ((getGradeName() == null) ? 0 : getGradeName().hashCode());
        return result;
    }
}
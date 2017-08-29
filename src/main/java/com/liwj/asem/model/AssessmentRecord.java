package com.liwj.asem.model;

import java.io.Serializable;

public class AssessmentRecord implements Serializable {
    private Long id;

    private Integer year;

    private Double score;

    private Integer intellectualRank;

    private Double intellectualScore;

    private Double maralScore;

    private Double overallScore;

    private Integer overallRank;

    private Integer majorRank;

    private Integer majorTotal;

    private String sn;

    private static final long serialVersionUID = 1L;

    public AssessmentRecord(Long id, Integer year, Double score, Integer intellectualRank, Double intellectualScore, Double maralScore, Double overallScore, Integer overallRank, Integer majorRank, Integer majorTotal, String sn) {
        this.id = id;
        this.year = year;
        this.score = score;
        this.intellectualRank = intellectualRank;
        this.intellectualScore = intellectualScore;
        this.maralScore = maralScore;
        this.overallScore = overallScore;
        this.overallRank = overallRank;
        this.majorRank = majorRank;
        this.majorTotal = majorTotal;
        this.sn = sn;
    }

    public AssessmentRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getIntellectualRank() {
        return intellectualRank;
    }

    public void setIntellectualRank(Integer intellectualRank) {
        this.intellectualRank = intellectualRank;
    }

    public Double getIntellectualScore() {
        return intellectualScore;
    }

    public void setIntellectualScore(Double intellectualScore) {
        this.intellectualScore = intellectualScore;
    }

    public Double getMaralScore() {
        return maralScore;
    }

    public void setMaralScore(Double maralScore) {
        this.maralScore = maralScore;
    }

    public Double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Double overallScore) {
        this.overallScore = overallScore;
    }

    public Integer getOverallRank() {
        return overallRank;
    }

    public void setOverallRank(Integer overallRank) {
        this.overallRank = overallRank;
    }

    public Integer getMajorRank() {
        return majorRank;
    }

    public void setMajorRank(Integer majorRank) {
        this.majorRank = majorRank;
    }

    public Integer getMajorTotal() {
        return majorTotal;
    }

    public void setMajorTotal(Integer majorTotal) {
        this.majorTotal = majorTotal;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
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
        AssessmentRecord other = (AssessmentRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getIntellectualRank() == null ? other.getIntellectualRank() == null : this.getIntellectualRank().equals(other.getIntellectualRank()))
            && (this.getIntellectualScore() == null ? other.getIntellectualScore() == null : this.getIntellectualScore().equals(other.getIntellectualScore()))
            && (this.getMaralScore() == null ? other.getMaralScore() == null : this.getMaralScore().equals(other.getMaralScore()))
            && (this.getOverallScore() == null ? other.getOverallScore() == null : this.getOverallScore().equals(other.getOverallScore()))
            && (this.getOverallRank() == null ? other.getOverallRank() == null : this.getOverallRank().equals(other.getOverallRank()))
            && (this.getMajorRank() == null ? other.getMajorRank() == null : this.getMajorRank().equals(other.getMajorRank()))
            && (this.getMajorTotal() == null ? other.getMajorTotal() == null : this.getMajorTotal().equals(other.getMajorTotal()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getIntellectualRank() == null) ? 0 : getIntellectualRank().hashCode());
        result = prime * result + ((getIntellectualScore() == null) ? 0 : getIntellectualScore().hashCode());
        result = prime * result + ((getMaralScore() == null) ? 0 : getMaralScore().hashCode());
        result = prime * result + ((getOverallScore() == null) ? 0 : getOverallScore().hashCode());
        result = prime * result + ((getOverallRank() == null) ? 0 : getOverallRank().hashCode());
        result = prime * result + ((getMajorRank() == null) ? 0 : getMajorRank().hashCode());
        result = prime * result + ((getMajorTotal() == null) ? 0 : getMajorTotal().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        return result;
    }
}
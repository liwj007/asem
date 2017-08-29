package com.liwj.asem.bo;

public class AssessmentRecordBO {
    private Integer year;

    private String name;

    private Integer intellectualRank;

    private Double intellectualScore;


    private Double overallScore;

    private Integer overallRank;


    private Integer majorTotal;

    private String sn;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.sn = sn;
    }
}

package com.liwj.asem.bo;

import com.liwj.asem.enums.LevelTypeEnum;

import java.util.List;

public class EntireScholarshipForm {
    private Long id;
    private Double avgMoney;
    private Integer avgNumber;
    private List<FileBO> files;
    private LevelTypeEnum levelType;
    private String name;
    private String requirement;
    private Long templateId;
    private List<NewPrizeItem> prizes;
    private String scholarshipTypeName;

    public String getScholarshipTypeName() {
        return scholarshipTypeName;
    }

    public void setScholarshipTypeName(String scholarshipTypeName) {
        this.scholarshipTypeName = scholarshipTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAvgMoney() {
        return avgMoney;
    }

    public void setAvgMoney(Double avgMoney) {
        this.avgMoney = avgMoney;
    }

    public Integer getAvgNumber() {
        return avgNumber;
    }

    public void setAvgNumber(Integer avgNumber) {
        this.avgNumber = avgNumber;
    }

    public List<FileBO> getFiles() {
        return files;
    }

    public void setFiles(List<FileBO> files) {
        this.files = files;
    }

    public LevelTypeEnum getLevelType() {
        return levelType;
    }

    public void setLevelType(LevelTypeEnum levelType) {
        this.levelType = levelType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public List<NewPrizeItem> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<NewPrizeItem> prizes) {
        this.prizes = prizes;
    }
}

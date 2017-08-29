package com.liwj.asem.model;

import java.io.Serializable;

public class Prize implements Serializable {
    private Long id;

    private Integer status;

    private Long parentPrizeId;

    private String prizeName;

    private Double money;

    private Integer number;

    private Long scholarshipId;

    private Integer scholarshipType;

    private Integer restNumber;

    private Integer allocationRule;

    private Integer allocationMethod;

    private Boolean allocationNumberStatus;

    private Long primaryTeachingInstitutionId;

    private Long gradeId;

    private Boolean isRoot;

    private Integer levelNumber;

    private Integer checkStatus;

    private Boolean allocationCollegeTimeStatus;

    private static final long serialVersionUID = 1L;

    public Prize(Long id, Integer status, Long parentPrizeId, String prizeName, Double money, Integer number, Long scholarshipId, Integer scholarshipType, Integer restNumber, Integer allocationRule, Integer allocationMethod, Boolean allocationNumberStatus, Long primaryTeachingInstitutionId, Long gradeId, Boolean isRoot, Integer levelNumber, Integer checkStatus, Boolean allocationCollegeTimeStatus) {
        this.id = id;
        this.status = status;
        this.parentPrizeId = parentPrizeId;
        this.prizeName = prizeName;
        this.money = money;
        this.number = number;
        this.scholarshipId = scholarshipId;
        this.scholarshipType = scholarshipType;
        this.restNumber = restNumber;
        this.allocationRule = allocationRule;
        this.allocationMethod = allocationMethod;
        this.allocationNumberStatus = allocationNumberStatus;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.gradeId = gradeId;
        this.isRoot = isRoot;
        this.levelNumber = levelNumber;
        this.checkStatus = checkStatus;
        this.allocationCollegeTimeStatus = allocationCollegeTimeStatus;
    }

    public Prize() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getParentPrizeId() {
        return parentPrizeId;
    }

    public void setParentPrizeId(Long parentPrizeId) {
        this.parentPrizeId = parentPrizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Integer getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(Integer scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public Integer getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(Integer restNumber) {
        this.restNumber = restNumber;
    }

    public Integer getAllocationRule() {
        return allocationRule;
    }

    public void setAllocationRule(Integer allocationRule) {
        this.allocationRule = allocationRule;
    }

    public Integer getAllocationMethod() {
        return allocationMethod;
    }

    public void setAllocationMethod(Integer allocationMethod) {
        this.allocationMethod = allocationMethod;
    }

    public Boolean getAllocationNumberStatus() {
        return allocationNumberStatus;
    }

    public void setAllocationNumberStatus(Boolean allocationNumberStatus) {
        this.allocationNumberStatus = allocationNumberStatus;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Boolean getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Boolean isRoot) {
        this.isRoot = isRoot;
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Boolean getAllocationCollegeTimeStatus() {
        return allocationCollegeTimeStatus;
    }

    public void setAllocationCollegeTimeStatus(Boolean allocationCollegeTimeStatus) {
        this.allocationCollegeTimeStatus = allocationCollegeTimeStatus;
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
        Prize other = (Prize) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getParentPrizeId() == null ? other.getParentPrizeId() == null : this.getParentPrizeId().equals(other.getParentPrizeId()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getRestNumber() == null ? other.getRestNumber() == null : this.getRestNumber().equals(other.getRestNumber()))
            && (this.getAllocationRule() == null ? other.getAllocationRule() == null : this.getAllocationRule().equals(other.getAllocationRule()))
            && (this.getAllocationMethod() == null ? other.getAllocationMethod() == null : this.getAllocationMethod().equals(other.getAllocationMethod()))
            && (this.getAllocationNumberStatus() == null ? other.getAllocationNumberStatus() == null : this.getAllocationNumberStatus().equals(other.getAllocationNumberStatus()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getIsRoot() == null ? other.getIsRoot() == null : this.getIsRoot().equals(other.getIsRoot()))
            && (this.getLevelNumber() == null ? other.getLevelNumber() == null : this.getLevelNumber().equals(other.getLevelNumber()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getAllocationCollegeTimeStatus() == null ? other.getAllocationCollegeTimeStatus() == null : this.getAllocationCollegeTimeStatus().equals(other.getAllocationCollegeTimeStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getParentPrizeId() == null) ? 0 : getParentPrizeId().hashCode());
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getRestNumber() == null) ? 0 : getRestNumber().hashCode());
        result = prime * result + ((getAllocationRule() == null) ? 0 : getAllocationRule().hashCode());
        result = prime * result + ((getAllocationMethod() == null) ? 0 : getAllocationMethod().hashCode());
        result = prime * result + ((getAllocationNumberStatus() == null) ? 0 : getAllocationNumberStatus().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getIsRoot() == null) ? 0 : getIsRoot().hashCode());
        result = prime * result + ((getLevelNumber() == null) ? 0 : getLevelNumber().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getAllocationCollegeTimeStatus() == null) ? 0 : getAllocationCollegeTimeStatus().hashCode());
        return result;
    }
}
package com.liwj.asem.model;

import java.io.Serializable;

public class Prize implements Serializable {
    private Long id;

    private Double money;

    private Integer number;

    private Long scholarshipId;

    private Integer scholarshipType;

    private String prizeName;

    private Integer restNumber;

    private Integer allocationRule;

    private Integer allocationMethod;

    private Boolean allocationNumberStatus;

    private Boolean allocationTimeStatus;

    private Long unitId;

    private Long parentPrizeId;

    private Boolean isRoot;

    private Integer levelNumber;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Prize(Long id, Double money, Integer number, Long scholarshipId, Integer scholarshipType, String prizeName, Integer restNumber, Integer allocationRule, Integer allocationMethod, Boolean allocationNumberStatus, Boolean allocationTimeStatus, Long unitId, Long parentPrizeId, Boolean isRoot, Integer levelNumber, Integer status) {
        this.id = id;
        this.money = money;
        this.number = number;
        this.scholarshipId = scholarshipId;
        this.scholarshipType = scholarshipType;
        this.prizeName = prizeName;
        this.restNumber = restNumber;
        this.allocationRule = allocationRule;
        this.allocationMethod = allocationMethod;
        this.allocationNumberStatus = allocationNumberStatus;
        this.allocationTimeStatus = allocationTimeStatus;
        this.unitId = unitId;
        this.parentPrizeId = parentPrizeId;
        this.isRoot = isRoot;
        this.levelNumber = levelNumber;
        this.status = status;
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

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
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

    public Boolean getAllocationTimeStatus() {
        return allocationTimeStatus;
    }

    public void setAllocationTimeStatus(Boolean allocationTimeStatus) {
        this.allocationTimeStatus = allocationTimeStatus;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getParentPrizeId() {
        return parentPrizeId;
    }

    public void setParentPrizeId(Long parentPrizeId) {
        this.parentPrizeId = parentPrizeId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getRestNumber() == null ? other.getRestNumber() == null : this.getRestNumber().equals(other.getRestNumber()))
            && (this.getAllocationRule() == null ? other.getAllocationRule() == null : this.getAllocationRule().equals(other.getAllocationRule()))
            && (this.getAllocationMethod() == null ? other.getAllocationMethod() == null : this.getAllocationMethod().equals(other.getAllocationMethod()))
            && (this.getAllocationNumberStatus() == null ? other.getAllocationNumberStatus() == null : this.getAllocationNumberStatus().equals(other.getAllocationNumberStatus()))
            && (this.getAllocationTimeStatus() == null ? other.getAllocationTimeStatus() == null : this.getAllocationTimeStatus().equals(other.getAllocationTimeStatus()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getParentPrizeId() == null ? other.getParentPrizeId() == null : this.getParentPrizeId().equals(other.getParentPrizeId()))
            && (this.getIsRoot() == null ? other.getIsRoot() == null : this.getIsRoot().equals(other.getIsRoot()))
            && (this.getLevelNumber() == null ? other.getLevelNumber() == null : this.getLevelNumber().equals(other.getLevelNumber()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getRestNumber() == null) ? 0 : getRestNumber().hashCode());
        result = prime * result + ((getAllocationRule() == null) ? 0 : getAllocationRule().hashCode());
        result = prime * result + ((getAllocationMethod() == null) ? 0 : getAllocationMethod().hashCode());
        result = prime * result + ((getAllocationNumberStatus() == null) ? 0 : getAllocationNumberStatus().hashCode());
        result = prime * result + ((getAllocationTimeStatus() == null) ? 0 : getAllocationTimeStatus().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getParentPrizeId() == null) ? 0 : getParentPrizeId().hashCode());
        result = prime * result + ((getIsRoot() == null) ? 0 : getIsRoot().hashCode());
        result = prime * result + ((getLevelNumber() == null) ? 0 : getLevelNumber().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
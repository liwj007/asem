package com.liwj.asem.model;

import java.io.Serializable;

public class PrizeInfo implements Serializable {
    private Long id;

    private String prizeName;

    private Double money;

    private Long scholarshipId;

    private Integer scholarshipType;

    private Integer level;

    private static final long serialVersionUID = 1L;

    public PrizeInfo(Long id, String prizeName, Double money, Long scholarshipId, Integer scholarshipType, Integer level) {
        this.id = id;
        this.prizeName = prizeName;
        this.money = money;
        this.scholarshipId = scholarshipId;
        this.scholarshipType = scholarshipType;
        this.level = level;
    }

    public PrizeInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
        PrizeInfo other = (PrizeInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrizeName() == null ? other.getPrizeName() == null : this.getPrizeName().equals(other.getPrizeName()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getScholarshipId() == null ? other.getScholarshipId() == null : this.getScholarshipId().equals(other.getScholarshipId()))
            && (this.getScholarshipType() == null ? other.getScholarshipType() == null : this.getScholarshipType().equals(other.getScholarshipType()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrizeName() == null) ? 0 : getPrizeName().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getScholarshipId() == null) ? 0 : getScholarshipId().hashCode());
        result = prime * result + ((getScholarshipType() == null) ? 0 : getScholarshipType().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }
}
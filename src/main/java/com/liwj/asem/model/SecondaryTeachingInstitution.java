package com.liwj.asem.model;

import java.io.Serializable;

public class SecondaryTeachingInstitution implements Serializable {
    private Long id;

    private String sn;

    private String name;

    private Integer year;

    private Integer changeType;

    private Integer isMain;

    private Integer acrossCollege;

    private Long primaryTeachingInstitution;

    private static final long serialVersionUID = 1L;

    public SecondaryTeachingInstitution(Long id, String sn, String name, Integer year, Integer changeType, Integer isMain, Integer acrossCollege, Long primaryTeachingInstitution) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.year = year;
        this.changeType = changeType;
        this.isMain = isMain;
        this.acrossCollege = acrossCollege;
        this.primaryTeachingInstitution = primaryTeachingInstitution;
    }

    public SecondaryTeachingInstitution() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public Integer getAcrossCollege() {
        return acrossCollege;
    }

    public void setAcrossCollege(Integer acrossCollege) {
        this.acrossCollege = acrossCollege;
    }

    public Long getPrimaryTeachingInstitution() {
        return primaryTeachingInstitution;
    }

    public void setPrimaryTeachingInstitution(Long primaryTeachingInstitution) {
        this.primaryTeachingInstitution = primaryTeachingInstitution;
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
        SecondaryTeachingInstitution other = (SecondaryTeachingInstitution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getChangeType() == null ? other.getChangeType() == null : this.getChangeType().equals(other.getChangeType()))
            && (this.getIsMain() == null ? other.getIsMain() == null : this.getIsMain().equals(other.getIsMain()))
            && (this.getAcrossCollege() == null ? other.getAcrossCollege() == null : this.getAcrossCollege().equals(other.getAcrossCollege()))
            && (this.getPrimaryTeachingInstitution() == null ? other.getPrimaryTeachingInstitution() == null : this.getPrimaryTeachingInstitution().equals(other.getPrimaryTeachingInstitution()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getChangeType() == null) ? 0 : getChangeType().hashCode());
        result = prime * result + ((getIsMain() == null) ? 0 : getIsMain().hashCode());
        result = prime * result + ((getAcrossCollege() == null) ? 0 : getAcrossCollege().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitution() == null) ? 0 : getPrimaryTeachingInstitution().hashCode());
        return result;
    }
}
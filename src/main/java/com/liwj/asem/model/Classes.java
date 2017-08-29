package com.liwj.asem.model;

import java.io.Serializable;

public class Classes implements Serializable {
    private Long id;

    private String name;

    private String sn;

    private Long secondaryTeachingInstitution;

    private Long gradeId;

    private static final long serialVersionUID = 1L;

    public Classes(Long id, String name, String sn, Long secondaryTeachingInstitution, Long gradeId) {
        this.id = id;
        this.name = name;
        this.sn = sn;
        this.secondaryTeachingInstitution = secondaryTeachingInstitution;
        this.gradeId = gradeId;
    }

    public Classes() {
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Long getSecondaryTeachingInstitution() {
        return secondaryTeachingInstitution;
    }

    public void setSecondaryTeachingInstitution(Long secondaryTeachingInstitution) {
        this.secondaryTeachingInstitution = secondaryTeachingInstitution;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
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
        Classes other = (Classes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getSecondaryTeachingInstitution() == null ? other.getSecondaryTeachingInstitution() == null : this.getSecondaryTeachingInstitution().equals(other.getSecondaryTeachingInstitution()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getSecondaryTeachingInstitution() == null) ? 0 : getSecondaryTeachingInstitution().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        return result;
    }
}
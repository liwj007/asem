package com.liwj.asem.model;

import java.io.Serializable;

public class RGradeAndSecondaryTeachingInstitution implements Serializable {
    private Long id;

    private Long gradeId;

    private Long secondaryTeachingInstitutionId;

    private static final long serialVersionUID = 1L;

    public RGradeAndSecondaryTeachingInstitution(Long id, Long gradeId, Long secondaryTeachingInstitutionId) {
        this.id = id;
        this.gradeId = gradeId;
        this.secondaryTeachingInstitutionId = secondaryTeachingInstitutionId;
    }

    public RGradeAndSecondaryTeachingInstitution() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getSecondaryTeachingInstitutionId() {
        return secondaryTeachingInstitutionId;
    }

    public void setSecondaryTeachingInstitutionId(Long secondaryTeachingInstitutionId) {
        this.secondaryTeachingInstitutionId = secondaryTeachingInstitutionId;
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
        RGradeAndSecondaryTeachingInstitution other = (RGradeAndSecondaryTeachingInstitution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getSecondaryTeachingInstitutionId() == null ? other.getSecondaryTeachingInstitutionId() == null : this.getSecondaryTeachingInstitutionId().equals(other.getSecondaryTeachingInstitutionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getSecondaryTeachingInstitutionId() == null) ? 0 : getSecondaryTeachingInstitutionId().hashCode());
        return result;
    }
}
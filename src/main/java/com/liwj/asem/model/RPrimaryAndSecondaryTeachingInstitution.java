package com.liwj.asem.model;

import java.io.Serializable;

public class RPrimaryAndSecondaryTeachingInstitution implements Serializable {
    private Long id;

    private Long primaryTeachingInstitutionId;

    private Long secondaryTeachingInstitutionId;

    private static final long serialVersionUID = 1L;

    public RPrimaryAndSecondaryTeachingInstitution(Long id, Long primaryTeachingInstitutionId, Long secondaryTeachingInstitutionId) {
        this.id = id;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
        this.secondaryTeachingInstitutionId = secondaryTeachingInstitutionId;
    }

    public RPrimaryAndSecondaryTeachingInstitution() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
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
        RPrimaryAndSecondaryTeachingInstitution other = (RPrimaryAndSecondaryTeachingInstitution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()))
            && (this.getSecondaryTeachingInstitutionId() == null ? other.getSecondaryTeachingInstitutionId() == null : this.getSecondaryTeachingInstitutionId().equals(other.getSecondaryTeachingInstitutionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        result = prime * result + ((getSecondaryTeachingInstitutionId() == null) ? 0 : getSecondaryTeachingInstitutionId().hashCode());
        return result;
    }
}
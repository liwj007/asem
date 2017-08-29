package com.liwj.asem.model;

import java.io.Serializable;

public class RUserAndPrimaryTeachingInstitution implements Serializable {
    private Long id;

    private Long userId;

    private Long primaryTeachingInstitutionId;

    private static final long serialVersionUID = 1L;

    public RUserAndPrimaryTeachingInstitution(Long id, Long userId, Long primaryTeachingInstitutionId) {
        this.id = id;
        this.userId = userId;
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
    }

    public RUserAndPrimaryTeachingInstitution() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPrimaryTeachingInstitutionId() {
        return primaryTeachingInstitutionId;
    }

    public void setPrimaryTeachingInstitutionId(Long primaryTeachingInstitutionId) {
        this.primaryTeachingInstitutionId = primaryTeachingInstitutionId;
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
        RUserAndPrimaryTeachingInstitution other = (RUserAndPrimaryTeachingInstitution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPrimaryTeachingInstitutionId() == null ? other.getPrimaryTeachingInstitutionId() == null : this.getPrimaryTeachingInstitutionId().equals(other.getPrimaryTeachingInstitutionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPrimaryTeachingInstitutionId() == null) ? 0 : getPrimaryTeachingInstitutionId().hashCode());
        return result;
    }
}
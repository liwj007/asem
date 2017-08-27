package com.liwj.asem.model;

import java.io.Serializable;

public class RStepRight implements Serializable {
    private Long id;

    private Long stepTemplateId;

    private Integer userRight;

    private static final long serialVersionUID = 1L;

    public RStepRight(Long id, Long stepTemplateId, Integer userRight) {
        this.id = id;
        this.stepTemplateId = stepTemplateId;
        this.userRight = userRight;
    }

    public RStepRight() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStepTemplateId() {
        return stepTemplateId;
    }

    public void setStepTemplateId(Long stepTemplateId) {
        this.stepTemplateId = stepTemplateId;
    }

    public Integer getUserRight() {
        return userRight;
    }

    public void setUserRight(Integer userRight) {
        this.userRight = userRight;
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
        RStepRight other = (RStepRight) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStepTemplateId() == null ? other.getStepTemplateId() == null : this.getStepTemplateId().equals(other.getStepTemplateId()))
            && (this.getUserRight() == null ? other.getUserRight() == null : this.getUserRight().equals(other.getUserRight()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStepTemplateId() == null) ? 0 : getStepTemplateId().hashCode());
        result = prime * result + ((getUserRight() == null) ? 0 : getUserRight().hashCode());
        return result;
    }
}
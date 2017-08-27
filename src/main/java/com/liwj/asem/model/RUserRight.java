package com.liwj.asem.model;

import java.io.Serializable;

public class RUserRight implements Serializable {
    private Long id;

    private Long userId;

    private Long rightId;

    private static final long serialVersionUID = 1L;

    public RUserRight(Long id, Long userId, Long rightId) {
        this.id = id;
        this.userId = userId;
        this.rightId = rightId;
    }

    public RUserRight() {
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

    public Long getRightId() {
        return rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
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
        RUserRight other = (RUserRight) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRightId() == null ? other.getRightId() == null : this.getRightId().equals(other.getRightId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRightId() == null) ? 0 : getRightId().hashCode());
        return result;
    }
}
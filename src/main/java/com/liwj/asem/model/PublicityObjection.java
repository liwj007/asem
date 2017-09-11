package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class PublicityObjection implements Serializable {
    private Long id;

    private Long userId;

    private Date createTime;

    private Date feedbackTime;

    private Long publicityId;

    private static final long serialVersionUID = 1L;

    public PublicityObjection(Long id, Long userId, Date createTime, Date feedbackTime, Long publicityId) {
        this.id = id;
        this.userId = userId;
        this.createTime = createTime;
        this.feedbackTime = feedbackTime;
        this.publicityId = publicityId;
    }

    public PublicityObjection() {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Long getPublicityId() {
        return publicityId;
    }

    public void setPublicityId(Long publicityId) {
        this.publicityId = publicityId;
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
        PublicityObjection other = (PublicityObjection) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFeedbackTime() == null ? other.getFeedbackTime() == null : this.getFeedbackTime().equals(other.getFeedbackTime()))
            && (this.getPublicityId() == null ? other.getPublicityId() == null : this.getPublicityId().equals(other.getPublicityId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFeedbackTime() == null) ? 0 : getFeedbackTime().hashCode());
        result = prime * result + ((getPublicityId() == null) ? 0 : getPublicityId().hashCode());
        return result;
    }
}
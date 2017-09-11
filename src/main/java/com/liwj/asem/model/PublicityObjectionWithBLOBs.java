package com.liwj.asem.model;

import java.io.Serializable;
import java.util.Date;

public class PublicityObjectionWithBLOBs extends PublicityObjection implements Serializable {
    private String content;

    private String feedback;

    private static final long serialVersionUID = 1L;

    public PublicityObjectionWithBLOBs(Long id, Long userId, Date createTime, Date feedbackTime, Long publicityId, String content, String feedback) {
        super(id, userId, createTime, feedbackTime, publicityId);
        this.content = content;
        this.feedback = feedback;
    }

    public PublicityObjectionWithBLOBs() {
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
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
        PublicityObjectionWithBLOBs other = (PublicityObjectionWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFeedbackTime() == null ? other.getFeedbackTime() == null : this.getFeedbackTime().equals(other.getFeedbackTime()))
            && (this.getPublicityId() == null ? other.getPublicityId() == null : this.getPublicityId().equals(other.getPublicityId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getFeedback() == null ? other.getFeedback() == null : this.getFeedback().equals(other.getFeedback()));
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
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getFeedback() == null) ? 0 : getFeedback().hashCode());
        return result;
    }
}
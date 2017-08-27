package com.liwj.asem.model;

import java.io.Serializable;

public class FlowLink implements Serializable {
    private Long id;

    private Long flowTemplateId;

    private Long fromStepId;

    private Long toStepId;

    private String description;

    private static final long serialVersionUID = 1L;

    public FlowLink(Long id, Long flowTemplateId, Long fromStepId, Long toStepId, String description) {
        this.id = id;
        this.flowTemplateId = flowTemplateId;
        this.fromStepId = fromStepId;
        this.toStepId = toStepId;
        this.description = description;
    }

    public FlowLink() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlowTemplateId() {
        return flowTemplateId;
    }

    public void setFlowTemplateId(Long flowTemplateId) {
        this.flowTemplateId = flowTemplateId;
    }

    public Long getFromStepId() {
        return fromStepId;
    }

    public void setFromStepId(Long fromStepId) {
        this.fromStepId = fromStepId;
    }

    public Long getToStepId() {
        return toStepId;
    }

    public void setToStepId(Long toStepId) {
        this.toStepId = toStepId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        FlowLink other = (FlowLink) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlowTemplateId() == null ? other.getFlowTemplateId() == null : this.getFlowTemplateId().equals(other.getFlowTemplateId()))
            && (this.getFromStepId() == null ? other.getFromStepId() == null : this.getFromStepId().equals(other.getFromStepId()))
            && (this.getToStepId() == null ? other.getToStepId() == null : this.getToStepId().equals(other.getToStepId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlowTemplateId() == null) ? 0 : getFlowTemplateId().hashCode());
        result = prime * result + ((getFromStepId() == null) ? 0 : getFromStepId().hashCode());
        result = prime * result + ((getToStepId() == null) ? 0 : getToStepId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }
}
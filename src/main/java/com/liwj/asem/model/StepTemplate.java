package com.liwj.asem.model;

import java.io.Serializable;

public class StepTemplate implements Serializable {
    private Long id;

    private String name;

    private Long flowTemplateId;

    private String description;

    private static final long serialVersionUID = 1L;

    public StepTemplate(Long id, String name, Long flowTemplateId, String description) {
        this.id = id;
        this.name = name;
        this.flowTemplateId = flowTemplateId;
        this.description = description;
    }

    public StepTemplate() {
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

    public Long getFlowTemplateId() {
        return flowTemplateId;
    }

    public void setFlowTemplateId(Long flowTemplateId) {
        this.flowTemplateId = flowTemplateId;
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
        StepTemplate other = (StepTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFlowTemplateId() == null ? other.getFlowTemplateId() == null : this.getFlowTemplateId().equals(other.getFlowTemplateId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFlowTemplateId() == null) ? 0 : getFlowTemplateId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }
}
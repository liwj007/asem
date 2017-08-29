package com.liwj.asem.model;

import java.io.Serializable;

public class RFlowTemplateStepAndUserRole implements Serializable {
    private Long id;

    private Long flowTemplateStepId;

    private Integer roleType;

    private static final long serialVersionUID = 1L;

    public RFlowTemplateStepAndUserRole(Long id, Long flowTemplateStepId, Integer roleType) {
        this.id = id;
        this.flowTemplateStepId = flowTemplateStepId;
        this.roleType = roleType;
    }

    public RFlowTemplateStepAndUserRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlowTemplateStepId() {
        return flowTemplateStepId;
    }

    public void setFlowTemplateStepId(Long flowTemplateStepId) {
        this.flowTemplateStepId = flowTemplateStepId;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
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
        RFlowTemplateStepAndUserRole other = (RFlowTemplateStepAndUserRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlowTemplateStepId() == null ? other.getFlowTemplateStepId() == null : this.getFlowTemplateStepId().equals(other.getFlowTemplateStepId()))
            && (this.getRoleType() == null ? other.getRoleType() == null : this.getRoleType().equals(other.getRoleType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlowTemplateStepId() == null) ? 0 : getFlowTemplateStepId().hashCode());
        result = prime * result + ((getRoleType() == null) ? 0 : getRoleType().hashCode());
        return result;
    }
}
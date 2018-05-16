package com.liwj.asem.model;

import java.io.Serializable;

public class Major implements Serializable {
    private Long id;

    private String name;

    private Long collegeId;

    private static final long serialVersionUID = 1L;

    public Major(Long id, String name, Long collegeId) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
    }

    public Major() {
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

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
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
        Major other = (Major) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        return result;
    }
}
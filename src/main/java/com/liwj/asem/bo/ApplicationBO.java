package com.liwj.asem.bo;

import java.util.List;

public class ApplicationBO {
    private Long id;
    private String scholarshipName;
    private String prizeName;
    private List<FileBO> files;
    private String evaluation;
    private List<ApplicationReasonBO> reasons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScholarshipName() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName = scholarshipName;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public List<FileBO> getFiles() {
        return files;
    }

    public void setFiles(List<FileBO> files) {
        this.files = files;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public List<ApplicationReasonBO> getReasons() {
        return reasons;
    }

    public void setReasons(List<ApplicationReasonBO> reasons) {
        this.reasons = reasons;
    }
}

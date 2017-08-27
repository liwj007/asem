package com.liwj.asem.bo;

import java.util.List;

public class EntireApplicationForm {
    private Long id;
    private List<Long> prizeIds;
    private List<FileBO> files;
    private String evaluation;
    private List<ApplicationReasonBO> reasons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getPrizeIds() {
        return prizeIds;
    }

    public void setPrizeIds(List<Long> prizeIds) {
        this.prizeIds = prizeIds;
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

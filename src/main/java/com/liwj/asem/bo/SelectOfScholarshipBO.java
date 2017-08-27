package com.liwj.asem.bo;

import java.util.ArrayList;
import java.util.List;

public class SelectOfScholarshipBO {
    private Long id;
    private String name;

    public SelectOfScholarshipBO() {
        prizes = new ArrayList<>();
    }

    private List<SelectOfPrizeBO> prizes;

    public List<SelectOfPrizeBO> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<SelectOfPrizeBO> prizes) {
        this.prizes = prizes;
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
        this.name = name;
    }
}

package com.liwj.asem.bo;

import com.liwj.asem.enums.AllocationMethodEnum;
import com.liwj.asem.enums.AllocationRuleEnum;

import java.util.ArrayList;
import java.util.List;

public class EntireUnitPrizeForm {
    private AllocationRuleEnum allocationRule;
    private AllocationMethodEnum allocationMethod;
    private Integer restNumber;
    private String unitType;
    private Integer number;

    private Long id;
    private String scholarshipName;
    private String prizeName;
    private List<UnitPrizeBO> list;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public EntireUnitPrizeForm() {
        list = new ArrayList<>();
    }

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


    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Integer getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(Integer restNumber) {
        this.restNumber = restNumber;
    }

    public AllocationRuleEnum getAllocationRule() {
        return allocationRule;
    }

    public void setAllocationRule(AllocationRuleEnum allocationRule) {
        this.allocationRule = allocationRule;
    }

    public AllocationMethodEnum getAllocationMethod() {
        return allocationMethod;
    }

    public void setAllocationMethod(AllocationMethodEnum allocationMethod) {
        this.allocationMethod = allocationMethod;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public List<UnitPrizeBO> getList() {
        return list;
    }

    public void setList(List<UnitPrizeBO> list) {
        this.list = list;
    }
}

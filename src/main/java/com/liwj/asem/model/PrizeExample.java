package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.List;

public class PrizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrizeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdIsNull() {
            addCriterion("parent_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdIsNotNull() {
            addCriterion("parent_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdEqualTo(Long value) {
            addCriterion("parent_prize_id =", value, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdNotEqualTo(Long value) {
            addCriterion("parent_prize_id <>", value, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdGreaterThan(Long value) {
            addCriterion("parent_prize_id >", value, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_prize_id >=", value, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdLessThan(Long value) {
            addCriterion("parent_prize_id <", value, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_prize_id <=", value, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdIn(List<Long> values) {
            addCriterion("parent_prize_id in", values, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdNotIn(List<Long> values) {
            addCriterion("parent_prize_id not in", values, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdBetween(Long value1, Long value2) {
            addCriterion("parent_prize_id between", value1, value2, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andParentPrizeIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_prize_id not between", value1, value2, "parentPrizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNull() {
            addCriterion("prize_name is null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNotNull() {
            addCriterion("prize_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameEqualTo(String value) {
            addCriterion("prize_name =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(String value) {
            addCriterion("prize_name <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(String value) {
            addCriterion("prize_name >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("prize_name >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(String value) {
            addCriterion("prize_name <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(String value) {
            addCriterion("prize_name <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLike(String value) {
            addCriterion("prize_name like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotLike(String value) {
            addCriterion("prize_name not like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<String> values) {
            addCriterion("prize_name in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<String> values) {
            addCriterion("prize_name not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(String value1, String value2) {
            addCriterion("prize_name between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(String value1, String value2) {
            addCriterion("prize_name not between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdIsNull() {
            addCriterion("scholarship_id is null");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdIsNotNull() {
            addCriterion("scholarship_id is not null");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdEqualTo(Long value) {
            addCriterion("scholarship_id =", value, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdNotEqualTo(Long value) {
            addCriterion("scholarship_id <>", value, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdGreaterThan(Long value) {
            addCriterion("scholarship_id >", value, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdGreaterThanOrEqualTo(Long value) {
            addCriterion("scholarship_id >=", value, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdLessThan(Long value) {
            addCriterion("scholarship_id <", value, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdLessThanOrEqualTo(Long value) {
            addCriterion("scholarship_id <=", value, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdIn(List<Long> values) {
            addCriterion("scholarship_id in", values, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdNotIn(List<Long> values) {
            addCriterion("scholarship_id not in", values, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdBetween(Long value1, Long value2) {
            addCriterion("scholarship_id between", value1, value2, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipIdNotBetween(Long value1, Long value2) {
            addCriterion("scholarship_id not between", value1, value2, "scholarshipId");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeIsNull() {
            addCriterion("scholarship_type is null");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeIsNotNull() {
            addCriterion("scholarship_type is not null");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeEqualTo(Integer value) {
            addCriterion("scholarship_type =", value, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeNotEqualTo(Integer value) {
            addCriterion("scholarship_type <>", value, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeGreaterThan(Integer value) {
            addCriterion("scholarship_type >", value, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scholarship_type >=", value, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeLessThan(Integer value) {
            addCriterion("scholarship_type <", value, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeLessThanOrEqualTo(Integer value) {
            addCriterion("scholarship_type <=", value, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeIn(List<Integer> values) {
            addCriterion("scholarship_type in", values, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeNotIn(List<Integer> values) {
            addCriterion("scholarship_type not in", values, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeBetween(Integer value1, Integer value2) {
            addCriterion("scholarship_type between", value1, value2, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andScholarshipTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("scholarship_type not between", value1, value2, "scholarshipType");
            return (Criteria) this;
        }

        public Criteria andRestNumberIsNull() {
            addCriterion("rest_number is null");
            return (Criteria) this;
        }

        public Criteria andRestNumberIsNotNull() {
            addCriterion("rest_number is not null");
            return (Criteria) this;
        }

        public Criteria andRestNumberEqualTo(Integer value) {
            addCriterion("rest_number =", value, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberNotEqualTo(Integer value) {
            addCriterion("rest_number <>", value, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberGreaterThan(Integer value) {
            addCriterion("rest_number >", value, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("rest_number >=", value, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberLessThan(Integer value) {
            addCriterion("rest_number <", value, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberLessThanOrEqualTo(Integer value) {
            addCriterion("rest_number <=", value, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberIn(List<Integer> values) {
            addCriterion("rest_number in", values, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberNotIn(List<Integer> values) {
            addCriterion("rest_number not in", values, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberBetween(Integer value1, Integer value2) {
            addCriterion("rest_number between", value1, value2, "restNumber");
            return (Criteria) this;
        }

        public Criteria andRestNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("rest_number not between", value1, value2, "restNumber");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleIsNull() {
            addCriterion("allocation_rule is null");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleIsNotNull() {
            addCriterion("allocation_rule is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleEqualTo(Integer value) {
            addCriterion("allocation_rule =", value, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleNotEqualTo(Integer value) {
            addCriterion("allocation_rule <>", value, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleGreaterThan(Integer value) {
            addCriterion("allocation_rule >", value, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("allocation_rule >=", value, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleLessThan(Integer value) {
            addCriterion("allocation_rule <", value, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleLessThanOrEqualTo(Integer value) {
            addCriterion("allocation_rule <=", value, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleIn(List<Integer> values) {
            addCriterion("allocation_rule in", values, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleNotIn(List<Integer> values) {
            addCriterion("allocation_rule not in", values, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleBetween(Integer value1, Integer value2) {
            addCriterion("allocation_rule between", value1, value2, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("allocation_rule not between", value1, value2, "allocationRule");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodIsNull() {
            addCriterion("allocation_method is null");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodIsNotNull() {
            addCriterion("allocation_method is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodEqualTo(Integer value) {
            addCriterion("allocation_method =", value, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodNotEqualTo(Integer value) {
            addCriterion("allocation_method <>", value, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodGreaterThan(Integer value) {
            addCriterion("allocation_method >", value, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("allocation_method >=", value, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodLessThan(Integer value) {
            addCriterion("allocation_method <", value, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodLessThanOrEqualTo(Integer value) {
            addCriterion("allocation_method <=", value, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodIn(List<Integer> values) {
            addCriterion("allocation_method in", values, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodNotIn(List<Integer> values) {
            addCriterion("allocation_method not in", values, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodBetween(Integer value1, Integer value2) {
            addCriterion("allocation_method between", value1, value2, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("allocation_method not between", value1, value2, "allocationMethod");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusIsNull() {
            addCriterion("allocation_number_status is null");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusIsNotNull() {
            addCriterion("allocation_number_status is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusEqualTo(Boolean value) {
            addCriterion("allocation_number_status =", value, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusNotEqualTo(Boolean value) {
            addCriterion("allocation_number_status <>", value, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusGreaterThan(Boolean value) {
            addCriterion("allocation_number_status >", value, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allocation_number_status >=", value, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusLessThan(Boolean value) {
            addCriterion("allocation_number_status <", value, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("allocation_number_status <=", value, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusIn(List<Boolean> values) {
            addCriterion("allocation_number_status in", values, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusNotIn(List<Boolean> values) {
            addCriterion("allocation_number_status not in", values, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("allocation_number_status between", value1, value2, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationNumberStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allocation_number_status not between", value1, value2, "allocationNumberStatus");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdIsNull() {
            addCriterion("primary_teaching_institution_id is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdIsNotNull() {
            addCriterion("primary_teaching_institution_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdEqualTo(Long value) {
            addCriterion("primary_teaching_institution_id =", value, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdNotEqualTo(Long value) {
            addCriterion("primary_teaching_institution_id <>", value, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdGreaterThan(Long value) {
            addCriterion("primary_teaching_institution_id >", value, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("primary_teaching_institution_id >=", value, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdLessThan(Long value) {
            addCriterion("primary_teaching_institution_id <", value, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdLessThanOrEqualTo(Long value) {
            addCriterion("primary_teaching_institution_id <=", value, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdIn(List<Long> values) {
            addCriterion("primary_teaching_institution_id in", values, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdNotIn(List<Long> values) {
            addCriterion("primary_teaching_institution_id not in", values, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdBetween(Long value1, Long value2) {
            addCriterion("primary_teaching_institution_id between", value1, value2, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andPrimaryTeachingInstitutionIdNotBetween(Long value1, Long value2) {
            addCriterion("primary_teaching_institution_id not between", value1, value2, "primaryTeachingInstitutionId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNull() {
            addCriterion("grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Long value) {
            addCriterion("grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Long value) {
            addCriterion("grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Long value) {
            addCriterion("grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Long value) {
            addCriterion("grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Long> values) {
            addCriterion("grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Long> values) {
            addCriterion("grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Long value1, Long value2) {
            addCriterion("grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("grade_id not between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andIsRootIsNull() {
            addCriterion("is_root is null");
            return (Criteria) this;
        }

        public Criteria andIsRootIsNotNull() {
            addCriterion("is_root is not null");
            return (Criteria) this;
        }

        public Criteria andIsRootEqualTo(Boolean value) {
            addCriterion("is_root =", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotEqualTo(Boolean value) {
            addCriterion("is_root <>", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootGreaterThan(Boolean value) {
            addCriterion("is_root >", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_root >=", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootLessThan(Boolean value) {
            addCriterion("is_root <", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootLessThanOrEqualTo(Boolean value) {
            addCriterion("is_root <=", value, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootIn(List<Boolean> values) {
            addCriterion("is_root in", values, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotIn(List<Boolean> values) {
            addCriterion("is_root not in", values, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootBetween(Boolean value1, Boolean value2) {
            addCriterion("is_root between", value1, value2, "isRoot");
            return (Criteria) this;
        }

        public Criteria andIsRootNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_root not between", value1, value2, "isRoot");
            return (Criteria) this;
        }

        public Criteria andLevelNumberIsNull() {
            addCriterion("level_number is null");
            return (Criteria) this;
        }

        public Criteria andLevelNumberIsNotNull() {
            addCriterion("level_number is not null");
            return (Criteria) this;
        }

        public Criteria andLevelNumberEqualTo(Integer value) {
            addCriterion("level_number =", value, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberNotEqualTo(Integer value) {
            addCriterion("level_number <>", value, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberGreaterThan(Integer value) {
            addCriterion("level_number >", value, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_number >=", value, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberLessThan(Integer value) {
            addCriterion("level_number <", value, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberLessThanOrEqualTo(Integer value) {
            addCriterion("level_number <=", value, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberIn(List<Integer> values) {
            addCriterion("level_number in", values, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberNotIn(List<Integer> values) {
            addCriterion("level_number not in", values, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberBetween(Integer value1, Integer value2) {
            addCriterion("level_number between", value1, value2, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andLevelNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("level_number not between", value1, value2, "levelNumber");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusIsNull() {
            addCriterion("allocation_college_time_status is null");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusIsNotNull() {
            addCriterion("allocation_college_time_status is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusEqualTo(Boolean value) {
            addCriterion("allocation_college_time_status =", value, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusNotEqualTo(Boolean value) {
            addCriterion("allocation_college_time_status <>", value, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusGreaterThan(Boolean value) {
            addCriterion("allocation_college_time_status >", value, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allocation_college_time_status >=", value, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusLessThan(Boolean value) {
            addCriterion("allocation_college_time_status <", value, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("allocation_college_time_status <=", value, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusIn(List<Boolean> values) {
            addCriterion("allocation_college_time_status in", values, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusNotIn(List<Boolean> values) {
            addCriterion("allocation_college_time_status not in", values, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("allocation_college_time_status between", value1, value2, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationCollegeTimeStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allocation_college_time_status not between", value1, value2, "allocationCollegeTimeStatus");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLikeInsensitive(String value) {
            addCriterion("upper(prize_name) like", value.toUpperCase(), "prizeName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
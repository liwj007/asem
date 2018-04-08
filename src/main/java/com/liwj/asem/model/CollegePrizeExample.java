package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollegePrizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollegePrizeExample() {
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

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(Long value) {
            addCriterion("college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(Long value) {
            addCriterion("college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(Long value) {
            addCriterion("college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(Long value) {
            addCriterion("college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(Long value) {
            addCriterion("college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<Long> values) {
            addCriterion("college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<Long> values) {
            addCriterion("college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(Long value1, Long value2) {
            addCriterion("college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(Long value1, Long value2) {
            addCriterion("college_id not between", value1, value2, "collegeId");
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

        public Criteria andPrizeInfoIdIsNull() {
            addCriterion("prize_info_id is null");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdIsNotNull() {
            addCriterion("prize_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdEqualTo(Long value) {
            addCriterion("prize_info_id =", value, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdNotEqualTo(Long value) {
            addCriterion("prize_info_id <>", value, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdGreaterThan(Long value) {
            addCriterion("prize_info_id >", value, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("prize_info_id >=", value, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdLessThan(Long value) {
            addCriterion("prize_info_id <", value, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("prize_info_id <=", value, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdIn(List<Long> values) {
            addCriterion("prize_info_id in", values, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdNotIn(List<Long> values) {
            addCriterion("prize_info_id not in", values, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdBetween(Long value1, Long value2) {
            addCriterion("prize_info_id between", value1, value2, "prizeInfoId");
            return (Criteria) this;
        }

        public Criteria andPrizeInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("prize_info_id not between", value1, value2, "prizeInfoId");
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

        public Criteria andSchoolPrizeIdIsNull() {
            addCriterion("school_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdIsNotNull() {
            addCriterion("school_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdEqualTo(Long value) {
            addCriterion("school_prize_id =", value, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdNotEqualTo(Long value) {
            addCriterion("school_prize_id <>", value, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdGreaterThan(Long value) {
            addCriterion("school_prize_id >", value, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("school_prize_id >=", value, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdLessThan(Long value) {
            addCriterion("school_prize_id <", value, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdLessThanOrEqualTo(Long value) {
            addCriterion("school_prize_id <=", value, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdIn(List<Long> values) {
            addCriterion("school_prize_id in", values, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdNotIn(List<Long> values) {
            addCriterion("school_prize_id not in", values, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdBetween(Long value1, Long value2) {
            addCriterion("school_prize_id between", value1, value2, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSchoolPrizeIdNotBetween(Long value1, Long value2) {
            addCriterion("school_prize_id not between", value1, value2, "schoolPrizeId");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIsNull() {
            addCriterion("submit_status is null");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIsNotNull() {
            addCriterion("submit_status is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusEqualTo(Boolean value) {
            addCriterion("submit_status =", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotEqualTo(Boolean value) {
            addCriterion("submit_status <>", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusGreaterThan(Boolean value) {
            addCriterion("submit_status >", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("submit_status >=", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusLessThan(Boolean value) {
            addCriterion("submit_status <", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("submit_status <=", value, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusIn(List<Boolean> values) {
            addCriterion("submit_status in", values, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotIn(List<Boolean> values) {
            addCriterion("submit_status not in", values, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("submit_status between", value1, value2, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andSubmitStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("submit_status not between", value1, value2, "submitStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNull() {
            addCriterion("apply_status is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(Boolean value) {
            addCriterion("apply_status =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(Boolean value) {
            addCriterion("apply_status <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(Boolean value) {
            addCriterion("apply_status >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("apply_status >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(Boolean value) {
            addCriterion("apply_status <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("apply_status <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<Boolean> values) {
            addCriterion("apply_status in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<Boolean> values) {
            addCriterion("apply_status not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("apply_status between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("apply_status not between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateIsNull() {
            addCriterion("allocation_date is null");
            return (Criteria) this;
        }

        public Criteria andAllocationDateIsNotNull() {
            addCriterion("allocation_date is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationDateEqualTo(Date value) {
            addCriterion("allocation_date =", value, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateNotEqualTo(Date value) {
            addCriterion("allocation_date <>", value, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateGreaterThan(Date value) {
            addCriterion("allocation_date >", value, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("allocation_date >=", value, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateLessThan(Date value) {
            addCriterion("allocation_date <", value, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateLessThanOrEqualTo(Date value) {
            addCriterion("allocation_date <=", value, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateIn(List<Date> values) {
            addCriterion("allocation_date in", values, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateNotIn(List<Date> values) {
            addCriterion("allocation_date not in", values, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateBetween(Date value1, Date value2) {
            addCriterion("allocation_date between", value1, value2, "allocationDate");
            return (Criteria) this;
        }

        public Criteria andAllocationDateNotBetween(Date value1, Date value2) {
            addCriterion("allocation_date not between", value1, value2, "allocationDate");
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
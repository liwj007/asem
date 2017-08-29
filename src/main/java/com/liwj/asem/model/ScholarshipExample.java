package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScholarshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScholarshipExample() {
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

        public Criteria andFlowTemplateIdIsNull() {
            addCriterion("flow_template_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdIsNotNull() {
            addCriterion("flow_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdEqualTo(Long value) {
            addCriterion("flow_template_id =", value, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdNotEqualTo(Long value) {
            addCriterion("flow_template_id <>", value, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdGreaterThan(Long value) {
            addCriterion("flow_template_id >", value, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("flow_template_id >=", value, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdLessThan(Long value) {
            addCriterion("flow_template_id <", value, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("flow_template_id <=", value, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdIn(List<Long> values) {
            addCriterion("flow_template_id in", values, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdNotIn(List<Long> values) {
            addCriterion("flow_template_id not in", values, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdBetween(Long value1, Long value2) {
            addCriterion("flow_template_id between", value1, value2, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andFlowTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("flow_template_id not between", value1, value2, "flowTemplateId");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNull() {
            addCriterion("requirement is null");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNotNull() {
            addCriterion("requirement is not null");
            return (Criteria) this;
        }

        public Criteria andRequirementEqualTo(String value) {
            addCriterion("requirement =", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotEqualTo(String value) {
            addCriterion("requirement <>", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThan(String value) {
            addCriterion("requirement >", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("requirement >=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThan(String value) {
            addCriterion("requirement <", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThanOrEqualTo(String value) {
            addCriterion("requirement <=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLike(String value) {
            addCriterion("requirement like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotLike(String value) {
            addCriterion("requirement not like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementIn(List<String> values) {
            addCriterion("requirement in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotIn(List<String> values) {
            addCriterion("requirement not in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementBetween(String value1, String value2) {
            addCriterion("requirement between", value1, value2, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotBetween(String value1, String value2) {
            addCriterion("requirement not between", value1, value2, "requirement");
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

        public Criteria andScholarshipNameIsNull() {
            addCriterion("scholarship_name is null");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameIsNotNull() {
            addCriterion("scholarship_name is not null");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameEqualTo(String value) {
            addCriterion("scholarship_name =", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameNotEqualTo(String value) {
            addCriterion("scholarship_name <>", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameGreaterThan(String value) {
            addCriterion("scholarship_name >", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameGreaterThanOrEqualTo(String value) {
            addCriterion("scholarship_name >=", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameLessThan(String value) {
            addCriterion("scholarship_name <", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameLessThanOrEqualTo(String value) {
            addCriterion("scholarship_name <=", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameLike(String value) {
            addCriterion("scholarship_name like", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameNotLike(String value) {
            addCriterion("scholarship_name not like", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameIn(List<String> values) {
            addCriterion("scholarship_name in", values, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameNotIn(List<String> values) {
            addCriterion("scholarship_name not in", values, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameBetween(String value1, String value2) {
            addCriterion("scholarship_name between", value1, value2, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameNotBetween(String value1, String value2) {
            addCriterion("scholarship_name not between", value1, value2, "scholarshipName");
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

        public Criteria andPrizeTypeIsNull() {
            addCriterion("prize_type is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(Integer value) {
            addCriterion("prize_type =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(Integer value) {
            addCriterion("prize_type <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(Integer value) {
            addCriterion("prize_type >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_type >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(Integer value) {
            addCriterion("prize_type <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("prize_type <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<Integer> values) {
            addCriterion("prize_type in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<Integer> values) {
            addCriterion("prize_type not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(Integer value1, Integer value2) {
            addCriterion("prize_type between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_type not between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusIsNull() {
            addCriterion("allocation_time_status is null");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusIsNotNull() {
            addCriterion("allocation_time_status is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusEqualTo(Boolean value) {
            addCriterion("allocation_time_status =", value, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusNotEqualTo(Boolean value) {
            addCriterion("allocation_time_status <>", value, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusGreaterThan(Boolean value) {
            addCriterion("allocation_time_status >", value, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allocation_time_status >=", value, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusLessThan(Boolean value) {
            addCriterion("allocation_time_status <", value, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("allocation_time_status <=", value, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusIn(List<Boolean> values) {
            addCriterion("allocation_time_status in", values, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusNotIn(List<Boolean> values) {
            addCriterion("allocation_time_status not in", values, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("allocation_time_status between", value1, value2, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andAllocationTimeStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allocation_time_status not between", value1, value2, "allocationTimeStatus");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckIsNull() {
            addCriterion("need_grade_check is null");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckIsNotNull() {
            addCriterion("need_grade_check is not null");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckEqualTo(Boolean value) {
            addCriterion("need_grade_check =", value, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckNotEqualTo(Boolean value) {
            addCriterion("need_grade_check <>", value, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckGreaterThan(Boolean value) {
            addCriterion("need_grade_check >", value, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_grade_check >=", value, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckLessThan(Boolean value) {
            addCriterion("need_grade_check <", value, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckLessThanOrEqualTo(Boolean value) {
            addCriterion("need_grade_check <=", value, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckIn(List<Boolean> values) {
            addCriterion("need_grade_check in", values, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckNotIn(List<Boolean> values) {
            addCriterion("need_grade_check not in", values, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckBetween(Boolean value1, Boolean value2) {
            addCriterion("need_grade_check between", value1, value2, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andNeedGradeCheckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_grade_check not between", value1, value2, "needGradeCheck");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateIsNull() {
            addCriterion("student_begin_date is null");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateIsNotNull() {
            addCriterion("student_begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateEqualTo(Date value) {
            addCriterion("student_begin_date =", value, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateNotEqualTo(Date value) {
            addCriterion("student_begin_date <>", value, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateGreaterThan(Date value) {
            addCriterion("student_begin_date >", value, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("student_begin_date >=", value, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateLessThan(Date value) {
            addCriterion("student_begin_date <", value, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("student_begin_date <=", value, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateIn(List<Date> values) {
            addCriterion("student_begin_date in", values, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateNotIn(List<Date> values) {
            addCriterion("student_begin_date not in", values, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateBetween(Date value1, Date value2) {
            addCriterion("student_begin_date between", value1, value2, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andStudentBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("student_begin_date not between", value1, value2, "studentBeginDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateIsNull() {
            addCriterion("college_end_date is null");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateIsNotNull() {
            addCriterion("college_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateEqualTo(Date value) {
            addCriterion("college_end_date =", value, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateNotEqualTo(Date value) {
            addCriterion("college_end_date <>", value, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateGreaterThan(Date value) {
            addCriterion("college_end_date >", value, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("college_end_date >=", value, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateLessThan(Date value) {
            addCriterion("college_end_date <", value, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateLessThanOrEqualTo(Date value) {
            addCriterion("college_end_date <=", value, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateIn(List<Date> values) {
            addCriterion("college_end_date in", values, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateNotIn(List<Date> values) {
            addCriterion("college_end_date not in", values, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateBetween(Date value1, Date value2) {
            addCriterion("college_end_date between", value1, value2, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andCollegeEndDateNotBetween(Date value1, Date value2) {
            addCriterion("college_end_date not between", value1, value2, "collegeEndDate");
            return (Criteria) this;
        }

        public Criteria andRequirementLikeInsensitive(String value) {
            addCriterion("upper(requirement) like", value.toUpperCase(), "requirement");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameLikeInsensitive(String value) {
            addCriterion("upper(scholarship_name) like", value.toUpperCase(), "scholarshipName");
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
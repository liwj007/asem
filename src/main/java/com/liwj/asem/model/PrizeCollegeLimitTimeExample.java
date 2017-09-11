package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrizeCollegeLimitTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrizeCollegeLimitTimeExample() {
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

        public Criteria andStudentEndDateIsNull() {
            addCriterion("student_end_date is null");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateIsNotNull() {
            addCriterion("student_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateEqualTo(Date value) {
            addCriterion("student_end_date =", value, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateNotEqualTo(Date value) {
            addCriterion("student_end_date <>", value, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateGreaterThan(Date value) {
            addCriterion("student_end_date >", value, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("student_end_date >=", value, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateLessThan(Date value) {
            addCriterion("student_end_date <", value, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateLessThanOrEqualTo(Date value) {
            addCriterion("student_end_date <=", value, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateIn(List<Date> values) {
            addCriterion("student_end_date in", values, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateNotIn(List<Date> values) {
            addCriterion("student_end_date not in", values, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateBetween(Date value1, Date value2) {
            addCriterion("student_end_date between", value1, value2, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andStudentEndDateNotBetween(Date value1, Date value2) {
            addCriterion("student_end_date not between", value1, value2, "studentEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateIsNull() {
            addCriterion("grade_end_date is null");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateIsNotNull() {
            addCriterion("grade_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateEqualTo(Date value) {
            addCriterion("grade_end_date =", value, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateNotEqualTo(Date value) {
            addCriterion("grade_end_date <>", value, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateGreaterThan(Date value) {
            addCriterion("grade_end_date >", value, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("grade_end_date >=", value, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateLessThan(Date value) {
            addCriterion("grade_end_date <", value, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateLessThanOrEqualTo(Date value) {
            addCriterion("grade_end_date <=", value, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateIn(List<Date> values) {
            addCriterion("grade_end_date in", values, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateNotIn(List<Date> values) {
            addCriterion("grade_end_date not in", values, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateBetween(Date value1, Date value2) {
            addCriterion("grade_end_date between", value1, value2, "gradeEndDate");
            return (Criteria) this;
        }

        public Criteria andGradeEndDateNotBetween(Date value1, Date value2) {
            addCriterion("grade_end_date not between", value1, value2, "gradeEndDate");
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
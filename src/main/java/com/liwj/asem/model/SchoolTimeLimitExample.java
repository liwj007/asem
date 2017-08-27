package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchoolTimeLimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchoolTimeLimitExample() {
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
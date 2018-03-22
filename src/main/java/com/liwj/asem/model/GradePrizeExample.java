package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GradePrizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradePrizeExample() {
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

        public Criteria andCollegePrizeIdIsNull() {
            addCriterion("college_prize_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdIsNotNull() {
            addCriterion("college_prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdEqualTo(Long value) {
            addCriterion("college_prize_id =", value, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdNotEqualTo(Long value) {
            addCriterion("college_prize_id <>", value, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdGreaterThan(Long value) {
            addCriterion("college_prize_id >", value, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("college_prize_id >=", value, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdLessThan(Long value) {
            addCriterion("college_prize_id <", value, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdLessThanOrEqualTo(Long value) {
            addCriterion("college_prize_id <=", value, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdIn(List<Long> values) {
            addCriterion("college_prize_id in", values, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdNotIn(List<Long> values) {
            addCriterion("college_prize_id not in", values, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdBetween(Long value1, Long value2) {
            addCriterion("college_prize_id between", value1, value2, "collegePrizeId");
            return (Criteria) this;
        }

        public Criteria andCollegePrizeIdNotBetween(Long value1, Long value2) {
            addCriterion("college_prize_id not between", value1, value2, "collegePrizeId");
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
package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublicityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PublicityExample() {
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

        public Criteria andScholarshipNameIsNull() {
            addCriterion("scholarship_name is null");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameIsNotNull() {
            addCriterion("scholarship_name is not null");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameEqualTo(Boolean value) {
            addCriterion("scholarship_name =", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameNotEqualTo(Boolean value) {
            addCriterion("scholarship_name <>", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameGreaterThan(Boolean value) {
            addCriterion("scholarship_name >", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameGreaterThanOrEqualTo(Boolean value) {
            addCriterion("scholarship_name >=", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameLessThan(Boolean value) {
            addCriterion("scholarship_name <", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameLessThanOrEqualTo(Boolean value) {
            addCriterion("scholarship_name <=", value, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameIn(List<Boolean> values) {
            addCriterion("scholarship_name in", values, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameNotIn(List<Boolean> values) {
            addCriterion("scholarship_name not in", values, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameBetween(Boolean value1, Boolean value2) {
            addCriterion("scholarship_name between", value1, value2, "scholarshipName");
            return (Criteria) this;
        }

        public Criteria andScholarshipNameNotBetween(Boolean value1, Boolean value2) {
            addCriterion("scholarship_name not between", value1, value2, "scholarshipName");
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

        public Criteria andPrizeNameEqualTo(Boolean value) {
            addCriterion("prize_name =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(Boolean value) {
            addCriterion("prize_name <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(Boolean value) {
            addCriterion("prize_name >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(Boolean value) {
            addCriterion("prize_name >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(Boolean value) {
            addCriterion("prize_name <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(Boolean value) {
            addCriterion("prize_name <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<Boolean> values) {
            addCriterion("prize_name in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<Boolean> values) {
            addCriterion("prize_name not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(Boolean value1, Boolean value2) {
            addCriterion("prize_name between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(Boolean value1, Boolean value2) {
            addCriterion("prize_name not between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andNeedNameIsNull() {
            addCriterion("need_name is null");
            return (Criteria) this;
        }

        public Criteria andNeedNameIsNotNull() {
            addCriterion("need_name is not null");
            return (Criteria) this;
        }

        public Criteria andNeedNameEqualTo(Boolean value) {
            addCriterion("need_name =", value, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameNotEqualTo(Boolean value) {
            addCriterion("need_name <>", value, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameGreaterThan(Boolean value) {
            addCriterion("need_name >", value, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_name >=", value, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameLessThan(Boolean value) {
            addCriterion("need_name <", value, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameLessThanOrEqualTo(Boolean value) {
            addCriterion("need_name <=", value, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameIn(List<Boolean> values) {
            addCriterion("need_name in", values, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameNotIn(List<Boolean> values) {
            addCriterion("need_name not in", values, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameBetween(Boolean value1, Boolean value2) {
            addCriterion("need_name between", value1, value2, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedNameNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_name not between", value1, value2, "needName");
            return (Criteria) this;
        }

        public Criteria andNeedSnIsNull() {
            addCriterion("need_sn is null");
            return (Criteria) this;
        }

        public Criteria andNeedSnIsNotNull() {
            addCriterion("need_sn is not null");
            return (Criteria) this;
        }

        public Criteria andNeedSnEqualTo(Boolean value) {
            addCriterion("need_sn =", value, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnNotEqualTo(Boolean value) {
            addCriterion("need_sn <>", value, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnGreaterThan(Boolean value) {
            addCriterion("need_sn >", value, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_sn >=", value, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnLessThan(Boolean value) {
            addCriterion("need_sn <", value, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnLessThanOrEqualTo(Boolean value) {
            addCriterion("need_sn <=", value, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnIn(List<Boolean> values) {
            addCriterion("need_sn in", values, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnNotIn(List<Boolean> values) {
            addCriterion("need_sn not in", values, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnBetween(Boolean value1, Boolean value2) {
            addCriterion("need_sn between", value1, value2, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedSnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_sn not between", value1, value2, "needSn");
            return (Criteria) this;
        }

        public Criteria andNeedClassesIsNull() {
            addCriterion("need_classes is null");
            return (Criteria) this;
        }

        public Criteria andNeedClassesIsNotNull() {
            addCriterion("need_classes is not null");
            return (Criteria) this;
        }

        public Criteria andNeedClassesEqualTo(Boolean value) {
            addCriterion("need_classes =", value, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesNotEqualTo(Boolean value) {
            addCriterion("need_classes <>", value, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesGreaterThan(Boolean value) {
            addCriterion("need_classes >", value, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_classes >=", value, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesLessThan(Boolean value) {
            addCriterion("need_classes <", value, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesLessThanOrEqualTo(Boolean value) {
            addCriterion("need_classes <=", value, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesIn(List<Boolean> values) {
            addCriterion("need_classes in", values, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesNotIn(List<Boolean> values) {
            addCriterion("need_classes not in", values, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesBetween(Boolean value1, Boolean value2) {
            addCriterion("need_classes between", value1, value2, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedClassesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_classes not between", value1, value2, "needClasses");
            return (Criteria) this;
        }

        public Criteria andNeedGradeIsNull() {
            addCriterion("need_grade is null");
            return (Criteria) this;
        }

        public Criteria andNeedGradeIsNotNull() {
            addCriterion("need_grade is not null");
            return (Criteria) this;
        }

        public Criteria andNeedGradeEqualTo(Boolean value) {
            addCriterion("need_grade =", value, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeNotEqualTo(Boolean value) {
            addCriterion("need_grade <>", value, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeGreaterThan(Boolean value) {
            addCriterion("need_grade >", value, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_grade >=", value, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeLessThan(Boolean value) {
            addCriterion("need_grade <", value, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeLessThanOrEqualTo(Boolean value) {
            addCriterion("need_grade <=", value, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeIn(List<Boolean> values) {
            addCriterion("need_grade in", values, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeNotIn(List<Boolean> values) {
            addCriterion("need_grade not in", values, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeBetween(Boolean value1, Boolean value2) {
            addCriterion("need_grade between", value1, value2, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedGradeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_grade not between", value1, value2, "needGrade");
            return (Criteria) this;
        }

        public Criteria andNeedMajorIsNull() {
            addCriterion("need_major is null");
            return (Criteria) this;
        }

        public Criteria andNeedMajorIsNotNull() {
            addCriterion("need_major is not null");
            return (Criteria) this;
        }

        public Criteria andNeedMajorEqualTo(Boolean value) {
            addCriterion("need_major =", value, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorNotEqualTo(Boolean value) {
            addCriterion("need_major <>", value, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorGreaterThan(Boolean value) {
            addCriterion("need_major >", value, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_major >=", value, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorLessThan(Boolean value) {
            addCriterion("need_major <", value, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorLessThanOrEqualTo(Boolean value) {
            addCriterion("need_major <=", value, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorIn(List<Boolean> values) {
            addCriterion("need_major in", values, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorNotIn(List<Boolean> values) {
            addCriterion("need_major not in", values, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorBetween(Boolean value1, Boolean value2) {
            addCriterion("need_major between", value1, value2, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedMajorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_major not between", value1, value2, "needMajor");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeIsNull() {
            addCriterion("need_college is null");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeIsNotNull() {
            addCriterion("need_college is not null");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeEqualTo(Boolean value) {
            addCriterion("need_college =", value, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeNotEqualTo(Boolean value) {
            addCriterion("need_college <>", value, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeGreaterThan(Boolean value) {
            addCriterion("need_college >", value, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_college >=", value, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeLessThan(Boolean value) {
            addCriterion("need_college <", value, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeLessThanOrEqualTo(Boolean value) {
            addCriterion("need_college <=", value, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeIn(List<Boolean> values) {
            addCriterion("need_college in", values, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeNotIn(List<Boolean> values) {
            addCriterion("need_college not in", values, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeBetween(Boolean value1, Boolean value2) {
            addCriterion("need_college between", value1, value2, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedCollegeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_college not between", value1, value2, "needCollege");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberIsNull() {
            addCriterion("need_prize_number is null");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberIsNotNull() {
            addCriterion("need_prize_number is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberEqualTo(Boolean value) {
            addCriterion("need_prize_number =", value, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberNotEqualTo(Boolean value) {
            addCriterion("need_prize_number <>", value, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberGreaterThan(Boolean value) {
            addCriterion("need_prize_number >", value, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_prize_number >=", value, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberLessThan(Boolean value) {
            addCriterion("need_prize_number <", value, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberLessThanOrEqualTo(Boolean value) {
            addCriterion("need_prize_number <=", value, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberIn(List<Boolean> values) {
            addCriterion("need_prize_number in", values, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberNotIn(List<Boolean> values) {
            addCriterion("need_prize_number not in", values, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberBetween(Boolean value1, Boolean value2) {
            addCriterion("need_prize_number between", value1, value2, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedPrizeNumberNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_prize_number not between", value1, value2, "needPrizeNumber");
            return (Criteria) this;
        }

        public Criteria andNeedFilesIsNull() {
            addCriterion("need_files is null");
            return (Criteria) this;
        }

        public Criteria andNeedFilesIsNotNull() {
            addCriterion("need_files is not null");
            return (Criteria) this;
        }

        public Criteria andNeedFilesEqualTo(Boolean value) {
            addCriterion("need_files =", value, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesNotEqualTo(Boolean value) {
            addCriterion("need_files <>", value, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesGreaterThan(Boolean value) {
            addCriterion("need_files >", value, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_files >=", value, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesLessThan(Boolean value) {
            addCriterion("need_files <", value, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesLessThanOrEqualTo(Boolean value) {
            addCriterion("need_files <=", value, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesIn(List<Boolean> values) {
            addCriterion("need_files in", values, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesNotIn(List<Boolean> values) {
            addCriterion("need_files not in", values, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesBetween(Boolean value1, Boolean value2) {
            addCriterion("need_files between", value1, value2, "needFiles");
            return (Criteria) this;
        }

        public Criteria andNeedFilesNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_files not between", value1, value2, "needFiles");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
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
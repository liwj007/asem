package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.List;

public class ComprehensiveEvaluationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComprehensiveEvaluationExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("no is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("no is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("no =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("no <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("no >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("no >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("no <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("no <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("no like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("no not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("no in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("no not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("no between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("no not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andMajorNumberIsNull() {
            addCriterion("major_number is null");
            return (Criteria) this;
        }

        public Criteria andMajorNumberIsNotNull() {
            addCriterion("major_number is not null");
            return (Criteria) this;
        }

        public Criteria andMajorNumberEqualTo(Integer value) {
            addCriterion("major_number =", value, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberNotEqualTo(Integer value) {
            addCriterion("major_number <>", value, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberGreaterThan(Integer value) {
            addCriterion("major_number >", value, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_number >=", value, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberLessThan(Integer value) {
            addCriterion("major_number <", value, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberLessThanOrEqualTo(Integer value) {
            addCriterion("major_number <=", value, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberIn(List<Integer> values) {
            addCriterion("major_number in", values, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberNotIn(List<Integer> values) {
            addCriterion("major_number not in", values, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberBetween(Integer value1, Integer value2) {
            addCriterion("major_number between", value1, value2, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andMajorNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("major_number not between", value1, value2, "majorNumber");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreIsNull() {
            addCriterion("composite_score is null");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreIsNotNull() {
            addCriterion("composite_score is not null");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreEqualTo(Double value) {
            addCriterion("composite_score =", value, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreNotEqualTo(Double value) {
            addCriterion("composite_score <>", value, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreGreaterThan(Double value) {
            addCriterion("composite_score >", value, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("composite_score >=", value, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreLessThan(Double value) {
            addCriterion("composite_score <", value, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreLessThanOrEqualTo(Double value) {
            addCriterion("composite_score <=", value, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreIn(List<Double> values) {
            addCriterion("composite_score in", values, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreNotIn(List<Double> values) {
            addCriterion("composite_score not in", values, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreBetween(Double value1, Double value2) {
            addCriterion("composite_score between", value1, value2, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeScoreNotBetween(Double value1, Double value2) {
            addCriterion("composite_score not between", value1, value2, "compositeScore");
            return (Criteria) this;
        }

        public Criteria andCompositeRankIsNull() {
            addCriterion("composite_rank is null");
            return (Criteria) this;
        }

        public Criteria andCompositeRankIsNotNull() {
            addCriterion("composite_rank is not null");
            return (Criteria) this;
        }

        public Criteria andCompositeRankEqualTo(Integer value) {
            addCriterion("composite_rank =", value, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankNotEqualTo(Integer value) {
            addCriterion("composite_rank <>", value, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankGreaterThan(Integer value) {
            addCriterion("composite_rank >", value, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("composite_rank >=", value, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankLessThan(Integer value) {
            addCriterion("composite_rank <", value, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankLessThanOrEqualTo(Integer value) {
            addCriterion("composite_rank <=", value, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankIn(List<Integer> values) {
            addCriterion("composite_rank in", values, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankNotIn(List<Integer> values) {
            addCriterion("composite_rank not in", values, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankBetween(Integer value1, Integer value2) {
            addCriterion("composite_rank between", value1, value2, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andCompositeRankNotBetween(Integer value1, Integer value2) {
            addCriterion("composite_rank not between", value1, value2, "compositeRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreIsNull() {
            addCriterion("intellectual_score is null");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreIsNotNull() {
            addCriterion("intellectual_score is not null");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreEqualTo(Double value) {
            addCriterion("intellectual_score =", value, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreNotEqualTo(Double value) {
            addCriterion("intellectual_score <>", value, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreGreaterThan(Double value) {
            addCriterion("intellectual_score >", value, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("intellectual_score >=", value, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreLessThan(Double value) {
            addCriterion("intellectual_score <", value, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreLessThanOrEqualTo(Double value) {
            addCriterion("intellectual_score <=", value, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreIn(List<Double> values) {
            addCriterion("intellectual_score in", values, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreNotIn(List<Double> values) {
            addCriterion("intellectual_score not in", values, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreBetween(Double value1, Double value2) {
            addCriterion("intellectual_score between", value1, value2, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualScoreNotBetween(Double value1, Double value2) {
            addCriterion("intellectual_score not between", value1, value2, "intellectualScore");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankIsNull() {
            addCriterion("intellectual_rank is null");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankIsNotNull() {
            addCriterion("intellectual_rank is not null");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankEqualTo(Integer value) {
            addCriterion("intellectual_rank =", value, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankNotEqualTo(Integer value) {
            addCriterion("intellectual_rank <>", value, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankGreaterThan(Integer value) {
            addCriterion("intellectual_rank >", value, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("intellectual_rank >=", value, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankLessThan(Integer value) {
            addCriterion("intellectual_rank <", value, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankLessThanOrEqualTo(Integer value) {
            addCriterion("intellectual_rank <=", value, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankIn(List<Integer> values) {
            addCriterion("intellectual_rank in", values, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankNotIn(List<Integer> values) {
            addCriterion("intellectual_rank not in", values, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankBetween(Integer value1, Integer value2) {
            addCriterion("intellectual_rank between", value1, value2, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andIntellectualRankNotBetween(Integer value1, Integer value2) {
            addCriterion("intellectual_rank not between", value1, value2, "intellectualRank");
            return (Criteria) this;
        }

        public Criteria andAcademicYearIsNull() {
            addCriterion("academic_year is null");
            return (Criteria) this;
        }

        public Criteria andAcademicYearIsNotNull() {
            addCriterion("academic_year is not null");
            return (Criteria) this;
        }

        public Criteria andAcademicYearEqualTo(String value) {
            addCriterion("academic_year =", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearNotEqualTo(String value) {
            addCriterion("academic_year <>", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearGreaterThan(String value) {
            addCriterion("academic_year >", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearGreaterThanOrEqualTo(String value) {
            addCriterion("academic_year >=", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearLessThan(String value) {
            addCriterion("academic_year <", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearLessThanOrEqualTo(String value) {
            addCriterion("academic_year <=", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearLike(String value) {
            addCriterion("academic_year like", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearNotLike(String value) {
            addCriterion("academic_year not like", value, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearIn(List<String> values) {
            addCriterion("academic_year in", values, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearNotIn(List<String> values) {
            addCriterion("academic_year not in", values, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearBetween(String value1, String value2) {
            addCriterion("academic_year between", value1, value2, "academicYear");
            return (Criteria) this;
        }

        public Criteria andAcademicYearNotBetween(String value1, String value2) {
            addCriterion("academic_year not between", value1, value2, "academicYear");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNull() {
            addCriterion("college_name is null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNotNull() {
            addCriterion("college_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameEqualTo(String value) {
            addCriterion("college_name =", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotEqualTo(String value) {
            addCriterion("college_name <>", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThan(String value) {
            addCriterion("college_name >", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThanOrEqualTo(String value) {
            addCriterion("college_name >=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThan(String value) {
            addCriterion("college_name <", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThanOrEqualTo(String value) {
            addCriterion("college_name <=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLike(String value) {
            addCriterion("college_name like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotLike(String value) {
            addCriterion("college_name not like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIn(List<String> values) {
            addCriterion("college_name in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotIn(List<String> values) {
            addCriterion("college_name not in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameBetween(String value1, String value2) {
            addCriterion("college_name between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotBetween(String value1, String value2) {
            addCriterion("college_name not between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNull() {
            addCriterion("major_name is null");
            return (Criteria) this;
        }

        public Criteria andMajorNameIsNotNull() {
            addCriterion("major_name is not null");
            return (Criteria) this;
        }

        public Criteria andMajorNameEqualTo(String value) {
            addCriterion("major_name =", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotEqualTo(String value) {
            addCriterion("major_name <>", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThan(String value) {
            addCriterion("major_name >", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameGreaterThanOrEqualTo(String value) {
            addCriterion("major_name >=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThan(String value) {
            addCriterion("major_name <", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLessThanOrEqualTo(String value) {
            addCriterion("major_name <=", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLike(String value) {
            addCriterion("major_name like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotLike(String value) {
            addCriterion("major_name not like", value, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameIn(List<String> values) {
            addCriterion("major_name in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotIn(List<String> values) {
            addCriterion("major_name not in", values, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameBetween(String value1, String value2) {
            addCriterion("major_name between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andMajorNameNotBetween(String value1, String value2) {
            addCriterion("major_name not between", value1, value2, "majorName");
            return (Criteria) this;
        }

        public Criteria andGradeNameIsNull() {
            addCriterion("grade_name is null");
            return (Criteria) this;
        }

        public Criteria andGradeNameIsNotNull() {
            addCriterion("grade_name is not null");
            return (Criteria) this;
        }

        public Criteria andGradeNameEqualTo(String value) {
            addCriterion("grade_name =", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotEqualTo(String value) {
            addCriterion("grade_name <>", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameGreaterThan(String value) {
            addCriterion("grade_name >", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("grade_name >=", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameLessThan(String value) {
            addCriterion("grade_name <", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameLessThanOrEqualTo(String value) {
            addCriterion("grade_name <=", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameLike(String value) {
            addCriterion("grade_name like", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotLike(String value) {
            addCriterion("grade_name not like", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameIn(List<String> values) {
            addCriterion("grade_name in", values, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotIn(List<String> values) {
            addCriterion("grade_name not in", values, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameBetween(String value1, String value2) {
            addCriterion("grade_name between", value1, value2, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotBetween(String value1, String value2) {
            addCriterion("grade_name not between", value1, value2, "gradeName");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andNoLikeInsensitive(String value) {
            addCriterion("upper(no) like", value.toUpperCase(), "no");
            return (Criteria) this;
        }

        public Criteria andAcademicYearLikeInsensitive(String value) {
            addCriterion("upper(academic_year) like", value.toUpperCase(), "academicYear");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLikeInsensitive(String value) {
            addCriterion("upper(college_name) like", value.toUpperCase(), "collegeName");
            return (Criteria) this;
        }

        public Criteria andMajorNameLikeInsensitive(String value) {
            addCriterion("upper(major_name) like", value.toUpperCase(), "majorName");
            return (Criteria) this;
        }

        public Criteria andGradeNameLikeInsensitive(String value) {
            addCriterion("upper(grade_name) like", value.toUpperCase(), "gradeName");
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
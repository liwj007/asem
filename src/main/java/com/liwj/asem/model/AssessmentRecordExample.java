package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.List;

public class AssessmentRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssessmentRecordExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andMaralScoreIsNull() {
            addCriterion("maral_score is null");
            return (Criteria) this;
        }

        public Criteria andMaralScoreIsNotNull() {
            addCriterion("maral_score is not null");
            return (Criteria) this;
        }

        public Criteria andMaralScoreEqualTo(Double value) {
            addCriterion("maral_score =", value, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreNotEqualTo(Double value) {
            addCriterion("maral_score <>", value, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreGreaterThan(Double value) {
            addCriterion("maral_score >", value, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("maral_score >=", value, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreLessThan(Double value) {
            addCriterion("maral_score <", value, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreLessThanOrEqualTo(Double value) {
            addCriterion("maral_score <=", value, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreIn(List<Double> values) {
            addCriterion("maral_score in", values, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreNotIn(List<Double> values) {
            addCriterion("maral_score not in", values, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreBetween(Double value1, Double value2) {
            addCriterion("maral_score between", value1, value2, "maralScore");
            return (Criteria) this;
        }

        public Criteria andMaralScoreNotBetween(Double value1, Double value2) {
            addCriterion("maral_score not between", value1, value2, "maralScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreIsNull() {
            addCriterion("overall_score is null");
            return (Criteria) this;
        }

        public Criteria andOverallScoreIsNotNull() {
            addCriterion("overall_score is not null");
            return (Criteria) this;
        }

        public Criteria andOverallScoreEqualTo(Double value) {
            addCriterion("overall_score =", value, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreNotEqualTo(Double value) {
            addCriterion("overall_score <>", value, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreGreaterThan(Double value) {
            addCriterion("overall_score >", value, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("overall_score >=", value, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreLessThan(Double value) {
            addCriterion("overall_score <", value, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreLessThanOrEqualTo(Double value) {
            addCriterion("overall_score <=", value, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreIn(List<Double> values) {
            addCriterion("overall_score in", values, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreNotIn(List<Double> values) {
            addCriterion("overall_score not in", values, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreBetween(Double value1, Double value2) {
            addCriterion("overall_score between", value1, value2, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallScoreNotBetween(Double value1, Double value2) {
            addCriterion("overall_score not between", value1, value2, "overallScore");
            return (Criteria) this;
        }

        public Criteria andOverallRankIsNull() {
            addCriterion("overall_rank is null");
            return (Criteria) this;
        }

        public Criteria andOverallRankIsNotNull() {
            addCriterion("overall_rank is not null");
            return (Criteria) this;
        }

        public Criteria andOverallRankEqualTo(Integer value) {
            addCriterion("overall_rank =", value, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankNotEqualTo(Integer value) {
            addCriterion("overall_rank <>", value, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankGreaterThan(Integer value) {
            addCriterion("overall_rank >", value, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("overall_rank >=", value, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankLessThan(Integer value) {
            addCriterion("overall_rank <", value, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankLessThanOrEqualTo(Integer value) {
            addCriterion("overall_rank <=", value, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankIn(List<Integer> values) {
            addCriterion("overall_rank in", values, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankNotIn(List<Integer> values) {
            addCriterion("overall_rank not in", values, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankBetween(Integer value1, Integer value2) {
            addCriterion("overall_rank between", value1, value2, "overallRank");
            return (Criteria) this;
        }

        public Criteria andOverallRankNotBetween(Integer value1, Integer value2) {
            addCriterion("overall_rank not between", value1, value2, "overallRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankIsNull() {
            addCriterion("major_rank is null");
            return (Criteria) this;
        }

        public Criteria andMajorRankIsNotNull() {
            addCriterion("major_rank is not null");
            return (Criteria) this;
        }

        public Criteria andMajorRankEqualTo(Integer value) {
            addCriterion("major_rank =", value, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankNotEqualTo(Integer value) {
            addCriterion("major_rank <>", value, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankGreaterThan(Integer value) {
            addCriterion("major_rank >", value, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_rank >=", value, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankLessThan(Integer value) {
            addCriterion("major_rank <", value, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankLessThanOrEqualTo(Integer value) {
            addCriterion("major_rank <=", value, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankIn(List<Integer> values) {
            addCriterion("major_rank in", values, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankNotIn(List<Integer> values) {
            addCriterion("major_rank not in", values, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankBetween(Integer value1, Integer value2) {
            addCriterion("major_rank between", value1, value2, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorRankNotBetween(Integer value1, Integer value2) {
            addCriterion("major_rank not between", value1, value2, "majorRank");
            return (Criteria) this;
        }

        public Criteria andMajorTotalIsNull() {
            addCriterion("major_total is null");
            return (Criteria) this;
        }

        public Criteria andMajorTotalIsNotNull() {
            addCriterion("major_total is not null");
            return (Criteria) this;
        }

        public Criteria andMajorTotalEqualTo(Integer value) {
            addCriterion("major_total =", value, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalNotEqualTo(Integer value) {
            addCriterion("major_total <>", value, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalGreaterThan(Integer value) {
            addCriterion("major_total >", value, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_total >=", value, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalLessThan(Integer value) {
            addCriterion("major_total <", value, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalLessThanOrEqualTo(Integer value) {
            addCriterion("major_total <=", value, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalIn(List<Integer> values) {
            addCriterion("major_total in", values, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalNotIn(List<Integer> values) {
            addCriterion("major_total not in", values, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalBetween(Integer value1, Integer value2) {
            addCriterion("major_total between", value1, value2, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andMajorTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("major_total not between", value1, value2, "majorTotal");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLikeInsensitive(String value) {
            addCriterion("upper(sn) like", value.toUpperCase(), "sn");
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
package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.List;

public class RStepRightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RStepRightExample() {
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

        public Criteria andStepTemplateIdIsNull() {
            addCriterion("step_template_id is null");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdIsNotNull() {
            addCriterion("step_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdEqualTo(Long value) {
            addCriterion("step_template_id =", value, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdNotEqualTo(Long value) {
            addCriterion("step_template_id <>", value, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdGreaterThan(Long value) {
            addCriterion("step_template_id >", value, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("step_template_id >=", value, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdLessThan(Long value) {
            addCriterion("step_template_id <", value, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("step_template_id <=", value, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdIn(List<Long> values) {
            addCriterion("step_template_id in", values, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdNotIn(List<Long> values) {
            addCriterion("step_template_id not in", values, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdBetween(Long value1, Long value2) {
            addCriterion("step_template_id between", value1, value2, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andStepTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("step_template_id not between", value1, value2, "stepTemplateId");
            return (Criteria) this;
        }

        public Criteria andUserRightIsNull() {
            addCriterion("user_right is null");
            return (Criteria) this;
        }

        public Criteria andUserRightIsNotNull() {
            addCriterion("user_right is not null");
            return (Criteria) this;
        }

        public Criteria andUserRightEqualTo(Integer value) {
            addCriterion("user_right =", value, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightNotEqualTo(Integer value) {
            addCriterion("user_right <>", value, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightGreaterThan(Integer value) {
            addCriterion("user_right >", value, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_right >=", value, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightLessThan(Integer value) {
            addCriterion("user_right <", value, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightLessThanOrEqualTo(Integer value) {
            addCriterion("user_right <=", value, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightIn(List<Integer> values) {
            addCriterion("user_right in", values, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightNotIn(List<Integer> values) {
            addCriterion("user_right not in", values, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightBetween(Integer value1, Integer value2) {
            addCriterion("user_right between", value1, value2, "userRight");
            return (Criteria) this;
        }

        public Criteria andUserRightNotBetween(Integer value1, Integer value2) {
            addCriterion("user_right not between", value1, value2, "userRight");
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
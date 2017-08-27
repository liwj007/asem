package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.List;

public class FlowTemplateInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowTemplateInfoExample() {
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

        public Criteria andGradeInstructorIsNull() {
            addCriterion("grade_instructor is null");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorIsNotNull() {
            addCriterion("grade_instructor is not null");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorEqualTo(Boolean value) {
            addCriterion("grade_instructor =", value, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorNotEqualTo(Boolean value) {
            addCriterion("grade_instructor <>", value, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorGreaterThan(Boolean value) {
            addCriterion("grade_instructor >", value, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("grade_instructor >=", value, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorLessThan(Boolean value) {
            addCriterion("grade_instructor <", value, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorLessThanOrEqualTo(Boolean value) {
            addCriterion("grade_instructor <=", value, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorIn(List<Boolean> values) {
            addCriterion("grade_instructor in", values, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorNotIn(List<Boolean> values) {
            addCriterion("grade_instructor not in", values, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorBetween(Boolean value1, Boolean value2) {
            addCriterion("grade_instructor between", value1, value2, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeInstructorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("grade_instructor not between", value1, value2, "gradeInstructor");
            return (Criteria) this;
        }

        public Criteria andGradeStudentIsNull() {
            addCriterion("grade_student is null");
            return (Criteria) this;
        }

        public Criteria andGradeStudentIsNotNull() {
            addCriterion("grade_student is not null");
            return (Criteria) this;
        }

        public Criteria andGradeStudentEqualTo(Boolean value) {
            addCriterion("grade_student =", value, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentNotEqualTo(Boolean value) {
            addCriterion("grade_student <>", value, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentGreaterThan(Boolean value) {
            addCriterion("grade_student >", value, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("grade_student >=", value, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentLessThan(Boolean value) {
            addCriterion("grade_student <", value, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentLessThanOrEqualTo(Boolean value) {
            addCriterion("grade_student <=", value, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentIn(List<Boolean> values) {
            addCriterion("grade_student in", values, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentNotIn(List<Boolean> values) {
            addCriterion("grade_student not in", values, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentBetween(Boolean value1, Boolean value2) {
            addCriterion("grade_student between", value1, value2, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andGradeStudentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("grade_student not between", value1, value2, "gradeStudent");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorIsNull() {
            addCriterion("special_instructor is null");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorIsNotNull() {
            addCriterion("special_instructor is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorEqualTo(Boolean value) {
            addCriterion("special_instructor =", value, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorNotEqualTo(Boolean value) {
            addCriterion("special_instructor <>", value, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorGreaterThan(Boolean value) {
            addCriterion("special_instructor >", value, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("special_instructor >=", value, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorLessThan(Boolean value) {
            addCriterion("special_instructor <", value, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorLessThanOrEqualTo(Boolean value) {
            addCriterion("special_instructor <=", value, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorIn(List<Boolean> values) {
            addCriterion("special_instructor in", values, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorNotIn(List<Boolean> values) {
            addCriterion("special_instructor not in", values, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorBetween(Boolean value1, Boolean value2) {
            addCriterion("special_instructor between", value1, value2, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andSpecialInstructorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("special_instructor not between", value1, value2, "specialInstructor");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentIsNull() {
            addCriterion("college_student is null");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentIsNotNull() {
            addCriterion("college_student is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentEqualTo(Boolean value) {
            addCriterion("college_student =", value, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentNotEqualTo(Boolean value) {
            addCriterion("college_student <>", value, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentGreaterThan(Boolean value) {
            addCriterion("college_student >", value, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("college_student >=", value, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentLessThan(Boolean value) {
            addCriterion("college_student <", value, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentLessThanOrEqualTo(Boolean value) {
            addCriterion("college_student <=", value, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentIn(List<Boolean> values) {
            addCriterion("college_student in", values, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentNotIn(List<Boolean> values) {
            addCriterion("college_student not in", values, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentBetween(Boolean value1, Boolean value2) {
            addCriterion("college_student between", value1, value2, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andCollegeStudentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("college_student not between", value1, value2, "collegeStudent");
            return (Criteria) this;
        }

        public Criteria andSchoolUserIsNull() {
            addCriterion("school_user is null");
            return (Criteria) this;
        }

        public Criteria andSchoolUserIsNotNull() {
            addCriterion("school_user is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolUserEqualTo(Boolean value) {
            addCriterion("school_user =", value, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserNotEqualTo(Boolean value) {
            addCriterion("school_user <>", value, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserGreaterThan(Boolean value) {
            addCriterion("school_user >", value, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserGreaterThanOrEqualTo(Boolean value) {
            addCriterion("school_user >=", value, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserLessThan(Boolean value) {
            addCriterion("school_user <", value, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserLessThanOrEqualTo(Boolean value) {
            addCriterion("school_user <=", value, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserIn(List<Boolean> values) {
            addCriterion("school_user in", values, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserNotIn(List<Boolean> values) {
            addCriterion("school_user not in", values, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserBetween(Boolean value1, Boolean value2) {
            addCriterion("school_user between", value1, value2, "schoolUser");
            return (Criteria) this;
        }

        public Criteria andSchoolUserNotBetween(Boolean value1, Boolean value2) {
            addCriterion("school_user not between", value1, value2, "schoolUser");
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
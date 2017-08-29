package com.liwj.asem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlowTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowTemplateExample() {
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

        public Criteria andFlowTypeIsNull() {
            addCriterion("flow_type is null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNotNull() {
            addCriterion("flow_type is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeEqualTo(Integer value) {
            addCriterion("flow_type =", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotEqualTo(Integer value) {
            addCriterion("flow_type <>", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThan(Integer value) {
            addCriterion("flow_type >", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_type >=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThan(Integer value) {
            addCriterion("flow_type <", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThanOrEqualTo(Integer value) {
            addCriterion("flow_type <=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIn(List<Integer> values) {
            addCriterion("flow_type in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotIn(List<Integer> values) {
            addCriterion("flow_type not in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeBetween(Integer value1, Integer value2) {
            addCriterion("flow_type between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_type not between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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

        public Criteria andModifyUserIdIsNull() {
            addCriterion("modify_user_id is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIsNotNull() {
            addCriterion("modify_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdEqualTo(Long value) {
            addCriterion("modify_user_id =", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotEqualTo(Long value) {
            addCriterion("modify_user_id <>", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThan(Long value) {
            addCriterion("modify_user_id >", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_user_id >=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThan(Long value) {
            addCriterion("modify_user_id <", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("modify_user_id <=", value, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdIn(List<Long> values) {
            addCriterion("modify_user_id in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotIn(List<Long> values) {
            addCriterion("modify_user_id not in", values, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdBetween(Long value1, Long value2) {
            addCriterion("modify_user_id between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("modify_user_id not between", value1, value2, "modifyUserId");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
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
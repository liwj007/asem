package com.liwj.asem.dao;

import com.liwj.asem.model.ComprehensiveEvaluation;
import com.liwj.asem.model.ComprehensiveEvaluationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprehensiveEvaluationMapper {
    long countByExample(ComprehensiveEvaluationExample example);

    int deleteByExample(ComprehensiveEvaluationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComprehensiveEvaluation record);

    int insertSelective(ComprehensiveEvaluation record);

    List<ComprehensiveEvaluation> selectByExample(ComprehensiveEvaluationExample example);

    ComprehensiveEvaluation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComprehensiveEvaluation record, @Param("example") ComprehensiveEvaluationExample example);

    int updateByExample(@Param("record") ComprehensiveEvaluation record, @Param("example") ComprehensiveEvaluationExample example);

    int updateByPrimaryKeySelective(ComprehensiveEvaluation record);

    int updateByPrimaryKey(ComprehensiveEvaluation record);
}
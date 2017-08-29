package com.liwj.asem.dao;

import com.liwj.asem.model.AssessmentRecord;
import com.liwj.asem.model.AssessmentRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRecordMapper {
    long countByExample(AssessmentRecordExample example);

    int deleteByExample(AssessmentRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssessmentRecord record);

    int insertSelective(AssessmentRecord record);

    List<AssessmentRecord> selectByExample(AssessmentRecordExample example);

    AssessmentRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssessmentRecord record, @Param("example") AssessmentRecordExample example);

    int updateByExample(@Param("record") AssessmentRecord record, @Param("example") AssessmentRecordExample example);

    int updateByPrimaryKeySelective(AssessmentRecord record);

    int updateByPrimaryKey(AssessmentRecord record);
}
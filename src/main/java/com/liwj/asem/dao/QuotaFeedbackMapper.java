package com.liwj.asem.dao;

import com.liwj.asem.model.QuotaFeedback;
import com.liwj.asem.model.QuotaFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotaFeedbackMapper {
    long countByExample(QuotaFeedbackExample example);

    int deleteByExample(QuotaFeedbackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuotaFeedback record);

    int insertSelective(QuotaFeedback record);

    List<QuotaFeedback> selectByExample(QuotaFeedbackExample example);

    QuotaFeedback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuotaFeedback record, @Param("example") QuotaFeedbackExample example);

    int updateByExample(@Param("record") QuotaFeedback record, @Param("example") QuotaFeedbackExample example);

    int updateByPrimaryKeySelective(QuotaFeedback record);

    int updateByPrimaryKey(QuotaFeedback record);
}
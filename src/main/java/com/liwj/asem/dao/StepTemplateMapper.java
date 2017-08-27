package com.liwj.asem.dao;

import com.liwj.asem.model.StepTemplate;
import com.liwj.asem.model.StepTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StepTemplateMapper {
    long countByExample(StepTemplateExample example);

    int deleteByExample(StepTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StepTemplate record);

    int insertSelective(StepTemplate record);

    List<StepTemplate> selectByExample(StepTemplateExample example);

    StepTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StepTemplate record, @Param("example") StepTemplateExample example);

    int updateByExample(@Param("record") StepTemplate record, @Param("example") StepTemplateExample example);

    int updateByPrimaryKeySelective(StepTemplate record);

    int updateByPrimaryKey(StepTemplate record);
}
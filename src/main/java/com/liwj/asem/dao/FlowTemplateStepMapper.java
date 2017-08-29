package com.liwj.asem.dao;

import com.liwj.asem.model.FlowTemplateStep;
import com.liwj.asem.model.FlowTemplateStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowTemplateStepMapper {
    long countByExample(FlowTemplateStepExample example);

    int deleteByExample(FlowTemplateStepExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlowTemplateStep record);

    int insertSelective(FlowTemplateStep record);

    List<FlowTemplateStep> selectByExample(FlowTemplateStepExample example);

    FlowTemplateStep selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlowTemplateStep record, @Param("example") FlowTemplateStepExample example);

    int updateByExample(@Param("record") FlowTemplateStep record, @Param("example") FlowTemplateStepExample example);

    int updateByPrimaryKeySelective(FlowTemplateStep record);

    int updateByPrimaryKey(FlowTemplateStep record);
}
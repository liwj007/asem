package com.liwj.asem.dao;

import com.liwj.asem.model.FlowTemplate;
import com.liwj.asem.model.FlowTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowTemplateMapper {
    long countByExample(FlowTemplateExample example);

    int deleteByExample(FlowTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlowTemplate record);

    int insertSelective(FlowTemplate record);

    List<FlowTemplate> selectByExample(FlowTemplateExample example);

    FlowTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlowTemplate record, @Param("example") FlowTemplateExample example);

    int updateByExample(@Param("record") FlowTemplate record, @Param("example") FlowTemplateExample example);

    int updateByPrimaryKeySelective(FlowTemplate record);

    int updateByPrimaryKey(FlowTemplate record);
}
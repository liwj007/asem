package com.liwj.asem.dao;

import com.liwj.asem.model.FlowTemplateLink;
import com.liwj.asem.model.FlowTemplateLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowTemplateLinkMapper {
    long countByExample(FlowTemplateLinkExample example);

    int deleteByExample(FlowTemplateLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlowTemplateLink record);

    int insertSelective(FlowTemplateLink record);

    List<FlowTemplateLink> selectByExample(FlowTemplateLinkExample example);

    FlowTemplateLink selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlowTemplateLink record, @Param("example") FlowTemplateLinkExample example);

    int updateByExample(@Param("record") FlowTemplateLink record, @Param("example") FlowTemplateLinkExample example);

    int updateByPrimaryKeySelective(FlowTemplateLink record);

    int updateByPrimaryKey(FlowTemplateLink record);
}
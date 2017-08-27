package com.liwj.asem.dao;

import com.liwj.asem.model.FlowTemplateInfo;
import com.liwj.asem.model.FlowTemplateInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowTemplateInfoMapper {
    long countByExample(FlowTemplateInfoExample example);

    int deleteByExample(FlowTemplateInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlowTemplateInfo record);

    int insertSelective(FlowTemplateInfo record);

    List<FlowTemplateInfo> selectByExample(FlowTemplateInfoExample example);

    FlowTemplateInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlowTemplateInfo record, @Param("example") FlowTemplateInfoExample example);

    int updateByExample(@Param("record") FlowTemplateInfo record, @Param("example") FlowTemplateInfoExample example);

    int updateByPrimaryKeySelective(FlowTemplateInfo record);

    int updateByPrimaryKey(FlowTemplateInfo record);
}
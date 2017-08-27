package com.liwj.asem.dao;

import com.liwj.asem.model.FlowLink;
import com.liwj.asem.model.FlowLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowLinkMapper {
    long countByExample(FlowLinkExample example);

    int deleteByExample(FlowLinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlowLink record);

    int insertSelective(FlowLink record);

    List<FlowLink> selectByExample(FlowLinkExample example);

    FlowLink selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FlowLink record, @Param("example") FlowLinkExample example);

    int updateByExample(@Param("record") FlowLink record, @Param("example") FlowLinkExample example);

    int updateByPrimaryKeySelective(FlowLink record);

    int updateByPrimaryKey(FlowLink record);
}
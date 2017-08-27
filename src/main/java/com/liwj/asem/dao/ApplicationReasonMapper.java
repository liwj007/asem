package com.liwj.asem.dao;

import com.liwj.asem.model.ApplicationReason;
import com.liwj.asem.model.ApplicationReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationReasonMapper {
    long countByExample(ApplicationReasonExample example);

    int deleteByExample(ApplicationReasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplicationReason record);

    int insertSelective(ApplicationReason record);

    List<ApplicationReason> selectByExample(ApplicationReasonExample example);

    ApplicationReason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplicationReason record, @Param("example") ApplicationReasonExample example);

    int updateByExample(@Param("record") ApplicationReason record, @Param("example") ApplicationReasonExample example);

    int updateByPrimaryKeySelective(ApplicationReason record);

    int updateByPrimaryKey(ApplicationReason record);
}
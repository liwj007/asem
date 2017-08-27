package com.liwj.asem.dao;

import com.liwj.asem.model.RUserRight;
import com.liwj.asem.model.RUserRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RUserRightMapper {
    long countByExample(RUserRightExample example);

    int deleteByExample(RUserRightExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RUserRight record);

    int insertSelective(RUserRight record);

    List<RUserRight> selectByExample(RUserRightExample example);

    RUserRight selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RUserRight record, @Param("example") RUserRightExample example);

    int updateByExample(@Param("record") RUserRight record, @Param("example") RUserRightExample example);

    int updateByPrimaryKeySelective(RUserRight record);

    int updateByPrimaryKey(RUserRight record);
}
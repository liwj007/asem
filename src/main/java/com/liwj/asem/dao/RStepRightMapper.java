package com.liwj.asem.dao;

import com.liwj.asem.model.RStepRight;
import com.liwj.asem.model.RStepRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RStepRightMapper {
    long countByExample(RStepRightExample example);

    int deleteByExample(RStepRightExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RStepRight record);

    int insertSelective(RStepRight record);

    List<RStepRight> selectByExample(RStepRightExample example);

    RStepRight selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RStepRight record, @Param("example") RStepRightExample example);

    int updateByExample(@Param("record") RStepRight record, @Param("example") RStepRightExample example);

    int updateByPrimaryKeySelective(RStepRight record);

    int updateByPrimaryKey(RStepRight record);
}
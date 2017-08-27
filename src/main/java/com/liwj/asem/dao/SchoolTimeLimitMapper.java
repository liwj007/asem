package com.liwj.asem.dao;

import com.liwj.asem.model.SchoolTimeLimit;
import com.liwj.asem.model.SchoolTimeLimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolTimeLimitMapper {
    long countByExample(SchoolTimeLimitExample example);

    int deleteByExample(SchoolTimeLimitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SchoolTimeLimit record);

    int insertSelective(SchoolTimeLimit record);

    List<SchoolTimeLimit> selectByExample(SchoolTimeLimitExample example);

    SchoolTimeLimit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SchoolTimeLimit record, @Param("example") SchoolTimeLimitExample example);

    int updateByExample(@Param("record") SchoolTimeLimit record, @Param("example") SchoolTimeLimitExample example);

    int updateByPrimaryKeySelective(SchoolTimeLimit record);

    int updateByPrimaryKey(SchoolTimeLimit record);
}
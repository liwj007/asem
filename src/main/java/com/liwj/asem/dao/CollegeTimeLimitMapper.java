package com.liwj.asem.dao;

import com.liwj.asem.model.CollegeTimeLimit;
import com.liwj.asem.model.CollegeTimeLimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeTimeLimitMapper {
    long countByExample(CollegeTimeLimitExample example);

    int deleteByExample(CollegeTimeLimitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollegeTimeLimit record);

    int insertSelective(CollegeTimeLimit record);

    List<CollegeTimeLimit> selectByExample(CollegeTimeLimitExample example);

    CollegeTimeLimit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollegeTimeLimit record, @Param("example") CollegeTimeLimitExample example);

    int updateByExample(@Param("record") CollegeTimeLimit record, @Param("example") CollegeTimeLimitExample example);

    int updateByPrimaryKeySelective(CollegeTimeLimit record);

    int updateByPrimaryKey(CollegeTimeLimit record);
}
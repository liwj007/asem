package com.liwj.asem.dao;

import com.liwj.asem.model.PrizeCollegeLimitTime;
import com.liwj.asem.model.PrizeCollegeLimitTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeCollegeLimitTimeMapper {
    long countByExample(PrizeCollegeLimitTimeExample example);

    int deleteByExample(PrizeCollegeLimitTimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PrizeCollegeLimitTime record);

    int insertSelective(PrizeCollegeLimitTime record);

    List<PrizeCollegeLimitTime> selectByExample(PrizeCollegeLimitTimeExample example);

    PrizeCollegeLimitTime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PrizeCollegeLimitTime record, @Param("example") PrizeCollegeLimitTimeExample example);

    int updateByExample(@Param("record") PrizeCollegeLimitTime record, @Param("example") PrizeCollegeLimitTimeExample example);

    int updateByPrimaryKeySelective(PrizeCollegeLimitTime record);

    int updateByPrimaryKey(PrizeCollegeLimitTime record);
}
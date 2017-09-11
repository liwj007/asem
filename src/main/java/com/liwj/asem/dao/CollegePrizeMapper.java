package com.liwj.asem.dao;

import com.liwj.asem.model.CollegePrize;
import com.liwj.asem.model.CollegePrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegePrizeMapper {
    long countByExample(CollegePrizeExample example);

    int deleteByExample(CollegePrizeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollegePrize record);

    int insertSelective(CollegePrize record);

    List<CollegePrize> selectByExample(CollegePrizeExample example);

    CollegePrize selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollegePrize record, @Param("example") CollegePrizeExample example);

    int updateByExample(@Param("record") CollegePrize record, @Param("example") CollegePrizeExample example);

    int updateByPrimaryKeySelective(CollegePrize record);

    int updateByPrimaryKey(CollegePrize record);
}
package com.liwj.asem.dao;

import com.liwj.asem.model.SchoolPrize;
import com.liwj.asem.model.SchoolPrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolPrizeMapper {
    long countByExample(SchoolPrizeExample example);

    int deleteByExample(SchoolPrizeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SchoolPrize record);

    int insertSelective(SchoolPrize record);

    List<SchoolPrize> selectByExample(SchoolPrizeExample example);

    SchoolPrize selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SchoolPrize record, @Param("example") SchoolPrizeExample example);

    int updateByExample(@Param("record") SchoolPrize record, @Param("example") SchoolPrizeExample example);

    int updateByPrimaryKeySelective(SchoolPrize record);

    int updateByPrimaryKey(SchoolPrize record);
}
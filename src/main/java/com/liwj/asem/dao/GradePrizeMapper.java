package com.liwj.asem.dao;

import com.liwj.asem.model.GradePrize;
import com.liwj.asem.model.GradePrizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradePrizeMapper {
    long countByExample(GradePrizeExample example);

    int deleteByExample(GradePrizeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GradePrize record);

    int insertSelective(GradePrize record);

    List<GradePrize> selectByExample(GradePrizeExample example);

    GradePrize selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GradePrize record, @Param("example") GradePrizeExample example);

    int updateByExample(@Param("record") GradePrize record, @Param("example") GradePrizeExample example);

    int updateByPrimaryKeySelective(GradePrize record);

    int updateByPrimaryKey(GradePrize record);
}
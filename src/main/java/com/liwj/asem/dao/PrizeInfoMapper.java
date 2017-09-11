package com.liwj.asem.dao;

import com.liwj.asem.model.PrizeInfo;
import com.liwj.asem.model.PrizeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeInfoMapper {
    long countByExample(PrizeInfoExample example);

    int deleteByExample(PrizeInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PrizeInfo record);

    int insertSelective(PrizeInfo record);

    List<PrizeInfo> selectByExample(PrizeInfoExample example);

    PrizeInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PrizeInfo record, @Param("example") PrizeInfoExample example);

    int updateByExample(@Param("record") PrizeInfo record, @Param("example") PrizeInfoExample example);

    int updateByPrimaryKeySelective(PrizeInfo record);

    int updateByPrimaryKey(PrizeInfo record);
}
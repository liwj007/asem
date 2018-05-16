package com.liwj.asem.dao;

import com.liwj.asem.model.Major;
import com.liwj.asem.model.MajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorMapper {
    long countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);

    Major selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}
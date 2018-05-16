package com.liwj.asem.dao;

import com.liwj.asem.model.RUserAndCollege;
import com.liwj.asem.model.RUserAndCollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RUserAndCollegeMapper {
    long countByExample(RUserAndCollegeExample example);

    int deleteByExample(RUserAndCollegeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RUserAndCollege record);

    int insertSelective(RUserAndCollege record);

    List<RUserAndCollege> selectByExample(RUserAndCollegeExample example);

    RUserAndCollege selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RUserAndCollege record, @Param("example") RUserAndCollegeExample example);

    int updateByExample(@Param("record") RUserAndCollege record, @Param("example") RUserAndCollegeExample example);

    int updateByPrimaryKeySelective(RUserAndCollege record);

    int updateByPrimaryKey(RUserAndCollege record);
}
package com.liwj.asem.dao;

import com.liwj.asem.model.RUserAndGrade;
import com.liwj.asem.model.RUserAndGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RUserAndGradeMapper {
    long countByExample(RUserAndGradeExample example);

    int deleteByExample(RUserAndGradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RUserAndGrade record);

    int insertSelective(RUserAndGrade record);

    List<RUserAndGrade> selectByExample(RUserAndGradeExample example);

    RUserAndGrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RUserAndGrade record, @Param("example") RUserAndGradeExample example);

    int updateByExample(@Param("record") RUserAndGrade record, @Param("example") RUserAndGradeExample example);

    int updateByPrimaryKeySelective(RUserAndGrade record);

    int updateByPrimaryKey(RUserAndGrade record);
}
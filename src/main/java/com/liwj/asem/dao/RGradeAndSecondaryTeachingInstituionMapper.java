package com.liwj.asem.dao;

import com.liwj.asem.model.RGradeAndSecondaryTeachingInstituion;
import com.liwj.asem.model.RGradeAndSecondaryTeachingInstituionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RGradeAndSecondaryTeachingInstituionMapper {
    long countByExample(RGradeAndSecondaryTeachingInstituionExample example);

    int deleteByExample(RGradeAndSecondaryTeachingInstituionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RGradeAndSecondaryTeachingInstituion record);

    int insertSelective(RGradeAndSecondaryTeachingInstituion record);

    List<RGradeAndSecondaryTeachingInstituion> selectByExample(RGradeAndSecondaryTeachingInstituionExample example);

    RGradeAndSecondaryTeachingInstituion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RGradeAndSecondaryTeachingInstituion record, @Param("example") RGradeAndSecondaryTeachingInstituionExample example);

    int updateByExample(@Param("record") RGradeAndSecondaryTeachingInstituion record, @Param("example") RGradeAndSecondaryTeachingInstituionExample example);

    int updateByPrimaryKeySelective(RGradeAndSecondaryTeachingInstituion record);

    int updateByPrimaryKey(RGradeAndSecondaryTeachingInstituion record);
}
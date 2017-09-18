package com.liwj.asem.dao;

import com.liwj.asem.model.RGradeAndSecondaryTeachingInstitution;
import com.liwj.asem.model.RGradeAndSecondaryTeachingInstitutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RGradeAndSecondaryTeachingInstitutionMapper {
    long countByExample(RGradeAndSecondaryTeachingInstitutionExample example);

    int deleteByExample(RGradeAndSecondaryTeachingInstitutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RGradeAndSecondaryTeachingInstitution record);

    int insertSelective(RGradeAndSecondaryTeachingInstitution record);

    List<RGradeAndSecondaryTeachingInstitution> selectByExample(RGradeAndSecondaryTeachingInstitutionExample example);

    RGradeAndSecondaryTeachingInstitution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RGradeAndSecondaryTeachingInstitution record, @Param("example") RGradeAndSecondaryTeachingInstitutionExample example);

    int updateByExample(@Param("record") RGradeAndSecondaryTeachingInstitution record, @Param("example") RGradeAndSecondaryTeachingInstitutionExample example);

    int updateByPrimaryKeySelective(RGradeAndSecondaryTeachingInstitution record);

    int updateByPrimaryKey(RGradeAndSecondaryTeachingInstitution record);
}
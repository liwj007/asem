package com.liwj.asem.dao;

import com.liwj.asem.model.SecondaryTeachingInstitution;
import com.liwj.asem.model.SecondaryTeachingInstitutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryTeachingInstitutionMapper {
    long countByExample(SecondaryTeachingInstitutionExample example);

    int deleteByExample(SecondaryTeachingInstitutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecondaryTeachingInstitution record);

    int insertSelective(SecondaryTeachingInstitution record);

    List<SecondaryTeachingInstitution> selectByExample(SecondaryTeachingInstitutionExample example);

    SecondaryTeachingInstitution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecondaryTeachingInstitution record, @Param("example") SecondaryTeachingInstitutionExample example);

    int updateByExample(@Param("record") SecondaryTeachingInstitution record, @Param("example") SecondaryTeachingInstitutionExample example);

    int updateByPrimaryKeySelective(SecondaryTeachingInstitution record);

    int updateByPrimaryKey(SecondaryTeachingInstitution record);
}
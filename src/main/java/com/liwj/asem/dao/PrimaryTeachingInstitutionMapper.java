package com.liwj.asem.dao;

import com.liwj.asem.model.PrimaryTeachingInstitution;
import com.liwj.asem.model.PrimaryTeachingInstitutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTeachingInstitutionMapper {
    long countByExample(PrimaryTeachingInstitutionExample example);

    int deleteByExample(PrimaryTeachingInstitutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PrimaryTeachingInstitution record);

    int insertSelective(PrimaryTeachingInstitution record);

    List<PrimaryTeachingInstitution> selectByExample(PrimaryTeachingInstitutionExample example);

    PrimaryTeachingInstitution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PrimaryTeachingInstitution record, @Param("example") PrimaryTeachingInstitutionExample example);

    int updateByExample(@Param("record") PrimaryTeachingInstitution record, @Param("example") PrimaryTeachingInstitutionExample example);

    int updateByPrimaryKeySelective(PrimaryTeachingInstitution record);

    int updateByPrimaryKey(PrimaryTeachingInstitution record);
}
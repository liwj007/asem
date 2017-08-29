package com.liwj.asem.dao;

import com.liwj.asem.model.RUserAndPrimaryTeachingInstitution;
import com.liwj.asem.model.RUserAndPrimaryTeachingInstitutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RUserAndPrimaryTeachingInstitutionMapper {
    long countByExample(RUserAndPrimaryTeachingInstitutionExample example);

    int deleteByExample(RUserAndPrimaryTeachingInstitutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RUserAndPrimaryTeachingInstitution record);

    int insertSelective(RUserAndPrimaryTeachingInstitution record);

    List<RUserAndPrimaryTeachingInstitution> selectByExample(RUserAndPrimaryTeachingInstitutionExample example);

    RUserAndPrimaryTeachingInstitution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RUserAndPrimaryTeachingInstitution record, @Param("example") RUserAndPrimaryTeachingInstitutionExample example);

    int updateByExample(@Param("record") RUserAndPrimaryTeachingInstitution record, @Param("example") RUserAndPrimaryTeachingInstitutionExample example);

    int updateByPrimaryKeySelective(RUserAndPrimaryTeachingInstitution record);

    int updateByPrimaryKey(RUserAndPrimaryTeachingInstitution record);
}
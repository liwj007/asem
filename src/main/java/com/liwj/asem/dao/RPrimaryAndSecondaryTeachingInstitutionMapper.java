package com.liwj.asem.dao;

import com.liwj.asem.model.RPrimaryAndSecondaryTeachingInstitution;
import com.liwj.asem.model.RPrimaryAndSecondaryTeachingInstitutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RPrimaryAndSecondaryTeachingInstitutionMapper {
    long countByExample(RPrimaryAndSecondaryTeachingInstitutionExample example);

    int deleteByExample(RPrimaryAndSecondaryTeachingInstitutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RPrimaryAndSecondaryTeachingInstitution record);

    int insertSelective(RPrimaryAndSecondaryTeachingInstitution record);

    List<RPrimaryAndSecondaryTeachingInstitution> selectByExample(RPrimaryAndSecondaryTeachingInstitutionExample example);

    RPrimaryAndSecondaryTeachingInstitution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RPrimaryAndSecondaryTeachingInstitution record, @Param("example") RPrimaryAndSecondaryTeachingInstitutionExample example);

    int updateByExample(@Param("record") RPrimaryAndSecondaryTeachingInstitution record, @Param("example") RPrimaryAndSecondaryTeachingInstitutionExample example);

    int updateByPrimaryKeySelective(RPrimaryAndSecondaryTeachingInstitution record);

    int updateByPrimaryKey(RPrimaryAndSecondaryTeachingInstitution record);
}
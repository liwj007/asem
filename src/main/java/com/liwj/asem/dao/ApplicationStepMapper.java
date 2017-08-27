package com.liwj.asem.dao;

import com.liwj.asem.model.ApplicationStep;
import com.liwj.asem.model.ApplicationStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationStepMapper {
    long countByExample(ApplicationStepExample example);

    int deleteByExample(ApplicationStepExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplicationStep record);

    int insertSelective(ApplicationStep record);

    List<ApplicationStep> selectByExample(ApplicationStepExample example);

    ApplicationStep selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplicationStep record, @Param("example") ApplicationStepExample example);

    int updateByExample(@Param("record") ApplicationStep record, @Param("example") ApplicationStepExample example);

    int updateByPrimaryKeySelective(ApplicationStep record);

    int updateByPrimaryKey(ApplicationStep record);
}
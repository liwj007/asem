package com.liwj.asem.dao;

import com.liwj.asem.model.RFlowTemplateStepAndUserRole;
import com.liwj.asem.model.RFlowTemplateStepAndUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RFlowTemplateStepAndUserRoleMapper {
    long countByExample(RFlowTemplateStepAndUserRoleExample example);

    int deleteByExample(RFlowTemplateStepAndUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RFlowTemplateStepAndUserRole record);

    int insertSelective(RFlowTemplateStepAndUserRole record);

    List<RFlowTemplateStepAndUserRole> selectByExample(RFlowTemplateStepAndUserRoleExample example);

    RFlowTemplateStepAndUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RFlowTemplateStepAndUserRole record, @Param("example") RFlowTemplateStepAndUserRoleExample example);

    int updateByExample(@Param("record") RFlowTemplateStepAndUserRole record, @Param("example") RFlowTemplateStepAndUserRoleExample example);

    int updateByPrimaryKeySelective(RFlowTemplateStepAndUserRole record);

    int updateByPrimaryKey(RFlowTemplateStepAndUserRole record);
}
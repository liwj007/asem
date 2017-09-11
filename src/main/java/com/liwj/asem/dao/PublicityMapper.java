package com.liwj.asem.dao;

import com.liwj.asem.model.Publicity;
import com.liwj.asem.model.PublicityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicityMapper {
    long countByExample(PublicityExample example);

    int deleteByExample(PublicityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Publicity record);

    int insertSelective(Publicity record);

    List<Publicity> selectByExample(PublicityExample example);

    Publicity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Publicity record, @Param("example") PublicityExample example);

    int updateByExample(@Param("record") Publicity record, @Param("example") PublicityExample example);

    int updateByPrimaryKeySelective(Publicity record);

    int updateByPrimaryKey(Publicity record);
}
package com.liwj.asem.dao;

import com.liwj.asem.model.PublicityObjection;
import com.liwj.asem.model.PublicityObjectionExample;
import com.liwj.asem.model.PublicityObjectionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicityObjectionMapper {
    long countByExample(PublicityObjectionExample example);

    int deleteByExample(PublicityObjectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PublicityObjectionWithBLOBs record);

    int insertSelective(PublicityObjectionWithBLOBs record);

    List<PublicityObjectionWithBLOBs> selectByExampleWithBLOBs(PublicityObjectionExample example);

    List<PublicityObjection> selectByExample(PublicityObjectionExample example);

    PublicityObjectionWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PublicityObjectionWithBLOBs record, @Param("example") PublicityObjectionExample example);

    int updateByExampleWithBLOBs(@Param("record") PublicityObjectionWithBLOBs record, @Param("example") PublicityObjectionExample example);

    int updateByExample(@Param("record") PublicityObjection record, @Param("example") PublicityObjectionExample example);

    int updateByPrimaryKeySelective(PublicityObjectionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PublicityObjectionWithBLOBs record);

    int updateByPrimaryKey(PublicityObjection record);
}
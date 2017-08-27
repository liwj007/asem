package com.liwj.asem.dao;

import com.liwj.asem.model.ApplicationFile;
import com.liwj.asem.model.ApplicationFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationFileMapper {
    long countByExample(ApplicationFileExample example);

    int deleteByExample(ApplicationFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApplicationFile record);

    int insertSelective(ApplicationFile record);

    List<ApplicationFile> selectByExample(ApplicationFileExample example);

    ApplicationFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApplicationFile record, @Param("example") ApplicationFileExample example);

    int updateByExample(@Param("record") ApplicationFile record, @Param("example") ApplicationFileExample example);

    int updateByPrimaryKeySelective(ApplicationFile record);

    int updateByPrimaryKey(ApplicationFile record);
}
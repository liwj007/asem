package com.liwj.asem.dao;

import com.liwj.asem.model.ScholarshipFile;
import com.liwj.asem.model.ScholarshipFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarshipFileMapper {
    long countByExample(ScholarshipFileExample example);

    int deleteByExample(ScholarshipFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScholarshipFile record);

    int insertSelective(ScholarshipFile record);

    List<ScholarshipFile> selectByExample(ScholarshipFileExample example);

    ScholarshipFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScholarshipFile record, @Param("example") ScholarshipFileExample example);

    int updateByExample(@Param("record") ScholarshipFile record, @Param("example") ScholarshipFileExample example);

    int updateByPrimaryKeySelective(ScholarshipFile record);

    int updateByPrimaryKey(ScholarshipFile record);
}
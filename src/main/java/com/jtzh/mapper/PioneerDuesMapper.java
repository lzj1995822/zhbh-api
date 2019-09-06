package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerDues;
import com.jtzh.pojo.KeyParam;

public interface PioneerDuesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerDues record);

    int insertSelective(PioneerDues record);

    PioneerDues selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PioneerDues record);

    int updateByPrimaryKey(PioneerDues record);
    List<PioneerDues> getDf(@Param("keyparam")KeyParam param);
    
    int getDfTotal(@Param("keyparam")KeyParam param);
}
package com.jtzh.mapper;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerServiceResult;

public interface PioneerServiceResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerServiceResult record);

    int insertSelective(PioneerServiceResult record);

    PioneerServiceResult selectByPrimaryKey(@Param("id")String id);

    int updateByPrimaryKeySelective(PioneerServiceResult record);

    int updateByPrimaryKeyWithBLOBs(PioneerServiceResult record);

    int updateByPrimaryKey(PioneerServiceResult record);
}
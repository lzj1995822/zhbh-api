package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerVolunteerPx;

public interface PioneerVolunteerPxMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerVolunteerPx record);

    int insertSelective(PioneerVolunteerPx record);

    PioneerVolunteerPx selectByPrimaryKey(Long id);
    List<PioneerVolunteerPx> selectByZyzId(String zyzId);
    int updateByPrimaryKeySelective(PioneerVolunteerPx record);

    int updateByPrimaryKey(PioneerVolunteerPx record);
    
    int updateById(@Param("id")String id);
}
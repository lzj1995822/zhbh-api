package com.jtzh.mapper;

import com.jtzh.entity.PioneerVolunteer;
import com.jtzh.pojo.KeyParam;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerServiceEnroll;

import java.util.List;

public interface PioneerServiceEnrollMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(PioneerServiceEnroll record);

    int insertSelective(PioneerServiceEnroll record);

    PioneerServiceEnroll selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PioneerServiceEnroll record);

    int updateByPrimaryKey(PioneerServiceEnroll record);
    
    int getZyzBm(@Param("hdid")String hdid,@Param("zyzzh")String zyzzh);

    int getZyzBmInfoTotal(@Param("keyparam")KeyParam keyParam);

    List<PioneerVolunteer> getZyzBmInfo(@Param("keyparam")KeyParam keyParam);
}
package com.jtzh.mapper;

import com.jtzh.entity.SecurityInfAppoint;

public interface SecurityInfAppointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecurityInfAppoint record);

    int insertSelective(SecurityInfAppoint record);

    SecurityInfAppoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecurityInfAppoint record);

    int updateByPrimaryKey(SecurityInfAppoint record);
    
    int [] getNewsIds(Integer userId);
    int [] getNewsIds2(Integer userId);
}
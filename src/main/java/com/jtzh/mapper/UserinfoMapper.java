package com.jtzh.mapper;

import com.jtzh.entity.Userinfo;

public interface UserinfoMapper {
    int deleteByPrimaryKey(String user);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String user);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}
package com.jtzh.mapper;

import com.jtzh.entity.Tenetgrideventreturn;

public interface TenetgrideventreturnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tenetgrideventreturn record);

    int insertSelective(Tenetgrideventreturn record);

    Tenetgrideventreturn selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tenetgrideventreturn record);

    int updateByPrimaryKey(Tenetgrideventreturn record);
}
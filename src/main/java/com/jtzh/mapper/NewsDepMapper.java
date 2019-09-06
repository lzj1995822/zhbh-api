package com.jtzh.mapper;

import com.jtzh.entity.NewsDep;

public interface NewsDepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsDep record);

    int insertSelective(NewsDep record);

    NewsDep selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsDep record);

    int updateByPrimaryKey(NewsDep record);
    
    int [] getNewsIds(String depName);
    
    int selectIdByNewsDep(NewsDep record);
    
    // 更新dep阅读次数
    int updateDepHasReceiveNum(Integer id);
    
}
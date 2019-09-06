package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.PioneerJf;

public interface PioneerJfMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerJf record);

    int insertSelective(PioneerJf record);

    PioneerJf selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PioneerJf record);

    int updateByPrimaryKey(PioneerJf record);
    
    
    List<PioneerJf> getDyjf(PioneerJf record);
    int getDyjfTotal(PioneerJf record);
}
package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerLddy;
import com.jtzh.pojo.KeyParam;

public interface PioneerLddyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerLddy record);
    
    List<PioneerLddy> getLddy(@Param("keyparam")KeyParam param);
    List<PioneerLddy> getLddys();
    int getLddyTotal(@Param("keyparam")KeyParam param);
    int removeLddy(@Param("id")String id);
    int insertSelective(PioneerLddy record);

    PioneerLddy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PioneerLddy record);

    int updateByPrimaryKey(PioneerLddy record);
}
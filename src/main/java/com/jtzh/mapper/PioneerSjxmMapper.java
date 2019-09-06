package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerSjxm;
import com.jtzh.pojo.KeyParam;

public interface PioneerSjxmMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerSjxm record);

    int insertSelective(PioneerSjxm record);

    PioneerSjxm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PioneerSjxm record);

    int updateByPrimaryKeyWithBLOBs(PioneerSjxm record);

    int updateByPrimaryKey(PioneerSjxm record);
    
    int getSjxmTotal(@Param("keyparam")KeyParam param);
    List<PioneerSjxm> getSjxm(@Param("keyparam")KeyParam param);
    List<PioneerSjxm> getAllSjxm(@Param("keyparam")KeyParam param);
    int updateSjxmZt(PioneerSjxm record);
}
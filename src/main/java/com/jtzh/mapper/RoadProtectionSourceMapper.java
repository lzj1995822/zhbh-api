package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoadProtectionSource;

public interface RoadProtectionSourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoadProtectionSource record);

    int insertSelective(RoadProtectionSource record);

    RoadProtectionSource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoadProtectionSource record);

    int updateByPrimaryKey(RoadProtectionSource record);
    
    // 查询路线模块对应的图片资源根据id
 	List<RoadProtectionSource> selectSource(@Param("source") String source, @Param("id") Long id);//

 	// 单个删除source
 	int deleteSource(Long a);
}
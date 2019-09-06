package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.HwSource;

public interface HwSourceMapper {
	
	HwSource selectByPrimaryKey(Integer id);
	
	int insert(HwSource record);

    int insertSelective(HwSource record);
    
    // 查询问题对应的图片资源根据id
 	List<HwSource> getSourceInfo(@Param("sourceType") String sourceType, @Param("id") String id);

 	// 获取问题对应的来源根据id和类型
 	List<HwSource> selectSourceList(@Param("id") String id, @Param("sourceType") String sourceType);

 	// 单个删除source
 	int deleteSource(Integer a);

}

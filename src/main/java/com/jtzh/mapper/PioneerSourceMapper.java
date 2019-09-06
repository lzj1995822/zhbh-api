package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerSource;

public interface PioneerSourceMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PioneerSource record);

	int insertSelective(PioneerSource record);

	PioneerSource selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PioneerSource record);

	int updateByPrimaryKey(PioneerSource record);

	// 获取source
	List<PioneerSource> selectSource(@Param("source") String source, @Param("id") String id);//

	// 查询问题对应的图片资源根据id
	List<PioneerSource> getSourceInfo(@Param("sourceType") String sourceType, @Param("id") String id);

	// 单个删除source
	int deleteSource(String a);
}
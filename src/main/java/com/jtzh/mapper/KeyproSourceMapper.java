package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.KeyproSource;

public interface KeyproSourceMapper {
	int deleteByPrimaryKey(Long id);

	int insert(KeyproSource record);

	int insertSelective(KeyproSource record);

	KeyproSource selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(KeyproSource record);

	int updateByPrimaryKey(KeyproSource record);

	// 获取source
	List<KeyproSource> selectSource(@Param("source") String source, @Param("id") String id);//

	// 查询问题对应的图片资源根据id
	List<KeyproSource> getSourceInfo(@Param("sourceType") String sourceType, @Param("id") String id);

	// 单个删除source
	int deleteSource(String a);
}
package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.KeyproInformation;

public interface KeyproInformationMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KeyproInformation record);

	int insertSelective(KeyproInformation record);

	KeyproInformation selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(KeyproInformation record);

	int updateByPrimaryKey(KeyproInformation record);

	// 查询五方信息列表
	List<KeyproInformation> selectFive(@Param("id") String id);

	// 查询具体的pro
	KeyproInformation selectInfo(@Param("id") String id);

	// 删除
	int deleteInfo(@Param("id") String id);

	// 新建Info
	int insertInfo(KeyproInformation record);
}
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.Vil;

public interface VilMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Vil record);

	int insertSelective(Vil record);

	Vil selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Vil record);

	int updateByPrimaryKey(Vil record);

	// 为了导出进行的查询
	List<Vil> getVilList();
}
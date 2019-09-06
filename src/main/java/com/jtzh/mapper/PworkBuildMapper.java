package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PworkBuild;
import com.jtzh.pojo.PworkPagination;

public interface PworkBuildMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(PworkBuild record);

	int insertSelective(PworkBuild record);

	PworkBuild selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(PworkBuild record);

	int updateByPrimaryKey(PworkBuild record);

	// 查询总数
	int selectTotal(@Param("page") PworkPagination param);

	// 分页查询
	List<PworkBuild> selectInfo(@Param("page") PworkPagination param);

	// 查询具体的work
	PworkBuild selectPwork(@Param("type") String type, @Param("id") String id);

	// 删除
	int deletePwork(@Param("id") String id);

	// 新建work
	int insertPwork(PworkBuild record);
}
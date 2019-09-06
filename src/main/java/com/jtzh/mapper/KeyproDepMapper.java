package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.KeyproDep;
import com.jtzh.pojo.DepPagination;

public interface KeyproDepMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KeyproDep record);

	int insertSelective(KeyproDep record);

	KeyproDep selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(KeyproDep record);

	int updateByPrimaryKey(KeyproDep record);

	// 查询总数
	int selectTotal(@Param("page") DepPagination param);

	// 分页查询
	List<KeyproDep> selectInfo(@Param("page") DepPagination param);

	// 获取所选的user
	KeyproDep selectDep(@Param("id") String id);

	// 删除
	int deleteDep(@Param("id") String id);

	// 为了导出进行的查询
	List<KeyproDep> getDepList();
}
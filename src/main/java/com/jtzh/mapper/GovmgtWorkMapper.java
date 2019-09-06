package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.GovmgtWork;
import com.jtzh.pojo.WorkPagination;

public interface GovmgtWorkMapper {
	int deleteByPrimaryKey(Long id);

	int insert(GovmgtWork record);

	int insertSelective(GovmgtWork record);

	GovmgtWork selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(GovmgtWork record);

	int updateByPrimaryKey(GovmgtWork record);

	// 查询总数
	int selectTotal(@Param("page") WorkPagination param);

	// 分页查询
	List<GovmgtWork> selectInfo(@Param("page") WorkPagination param);

	// 查询具体的work
	GovmgtWork selectWork(@Param("type") String type, @Param("id") String id);

	// 删除
	int deleteWork(@Param("id") String id);

	// 新建work
	int insertWork(GovmgtWork record);

}
package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoadProtectionGroup;
import com.jtzh.pojo.RoadProtectionGroupPagination;
import com.jtzh.responsevo.RoadProtectionGroupVo;

public interface RoadProtectionGroupMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(RoadProtectionGroup record);

	int insertSelective(RoadProtectionGroup record);

	RoadProtectionGroup selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(RoadProtectionGroup record);

	int updateByPrimaryKey(RoadProtectionGroup record);

	// 查询总数
	int selectTotal(@Param("page") RoadProtectionGroupPagination param);

	// 分页查询
	List<RoadProtectionGroupVo> selectInfo(@Param("page") RoadProtectionGroupPagination param);

	// 查询具体的路
	RoadProtectionGroup selectGroup(Integer id);

	// 删除
	int deleteGroup(Integer id);

}
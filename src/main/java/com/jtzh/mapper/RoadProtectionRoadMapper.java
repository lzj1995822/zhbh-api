package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoadProtectionRoad;
import com.jtzh.pojo.RoadProtectionRoadPagination;

public interface RoadProtectionRoadMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RoadProtectionRoad record);

	int insertSelective(RoadProtectionRoad record);

	RoadProtectionRoad selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(RoadProtectionRoad record);

	int updateByPrimaryKey(RoadProtectionRoad record);

	// 查询总数
	int selectTotal(@Param("page") RoadProtectionRoadPagination param);

	// 分页查询
	List<RoadProtectionRoad> selectInfo(@Param("page") RoadProtectionRoadPagination param);

	// 查询具体的路
	RoadProtectionRoad selectRoad(Long  id);

	// 删除
	int deleteRoad(Long id);

	// 新建路线
	int insertRoad(RoadProtectionRoad record);

}
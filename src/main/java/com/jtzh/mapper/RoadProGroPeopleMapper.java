package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoadProGroPeople;
import com.jtzh.pojo.RoadProGroPeopleParam;

public interface RoadProGroPeopleMapper {
	
	// 查询id
	RoadProGroPeople selectByPrimaryKey(Integer id);
	// 查询总数
	int selectRPGTotal(@Param("page") RoadProGroPeopleParam param);
	// 分页查询
	List<RoadProGroPeople> selectRPGInfo(@Param("page") RoadProGroPeopleParam param);
	// 根据id查询
	RoadProGroPeople getRoadProGroPeopleInfo(@Param("id") String id);
	// 修改
	void updateRoadProGroPeople(RoadProGroPeople param);
	// 新建
	int addRoadProGroPeople(RoadProGroPeople cguser);
	// 删除
	int deleteRoadProGroPeople(@Param("id") String id);

}

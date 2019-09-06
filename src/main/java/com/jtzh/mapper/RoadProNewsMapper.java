package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoadProNews;
import com.jtzh.pojo.RoadProNewsParam;

public interface RoadProNewsMapper {
	
	// 查询id
	RoadProNews selectByPrimaryKey(Integer id);
	// 查询总数
	int selectRPNTotal(@Param("page") RoadProNewsParam param);
	// 分页查询
	List<RoadProNews> selectRPNInfo(@Param("page") RoadProNewsParam param);
	// 根据id查询
	RoadProNews getRoadProNewsInfo(@Param("id") String id);
	// 修改
	void updateRoadProNews(RoadProNews param);
	// 新建
	int addRoadProNews(RoadProNews meeting);
	// 删除
	int deleteRoadProNews(@Param("id") String id);

}

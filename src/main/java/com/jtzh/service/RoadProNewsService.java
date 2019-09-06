package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProNews;
import com.jtzh.pojo.RoadProNewsParam;

public interface RoadProNewsService {
	
	public Object getRoadProNewsList(RoadProNewsParam param); // 查询
	
	public RoadProNews getRoadProNewsInfo(String id); // 查看详情
	
	public Object addRoadProNews(RoadProNews inf, LoginUserTest user); // 新建
	
	Object updateRoadProNews(RoadProNews param); // 修改
	
	public Object deleteRoadProNews(String id); // 删除

}

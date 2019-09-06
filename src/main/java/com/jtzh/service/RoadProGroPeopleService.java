package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProGroPeople;
import com.jtzh.pojo.RoadProGroPeopleParam;

public interface RoadProGroPeopleService {
	
	public Object getRoadProGroPeopleList(RoadProGroPeopleParam param); // 查询

	public RoadProGroPeople getRoadProGroPeopleInfo(String id); // 查看详情

	public Object addRoadProGroPeople(RoadProGroPeople cguser, LoginUserTest user); // 新建
	
	public Object deleteRoadProGroPeople(String id); // 删除
	
	Object updateRoadProGroPeople(RoadProGroPeople param); // 修改

}

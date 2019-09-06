package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionGroup;
import com.jtzh.pojo.RoadProtectionGroupPagination;

public interface RoadProtectionGroupService {
	public Object getRoadProtectionGroupList(RoadProtectionGroupPagination param);
	
	public Object getRoadProtectionGroup(Integer id);
	
	public Object removeRoadProtectionGroup(Integer id);
	
	public Object addRoadProtectionGroup(RoadProtectionGroup param, LoginUserTest user);
	
	public Object modifyRoadProtectionGroup(RoadProtectionGroup param);
}

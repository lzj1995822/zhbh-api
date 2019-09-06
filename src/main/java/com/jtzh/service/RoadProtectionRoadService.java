package com.jtzh.service;

import com.jtzh.detail.pojo.RoadDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.RoadProtectionRoadPagination;

public interface RoadProtectionRoadService {
	public Object getRoadProtectionRoadList(RoadProtectionRoadPagination param);
	
	public Object getRoadProtectionRoad(Long id);
	
	public Object removeRoadProtectionRoad(Long id);
	
	public Object addRoadProtectionRoad(RoadDetail detail, LoginUserTest user);
	
	public Object modifyRoadProtectionRoad(RoadDetail detail);
}

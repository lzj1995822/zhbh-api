package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.RoadProtectionRoad;
import com.jtzh.entity.RoadProtectionSource;

public class RoadDetail {
	private RoadProtectionRoad road;
	private List<RoadProtectionSource> source;
	public RoadProtectionRoad getRoad() {
		return road;
	}
	public void setRoad(RoadProtectionRoad road) {
		this.road = road;
	}
	public List<RoadProtectionSource> getSource() {
		return source;
	}
	public void setSource(List<RoadProtectionSource> source) {
		this.source = source;
	}
	
	
}

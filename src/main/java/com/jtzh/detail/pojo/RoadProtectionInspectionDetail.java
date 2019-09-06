package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.RoadProtectionInspection;
import com.jtzh.entity.RoadProtectionSource;

public class RoadProtectionInspectionDetail {
	private RoadProtectionInspection roadProtectionInspection;
	private List<RoadProtectionSource> source;
	public RoadProtectionInspection getRoadProtectionInspection() {
		return roadProtectionInspection;
	}
	public void setRoadProtectionInspection(RoadProtectionInspection roadProtectionInspection) {
		this.roadProtectionInspection = roadProtectionInspection;
	}
	public List<RoadProtectionSource> getSource() {
		return source;
	}
	public void setSource(List<RoadProtectionSource> source) {
		this.source = source;
	}
	
}

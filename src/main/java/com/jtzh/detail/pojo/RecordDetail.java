package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.RoadProtectionRecord;
import com.jtzh.entity.RoadProtectionSource;

public class RecordDetail {
	private RoadProtectionRecord record;
	private List<RoadProtectionSource> source;
	public RoadProtectionRecord getRecord() {
		return record;
	}
	public void setRecord(RoadProtectionRecord record) {
		this.record = record;
	}
	public List<RoadProtectionSource> getSource() {
		return source;
	}
	public void setSource(List<RoadProtectionSource> source) {
		this.source = source;
	}
	
}

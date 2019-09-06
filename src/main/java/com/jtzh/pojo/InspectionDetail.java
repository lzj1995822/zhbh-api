package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.SecuritySource;

public class InspectionDetail {
	private InspectionRecord inspectionRecord;
	private List<SecuritySource> source;
	
	public InspectionRecord getInspectionRecord() {
		return inspectionRecord;
	}
	public void setInspectionRecord(InspectionRecord inspectionRecord) {
		this.inspectionRecord = inspectionRecord;
	}
	public List<SecuritySource> getSource() {
		return source;
	}
	public void setSource(List<SecuritySource> source) {
		this.source = source;
	}


}

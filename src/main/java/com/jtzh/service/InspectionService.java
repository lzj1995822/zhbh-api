package com.jtzh.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.InspectionDetail;
import com.jtzh.pojo.InspectionParam;

public interface InspectionService {
	
	public Object getInspectionList(InspectionParam param);

	public InspectionDetail getInspectionInfo(String id);

	public Object addInspection(InspectionDetail inspectionDetail, LoginUserTest user);
	
	Object updateInspection(InspectionRecord param);

	public Object deleteInspection(String id, String sourceType);

	public Object countInspectionState();
	
	public Object countInspectionYear(String year);
	
	public Object countInspectionByMonth(String year);
	
	public Object countInspectionByDay(String year);
	
	public Object getInspectionGis();

}

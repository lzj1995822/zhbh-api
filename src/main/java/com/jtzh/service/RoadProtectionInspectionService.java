package com.jtzh.service;

import java.util.List;

import com.jtzh.detail.pojo.RoadProtectionInspectionDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionInspection;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.RoadProtectionInspectionPagination;

public interface RoadProtectionInspectionService {
	public BaseResponse<List<RoadProtectionInspection>> getRoadProtectionInspectionList(RoadProtectionInspectionPagination param);
	
	public BaseResponse<RoadProtectionInspectionDetail> getRoadProtectionInspection(Long id);
	
	public BaseResponse<String> removeRoadProtectionInspection(Long id);
	
	public BaseResponse<String> addRoadProtectionInspection(RoadProtectionInspectionDetail detail, LoginUserTest user);
	
	public BaseResponse<String> modifyRoadProtectionInspection(RoadProtectionInspectionDetail detail);
}

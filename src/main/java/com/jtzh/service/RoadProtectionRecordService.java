package com.jtzh.service;

import com.jtzh.detail.pojo.RecordDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.RoadProtectionRecordPagination;

public interface RoadProtectionRecordService {
	public Object getRoadProtectionRecordList(RoadProtectionRecordPagination param);

	public Object getRoadProtectionRecord(Long id);

	public Object removeRoadProtectionRecord(Long id);

	public Object addRoadProtectionRecord(RecordDetail detail, LoginUserTest user);

	public Object modifyRoadProtectionRecord(RecordDetail detail);

}

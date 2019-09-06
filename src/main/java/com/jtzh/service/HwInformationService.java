package com.jtzh.service;

import com.jtzh.entity.HwInformation;
import com.jtzh.entity.HwInformationTypeCount;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.HwInformationDetail;
import com.jtzh.pojo.HwInformationParam;

import java.util.List;

public interface HwInformationService {
	
	public Object getHwInformationList(HwInformationParam param); // 查询

	public HwInformationDetail getHwInformationInfo(String id); // 查看详情

	public Object addHwInformation(HwInformationDetail hwInformationDetail, LoginUserTest user); // 新建
	
	public Object deleteHwInformation(String id, String sourceType); // 删除
	
	Object updateHwInformation(HwInformation param); // 修改


	public List<HwInformationTypeCount> getHwInformationTypeCount();
}

package com.jtzh.service;

import com.jtzh.entity.CgInformation;
import com.jtzh.entity.CgInformationTypeCount;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CgInformationDetail;
import com.jtzh.pojo.CgInformationParam;

import java.util.List;

public interface CgInformationService {
	
	public Object getCgInformationList(CgInformationParam param); // 查询

	public CgInformationDetail getCgInformationInfo(String id); // 查看详情

	public Object addCgInformation(CgInformationDetail cgInformationDetail, LoginUserTest user); // 新建
	
	public Object deleteCgInformation(String id, String sourceType); // 删除
	
	Object updateCgInformation(CgInformation param); // 修改

	public List <CgInformationTypeCount> getCgInformationTypeCount();

}

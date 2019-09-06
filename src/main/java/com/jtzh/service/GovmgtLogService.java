package com.jtzh.service;

import com.jtzh.entity.GovmgtLog;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.GovmgtLogParam;

public interface GovmgtLogService {
	
	public Object getGovmgtLogList(GovmgtLogParam param); // 查询
	
	public GovmgtLog getGovmgtLogInfo(String id); // 查看详情
	
	public Object addGovmgtLog(GovmgtLog param, LoginUserTest user); // 新建
	
	Object updateGovmgtLog(GovmgtLog param); // 修改
	
	public Object deleteGovmgtLog(String id); // 删除

}

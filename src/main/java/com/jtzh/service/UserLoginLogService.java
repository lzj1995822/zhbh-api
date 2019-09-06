package com.jtzh.service;


import com.jtzh.entity.UserLoginLog;
import com.jtzh.pojo.UserLoginLogPagination;

public interface UserLoginLogService {
	public Object addUserLoginLog(UserLoginLog userLoginLog);
	
	public Object getUserLoginLogList(UserLoginLogPagination param);
	
}

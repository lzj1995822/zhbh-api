package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.UserInfomationPagination;
import com.jtzh.pojo.UserPassword;

public interface UserinfomationService {
	
	public Object getUserinfo(Integer id);

	public Object removeUserinfo(Integer id);

	public Object addUserinfo(Userinformation detail);

	public Object modifyUserinfo(Userinformation detail);
	
	public Object getUserinfoList(UserInfomationPagination param);

	public Object getLoginInfo(Userinformation user);

	public Object modifyUserPwd(UserPassword param);
}

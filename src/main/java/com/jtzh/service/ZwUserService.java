package com.jtzh.service;

import com.jtzh.entity.GovmgtUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.UserPagination;

public interface ZwUserService {
	public Object getUserList(UserPagination param);

	public Object getUser(String id);

	public Object removeUser(String id);

	public Object insertUser(GovmgtUser user, LoginUserTest loginUser);

	public Object updateUser(GovmgtUser user);

	public Object getTree();

	public Object getUserTree();
	
	public Object getAllUserList(GovmgtUser param);
}

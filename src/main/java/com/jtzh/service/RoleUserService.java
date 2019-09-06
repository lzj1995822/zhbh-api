package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoleUser;
import com.jtzh.pojo.RoleUserPagination;

public interface RoleUserService {

	public Object getRoleUser(Integer id);

	public Object removeRoleUser(Integer id);

	public Object addRoleUser(RoleUser detail);

	public Object modifyRoleUser(RoleUser detail);
	
	public Object getRoleUserList(RoleUserPagination param);
	
	public Object selectRoleNameByUserId(Integer id);
}

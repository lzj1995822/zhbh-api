package com.jtzh.service;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.MenuRole;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.MenuRolePagination;

public interface MenuRoleService {
	public Object getMenuRole(Integer id);

	public Object removeMenuRole(Integer id);

	public Object addMenuRole(MenuRole detail);

	public Object modifyMenuRole(MenuRole detail);
	
	public Object getMenuRoleList(MenuRolePagination param);
	
	public Object getMenuRoleUserList(Userinformation parpm);
}

package com.jtzh.service;

import java.util.List;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PermissionName;
import com.jtzh.entity.Permissionconfiguration;
import com.jtzh.pojo.PermissionconfigurationPagination;

public interface PermissionconfigurationService {
	public Object getPermissionconfig(Integer id);

	public Object removePermissionconfig(Integer id);

	public Object addPermissionconfig(Permissionconfiguration detail, LoginUserTest user);

	public Object modifyPermissionconfig(Permissionconfiguration detail);

	public Object getPermissionconfigList(PermissionconfigurationPagination param);

	public List<PermissionName> getPCNumberName();
}

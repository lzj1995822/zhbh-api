package com.jtzh.service;

import com.jtzh.entity.RoleUser;
import org.springframework.web.bind.annotation.PathVariable;

import com.jtzh.entity.CharacterUserinfo;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CharacterUserinfoPagination;

public interface CharacterUserinfoService {

	public Object getCharacterUserinfo(Integer id);

	public Object removeCharacterUserinfo(Integer id);

	public Object addCharacterUserinfo(CharacterUserinfo detail,LoginUserTest user);

	public Object modifyCharacterUserinfo(CharacterUserinfo detail,LoginUserTest user);
	
	public Object getCharacterUserinfoList(CharacterUserinfoPagination param);
	
	public String getCharacterUserinfoName(Integer id);
	
	public Object getCharacersList(CharacterUserinfoPagination param);
	
	public Object getIdByName(String CRoleName);
	
	public Object getCharacterUserTree();
	
	public Object getMenuTree(Integer id);

	public Object getMenuTreeByUserId(String id);
	
	public Object getAllRole();
	
}

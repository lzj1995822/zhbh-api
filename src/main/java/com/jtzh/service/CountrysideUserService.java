package com.jtzh.service;

import com.jtzh.entity.CountrysideUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideUserParam;

public interface CountrysideUserService {
	
	public Object getCountrysideUserList(CountrysideUserParam param); // 查询

	public CountrysideUser getCountrysideUserInfo(String id); // 查看详情

	public Object addCountrysideUser(CountrysideUser cguser, LoginUserTest user); // 新建
	
	public Object deleteCountrysideUser(String id); // 删除
	
	Object updateCountrysideUser(CountrysideUser param); // 修改

}

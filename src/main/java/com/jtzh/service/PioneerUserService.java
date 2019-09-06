package com.jtzh.service;

import javax.servlet.http.HttpServletResponse;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PioneerUser;
import com.jtzh.pojo.PioneerUserPagination;

public interface PioneerUserService {
	public Object getPioneerUserList(PioneerUserPagination param);

	public Object getPioneerUser(String id);

	public Object removePioneerUser(String id);

	public Object insertPioneerUser(PioneerUser user, LoginUserTest loginUser);

	public Object updatePioneerUser(PioneerUser user);

	public Object countNumber();

	public Object exportExcel(HttpServletResponse response);
}

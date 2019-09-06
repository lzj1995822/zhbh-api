package com.jtzh.service;

import javax.servlet.http.HttpServletRequest;

import com.jtzh.entity.LoginUserTest;

public interface LoginUserTestService {
	public Object getTestUser(HttpServletRequest request, LoginUserTest user);

	public Object getTestUserInfo(HttpServletRequest request);
}

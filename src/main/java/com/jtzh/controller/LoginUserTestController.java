package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.service.LoginUserTestService;

@RestController
@RequestMapping("loginUserTestController")
public class LoginUserTestController {
	@Resource
	private LoginUserTestService loginUserTestService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object login(@RequestBody LoginUserTest user, HttpServletRequest request) {
		if (user.getLoginId() != null) {
			return loginUserTestService.getTestUser(request, user);
		} else {
			ResultObject obj = new ResultObject();
			obj.setResult(false);
			return obj;
		}
	}
}

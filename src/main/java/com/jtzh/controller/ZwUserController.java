package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.GovmgtUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.UserPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.ZwUserService;

import io.swagger.annotations.Api;

@Api(tags = "政务人员管理")
@RestController
@RequestMapping("user")
public class ZwUserController {
	@Resource
	private ZwUserService userService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取政务管理人员列表后台api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	public Object getUserList(@RequestBody UserPagination param) {
		return userService.getUserList(param);
	}

	/**
	 * 获取人员详情后台api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public Object getUser(@PathVariable("id") String id) {
		return userService.getUser(id);
	}

	/**
	 * 删除人员后台api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeUser/{id}", method = RequestMethod.GET)
	public Object removeUser(@PathVariable("id") String id) {
		return userService.removeUser(id);
	}

	/**
	 * 新建人员后台api
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public Object insertUser(@RequestBody GovmgtUser user, HttpServletRequest request) {
		LoginUserTest loginUser = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return userService.insertUser(user, loginUser);
	}

	/**
	 * 修改人员后台api
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public Object updateUser(@RequestBody GovmgtUser user) {
		return userService.updateUser(user);
	}

	/**
	 * 废弃的组织架构接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "getTree", method = RequestMethod.POST)
	public Object getTree() {
		return userService.getTree();
	}

	/**
	 * 组织架构接口 api
	 * 
	 * @return
	 */
	@RequestMapping(value = "getUserTree", method = RequestMethod.POST)
	public Object getUserTree() {
		return userService.getUserTree();
	}
	
	/**
	 * 获取政务管理人员菜单后台api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getAllUserList", method = RequestMethod.POST)
	public Object getAllUserList(GovmgtUser param) {
		return userService.getAllUserList(param);
	}
}

package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.util.Cors;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.UserInfomationPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.UserinfomationService;

import io.swagger.annotations.Api;
/**
 * 用户的增删改查和分页查询所有
 * @author JTZH
 *
 */
@Api(tags = "运维用户管理")
@RestController
@RequestMapping("userinformationController")
public class UserinformationController extends Cors{
	@Autowired
	private HttpServletRequest context;
	@Resource
	private UserinfomationService userinfomationService;
	@Resource
	private LoginUserTestService loginUserTestService;
	//获取列表
	/**
	 * 分页查询用户信息api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getUserinfoList", method = RequestMethod.POST)
	public Object getUserinfoList(@RequestBody UserInfomationPagination param) {
		return  userinfomationService.getUserinfoList(param);
	}
	/**
	 * 添加用户api
	 * @param permission
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/insertUserinfo", method = RequestMethod.POST)
	public Object insertUserinfo(@RequestBody Userinformation userinfo, HttpServletRequest request) {
		return userinfomationService.addUserinfo(userinfo);
	}
	/**
	 * 删除用户信息api
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeUserinfo/{id}", method = RequestMethod.GET)
	public Object removeUserinfo(@PathVariable("id") String id) {
		return userinfomationService.removeUserinfo(Integer.parseInt(id));
	}

	/**
	 * 修改用户信息api
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/updateUserinfo", method = RequestMethod.POST)
	public Object updateUserinfo(@RequestBody Userinformation userinfo) {
		return userinfomationService.modifyUserinfo(userinfo);
	}
	/**
	 * 查找用户api
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getUserinfro/{id}", method = RequestMethod.GET)
	public Object getUserinfro(@PathVariable("id") String id) {	
		return userinfomationService.getUserinfo(Integer.parseInt(id));
	}
}

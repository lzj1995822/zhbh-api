package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CountrysideUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideUserParam;
import com.jtzh.service.CountrysideUserService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "村建角色管理")
@RestController
@RequestMapping("CountrysideUser")
public class CountrysideUserController {
	
	@Resource
	private CountrysideUserService countrysideUserService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取人员列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideUserList", method = RequestMethod.POST)
	public Object getCountrysideUserList(@RequestBody CountrysideUserParam param) {
		
		return countrysideUserService.getCountrysideUserList(param);
	}

	/**
	 * 获取人员详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideUserInfo/{id}", method = RequestMethod.GET)
	public Object getCountrysideUserInfo(@PathVariable("id") String id) {
		return countrysideUserService.getCountrysideUserInfo(id);
	}

	/**
	 * 新增人员信息api
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/addCountrysideUser", method = RequestMethod.POST)
	public Object addCountrysideUser(@RequestBody CountrysideUser cuser,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return countrysideUserService.addCountrysideUser(cuser, user);
	}
	
	/**
	 * 删除人员信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCountrysideUser/{id}", method = RequestMethod.GET)
	public Object deleteCountrysideUser(@PathVariable("id") String id) {
		return countrysideUserService.deleteCountrysideUser(id);
	}
	
	/**
	 * 修改人员信息api
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updateCountrysideUser", method = RequestMethod.POST)
	public Object updateCountrysideUser(@RequestBody CountrysideUser param) {
		return countrysideUserService.updateCountrysideUser(param);
	}

}

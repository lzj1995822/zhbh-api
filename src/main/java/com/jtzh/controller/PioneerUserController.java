package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jtzh.mapper.PioneerOrgMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PioneerUser;
import com.jtzh.pojo.PioneerUserPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.PioneerUserService;

import io.swagger.annotations.Api;

@Api(tags = "宝华先锋党员管理")
@RestController
@RequestMapping("pioneerUser")
public class PioneerUserController {
	@Resource
	private PioneerUserService pioneerUserService;
	@Resource
	private LoginUserTestService loginUserTestService;



	/**
	 * 宝华先锋党员分页 api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getPioneerUserList", method = RequestMethod.POST)
	public Object getPioneerUserList(@RequestBody PioneerUserPagination param) {
		return pioneerUserService.getPioneerUserList(param);
	}

	/**
	 * 根据id查询详细信息 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getPioneerUser/{id}", method = RequestMethod.GET)
	public Object getPioneerUser(@PathVariable("id") String id) {
		return pioneerUserService.getPioneerUser(id);
	}

	/**
	 * 根据id删除党员 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removePioneerUser/{id}", method = RequestMethod.GET)
	public Object removePioneerUser(@PathVariable("id") String id) {
		return pioneerUserService.removePioneerUser(id);
	}

	/**
	 * 添加党员 api
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addPioneerUser", method = RequestMethod.POST)
	public Object insertPioneerUser(@RequestBody PioneerUser user, HttpServletRequest request) {
		LoginUserTest loginUser = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return pioneerUserService.insertPioneerUser(user, loginUser);
	}

	/**
	 * 修改党员 api
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public Object updatePioneerUser(@RequestBody PioneerUser user) {
		return pioneerUserService.updatePioneerUser(user);
	}

	/**
	 * 统计党组织对应的党员数量 api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/countNumber", method = RequestMethod.POST)
	public Object countNumber() {
		return pioneerUserService.countNumber();
	}

	/**
	 * 导出党员信息 api
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		pioneerUserService.exportExcel(response);
		return null;
	}
}

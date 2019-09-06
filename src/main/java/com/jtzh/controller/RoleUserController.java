package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoleUser;
import com.jtzh.pojo.RoleUserPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.RoleUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "运维用户角色管理")
@RestController
@RequestMapping("roleUserController")
public class RoleUserController {
	@Autowired
	private HttpServletRequest context;
	@Resource
	private RoleUserService roleUserService;
	@Resource
	private LoginUserTestService loginUserTestService;
	/**
	 * 查询所有的
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getRoleUserList", method = RequestMethod.POST)
	public Object getRoleUserList(@RequestBody RoleUserPagination param) {
		return roleUserService.getRoleUserList(param);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeRoleUserfig/{id}", method = RequestMethod.GET)
	public Object removeRoleUserfig(@PathVariable("id") String id) {
		return roleUserService.removeRoleUser(Integer.parseInt(id));
	}
	/**
	 * 添加
	 * @param permission
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addRoleUserfig", method = RequestMethod.POST)
	public Object addRoleUserfig(@RequestBody RoleUser roleUser, HttpServletRequest request) {
		return roleUserService.addRoleUser(roleUser);
	}
	/**
	 * 修改
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/modifyRoleUserfig", method = RequestMethod.POST)
	public Object modifyRoleUserfig(@RequestBody RoleUser roleUser) {
		return roleUserService.modifyRoleUser(roleUser);
	}
	/**
	 * 获取
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getRoleUserfig/{id}", method = RequestMethod.GET)
	public Object getRoleUserfig(@PathVariable("id") String id) {	
		return roleUserService.getRoleUser(Integer.parseInt(id));

	}
	
	@ApiOperation(value = "运维根据用户id查找角色名称")
	@RequestMapping(value = "/selectRoleNameByUserId/{id}", method = RequestMethod.GET)
	public Object selectRoleNameByUserId(@PathVariable("id") String id) {	
		return roleUserService.selectRoleNameByUserId(Integer.parseInt(id));
	}
	
}

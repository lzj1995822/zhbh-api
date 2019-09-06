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
import com.jtzh.entity.Permissionconfiguration;
import com.jtzh.pojo.PermissionconfigurationPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.PermissionconfigurationService;
/**
 * 权限增删改查和查找对应的角色、用户、菜单的中文名称功能
 * @author JTZH
 *
 */
@RestController
@RequestMapping("permissionconfigurationController")
public class PermissionconfigurationController extends BaseCController{
	@Autowired
	private HttpServletRequest context;
	@Resource
	private PermissionconfigurationService permissionconfigurationService;
	@Resource
	private LoginUserTestService loginUserTestService;
	/**
	 * 查询所有的权限
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getPermissionconfigList", method = RequestMethod.POST)
	public Object getPermissionconfigList(@RequestBody PermissionconfigurationPagination param) {
		return permissionconfigurationService.getPermissionconfigList(param);
	}
	/**
	 * 删除权限
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removePermissionconfig/{id}", method = RequestMethod.GET)
	public Object removePermissionconfig(@PathVariable("id") String id) {
		return permissionconfigurationService.removePermissionconfig(Integer.parseInt(id));
	}
	/**
	 * 添加权限
	 * @param permission
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addPermissionconfig", method = RequestMethod.POST)
	public Object addPermissionconfig(@RequestBody Permissionconfiguration permission, HttpServletRequest request) {
		LoginUserTest loginUser = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return permissionconfigurationService.addPermissionconfig(permission, loginUser);
	}
	/**
	 * 修改权限信息
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/modifyPermissionconfig", method = RequestMethod.POST)
	public Object modifyPermissionconfig(@RequestBody Permissionconfiguration permission) {
		return permissionconfigurationService.modifyPermissionconfig(permission);
	}
	/**
	 * 获取权限信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getPermissionconfig/{id}", method = RequestMethod.GET)
	public Object getPermissionconfig(@PathVariable("id") String id) {	
		return permissionconfigurationService.getPermissionconfig(Integer.parseInt(id));

	}
	/**
	 * 查询权限对应的角色、用户、菜单的中文名称
	 * @return
	 */
	@RequestMapping(value = "/getPCNumberName", method = RequestMethod.GET)
	public Object getPCNumberName() {	
		return permissionconfigurationService.getPCNumberName();
	}

}

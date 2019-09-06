package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.DeptUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.DeptUserPagination;
import com.jtzh.service.DeptUserService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "部门人员管理")
@RestController
@RequestMapping("deptUserController")
public class DeptUserController {
	@Autowired
	private HttpServletRequest context;
	@Resource
	private DeptUserService deptUserService;
	@Resource
	private LoginUserTestService loginUserTestService;
	/**
	 * 查询所有
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getDeptUserList", method = RequestMethod.POST)
	public Object getDeptUserList(@RequestBody DeptUserPagination param) {
		return deptUserService.getDeptUserList(param);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeDeptUser/{id}", method = RequestMethod.GET)
	public Object removeDeptUser(@PathVariable("id") String id) {
		return deptUserService.removeDeptUser(Integer.parseInt(id));
	}
	/**
	 * 添加
	 * @param permission
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addDeptUser", method = RequestMethod.POST)
	public Object addDeptUser(@RequestBody DeptUser deptUser, HttpServletRequest request) {
		return deptUserService.addDeptUser(deptUser);
	}
	/**
	 * 修改
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/modifyDeptUser", method = RequestMethod.POST)
	public Object modifyDeptUser(@RequestBody DeptUser deptUser) {
		return deptUserService.modifyDeptUser(deptUser);
	}
	/**
	 * 获取
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getDeptUser/{id}", method = RequestMethod.GET)
	public Object getDeptUser(@PathVariable("id") String id) {	
		return deptUserService.getDeptUser(Integer.parseInt(id));

	}

}

package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.Department;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.Departmentpagination;
import com.jtzh.service.DepartmentService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "运维部门管理")
@RestController
@RequestMapping("departmentController")
public class DepartmentController {
	@Autowired
	private HttpServletRequest context;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private LoginUserTestService loginUserTestService;
	/**
	 * 查询所有的
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取运维部门")
	@RequestMapping(value = "/getDepartmentList", method = RequestMethod.POST)
	public Object getDepartmentList(@RequestBody Departmentpagination param) {
		return departmentService.getDepartmentList(param);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除运维部门")
	@RequestMapping(value = "/removeDepartment/{id}", method = RequestMethod.GET)
	public Object removeDepartment(@PathVariable("id") String id) {
		return departmentService.removeDepartment(Integer.parseInt(id));
	}
	/**
	 * 添加
	 * @param permission
	 * @param request
	 * @return
	 */
	@ApiOperation(value="新建运维部门")
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public Object addDepartment(@RequestBody Department department, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest)loginUserTestService.getTestUserInfo(request);
		return departmentService.addDepartment(department,user);
	}
	/**
	 * 修改
	 * @param permission
	 * @return
	 */
	@ApiOperation(value="修改运维部门")
	@RequestMapping(value = "/modifyDepartment", method = RequestMethod.POST)
	public Object modifyDepartment(@RequestBody Department department) {
		return departmentService.modifyDepartment(department);
	}
	/**
	 * 获取
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询运维部门")
	@RequestMapping(value = "/getDepartment/{id}", method = RequestMethod.GET)
	public Object getDepartment(@PathVariable("id") String id) {	
		return departmentService.getDepartment(Integer.parseInt(id));
	}
	
	/**
	 * 拉取所有运维部门
	 * 
	 * @return
	 */
	@ApiOperation(value="拉取所有运维部门")
	@RequestMapping(value = "/getAllDepartment", method = RequestMethod.POST)
	public Object getAllDepartment() {
		return departmentService.getAllDepartment();
	}

}

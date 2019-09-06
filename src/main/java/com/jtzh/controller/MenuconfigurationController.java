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
import com.jtzh.entity.Menuconfiguration;
import com.jtzh.pojo.MenuconfigurationPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.MenuconfigurationService;

import io.swagger.annotations.Api;

@Api(tags = "运维菜单管理")
@RestController
@RequestMapping("menuconfigurationController")
public class MenuconfigurationController extends BaseCController {
	@Autowired
	private HttpServletRequest context;
	@Resource
	private MenuconfigurationService menuconfigurationService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 查询所有的菜单
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getMenuconfigList", method = RequestMethod.POST)
	public Object getMenuconfigList(@RequestBody MenuconfigurationPagination param) {
		return menuconfigurationService.getMenuconfigList(param);
	}
	
	/**
	 * 不分页查询所有的菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAllMenuconfig", method = RequestMethod.POST)
	public Object getAllMenuconfig() {
		return menuconfigurationService.getAllMenuconfig();
	}

	/**
	 * 添加菜单
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/addMenuconfig", method = RequestMethod.POST)
	public Object addMenuconfig(@RequestBody Menuconfiguration menu, HttpServletRequest request) {
		LoginUserTest loginUser = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return menuconfigurationService.addMenuconfig(menu);
	}

	/**
	 * 移除菜单
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/removeMenuconfig/{id}", method = RequestMethod.GET)
	public Object removeMenuconfig(@PathVariable("id") String id) {
		return menuconfigurationService.removeMenuconfig(Integer.parseInt(id));
	}

	/**
	 * 修改菜单
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/modifyMenuconfig", method = RequestMethod.POST)
	public Object modifyMenuconfig(@RequestBody Menuconfiguration menu) {
		return menuconfigurationService.modifyMenuconfig(menu);
	}

	/**
	 * 查询菜单
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getMenuconfig/{id}", method = RequestMethod.GET)
	public Object getMenuconfig(@PathVariable("id") String id) {
		System.out.println("MenuconfigurationController.getMenuconfig()" + id);
		return menuconfigurationService.getMenuconfig(Integer.parseInt(id));
	}

}

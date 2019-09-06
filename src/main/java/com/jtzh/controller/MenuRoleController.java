package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.MenuRole;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.MenuRolePagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.MenuRoleService;

import io.swagger.annotations.Api;

@Api(tags = "运维角色菜单管理")
@RestController
@RequestMapping("menuRoleController")
public class MenuRoleController extends BaseCController{
	@Autowired
	private HttpServletRequest context;
	@Resource
	private MenuRoleService menuRoleService;
	@Resource
	private LoginUserTestService loginUserTestService;
	/**
	 * 查询所有的
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getMenuRoleList", method = RequestMethod.POST)
	public Object getMenuRoleList(@RequestBody MenuRolePagination param) {
		return menuRoleService.getMenuRoleList(param);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeMenuRole/{id}", method = RequestMethod.GET)
	public Object removeMenuRole(@PathVariable("id") String id) {
		return menuRoleService.removeMenuRole(Integer.parseInt(id));
	}
	/**
	 * 添加
	 * @param permission
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addMenuRole", method = RequestMethod.POST)
	public Object addMenuRole(@RequestBody MenuRole menuRole, HttpServletRequest request) {
		return menuRoleService.addMenuRole(menuRole);
	}
	/**
	 * 修改
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/modifyMenuRole", method = RequestMethod.POST)
	public Object modifyMenuRole(@RequestBody MenuRole menuRole) {
		return menuRoleService.modifyMenuRole(menuRole);
	}
	/**
	 * 获取权
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getMenuRole/{id}", method = RequestMethod.GET)
	public Object getMenuRole(@PathVariable("id") String id) {	
		return menuRoleService.getMenuRole(Integer.parseInt(id));
	}
	
	@RequestMapping(value = "/getMenuRoleUserList", method = RequestMethod.POST)
	public Object getMenuRoleUserList(HttpServletRequest request, HttpServletResponse response) {
		Userinformation user=new Userinformation(); 
		Cookie cs=null;
		String	authUser=null;
		//获取登陆用户
		Cookie[] coos=request.getCookies();
		if(coos!=null) {
			for (Cookie c : coos) {
				if(c.getName().equals("auth_user")) {
					cs=c;
				}
			}
		}
		if(cs!=null) 	authUser=cs.getValue();
		//对登陆用户解密
		String keys = decrypt(authUser);
		if(keys!=null){
			//对登陆用户加密
			user.setId(Integer.parseInt(keys));
		}

		return menuRoleService.getMenuRoleUserList(user);
	}

	
}

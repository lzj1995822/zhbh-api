package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CharacterUserinfo;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CharacterUserinfoPagination;
import com.jtzh.service.CharacterUserinfoService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * 角色的增删改查和分页查询所有
 * @author JTZH
 *
 */
@Api(tags = "运维角色管理")
@RestController
@RequestMapping("characterUserinfoController")
public class CharacterUserinfoController {
	@Autowired
	private HttpServletRequest context;
	@Resource
	private CharacterUserinfoService characterUserinfoService;
	@Resource
	private LoginUserTestService loginUserTestService;
	/**
	 * 分页查询角色api
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCharacterUserinfoList", method = RequestMethod.POST)
	public Object getCharacterUserinfoList(@RequestBody CharacterUserinfoPagination param) {
		return characterUserinfoService.getCharacterUserinfoList(param);
	}
	
	@ApiOperation(value="运维获取所有角色")
	@RequestMapping(value = "/getAllRole", method = RequestMethod.POST)
	public Object getAllRole() {
		return characterUserinfoService.getAllRole();
	}
	/**
	 * 删除角色api
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeCharacterUserinfo/{id}", method = RequestMethod.GET)
	public Object removeCharacterUserinfo(@PathVariable("id") String id) {
		return characterUserinfoService.removeCharacterUserinfo(Integer.parseInt(id));
	}

	/**
	 * 添加角色api
	 * @param character
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addCharacterUserinfo", method = RequestMethod.POST)
	public Object addCharacterUserinfo(@RequestBody CharacterUserinfo character, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest)loginUserTestService.getTestUserInfo(request);
		return characterUserinfoService.addCharacterUserinfo(character,user);
	}

	/**
	 * 修改角色api
	 * @param character
	 * @return
	 */
	@RequestMapping(value = "/modifyCharacterUserinfo", method = RequestMethod.POST)
	public Object modifyCharacterUserinfo(@RequestBody CharacterUserinfo character, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest)loginUserTestService.getTestUserInfo(request);
		return characterUserinfoService.modifyCharacterUserinfo(character,user);
	}
	
	
	//
	/**
	 * 查找角色详情api
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCharacterUserinfo/{id}", method = RequestMethod.GET)
	public Object getCharacterUserinfo(@PathVariable("id") String id) {	
		return characterUserinfoService.getCharacterUserinfo(Integer.parseInt(id));
		
	}
	@RequestMapping(value = "/getCharacersList", method = RequestMethod.POST)
	public Object getCharacersList(@RequestBody CharacterUserinfoPagination param) {
		return characterUserinfoService.getCharacersList(param);
	}
	
	/**
	 * 获得角色树  api
	 * 
	 * @return
	 */
	@RequestMapping(value = "getCharacterUserTree", method = RequestMethod.POST)
	public Object getCharacterUserTree() {
		return characterUserinfoService.getCharacterUserTree();
	}
	
	/**
	 * 根据角色id获得对应的菜单树  api
	 * 
	 * @return
	 */
	@RequestMapping(value = "getMenuTree/{id}", method = RequestMethod.GET)
	public Object getMenuTree(@PathVariable("id") String id) {
		return characterUserinfoService.getMenuTree(Integer.parseInt(id));
	}

	/**
	 *	根据用户id获取权限树
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getMenuTreeByUserId/{id}",method = RequestMethod.GET)
	public Object getMenuTreeByUserId(@PathVariable("id")String id){

		return characterUserinfoService.getMenuTreeByUserId(id);
	}

}

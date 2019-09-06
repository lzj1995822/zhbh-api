package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PioneerOrg;
import com.jtzh.pojo.PioneerOrgPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.PioneerOrgService;

import io.swagger.annotations.Api;

@Api(tags = "宝华先锋组织架构管理")
@RestController
@RequestMapping("pioneerOrg")
public class PioneerOrgController {
	@Resource
	private PioneerOrgService pioneerOrgService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 分页获取宝华先锋组织架构 api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getPioneerOrgList", method = RequestMethod.POST)
	public Object getPioneerOrgList(@RequestBody PioneerOrgPagination param) {
		return pioneerOrgService.getPioneerOrgList(param);
	}

	/**
	 * 根据id查询具体信息 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getPioneerOrg/{id}", method = RequestMethod.GET)
	public Object getPioneerOrg(@PathVariable("id") String id) {
		return pioneerOrgService.getPioneerOrg(id);
	}

	/**
	 * 根据id删除 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removePioneerOrg/{id}", method = RequestMethod.GET)
	public Object removePioneerOrg(@PathVariable("id") String id) {
		return pioneerOrgService.removePioneerOrg(id);
	}

	/**
	 * 新建组织 api
	 * 
	 * @param org
	 * @return
	 */
	@RequestMapping(value = "/addPioneerOrg", method = RequestMethod.POST)
	public Object insertPioneerOrg(@RequestBody PioneerOrg org, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return pioneerOrgService.insertPioneerOrg(org, user);
	}

	/**
	 * 修改组织 api
	 * 
	 * @param org
	 * @return
	 */
	@RequestMapping(value = "/updatePioneerOrg", method = RequestMethod.POST)
	public Object updatePioneerOrg(@RequestBody PioneerOrg org) {
		return pioneerOrgService.updatePioneerOrg(org);
	}

	/**
	 * 获得组织架构树 api
	 * 
	 * @return
	 */
	@RequestMapping(value = "getPioneerOrgTree", method = RequestMethod.POST)
	public Object getPioneerOrgTree() {
		return pioneerOrgService.getPioneerOrgTree();
	}
	
	/**
	 * 党组织统计 api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCountList", method = RequestMethod.POST)
    public Object getCountList() {
    	Long count=pioneerOrgService.getCountList();
		return count;
	}
	
	/**
	 * 党组织统计 api
	 * 
	 * @return
	 */
	@RequestMapping("/getCountOrgList")
    public Object getCountOrgList() {
    	Object obj =pioneerOrgService.getCountOrgList();
		return obj;
	}
}

package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WorkshopAdm;
import com.jtzh.entity.WorkshopEnt;
import com.jtzh.entity.WorkshopEqu;
import com.jtzh.pojo.HiddenParam;
import com.jtzh.pojo.WorkshopParam;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.WorkshopService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "安全厂房管理")
@RestController
@RequestMapping("Workshop")
public class WorkshopController {
	
	@Resource
	private WorkshopService workshopService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	// 企业档案
	/**
	 * 获取企业档案列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getWorkshopEntList", method = RequestMethod.POST)
	public Object getWorkshopEntList(@RequestBody WorkshopParam param) {
		return workshopService.getWorkshopEntList(param);
	}
	
	/**
	 * 获取企业档案详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getWorkshopEnt/{id}", method = RequestMethod.GET)
	public Object getWorkshopEnt(@PathVariable("id") String id) {
		return workshopService.getWorkshopEnt(id);
	}
	
	/**
	 * 新建企业档案api
	 * 
	 * @param WorkshopEnt
	 * @return
	 */
	@RequestMapping(value = "/addWorkshopEnt", method = RequestMethod.POST)
	public Object addWorkshopEnt(@RequestBody WorkshopEnt ent, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return workshopService.addWorkshopEnt(ent, user);
	}
	
	/**
	 * 修改企业档案api
	 * 
	 * @param WorkshopEnt
	 * @return
	 */
	@RequestMapping(value = "/updateWorkshopEnt", method = RequestMethod.POST)
	public Object updateWorkshopEnt(@RequestBody WorkshopEnt param) {
		return workshopService.updateWorkshopEnt(param);
	}
	
	/**
	 * 删除企业档案api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteWorkshopEnt/{id}", method = RequestMethod.GET)
	public Object deleteWorkshopEnt(@PathVariable("id") String id) {
		return workshopService.deleteWorkshopEnt(id);
	}
	
	// 厂区概况
	/**
	 * 获取厂区概况列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getWorkshopAdmList", method = RequestMethod.POST)
	public Object getWorkshopAdmList(@RequestBody WorkshopParam param) {
		return workshopService.getWorkshopAdmList(param);
	}
	
	/**
	 * 获取厂区概况详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getWorkshopAdm/{id}", method = RequestMethod.GET)
	public Object getWorkshopAdm(@PathVariable("id") String id) {
		return workshopService.getWorkshopAdm(id);
	}
	
	/**
	 * 新建厂区概况api
	 * 
	 * @param WorkshopEnt
	 * @return
	 */
	@RequestMapping(value = "/addWorkshopAdm", method = RequestMethod.POST)
	public Object addWorkshopAdm(@RequestBody WorkshopAdm adm, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return workshopService.addWorkshopAdm(adm, user);
	}
	
	/**
	 * 修改厂区概况api
	 * 
	 * @param WorkshopEnt
	 * @return
	 */
	@RequestMapping(value = "/updateWorkshopAdm", method = RequestMethod.POST)
	public Object updateWorkshopAdm(@RequestBody WorkshopAdm param) {
		return workshopService.updateWorkshopAdm(param);
	}
	
	/**
	 * 删除厂区概况api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteWorkshopAdm/{id}", method = RequestMethod.GET)
	public Object deleteWorkshopAdm(@PathVariable("id") String id) {
		return workshopService.deleteWorkshopAdm(id);
	}
	
	/**
	 * 获取厂房gis api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getAdmGis", method = RequestMethod.POST)
	public Object getAdmGis() {
		return workshopService.getAdmGis();
	}
	
	// 器材管理
	/**
	 * 获取器材管理列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getWorkshopEquList", method = RequestMethod.POST)
	public Object getWorkshopEquList(@RequestBody WorkshopParam param) {
		return workshopService.getWorkshopEquList(param);
	}
	
	/**
	 * 获取器材管理详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getWorkshopEqu/{id}", method = RequestMethod.GET)
	public Object getWorkshopEqu(@PathVariable("id") String id) {
		return workshopService.getWorkshopEqu(id);
	}
	
	/**
	 * 新建器材管理api
	 * 
	 * @param WorkshopEqu
	 * @return
	 */
	@RequestMapping(value = "/addWorkshopEqu", method = RequestMethod.POST)
	public Object addWorkshopEqu(@RequestBody WorkshopEqu ent, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return workshopService.addWorkshopEqu(ent, user);
	}
	
	/**
	 * 修改器材管理api
	 * 
	 * @param WorkshopEqu
	 * @return
	 */
	@RequestMapping(value = "/updateWorkshopEqu", method = RequestMethod.POST)
	public Object updateWorkshopEqu(@RequestBody WorkshopEqu param) {
		return workshopService.updateWorkshopEqu(param);
	}
	
	/**
	 * 删除器材管理api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteWorkshopEqu/{id}", method = RequestMethod.GET)
	public Object deleteWorkshopEqu(@PathVariable("id") String id) {
		return workshopService.deleteWorkshopEqu(id);
	}
	
	@ApiOperation(value =  "按村统计厂房数量")
	@RequestMapping(value = "/countAdmAllCountryside", method = RequestMethod.POST)
	public Object countAdmAllCountryside() {
		return workshopService.countAdmAllCountryside();
	}

}

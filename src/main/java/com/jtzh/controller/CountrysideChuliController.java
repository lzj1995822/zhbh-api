package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CountrysideChuli;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideChuliDetail;
import com.jtzh.pojo.CountrysideChuliParam;
import com.jtzh.service.CountrysideChuliService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "村建问题处理")
@RestController
@RequestMapping("CountrysideChuli")
public class CountrysideChuliController {
	@Resource
	private CountrysideChuliService countrysideChuliService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取问题列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideChuliList", method = RequestMethod.POST)
	public Object getCountrysideChuliList(@RequestBody CountrysideChuliParam param) {
		
		return countrysideChuliService.getCountrysideChuliList(param);
	}
	
	/**
	 * 问题处理api
	 * 
	 * @param CountrysideProblem
	 * @return
	 */
	@RequestMapping(value = "/Problemyichuli", method = RequestMethod.POST)
	public Object Problemyichuli(@RequestBody CountrysideChuliDetail chuliDetail,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return countrysideChuliService.Problemyichuli(chuliDetail, user);
	}
	
	/**
	 * 问题审核api
	 * 
	 * @param CountrysideProblem
	 * @return
	 */
	@RequestMapping(value = "/Problemshenhe", method = RequestMethod.POST)
	public Object Problemshenhe(@RequestBody CountrysideChuli shenhe) {
		return countrysideChuliService.Problemshenhe(shenhe);
	}
	
	/**
	 * 删除处理信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletechuli/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deletechuli(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return countrysideChuliService.deletechuli(id, sourceType);
	}
	
	/**
	 * 根据shangbaoid获取全部处理列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getChuliList", method = RequestMethod.POST)
	public Object getChuliList(@RequestBody CountrysideChuliParam param) {
		
		return countrysideChuliService.getChuliList(param);
	}
	
	/**
	 * 根据id获取回退描述api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getHuituiInfo/{id}", method = RequestMethod.GET)
	public Object getHuituiInfo(@PathVariable("id") String id) {
		return countrysideChuliService.getHuituiInfo(id);
	}
	
	/**
	 * 拉取所有问题处理信息根据上报idapi
	 * 
	 * @param shangbaoid
	 * @return
	 */
	@RequestMapping(value = "/getAllSolve/{shangbaoid}", method = RequestMethod.GET)
	public Object getAllSolve(@PathVariable("shangbaoid") String shangbaoid) {
		return countrysideChuliService.getAllSolve(shangbaoid);
	}

}

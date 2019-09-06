package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CountrysideNews;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideNewsDetail;
import com.jtzh.pojo.CountrysideParam;
import com.jtzh.service.CountrysideNewsService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "村建信息发布")
@RestController
@RequestMapping("CountrysideNews")
public class CountrysideNewsController {
	@Resource
	private CountrysideNewsService countrysideNewsService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取信息发布列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideNewsList", method = RequestMethod.POST)
	public Object getCountrysideNewsList(@RequestBody CountrysideParam param) {
		
		return countrysideNewsService.getCountrysideNewsList(param);
	}

	/**
	 * 获取信息发布详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideNewsInfo/{id}", method = RequestMethod.GET)
	public Object getCountrysideNewsInfo(@PathVariable("id") String id) {
		return countrysideNewsService.getCountrysideNewsInfo(id);
	}

	/**
	 * 信息发布api
	 * 
	 * @param countrysideNewsDetail
	 * @return
	 */
	@RequestMapping(value = "/addCountryside", method = RequestMethod.POST)
	public Object addCountrysideNews(@RequestBody CountrysideNewsDetail countrysideNewsDetail,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return countrysideNewsService.addCountrysideNews(countrysideNewsDetail, user);
	}
	
	/**
	 * 删除发布信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCountrysideNews/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deleteCountrysideNews(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return countrysideNewsService.deleteCountrysideNews(id, sourceType);
	}
	
	/**
	 * 修改发布信息api
	 * 
	 * @param CountrysideNews
	 * @return
	 */
	@RequestMapping(value = "/updateCountrysideNews", method = RequestMethod.POST)
	public Object updateCountrysideNews(@RequestBody CountrysideNews param) {
		return countrysideNewsService.updateCountrysideNews(param);
	}
	
	/**
	 * 获取多模块通知公告第一条api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getAllNewsList", method = RequestMethod.POST)
	public Object getAllNewsList() {
		
		return countrysideNewsService.getAllNewsList();
	}

}

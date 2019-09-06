package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProNews;
import com.jtzh.pojo.RoadProNewsParam;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.RoadProNewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "护路护线专项工作管理")
@RestController
@RequestMapping("RoadProNews")
public class RoadProNewsController {
	@Resource
	private RoadProNewsService roadProNewsService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取列表api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取护路工作")
	@RequestMapping(value = "/getRoadProNewsList", method = RequestMethod.POST)
	public Object getRoadProNewsList(@RequestBody RoadProNewsParam param) {
		return roadProNewsService.getRoadProNewsList(param);
	}
	
	/**
	 * 获取详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询护路工作详情")
	@RequestMapping(value = "/getRoadProNewsInfo/{id}", method = RequestMethod.GET)
	public Object getRoadProNewsInfo(@PathVariable("id") String id) {
		return roadProNewsService.getRoadProNewsInfo(id);
	}
	
	/**
	 * 发布api
	 * 
	 * @param RoadProNews
	 * @return
	 */
	@ApiOperation(value="新建护路工作")
	@RequestMapping(value = "/addRoadProNews", method = RequestMethod.POST)
	public Object addRoadProNews(@RequestBody RoadProNews news,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return roadProNewsService.addRoadProNews(news, user);
	}
	
	/**
	 * 修改api
	 * 
	 * @param RoadProNews
	 * @return
	 */
	@ApiOperation(value="修改护路工作")
	@RequestMapping(value = "/updateRoadProNews", method = RequestMethod.POST)
	public Object updateRoadProNews(@RequestBody RoadProNews param) {
		return roadProNewsService.updateRoadProNews(param);
	}
	
	/**
	 * 删除api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除护路工作")
	@RequestMapping(value = "/deleteRoadProNews/{id}", method = RequestMethod.GET)
	public Object deleteRoadProNews(@PathVariable("id") String id) {
		return roadProNewsService.deleteRoadProNews(id);
	}

}

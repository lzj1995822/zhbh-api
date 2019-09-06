package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.detail.pojo.RoadDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.RoadProtectionRoadPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.RoadProtectionRoadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "护路护线路线管理")
@RestController
@RequestMapping("roadProtectionRoad")
public class RoadProtectionRoadController {
	@Resource
	private RoadProtectionRoadService roadProtectionRoadService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取护路护线路线列表api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取护路护线路线")
	@RequestMapping(value = "/getRoadProtectionRoadList", method = RequestMethod.POST)
	public Object getRoadProtectionRoadList(@RequestBody RoadProtectionRoadPagination param) {
		return roadProtectionRoadService.getRoadProtectionRoadList(param);
	}
	
	/**
	 * 根据id获取路线详情 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询护路护线路线详情")
	@RequestMapping(value = "/getRoadProtectionRoad/{id}", method = RequestMethod.GET)
	public Object getRoadProtectionRoad(@PathVariable("id") Long id) {
		return roadProtectionRoadService.getRoadProtectionRoad(id);
	}
	
	/**
	 * 根据id删除路线 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除护路护线路线")
	@RequestMapping(value = "/removeRoadProtectionRoad/{id}", method = RequestMethod.GET)
	public Object removeRoadProtectionRoad(@PathVariable("id") Long id) {
		return roadProtectionRoadService.removeRoadProtectionRoad(id);
	}
	
	/**
	 * 新建路线api
	 * 
	 * @param detail
	 * @param request
	 * @return
	 */
	@ApiOperation(value="新建护路护线路线")
	@RequestMapping(value = "/addRoadProtectionRoad", method = RequestMethod.POST)
	public Object addRoadProtectionRoad(@RequestBody RoadDetail detail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return roadProtectionRoadService.addRoadProtectionRoad(detail, user);
	}
	
	/**
	 * 修改路线api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="修改护路护线路线")
	@RequestMapping(value = "/modifyRoadProtectionRoad", method = RequestMethod.POST)
	public Object modifyRoadProtectionRoad(@RequestBody RoadDetail detail) {
		return roadProtectionRoadService.modifyRoadProtectionRoad(detail);
	}

}

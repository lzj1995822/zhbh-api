package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionGroup;
import com.jtzh.pojo.RoadProtectionGroupPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.RoadProtectionGroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "护路护线小组管理")
@RestController
@RequestMapping("roadProtectionGroup")
public class RoadProtectionGroupController {
	@Resource
	private RoadProtectionGroupService roadProtectionGroupService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 分页获取护路小组 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取护路护线小组")
	@RequestMapping(value = "/getRoadProtectionGroupList", method = RequestMethod.POST)
	public Object getRoadProtectionGroupList(@RequestBody RoadProtectionGroupPagination param) {
		return roadProtectionGroupService.getRoadProtectionGroupList(param);
	}
	
	/**
	 * 根据id获取护路详情 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询护路护线小组详情")
	@RequestMapping(value = "/getRoadProtectionGroup/{id}", method = RequestMethod.GET)
	public Object getRoadProtectionGroup(@PathVariable("id") Integer id) {
		return roadProtectionGroupService.getRoadProtectionGroup(id);
	}
	
	/**
	 * 根据id删除护路小组 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除护路护线小组")
	@RequestMapping(value = "/removeRoadProtectionGroup/{id}", method = RequestMethod.GET)
	public Object removeRoadProtectionGroup(@PathVariable("id") Integer id) {
		return roadProtectionGroupService.removeRoadProtectionGroup(id);
	}
	
	/**
	 * 新增护路小组 api
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@ApiOperation(value="新建护路护线小组")
	@RequestMapping(value = "/addRoadProtectionGroup", method = RequestMethod.POST)
	public Object addRoadProtectionGroup(@RequestBody RoadProtectionGroup param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return roadProtectionGroupService.addRoadProtectionGroup(param, user);
	}

	/**
	 * 修改护路小组 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="修改护路护线小组")
	@RequestMapping(value = "/modifyRoadProtectionGroup", method = RequestMethod.POST)
	public Object modifyRoadProtectionGroup(@RequestBody RoadProtectionGroup param) {
		return roadProtectionGroupService.modifyRoadProtectionGroup(param);
	}
	
}

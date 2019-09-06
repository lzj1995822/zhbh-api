package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProGroPeople;
import com.jtzh.pojo.RoadProGroPeopleParam;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.RoadProGroPeopleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "护路护线人员管理")
@RestController
@RequestMapping("RoadProGroPeople")
public class RoadProGroPeopleController {
	
	@Resource
	private RoadProGroPeopleService roadProGroPeopleService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取人员列表api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取护路人员")
	@RequestMapping(value = "/getRoadProGroPeopleList", method = RequestMethod.POST)
	public Object getRoadProGroPeopleList(@RequestBody RoadProGroPeopleParam param) {
		
		return roadProGroPeopleService.getRoadProGroPeopleList(param);
	}

	/**
	 * 获取人员详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询护路人员详情")
	@RequestMapping(value = "/getRoadProGroPeopleInfo/{id}", method = RequestMethod.GET)
	public Object getRoadProGroPeopleInfo(@PathVariable("id") String id) {
		return roadProGroPeopleService.getRoadProGroPeopleInfo(id);
	}

	/**
	 * 新增人员信息api
	 * 
	 * @param
	 * @return
	 */
	@ApiOperation(value="新建护路人员")
	@RequestMapping(value = "/addRoadProGroPeople", method = RequestMethod.POST)
	public Object addRoadProGroPeople(@RequestBody RoadProGroPeople cuser,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return roadProGroPeopleService.addRoadProGroPeople(cuser, user);
	}
	
	/**
	 * 删除人员信息api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除护路人员")
	@RequestMapping(value = "/deleteRoadProGroPeople/{id}", method = RequestMethod.GET)
	public Object deleteRoadProGroPeople(@PathVariable("id") String id) {
		return roadProGroPeopleService.deleteRoadProGroPeople(id);
	}
	
	/**
	 * 修改人员信息api
	 * 
	 * @param
	 * @return
	 */
	@ApiOperation(value="修改护路人员")
	@RequestMapping(value = "/updateRoadProGroPeople", method = RequestMethod.POST)
	public Object updateRoadProGroPeople(@RequestBody RoadProGroPeople param) {
		return roadProGroPeopleService.updateRoadProGroPeople(param);
	}

}

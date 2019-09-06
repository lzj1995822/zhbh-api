package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.detail.pojo.RecordDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.RoadProtectionRecordPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.RoadProtectionRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "护路护线记录管理")
@RestController
@RequestMapping("roadProtectionRecord")
public class RoadProtectionRecordController {
	@Resource
	private RoadProtectionRecordService roadProtectionRecordService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 分页查询记录 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取护路护线记录")
	@RequestMapping(value = "/getRoadProtectionRecordList", method = RequestMethod.POST)
	public Object getRoadProtectionRecordList(@RequestBody RoadProtectionRecordPagination param) {
		return roadProtectionRecordService.getRoadProtectionRecordList(param);
	}
	
	/**
	 * 根据id查询记录详情api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询护路护线记录详情")
	@RequestMapping(value = "/getRoadProtectionRecord/{id}", method = RequestMethod.GET)
	public Object getRoadProtectionRecord(@PathVariable("id") Long id) {
		return roadProtectionRecordService.getRoadProtectionRecord(id);
	}
	
	/**
	 * 根据id删除具体记录api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除护路护线记录")
	@RequestMapping(value = "/removeRoadProtectionRecord/{id}", method = RequestMethod.GET)
	public Object removeRoadProtectionRecord(@PathVariable("id") Long id) {
		return roadProtectionRecordService.removeRoadProtectionRecord(id);
	}
	
	/**
	 * 新增记录 api
	 * 
	 * @param detail
	 * @param request
	 * @return
	 */
	@ApiOperation(value="新建护路护线记录")
	@RequestMapping(value = "/addRoadProtectionRecord", method = RequestMethod.POST)
	public Object addRoadProtectionRecord(@RequestBody RecordDetail detail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return roadProtectionRecordService.addRoadProtectionRecord(detail, user);
	}
	
	/**
	 * 修改记录api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="修改护路护线记录")
	@RequestMapping(value = "/modifyRoadProtectionRecord", method = RequestMethod.POST)
	public Object modifyRoadProtectionRecord(@RequestBody RecordDetail detail) {
		return roadProtectionRecordService.modifyRoadProtectionRecord(detail);
	}
}

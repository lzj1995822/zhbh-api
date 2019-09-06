package com.jtzh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.detail.pojo.RoadProtectionInspectionDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionInspection;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.RoadProtectionInspectionPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.RoadProtectionInspectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "护路护线巡检管理")
@RestController
@RequestMapping("roadProtectionInspection")
public class RoadProtectionInspectionController {
	@Resource
	private RoadProtectionInspectionService roadProtectionInspectionService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 分页获取巡检api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取护路护线巡检")
	@RequestMapping(value = "/getRoadProtectionInspectionList", method = RequestMethod.POST)
	public BaseResponse<List<RoadProtectionInspection>> getRoadProtectionInspectionList(@RequestBody RoadProtectionInspectionPagination param) {
		return roadProtectionInspectionService.getRoadProtectionInspectionList(param);
	}
	
	/**
	 * 根据id查询巡检详情api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询护路护线巡检详情")
	@RequestMapping(value = "/getRoadProtectionInspection/{id}", method = RequestMethod.GET)
	public BaseResponse<RoadProtectionInspectionDetail> getRoadProtectionInspection(@PathVariable("id") Long id) {
		return roadProtectionInspectionService.getRoadProtectionInspection(id);
	}
	
	/**
	 * 根据id删除巡检api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除护路护线巡检")
	@RequestMapping(value = "/removeRoadProtectionInspection/{id}", method = RequestMethod.GET)
	public BaseResponse<String> removeRoadProtectionInspection(@PathVariable("id") Long id) {
		return roadProtectionInspectionService.removeRoadProtectionInspection(id);
	}
	
	/**
	 * 新建巡检api
	 * 
	 * @param detail
	 * @param request
	 * @return
	 */
	@ApiOperation(value="新建护路护线小组")
	@RequestMapping(value = "/addRoadProtectionInspection", method = RequestMethod.POST)
	public BaseResponse<String> addRoadProtectionInspection(@RequestBody RoadProtectionInspectionDetail detail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return roadProtectionInspectionService.addRoadProtectionInspection(detail, user);
	}
	
	/**
	 * 修改巡检api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="修改护路护线巡检")
	@RequestMapping(value = "/modifyRoadProtectionInspection", method = RequestMethod.POST)
	public BaseResponse<String> modifyRoadProtectionInspection(@RequestBody RoadProtectionInspectionDetail detail) {
		return roadProtectionInspectionService.modifyRoadProtectionInspection(detail);
	}

}

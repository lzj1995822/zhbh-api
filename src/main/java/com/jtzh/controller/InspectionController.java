package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.InspectionDetail;
import com.jtzh.pojo.InspectionParam;
import com.jtzh.service.InspectionService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "安全工作巡检")
@RestController
@RequestMapping("Inspection")
public class InspectionController {
	@Resource
	private InspectionService inspectionService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取工作巡检记录列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getInspectionList", method = RequestMethod.POST)
	public Object getInspectionList(@RequestBody InspectionParam param) {
		
		return inspectionService.getInspectionList(param);
	}

	/**
	 * 获取工作巡检记录详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getInspectionInfo/{id}", method = RequestMethod.GET)
	public Object getInspectionInfo(@PathVariable("id") String id) {
		return inspectionService.getInspectionInfo(id);
	}

	/**
	 * 新建工作巡检记录api
	 * 
	 * @param inspectionDetail
	 * @return
	 */
	@RequestMapping(value = "/addInspection", method = RequestMethod.POST)
	public Object addInspection(@RequestBody InspectionDetail inspectionDetail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return inspectionService.addInspection(inspectionDetail, user);
	}
	
	/**
	 * 修改工作巡检记录api
	 * 
	 * @param InspectionRecord
	 * @return
	 */
	@RequestMapping(value = "/updateInspection", method = RequestMethod.POST)
	public Object updateInspection(@RequestBody InspectionRecord param) {
		return inspectionService.updateInspection(param);
	}

	/**
	 * 删除工作巡检记录api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteInspection/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deleteInspection(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return inspectionService.deleteInspection(id, sourceType);
	}

	/**
	 * 统计数据 api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/countInspectionState", method = RequestMethod.POST)
	public Object countInspectionState() {
		return inspectionService.countInspectionState();
	}
	
	/**
	 * 根据年份进行季度统计api
	 * 
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/countInspectionYear/{year}", method = RequestMethod.GET)
	public Object countInspectionYear(@PathVariable("year") String year) {
		return inspectionService.countInspectionYear(year);
	}
	
	/**
	 * 根据年份进行月份统计api
	 * 
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/countInspectionByMonth/{year}", method = RequestMethod.GET)
	public Object countInspectionByMonth(@PathVariable("year") String year) {
		return inspectionService.countInspectionByMonth(year);
	}
	
	/**
	 * 根据年份进行一周统计api
	 * 
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/countInspectionByDay/{year}", method = RequestMethod.GET)
	public Object countInspectionByDay(@PathVariable("year") String year) {
		return inspectionService.countInspectionByDay(year);
	}
	
	/**
	 * 获取巡检gis api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getInspectionGis", method = RequestMethod.POST)
	public Object getInspectionGis() {
		return inspectionService.getInspectionGis();
	}
}

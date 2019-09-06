package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.GovmgtLog;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.GovmgtLogParam;
import com.jtzh.service.GovmgtLogService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "政务工作日志")
@RestController
@RequestMapping("GovmgtLog")
public class GovmgtLogController {
	@Resource
	private GovmgtLogService govmgtLogService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取会议通知记录列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getGovmgtLogList", method = RequestMethod.POST)
	public Object getGovmgtLogList(@RequestBody GovmgtLogParam param) {
		return govmgtLogService.getGovmgtLogList(param);
	}
	
	/**
	 * 获取会议通知详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getGovmgtLogInfo/{id}", method = RequestMethod.GET)
	public Object getGovmgtLogInfo(@PathVariable("id") String id) {
		return govmgtLogService.getGovmgtLogInfo(id);
	}
	
	/**
	 * 发布会议通知api
	 * 
	 * @param CountrysideMeeting
	 * @return
	 */
	@RequestMapping(value = "/addGovmgtLog", method = RequestMethod.POST)
	public Object addGovmgtLog(@RequestBody GovmgtLog param,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return govmgtLogService.addGovmgtLog(param, user);
	}
	
	/**
	 * 修改会议通知api
	 * 
	 * @param CountrysideMeeting
	 * @return
	 */
	@RequestMapping(value = "/updateGovmgtLog", method = RequestMethod.POST)
	public Object updateGovmgtLog(@RequestBody GovmgtLog param) {
		return govmgtLogService.updateGovmgtLog(param);
	}
	
	/**
	 * 删除会议通知api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteGovmgtLog/{id}", method = RequestMethod.GET)
	public Object deleteGovmgtLog(@PathVariable("id") String id) {
		return govmgtLogService.deleteGovmgtLog(id);
	}

}

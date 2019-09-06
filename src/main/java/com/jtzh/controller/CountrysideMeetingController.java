package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CountrysideMeeting;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideMeetingParam;
import com.jtzh.service.CountrysideMeetingService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "村建会议通知")
@RestController
@RequestMapping("CountrysideMeeting")
public class CountrysideMeetingController {
	@Resource
	private CountrysideMeetingService meetingService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取会议通知记录列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideMeetingList", method = RequestMethod.POST)
	public Object getCountrysideMeetingList(@RequestBody CountrysideMeetingParam param) {
		return meetingService.getCountrysideMeetingList(param);
	}
	
	/**
	 * 获取会议通知详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideMeetingInfo/{id}", method = RequestMethod.GET)
	public Object getCountrysideMeetingInfo(@PathVariable("id") String id) {
		return meetingService.getCountrysideMeetingInfo(id);
	}
	
	/**
	 * 发布会议通知api
	 * 
	 * @param CountrysideMeeting
	 * @return
	 */
	@RequestMapping(value = "/addCountrysideMeeting", method = RequestMethod.POST)
	public Object addCountrysideMeeting(@RequestBody CountrysideMeeting meeting,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return meetingService.addCountrysideMeeting(meeting, user);
	}
	
	/**
	 * 修改会议通知api
	 * 
	 * @param CountrysideMeeting
	 * @return
	 */
	@RequestMapping(value = "/updateCountrysideMeeting", method = RequestMethod.POST)
	public Object updateCountrysideMeeting(@RequestBody CountrysideMeeting param) {
		return meetingService.updateCountrysideMeeting(param);
	}
	
	/**
	 * 删除会议通知api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCountrysideMeeting/{id}", method = RequestMethod.GET)
	public Object deleteCountrysideMeeting(@PathVariable("id") String id) {
		return meetingService.deleteCountrysideMeeting(id);
	}
}
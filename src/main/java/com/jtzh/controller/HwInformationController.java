package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.HwInformation;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.HwInformationDetail;
import com.jtzh.pojo.HwInformationParam;
import com.jtzh.service.HwInformationService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "环卫信息发布")
@RestController
@RequestMapping("HwInformation")
public class HwInformationController {
	@Resource
	private HwInformationService hwInformationService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取信息列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getHwInformationList", method = RequestMethod.POST)
	public Object getHwInformationList(@RequestBody HwInformationParam param) {
		
		return hwInformationService.getHwInformationList(param);
	}

	/**
	 * 获取详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getHwInformationInfo/{id}", method = RequestMethod.GET)
	public Object getHwInformationInfo(@PathVariable("id") String id) {
		return hwInformationService.getHwInformationInfo(id);
	}

	/**
	 * 发布信息api
	 * 
	 * @param HwInformationDetail
	 * @return
	 */
	@RequestMapping(value = "/addHwInformation", method = RequestMethod.POST)
	public Object addHwInformation(@RequestBody HwInformationDetail hwInformationDetail,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return hwInformationService.addHwInformation(hwInformationDetail, user);
	}
	
	/**
	 * 删除信息记录api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteHwInformation/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deleteHwInformation(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return hwInformationService.deleteHwInformation(id, sourceType);
	}
	
	/**
	 * 修改信息api
	 * 
	 * @param HwInformation
	 * @return
	 */
	@RequestMapping(value = "/updateHwInformation", method = RequestMethod.POST)
	public Object updateHwInformation(@RequestBody HwInformation param) {
		return hwInformationService.updateHwInformation(param);
	}

	/**
	 *
	 * 获取环卫信息发布每个类型的数量
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getHwInformationTypeCount", method = RequestMethod.GET)
	public Object getHwInformationTypeCount() {
		return hwInformationService.getHwInformationTypeCount();
	}


}

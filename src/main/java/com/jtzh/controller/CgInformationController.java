package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CgInformation;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CgInformationDetail;
import com.jtzh.pojo.CgInformationParam;
import com.jtzh.service.CgInformationService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "城管信息发布")
@RestController
@RequestMapping("CgInformation")
public class CgInformationController {
	@Resource
	private CgInformationService cgInformationService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取信息列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCgInformationList", method = RequestMethod.POST)
	public Object getCgInformationList(@RequestBody CgInformationParam param) {
		
		return cgInformationService.getCgInformationList(param);
	}

	/**
	 * 获取详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCgInformationInfo/{id}", method = RequestMethod.GET)
	public Object getCgInformationInfo(@PathVariable("id") String id) {
		return cgInformationService.getCgInformationInfo(id);
	}

	/**
	 * 发布信息api
	 * 
	 * @param CgInformationDetail
	 * @return
	 */
	@RequestMapping(value = "/addCgInformation", method = RequestMethod.POST)
	public Object addCgInformation(@RequestBody CgInformationDetail cgInformationDetail,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return cgInformationService.addCgInformation(cgInformationDetail, user);
	}
	
	/**
	 * 删除信息记录api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCgInformation/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deleteCgInformation(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return cgInformationService.deleteCgInformation(id, sourceType);
	}
	
	/**
	 * 修改信息api
	 * 
	 * @param CgInformation
	 * @return
	 */
	@RequestMapping(value = "/updateCgInformation", method = RequestMethod.POST)
	public Object updateCgInformation(@RequestBody CgInformation param) {
		return cgInformationService.updateCgInformation(param);
	}


	/**
	 *
	 * 获取城管信息发布每个类型的数量
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getCgInformationTypeCount", method = RequestMethod.GET)
	public Object getCgInformationTypeCount() {
		return cgInformationService.getCgInformationTypeCount();
	}

}

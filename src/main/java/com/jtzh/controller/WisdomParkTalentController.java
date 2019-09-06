package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkTalent;
import com.jtzh.pojo.WisdomParkTalentPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.WisdomParkTalentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "智慧园区人才管理")
@RestController
@RequestMapping("wisdomParkTalent")
public class WisdomParkTalentController {
	@Resource
	private WisdomParkTalentService wisdomParkTalentService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 分页获取智慧园区人才列表 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取园区人才")
	@RequestMapping(value = "/getWisdomParkTalentList", method = RequestMethod.POST)
	public Object getWisdomParkTalentList(@RequestBody WisdomParkTalentPagination param) {
		return wisdomParkTalentService.getWisdomParkTalentList(param);
	}
	
	/**
	 * 根据id查询人才详细信息 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询园区人才详情")
	@RequestMapping(value = "/getWisdomParkTalent/{id}", method = RequestMethod.GET)
	public Object getWisdomParkTalent(@PathVariable("id") String id) {
		return wisdomParkTalentService.getWisdomParkTalent(id);
	}
	
	/**
	 * 根据id删除人才 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除园区人才")
	@RequestMapping(value = "/removeWisdomParkTalent/{id}", method = RequestMethod.GET)
	public Object removeWisdomParkTalent(@PathVariable("id") String id) {
		return wisdomParkTalentService.removeWisdomParkTalent(id);
	}
	
	/**
	 * 新建人才 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="新建园区人才")
	@RequestMapping(value = "/addWisdomParkTalent", method = RequestMethod.POST)
	public Object insertWisdomParkTalent(@RequestBody WisdomParkTalent param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return wisdomParkTalentService.insertWisdomParkTalent(param, user);
	}
	
	/**
	 * 修改人才 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="修改园区人才")
	@RequestMapping(value = "/updateWisdomParkTalent", method = RequestMethod.POST)
	public Object updateWisdomParkTalent(@RequestBody WisdomParkTalent param) {
		return wisdomParkTalentService.updateWisdomParkTalent(param);
	}
	
	/**
	 * 获取人才gis api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="获取园区人才坐标")
	@RequestMapping(value = "/getWisdomParkTalentGis", method = RequestMethod.POST)
	public Object getWisdomParkTalentGis() {
		return wisdomParkTalentService.getWisdomParkTalentGis();
	}
	
	@ApiOperation(value="园区人才最高学历专业统计")
	@RequestMapping(value = "/countWTHighestMajor", method = RequestMethod.POST)
	public Object countWTHighestMajor() {
		return wisdomParkTalentService.countWTHighestMajor();
	}
	
	@ApiOperation(value="园区人才十年统计")
	@RequestMapping(value = "/countWTDecade", method = RequestMethod.POST)
	public Object countWTDecade() {
		return wisdomParkTalentService.countWTDecade();
	}
	
}

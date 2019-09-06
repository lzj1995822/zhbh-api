package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.KeyproDep;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkEnterprise;
import com.jtzh.pojo.DepPagination;
import com.jtzh.pojo.WisdomParkEnterprisePagination;
import com.jtzh.service.KeyproBuildService;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.WisdomParkEnterpriseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "智慧园区企业管理")
@RestController
@RequestMapping("wisdomParkEnterprise")
public class WisdomParkEnterpriseController {
	@Resource
	private WisdomParkEnterpriseService wisdomParkEnterpriseService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取智慧园区企业列表 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取园区企业")
	@RequestMapping(value = "/getWisdomParkEnterpriseList", method = RequestMethod.POST)
	public Object getWisdomParkEnterpriseList(@RequestBody WisdomParkEnterprisePagination param) {
		return wisdomParkEnterpriseService.getWisdomParkEnterpriseList(param);
	}
	
	/**
	 * 根据id查询企业详细信息 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询园区企业详情")
	@RequestMapping(value = "/getWisdomParkEnterprise/{id}", method = RequestMethod.GET)
	public Object getWisdomParkEnterpriseInfo(@PathVariable("id") String id) {
		return wisdomParkEnterpriseService.getWisdomParkEnterpriseInfo(id);
	}
	
	/**
	 * 根据id删除企业 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除园区企业")
	@RequestMapping(value = "/removeWisdomParkEnterprise/{id}", method = RequestMethod.GET)
	public Object removeWisdomParkEnterprise(@PathVariable("id") String id) {
		return wisdomParkEnterpriseService.removeWisdomParkEnterprise(id);
	}
	
	/**
	 * 新建企业 api
	 * 
	 * @param dep
	 * @return
	 */
	@ApiOperation(value="新建园区企业")
	@RequestMapping(value = "/addWisdomParkEnterprise", method = RequestMethod.POST)
	public Object addWisdomParkEnterprise(@RequestBody WisdomParkEnterprise param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return wisdomParkEnterpriseService.addWisdomParkEnterprise(param, user);
	}
	
	/**
	 * 修改企业 api
	 * 
	 * @param dep
	 * @return
	 */
	@ApiOperation(value="修改园区企业")
	@RequestMapping(value = "/updateWisdomParkEnterprise", method = RequestMethod.POST)
	public Object modifyWisdomParkEnterprise(@RequestBody WisdomParkEnterprise param) {
		return wisdomParkEnterpriseService.modifyWisdomParkEnterprise(param);
	}
	
	/**
	 * 获取企业gis api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="获得园区企业坐标")
	@RequestMapping(value = "/getWisdomParkEnterpriseGis", method = RequestMethod.POST)
	public Object getWisdomParkEnterpriseGis() {
		return wisdomParkEnterpriseService.getWisdomParkEnterpriseGis();
	}
	
	@ApiOperation(value="园区所属行业统计接口")
	@RequestMapping(value = "/countWEIndustryBelong", method = RequestMethod.POST)
	public Object countWEIndustryBelong() {
		return wisdomParkEnterpriseService.countWEIndustryBelong();
	}
	
	@ApiOperation(value="园区所属产业园统计接口")
	@RequestMapping(value = "/countWEParkBelong", method = RequestMethod.POST)
	public Object countWEParkBelong() {
		return wisdomParkEnterpriseService.countWEParkBelong();
	}
	
}

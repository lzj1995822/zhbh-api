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
import com.jtzh.entity.WisdomParkPolicy;
import com.jtzh.pojo.DepPagination;
import com.jtzh.pojo.WisdomParkPolicyPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.WisdomParkPolicyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "智慧园区政法管理")
@RestController
@RequestMapping("wisdomParkPolicy")
public class WisdomParkPolicyController {
	@Resource
	private WisdomParkPolicyService wisdomParkPolicyService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 分页获取智慧园区政策法规 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取园区政法")
	@RequestMapping(value = "/getWisdomParkPolicyList", method = RequestMethod.POST)
	public Object getWisdomParkPolicyList(@RequestBody WisdomParkPolicyPagination param) {
		return wisdomParkPolicyService.getWisdomParkPolicyList(param);
	}
	
	/**
	 * 根据id查询政策法规详细信息 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询园区政法详情")
	@RequestMapping(value = "/getWisdomParkPolicy/{id}", method = RequestMethod.GET)
	public Object getWisdomParkPolicy(@PathVariable("id") String id) {
		return wisdomParkPolicyService.getWisdomParkPolicy(id);
	}
	
	/**
	 * 根据id删除政策法规 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除园区政法")
	@RequestMapping(value = "/removeWisdomParkPolicy/{id}", method = RequestMethod.GET)
	public Object removeWisdomParkPolicy(@PathVariable("id") String id) {
		return wisdomParkPolicyService.removeWisdomParkPolicy(id);
	}
	
	/**
	 * 新建部门 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="新建园区政法")
	@RequestMapping(value = "/addWisdomParkPolicy", method = RequestMethod.POST)
	public Object insertWisdomParkPolicy(@RequestBody WisdomParkPolicy param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return wisdomParkPolicyService.insertWisdomParkPolicy(param, user);
	}

	/**
	 * 修改政策法规 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="修改园区政法")
	@RequestMapping(value = "/updateWisdomParkPolicy", method = RequestMethod.POST)
	public Object updateWisdomParkPolicy(@RequestBody WisdomParkPolicy param) {
		return wisdomParkPolicyService.updateWisdomParkPolicy(param);
	}
	
}

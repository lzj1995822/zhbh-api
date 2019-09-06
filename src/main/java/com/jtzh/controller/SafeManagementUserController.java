package com.jtzh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.SafeManagementUser;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.SafeUserPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.SafeManagementUserService;

import io.swagger.annotations.Api;

@Api(tags = "安全人员管理")
@RestController
@RequestMapping("safeManagementUser")
public class SafeManagementUserController {
	@Resource
	private SafeManagementUserService safeManagementUserService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 分页获取安全管理人员 api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getSafeManagementUserList", method = RequestMethod.POST)
	public BaseResponse<List<SafeManagementUser>> getSafeManagementUserList(@RequestBody SafeUserPagination param) {
		return safeManagementUserService.getSafeManagementUserList(param);
	}
	
	/**
	 * 根据id获取人员详情 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getSafeManagementUser/{id}", method = RequestMethod.GET)
	public BaseResponse<SafeManagementUser> getSafeManagementUser(@PathVariable("id") Integer id) {
		return safeManagementUserService.getSafeManagementUser(id);
	}
	
	/**
	 * 根据id删除人员 api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeSafeManagementUser/{id}", method = RequestMethod.GET)
	public BaseResponse<String> removeSafeManagementUser(@PathVariable("id") Integer id) {
		return safeManagementUserService.removeSafeManagementUser(id);
	}
	
	/**
	 * 新建人员 api
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addSafeManagementUser", method = RequestMethod.POST)
	public BaseResponse<String> addSafeManagementUser(@RequestBody SafeManagementUser param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return safeManagementUserService.addSafeManagementUser(param, user);
	}
	
	/**
	 * 修改人员 api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/modifySafeManagementUser", method = RequestMethod.POST)
	public BaseResponse<String> modifySafeManagementUser(@RequestBody SafeManagementUser param) {
		return safeManagementUserService.modifySafeManagementUser(param);
	}

}

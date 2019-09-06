package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.detail.pojo.WorkDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.WorkPagination;
import com.jtzh.pojo.WorkSourceParam;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.WorkService;

import io.swagger.annotations.Api;

@Api(tags = "政务工作管理")
@RestController
@RequestMapping("work")
public class WorkController {
	@Resource
	private WorkService workService;
	@Resource
	private LoginUserTestService loginUserTestService;


	/**
	 * 获取政务管理工作列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getWorkList", method = RequestMethod.POST)
	public Object getWorkList(@RequestBody WorkPagination param) {
		return workService.getWorkList(param);
	}

	/**
	 * 获取选中的工作信息后台api
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getWork/{type}/{id}", method = RequestMethod.GET)
	public Object getWork(@PathVariable("type") String type, @PathVariable("id") String id) {
		return workService.getWork(type, id);
	}

	/**
	 * 删除所选工作后台api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeWork/{id}", method = RequestMethod.GET)
	public Object removeWork(@PathVariable("id") String id) {
		return workService.removeWork(id);
	}

	/**
	 * 新建工作后台api
	 * 
	 * @param detail
	 * @return
	 */
	@RequestMapping(value = "/addWork", method = RequestMethod.POST)
	public Object addWork(@RequestBody WorkDetail detail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return workService.addWork(detail, user);
	}

	/**
	 * 修改工作后台api
	 * 
	 * @param detail
	 * @return
	 */
	@RequestMapping(value = "/modifyWork", method = RequestMethod.POST)
	public Object modifyWork(@RequestBody WorkDetail detail) {
		return workService.modifyWork(detail);
	}
	
	/**
	 * 查询全部图片api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getphotoList", method = RequestMethod.POST)
	public Object getphotoList(@RequestBody WorkSourceParam param) {
		return workService.getphotoList(param);
	}
}

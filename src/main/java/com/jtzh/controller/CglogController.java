package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.Cglog;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CglogParam;
import com.jtzh.service.CglogService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "城管日志")
@RestController
@RequestMapping("Cglog")
public class CglogController {
	@Resource
	private CglogService cglogService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取日志列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCglogList", method = RequestMethod.POST)
	public Object getCglogList(@RequestBody CglogParam param) {
		
		return cglogService.getCglogList(param);
	}

	/**
	 * 获取日志详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCglogInfo/{id}", method = RequestMethod.GET)
	public Object getCglogInfo(@PathVariable("id") String id) {
		return cglogService.getCglogInfo(id);
	}

	/**
	 * 新增日志信息api
	 * 
	 * @param Cglog
	 * @return
	 */
	@RequestMapping(value = "/addCglog", method = RequestMethod.POST)
	public Object addCglog(@RequestBody Cglog cglog,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return cglogService.addCglog(cglog, user);
	}
	
	/**
	 * 删除日志信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCglog/{id}", method = RequestMethod.GET)
	public Object deleteCglog(@PathVariable("id") String id) {
		return cglogService.deleteCglog(id);
	}
	
	/**
	 * 修改日志信息api
	 * 
	 * @param Cglog
	 * @return
	 */
	@RequestMapping(value = "/updateCglog", method = RequestMethod.POST)
	public Object updateCglog(@RequestBody Cglog param) {
		return cglogService.updateCglog(param);
	}

}

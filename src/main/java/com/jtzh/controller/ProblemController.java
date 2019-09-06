package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.GovmgtProblem;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.ProblemPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.ProblemService;

import io.swagger.annotations.Api;

@Api(tags = "政务问题管理")
@RestController
@RequestMapping("problem")
public class ProblemController {
	@Resource
	private ProblemService problemService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取政务问题列表后台api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getProblemList", method = RequestMethod.POST)
	public Object getProblemList(@RequestBody ProblemPagination param) {
		return problemService.getProblemList(param);
	}

	/**
	 * 根据id查询政务问题信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getProblem/{id}", method = RequestMethod.GET)
	public Object getProblem(@PathVariable("id") String id) {
		return problemService.getProblem(id);
	}

	/**
	 * 删除政务问题后台api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeProblem/{id}", method = RequestMethod.GET)
	public Object removeProblem(@PathVariable("id") String id) {
		return problemService.removeProblem(id);
	}

	/**
	 * 新建政务问题后台api
	 * 
	 * @param detail
	 * @return
	 */
	@RequestMapping(value = "/addProblem", method = RequestMethod.POST)
	public Object addProblem(@RequestBody GovmgtProblem param, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return problemService.addProblem(param, user);
	}

	/**
	 * 修改政务问题后台api
	 * 
	 * @param detail
	 * @return
	 */
	@RequestMapping(value = "/modifyProblem", method = RequestMethod.POST)
	public Object modifyProblem(@RequestBody GovmgtProblem param) {
		return problemService.modifyProblem(param);
	}
}

package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.detail.pojo.KeyproInfDelDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.KeyproInfoPagination;
import com.jtzh.service.KeyproInfoDelService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "重点工程信息发布")
@RestController
@RequestMapping("keyproInfoDel")
public class KeyproInfoDelController {
	@Resource
	private KeyproInfoDelService keyproInfoDelService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 分页获取重点工程信息发布列表包含图片 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页重点工程信息发布含图片")
	@RequestMapping(value = "/getKeyproInfoDelList", method = RequestMethod.POST)
	public Object getKeyproInfoDelList(@RequestBody KeyproInfoPagination param) {
		return keyproInfoDelService.getKeyproInfoDelList(param);
	}

	/**
	 * 分页获取重点工程信息发布列表不包含图片 api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页重点工程信息发布不含图片")
	@RequestMapping(value = "/getKeyproInfoDelList2", method = RequestMethod.POST)
	public Object getKeyproInfoDelList2(@RequestBody KeyproInfoPagination param) {
		return keyproInfoDelService.getKeyproInfoDelList2(param);
	}

	/**
	 * 根据id查询重点工程具体信息 api
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id、type查询重点工程信息")
	@RequestMapping(value = "/getKeyproInfoDel/{type}/{id}", method = RequestMethod.GET)
	public Object getKeyproInfoDel(@PathVariable("type") String type, @PathVariable("id") String id) {
		return keyproInfoDelService.getKeyproInfoDel(type, id);
	}

	/**
	 * 根据id删除重点工程信息 api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除重点工程信息发布")
	@RequestMapping(value = "/removeKeyproInfoDel/{id}", method = RequestMethod.GET)
	public Object removeKeyproInfoDel(@PathVariable("id") String id) {
		return keyproInfoDelService.removeKeyproInfoDel(id);
	}

	/**
	 * 新建信息 api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="新建重点工程信息发布")
	@RequestMapping(value = "/addKeyproInfDel", method = RequestMethod.POST)
	public Object addKeyproInfDel(@RequestBody KeyproInfDelDetail detail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return keyproInfoDelService.addKeyproInfDel(detail, user);
	}

	/**
	 * 删除信息 api
	 * 
	 * @param detail
	 * @return
	 */
	@ApiOperation(value="修改重点工程信息发布")
	@RequestMapping(value = "/modifyKeyproInfDel", method = RequestMethod.POST)
	public Object modifyKeyproInfDel(@RequestBody KeyproInfDelDetail detail) {
		return keyproInfoDelService.modifyKeyproInfDel(detail);
	}
}

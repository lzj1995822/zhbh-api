package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.jtzh.common.ExtResponse;
import com.jtzh.util.ResponseUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.HiddenDanger;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.HiddenDetail;
import com.jtzh.pojo.HiddenParam;
import com.jtzh.service.HiddenService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "安全隐患管理")
@RestController
@RequestMapping("Hidden")
public class HiddenController {
	@Resource
	private HiddenService hiddenService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取隐患列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getHiddenList", method = RequestMethod.POST)
	public Object getHiddenList(@RequestBody HiddenParam param) {
		
		return hiddenService.getHiddenList(param);
	}

	/**
	 * 获取隐患详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getHiddenInfo/{id}", method = RequestMethod.GET)
	public Object getHiddenInfo(@PathVariable("id") String id) {
		return hiddenService.getHiddenInfo(id);
	}

	/**
	 * 发现隐患（新建隐患）api
	 * 
	 * @param hiddenDetail
	 * @return
	 */
	@RequestMapping(value = "/addHidden", method = RequestMethod.POST)
	public Object addHidden(@RequestBody HiddenDetail hiddenDetail, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return hiddenService.addHidden(hiddenDetail, user);
	}
	
	/**
	 * 删除隐患api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteHidden/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deleteHidden(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return hiddenService.deleteHidden(id, sourceType);
	}
	
	/**
	 * 修改隐患记录api
	 * 
	 * @param HiddenDanger
	 * @return
	 */
	@RequestMapping(value = "/updateHidden", method = RequestMethod.POST)
	public Object updateHidden(@RequestBody HiddenDanger param) {
		return hiddenService.updateHidden(param);
	}

	/**
	 * 移交api (已经废弃)
	 * 
	 * @param HiddenDanger
	 * @return
	 */
	@RequestMapping(value = "/moveHidden", method = RequestMethod.POST)
	public Object moveHidden(@RequestBody HiddenDanger param) {
		return hiddenService.moveHidden(param);
	}
	
	/**
	 * 指派api (已经废弃)
	 * 
	 * @param HiddenDanger
	 * @return
	 */
	@RequestMapping(value = "/sendHidden", method = RequestMethod.POST)
	public Object sendHidden(@RequestBody HiddenDanger param) {
		return hiddenService.sendHidden(param);
	}
	
	/**
	 * 整改api
	 * 
	 * @param HiddenDanger
	 * @return
	 */
	@RequestMapping(value = "/solveHidden", method = RequestMethod.POST)
	public Object solveHidden(@RequestBody HiddenDetail hiddenDetail) {
		return hiddenService.solveHidden(hiddenDetail);
	}

	/**
	 * 获取安全管理隐患坐标api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getHiddenCoordinate", method = RequestMethod.POST)
	public Object getHiddenCoordinate() {
		return hiddenService.getHiddenCoordinate();
	}

	/**
	 * 获取隐患列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getHiddenGis", method = RequestMethod.POST)
	public Object getHiddenGis(@RequestBody HiddenParam param) {
		return hiddenService.getHiddenGis(param);
	}
	
	/**
	 * 统计负责人对应数量（无参） api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/countHiddenState", method = RequestMethod.POST)
	public Object countHiddenState() {
		return hiddenService.countHiddenState();
	}
	
	/**
	 * 统计状态对应数据（无参） api
	 * 
	 * @return
	 */
	@RequestMapping(value = "/countHiddenStateNoParam", method = RequestMethod.POST)
	public Object countHiddenStateNoParam() {
		return hiddenService.countHiddenStateNoParam();
	}
	
	/**
	 * 统计状态数据（有参） api
	 * 
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/countHiddenByState/{state}", method = RequestMethod.GET)
	public Object countHiddenByState(@PathVariable("state") String state) {
		return hiddenService.countHiddenByState(state);
	}
	
	/**
	 * 根据年份进行季度统计api
	 * 
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/countHiddenByYear/{year}", method = RequestMethod.GET)
	public Object countHiddenByYear(@PathVariable("year") String year) {
		return hiddenService.countHiddenByYear(year);
	}
	
	/**
	 * 根据年份进行月份统计api
	 * 
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/countHiddenByMonth/{year}", method = RequestMethod.GET)
	public Object countHiddenByMonth(@PathVariable("year") String year) {
		return hiddenService.countHiddenByMonth(year);
	}
	
	/**
	 * 根据年份进行一周统计api
	 * 
	 * @param year
	 * @return
	 */
	@RequestMapping(value = "/countHiddenByDay/{year}", method = RequestMethod.GET)
	public Object countHiddenByDay(@PathVariable("year") String year) {
		return hiddenService.countHiddenByDay(year);
	}
	
	@ApiOperation(value = "按村统计隐患数量")
	@RequestMapping(value = "/countHiddenAllCountryside", method = RequestMethod.POST)
	public Object countHiddenAllCountryside() {
		return hiddenService.countHiddenAllCountryside();
	}
	
	@ApiOperation(value = "根据隐患类型统计每个类型的未处理和已处理")
	@RequestMapping(value = "/countHiddenByType", method = RequestMethod.POST)
	public Object countHiddenByType() {
		return hiddenService.countHiddenByType();
	}
	
	@ApiOperation(value = "根据人员统计每个类型的未处理和已处理")
	@RequestMapping(value = "/countHiddenByPeople", method = RequestMethod.POST)
	public Object countHiddenByPeople() {
		return hiddenService.countHiddenByPeople();
	}

	@ApiOperation(value = "获取隐患种类")
	@RequestMapping(value = "/getHiddenType", method = RequestMethod.GET)
 	public ExtResponse getHiddenType() {
		return ResponseUtil.success(this.hiddenService.getHiddenType());
	}

	@ApiOperation(value = "获取隐患种类")
	@RequestMapping(value = "/getHiddenCountByType", method = RequestMethod.GET)
	public Object getHiddenCountByType() {
		return ResponseUtil.success(this.hiddenService.getHiddenCountByType());
	}


}

package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.Constants;
import com.jtzh.entity.CountrysideProblem;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.jpush.JpushUtils;
import com.jtzh.pojo.CountrysideProblemDetail;
import com.jtzh.pojo.CountrysideProblemParam;
import com.jtzh.service.CountrysideProblemService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "村建问题管理")
@RestController
@RequestMapping("CountrysideProblem")
public class CountrysideProblemController {
	@Resource
	private CountrysideProblemService countrysideProblemService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	@Resource
	private JpushUtils jpushUtils;
	
	/**
	 * 获取问题列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideProblemList", method = RequestMethod.POST)
	public Object getCountrysideProblemList(@RequestBody CountrysideProblemParam param) {
		
		return countrysideProblemService.getCountrysideProblemList(param);
	}

	/**
	 * 获取问题详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideProblemInfo/{id}", method = RequestMethod.GET)
	public Object getCountrysideProblemInfo(@PathVariable("id") String id) {
		return countrysideProblemService.getCountrysideProblemInfo(id);
	}
	
	/**
	 * 删除问题记录api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCountrysideProblem/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deleteCountrysideProblem(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return countrysideProblemService.deleteCountrysideProblem(id, sourceType);
	}
	
	/**
	 * 修改问题记录api
	 * 
	 * @param CountrysideProblem
	 * @return
	 */
	@RequestMapping(value = "/updateCountrysideProblem", method = RequestMethod.POST)
	public Object updateCountrysideProblem(@RequestBody CountrysideProblem param) {
		return countrysideProblemService.updateCountrysideProblem(param);
	}
	
	/**
	 * 问题上报（登记）api
	 * 
	 * @param problemDetail
	 * @return
	 */
	@RequestMapping(value = "/addCountrysideProblem", method = RequestMethod.POST)
	public Object addCountrysideProblem(@RequestBody CountrysideProblemDetail problemDetail,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return countrysideProblemService.addCountrysideProblem(problemDetail, user);
	}
	
	/**
	 * 问题立案api
	 * 
	 * @param CountrysideProblem
	 * @return
	 */
	@RequestMapping(value = "/Problemlian", method = RequestMethod.POST)
	public Object Problemlian(@RequestBody CountrysideProblem param) {
		return countrysideProblemService.Problemlian(param);
	}
	
	/**
	 * 问题派发api
	 * 
	 * @param CountrysideProblem
	 * @return
	 */
	@RequestMapping(value = "/Problempaifa", method = RequestMethod.POST)
	public Object Problempaifa(@RequestBody CountrysideProblem param) {
		String alias = Constants.JPUSH_CJ_DEPNAME+param.getPaifaren();
    	jpushUtils.sendMsgToAndroid(Constants.JPUSH_DEFAULT_MSG, alias);
		return countrysideProblemService.Problempaifa(param);
	}
	
	/**
	 * 根据状态查询所有信息api
	 * 
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/findbystate", method = RequestMethod.POST)
	public Object findbystate(@RequestBody CountrysideProblemParam param) {
		
		return countrysideProblemService.findbystate(param);
	}
	
	/**
	 * 根据id查询所有信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findbyId/{id}", method = RequestMethod.GET)
    public Object findbyId(@PathVariable("id") String id){
		return countrysideProblemService.findbyId(id);
    }
	
	/**
	 * 获取上报人为当前登录人状态为审核不通过列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getshangbaorenProblemList", method = RequestMethod.POST)
	public Object getshangbaorenProblemList(@RequestBody CountrysideProblemParam param,HttpServletRequest request) {
		return countrysideProblemService.getshangbaorenProblemList(param);

	}
	/**
	 * 获取派发人为当前登录人状态为待处理列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getpaifarenProblemList", method = RequestMethod.POST)
	public Object getpaifarenProblemList(@RequestBody CountrysideProblemParam param,HttpServletRequest request) {
		return countrysideProblemService.getpaifarenProblemList(param);

	}
	/**
	 * 获取立案人或派发人为当前登录人状态为审核通过列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getPeopleProblemList", method = RequestMethod.POST)
	public Object getPeopleProblemList(@RequestBody CountrysideProblemParam param,HttpServletRequest request) {
		return countrysideProblemService.getPeopleProblemList(param);

	}
	
	/**
	 * 状态修改api
	 * 
	 * @param CountrysideProblemgetZyz
	 * @return
	 */
	@RequestMapping(value = "/updateIsdeleted", method = RequestMethod.POST)
	public Object updateIsdeleted(@RequestBody CountrysideProblem param) {
		return countrysideProblemService.updateIsdeleted(param);
	}

	/**
	 * 根据id获取坐标api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getxyInfo/{id}", method = RequestMethod.GET)
	public Object getxyInfo(@PathVariable("id") String id) {
		return countrysideProblemService.getxyInfo(id);
	}
	
	/**
	 * 获取全部问题坐标api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getxyList", method = RequestMethod.POST)
	public Object getxyList(@RequestBody CountrysideProblemParam param) {
		
		return countrysideProblemService.getxyList(param);
	}
	
	/**
	 * 获取全部问题坐标api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getAllxyList", method = RequestMethod.POST)
	public Object getAllxyList(@RequestBody CountrysideProblemParam param) {
		
		return countrysideProblemService.getAllxyList(param);
	}
	
	// 废弃问题统计
    @RequestMapping(value = "/getCountListfeiqi", method = RequestMethod.POST)
    public Object getCountListfeiqi() {
    	Long count=countrysideProblemService.getCountListfeiqi();
		return count;
	}
    // 待派发问题统计
    @RequestMapping(value = "/getCountListdaipaifa", method = RequestMethod.POST)
    public Object getCountListdaipaifa() {
    	Long count=countrysideProblemService.getCountListdaipaifa();
		return count;
	}
    // 处理中问题统计
    @RequestMapping(value = "/getCountListchulizhong", method = RequestMethod.POST)
    public Object getCountListchulizhong() {
    	Long count=countrysideProblemService.getCountListchulizhong();
		return count;
	}
    // 待审核问题统计
    @RequestMapping(value = "/getCountListdaishenhe", method = RequestMethod.POST)
    public Object getCountListdaishenhe() {
    	Long count=countrysideProblemService.getCountListdaishenhe();
		return count;
	}
    // 已结案问题统计
    @RequestMapping(value = "/getCountListyijiean", method = RequestMethod.POST)
    public Object getCountListyijiean() {
    	Long count=countrysideProblemService.getCountListyijiean();
		return count;
	}
    // 季度问题统计
    @RequestMapping(value = "/getCountListjidu/{year}", method = RequestMethod.GET)
    public Object getCountListjidu(@PathVariable String year) {
    	return countrysideProblemService.getCountListjidu(year);
	}
    // 问题状态统计-所有状态
    @RequestMapping(value = "/getAllCountList", method = RequestMethod.GET)
    public Object getAllCountList(CountrysideProblem param) {
    	Object obj =countrysideProblemService.getAllCountList(param);
		return obj;
	}
    
    /**
	 * 村建问题状态统计api
	 * 
	 * @param param
	 * @return
	 */
    @RequestMapping("/getCountList")
    public Object getCountList(@RequestBody CountrysideProblem param) {
    	Long count = countrysideProblemService.getCountList(param);
		return count;
	}
}

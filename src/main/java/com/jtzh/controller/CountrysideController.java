package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CountrysideBuild;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideDetail;
import com.jtzh.pojo.CountrysideParam;
import com.jtzh.service.CountrysideService;
import com.jtzh.service.LoginUserTestService;

import io.swagger.annotations.Api;

@Api(tags = "村建自建房管理")
@RestController
@RequestMapping("Countryside")
public class CountrysideController {
	@Resource
	private CountrysideService countrysideService;
	
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 获取自建房申请信息列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideShenheList", method = RequestMethod.POST)
	public Object getCountrysideList(@RequestBody CountrysideParam param) {
		
		return countrysideService.getCountrysideList(param);
	}

	/**
	 * 获取自建房申请详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideInfo/{id}", method = RequestMethod.GET)
	public Object getCountrysideInfo(@PathVariable("id") String id) {
		return countrysideService.getCountrysideInfo(id);
	}

	/**
	 * 自建房申请api
	 * 
	 * @param countrysideDetail
	 * @return
	 */
	@RequestMapping(value = "/addCountryside", method = RequestMethod.POST)
	public Object addCountryside(@RequestBody CountrysideDetail countrysideDetail,HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return countrysideService.addCountryside(countrysideDetail, user);
	}
	
	/**
	 * 删除申请api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCountryside/{id}/{sourceType}", method = RequestMethod.GET)
	public Object deleteCountryside(@PathVariable("id") String id, @PathVariable("sourceType") String sourceType) {
		return countrysideService.deleteCountryside(id, sourceType);
	}
	
	/**
	 * 修改申请信息api
	 * 
	 * @param HiddenDanger
	 * @return
	 */
	@RequestMapping(value = "/updateCountryside", method = RequestMethod.POST)
	public Object updateCountryside(@RequestBody CountrysideBuild param) {
		return countrysideService.updateCountryside(param);
	}
	
	/**
	 * 申请审核api
	 * 
	 * @param CountrysideBuild
	 * @return
	 */
	@RequestMapping(value = "/testCountryside", method = RequestMethod.POST)
	public Object testCountryside(@RequestBody CountrysideBuild param) {
		return countrysideService.testCountryside(param);
	}
	
	/**
	 * 获取全部问题坐标api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getAllxyList", method = RequestMethod.POST)
	public Object getAllxyList(@RequestBody CountrysideParam param) {
		
		return countrysideService.getAllxyList(param);
	}
	
	/**
	 * 提交验收api
	 * 
	 * @param CountrysideBuild
	 * @return
	 */
	@RequestMapping(value = "/commitCountryside", method = RequestMethod.POST)
	public Object commitCountryside(@RequestBody CountrysideBuild param) {
		return countrysideService.commitCountryside(param);
	}
	
	/**
	 * 验收审核api
	 * 
	 * @param CountrysideBuild
	 * @return
	 */
	@RequestMapping(value = "/shenheCountryside", method = RequestMethod.POST)
	public Object shenheCountryside(@RequestBody CountrysideBuild param) {
		return countrysideService.shenheCountryside(param);
	}
	
	/**
	 * 获取自建房申请信息列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideYanshouList", method = RequestMethod.POST)
	public Object getCountrysideYanshouList(@RequestBody CountrysideParam param) {
		
		return countrysideService.getCountrysideYanshouList(param);
	}
	
	/**
	 * 自建房申请状态统计api
	 * 
	 * @param param
	 * @return
	 */
    @RequestMapping("/getCountList1")
    public Object getCountList1(@RequestBody CountrysideBuild param) {
    	Long count = countrysideService.getCountList1(param);
		return count;
	}
    
    /**
	 * 自建房验收状态统计api
	 * 
	 * @param param
	 * @return
	 */
    @RequestMapping("/getCountList2")
    public Object getCountList2(@RequestBody CountrysideBuild param) {
    	Long count = countrysideService.getCountList2(param);
		return count;
	}
    
    /**
	 * 自建房验收审核状态统计api
	 * 
	 * @param param
	 * @return
	 */
    @RequestMapping("/getCountList3")
    public Object getCountList3(@RequestBody CountrysideBuild param) {
    	Long count = countrysideService.getCountList3(param);
		return count;
	}
    
    @RequestMapping("/getapplyList")
    public Object getapplyList(CountrysideBuild param) {
    	Object obj =countrysideService.getapplyList(param);
		return obj;
	}
    
    @RequestMapping("/getexamineList")
    public Object getexamineList(CountrysideBuild param) {
    	Object obj =countrysideService.getexamineList(param);
		return obj;
	}

}

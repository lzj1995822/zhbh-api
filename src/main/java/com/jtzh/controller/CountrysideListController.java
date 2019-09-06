package com.jtzh.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.CountrysideList;
import com.jtzh.pojo.CountrysideListParam;
import com.jtzh.service.CountrysideListService;

import io.swagger.annotations.Api;

@Api(tags = "村列表")
@RestController
@RequestMapping("CountrysideList")
public class CountrysideListController {
	@Resource
	private CountrysideListService listService;
	
	/**
	 * 获取村列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideList", method = RequestMethod.POST)
	public Object getCountrysideList(@RequestBody CountrysideListParam param) {
		return listService.getCountrysideList(param);
	}
	
	/**
	 * 获取村详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getCountrysideListInfo/{id}", method = RequestMethod.GET)
	public Object getCountrysideListInfo(@PathVariable("id") String id) {
		return listService.getCountrysideListInfo(id);
	}
	
	/**
	 * 发布会议通知api
	 * 
	 * @param CountrysideList
	 * @return
	 */
	@RequestMapping(value = "/addCountrysideList", method = RequestMethod.POST)
	public Object addCountrysideList(@RequestBody CountrysideList list) {
		return listService.addCountrysideList(list);
	}
	
	/**
	 * 修改会议通知api
	 * 
	 * @param CountrysideList
	 * @return
	 */
	@RequestMapping(value = "/updateCountrysideList", method = RequestMethod.POST)
	public Object updateCountrysideList(@RequestBody CountrysideList param) {
		return listService.updateCountrysideList(param);
	}
	
	/**
	 * 删除会议通知api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteCountrysideList/{id}", method = RequestMethod.GET)
	public Object deleteCountrysideList(@PathVariable("id") String id) {
		return listService.deleteCountrysideList(id);
	}

}

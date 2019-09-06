package com.jtzh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.jtzh.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NewsDepReq;
import com.jtzh.pojo.NewsInfDto;
import com.jtzh.pojo.NewsInfPagination;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.NewsInfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "通知公告管理")
@RestController
@RequestMapping("newsInf")
public class NewsInfController {
	@Resource
	private NewsInfService newsInfService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	/**
	 * 分页获取通知公告api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="分页获取通知公告")
	@RequestMapping(value = "/getNewsInfList", method = RequestMethod.POST)
	public BaseResponse<List<NewsInf>> getNewsInfList(@RequestBody NewsInfPagination param) {
		return newsInfService.getNewsInfList(param);
	}
	
	/**
	 * 根据id获取通知公告详情api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id查询通知公告详情")
	@RequestMapping(value = "/getNewsInf", method = RequestMethod.POST)
	public BaseResponse<NewsInf> getNewsInf(@RequestBody NewsDepReq param) {
		return newsInfService.getNewsInf(param);
	}
	
	/**
	 * 根据id删除通知公告api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id删除通知公告")
	@RequestMapping(value = "/removeNewsInf/{id}", method = RequestMethod.GET)
	public BaseResponse<String> removeNewsInf(@PathVariable("id") Integer id) {
		return newsInfService.removeNewsInf(id);
	}
	
	/**
	 * 新建通知公告api
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@ApiOperation(value="新建通知公告")
	@RequestMapping(value = "/addNewsInf", method = RequestMethod.POST)
	public BaseResponse<String> addNewsInf(@RequestBody NewsInfDto param) {

		return newsInfService.addNewsInf(param);
	}
	
	/**
	 * 修改通知公告api
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="修改通知公告")
	@RequestMapping(value = "/modifyNewsInf", method = RequestMethod.POST)
	public BaseResponse<String> modifyNewsInf(@RequestBody NewsInfDto param) {
		return newsInfService.modifyNewsInf(param);
	}
	
	/**
	 * 根据id更新阅读次数api
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value="根据id更新通知公告阅读次数")
	@RequestMapping(value = "/updateReadNum/{id}", method = RequestMethod.GET)
	public BaseResponse<String> updateReadNum(@PathVariable("id") Integer id) {
		return newsInfService.updateReadNum(id);
	}
	
	/**
	 * 获取所有通知公告的总数
	 * 
	 * @return
	 */
	@ApiOperation(value="活动通知公告总数")
	@RequestMapping(value = "/getTotal", method = RequestMethod.POST)
	public int getTotal(){
		return newsInfService.getTotal();
	}
	
	/**
	 * 接受公告
	 * 
	 * @param param
	 * @return
	 */
	@ApiOperation(value="接受公告")
	@RequestMapping(value = "/receiveNews", method = RequestMethod.POST)
	public Object receiveNews(@RequestBody NewsUserReceive param){
		return newsInfService.receiveNews(param);
	}
	
	@ApiOperation(value="根据newsId和depName获取已经接受人姓名和部门")
	@RequestMapping(value = "/getReceiveNameAndDep", method = RequestMethod.POST)
	public Object getReceiveNameAndDep(@RequestBody NewsDepReq param){
		return newsInfService.getReceiveNameAndDep(param);
	}


    /**
     * 根据id更新审核状态
     *
     * @param param
     * @return
     */
    @ApiOperation(value="修改通知公告审核状态")
    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    public BaseResponse<String> updateState(@RequestBody NewsInf param) {
        return newsInfService.updateState(param);
    }


	/**
	 * 插入通知公告浏览记录
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value="插入浏览记录")
	@RequestMapping(value = "/insertBrowsingHistory", method = RequestMethod.POST)
	public BaseResponse<String> insertBrowsingHistory(@RequestBody NewsBrowsingHistory param) {
		return newsInfService.insertBrowsingHistory(param);
	}


	/**
	 * 根据newsId返回浏览人和浏览次数
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value="根据newsId返回浏览人和浏览次数")
	@RequestMapping(value = "/getBrowsingHistory", method = RequestMethod.POST)
	public BaseResponse<List<NewsBrowsingHistory>> getBrowsingHistory(@RequestBody BrowsingPage param) {
		return newsInfService.getBrowsingHistory(param);
	}

	/**
	 * 根据newsId和name返回浏览记录
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation(value="3.根据newsId和name返回浏览记录")
	@RequestMapping(value = "/getBrowsingList", method = RequestMethod.POST)
	public BaseResponse<List<NewsBrowsingHistory>> getBrowsingList(@RequestBody BrowsingPage param) {
		return newsInfService.getBrowsingList(param);
	}

}

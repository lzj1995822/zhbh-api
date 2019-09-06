package com.jtzh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.dto.SafeNoticeAndPicDto;
import com.jtzh.dto.SafeNoticeDto;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.NoticeInf;
import com.jtzh.entity.SecurityInfReceive;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NoticeParam;
import com.jtzh.responsevo.SecurityInfReceiveDetailVo;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.SafeNoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "应急通知公告管理")
@RestController
@RequestMapping("safeNotice")
public class SafeNoticeController {
	@Resource
	private SafeNoticeService safeNoticeService;
	@Resource
	private LoginUserTestService loginUserTestService;
	
	@ApiOperation(value="分页获取应急通知公告列表")
	@RequestMapping(value = "/getSafeNoticeList", method = RequestMethod.POST)
	public BaseResponse<List<NoticeInf>> getSafeNoticeList(@RequestBody NoticeParam param) {
		return safeNoticeService.getSafeNoticeList(param);
	}
	
	@ApiOperation(value="根据id获取应急通知公告详情")
	@RequestMapping(value = "/getSafeNotice/{id}", method = RequestMethod.GET)
	public Object getSafeNotice(@PathVariable("id") String id) {
		return safeNoticeService.getSafeNotice(id);
	}
	
	@ApiOperation(value="新建应急通知公告")
	@RequestMapping(value = "/addSafeNotice", method = RequestMethod.POST)
	public Object addSafeNotice(@RequestBody SafeNoticeDto inf, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return safeNoticeService.addSafeNotice(inf, user);
	}
	
	@ApiOperation(value="修改应急通知公告(只能修改公告内容)")
	@RequestMapping(value = "/updateSafeNotice", method = RequestMethod.POST)
	public Object updateSafeNotice(@RequestBody NoticeInf param) {
		return safeNoticeService.updateSafeNotice(param);
	}
	
	@ApiOperation(value="根据id删除应急通知公告")
	@RequestMapping(value = "/deleteSafeNotice/{id}", method = RequestMethod.GET)
	public Object deleteSafeNotice(@PathVariable("id") String id) {
		return safeNoticeService.deleteSafeNotice(id);
	}
	
	@ApiOperation(value="点击阅读应急通知公告")
	@RequestMapping(value = "/readSafeNotice", method = RequestMethod.POST)
	public Object readSafeNotice(@RequestBody SecurityInfReceive param){
		return safeNoticeService.readSafeNotice(param);
	}
	
	@ApiOperation(value="接受应急通知公告并上传图片")
	@RequestMapping(value = "/receiveSafeNotice", method = RequestMethod.POST)
	public Object receiveSafeNotice(@RequestBody SafeNoticeAndPicDto param){
		return safeNoticeService.receiveSafeNotice(param);
	}
	
	@ApiOperation(value="根据newsId和userId查看其公告信息和上传的文字图片信息")
	@RequestMapping(value = "/getSafeNoticeDetail", method = RequestMethod.POST)
	public BaseResponse <SecurityInfReceiveDetailVo> getSafeNoticeDetail(@RequestBody SecurityInfReceive param){
		return safeNoticeService.getSafeNoticeDetail(param);
	}
	
	@ApiOperation(value="根据type查询应急人员")
	@RequestMapping(value = "/getSafeUser/{type}", method = RequestMethod.GET)
	public BaseResponse <List<Userinformation>> getSafeUser(@PathVariable("type") String type) {
		return safeNoticeService.getSafeUser(type);
	}
	
	@ApiOperation(value="根据newsId查看其公告信息和上传的文字图片信息")
	@RequestMapping(value = "/getSafeNoticeDetailByNewId/{newsId}", method = RequestMethod.GET)
	public BaseResponse<List<SecurityInfReceiveDetailVo>> getSafeNoticeDetailByNewId(@PathVariable("newsId") Integer newsId){
		return safeNoticeService.getSafeNoticeDetailByNewId(newsId);
	}

}

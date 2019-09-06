package com.jtzh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.NoticeInf;
import com.jtzh.entity.NoticeLaw;
import com.jtzh.entity.NoticeTrain;
import com.jtzh.pojo.NoticeDetail;
import com.jtzh.pojo.NoticeParam;
import com.jtzh.service.LoginUserTestService;
import com.jtzh.service.NoticeService;

import io.swagger.annotations.Api;

@Api(tags = "安全通知公告管理")
@RestController
@RequestMapping("Notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	@Resource
	private LoginUserTestService loginUserTestService;

	/**
	 * 获取所有公告列表 - APP
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getInfoListApp", method = RequestMethod.POST)
	public Object getInfoListApp(@RequestBody NoticeParam param) {
		return noticeService.getInfoListApp(param);
	}

	// 通知公告
	/**
	 * 获取通知公告列表api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getNoticeInfList", method = RequestMethod.POST)
	public Object getNoticeInfList(@RequestBody NoticeParam param) {
		return noticeService.getNoticeInfList(param);
	}

	/**
	 * 获取通知公告详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getNoticeInf/{id}", method = RequestMethod.GET)
	public Object getNoticeInf(@PathVariable("id") String id) {
		return noticeService.getNoticeInf(id);
	}

	/**
	 * 新建通知公告api
	 * 
	 * @param NoticeInf
	 * @return
	 */
	@RequestMapping(value = "/addNoticeInf", method = RequestMethod.POST)
	public Object addNoticeInf(@RequestBody NoticeInf inf, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return noticeService.addNoticeInf(inf, user);
	}

	/**
	 * 修改通知公告api
	 * 
	 * @param NoticeInf
	 * @return
	 */
	@RequestMapping(value = "/updateNoticeInf", method = RequestMethod.POST)
	public Object updateNoticeInf(@RequestBody NoticeInf param) {
		return noticeService.updateNoticeInf(param);
	}

	/**
	 * 删除通知公告api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteNoticeInf/{id}", method = RequestMethod.GET)
	public Object deleteNoticeInf(@PathVariable("id") String id) {
		return noticeService.deleteNoticeInf(id);
	}

	// 法律法规
	/**
	 * 默认获取法律法规api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getNoticeLawList", method = RequestMethod.POST)
	public Object getNoticeLawList(@RequestBody NoticeParam param) {
		return noticeService.getNoticeLawList(param);
	}

	/**
	 * 获取法律法规详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getNoticeLaw/{id}", method = RequestMethod.GET)
	public Object getNoticeLaw(@PathVariable("id") String id) {
		return noticeService.getNoticeLaw(id);
	}

	/**
	 * 新建法律法规api
	 * 
	 * @param NoticeLaw
	 * @return
	 */
	@RequestMapping(value = "/addNoticeLaw", method = RequestMethod.POST)
	public Object addNoticeLaw(@RequestBody NoticeLaw law, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return noticeService.addNoticeLaw(law, user);
	}

	/**
	 * 修改法律法规api
	 * 
	 * @param NoticeLaw
	 * @return
	 */
	@RequestMapping(value = "/updateNoticeLaw", method = RequestMethod.POST)
	public Object updateNoticeLaw(@RequestBody NoticeLaw param) {
		return noticeService.updateNoticeLaw(param);
	}

	/**
	 * 删除法律法规api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteNoticeLaw/{id}", method = RequestMethod.GET)
	public Object deleteNoticeLaw(@PathVariable("id") String id) {
		return noticeService.deleteNoticeLaw(id);
	}

	// 教育培训
	/**
	 * 默认获取教育培训api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getNoticeTrainList", method = RequestMethod.POST)
	public Object getNoticeTrainList(@RequestBody NoticeParam param) {
		return noticeService.getNoticeTrainList(param);
	}

	/**
	 * 获取教育培训详细信息api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getNoticeTrain/{id}", method = RequestMethod.GET)
	public Object getNoticeTrain(@PathVariable("id") String id) {
		return noticeService.getNoticeTrain(id);
	}

	/**
	 * 新建教育培训api
	 * 
	 * @param NoticeTrain
	 * @return
	 */
	@RequestMapping(value = "/addNoticeTrain", method = RequestMethod.POST)
	public Object addNoticeTrain(@RequestBody NoticeTrain train, HttpServletRequest request) {
		LoginUserTest user = (LoginUserTest) loginUserTestService.getTestUserInfo(request);
		return noticeService.addNoticeTrain(train, user);
	}

	/**
	 * 修改教育培训api
	 * 
	 * @param NoticeTrain
	 * @return
	 */
	@RequestMapping(value = "/updateNoticeTrain", method = RequestMethod.POST)
	public Object updateNoticeTrain(@RequestBody NoticeTrain param) {
		return noticeService.updateNoticeTrain(param);
	}

	/**
	 * 删除教育培训api
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteNoticeTrain/{id}", method = RequestMethod.GET)
	public Object deleteNoticeTrain(@PathVariable("id") String id) {
		return noticeService.deleteNoticeTrain(id);
	}

	/**
	 * 默认获取教育培训api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getNoticeAllList", method = RequestMethod.POST)
	public Object getNoticeAllList(@RequestBody NoticeParam param) {
		List<NoticeInf> list = noticeService.getNoticeInfList(param).getResponseData();
		List<NoticeLaw> list1 = noticeService.getNoticeLawList(param).getResponseData();
		List<NoticeTrain> list2 = noticeService.getNoticeTrainList(param).getResponseData();
		NoticeDetail detail = new NoticeDetail();
		detail.setNoticeInf(list);
		detail.setNoticeLaw(list1);
		detail.setNoticeTrain(list2);
		return detail;
	}

	/**
	 * 大屏获取通知公告
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getNoticeScreenList", method = RequestMethod.POST)
	public Object getNoticeScreenList(@RequestBody NoticeParam param) {
		List<NoticeInf> list0 = new ArrayList<NoticeInf>();
		List<NoticeInf> list00 = noticeService.getNoticeInfList(param).getResponseData();
		if (null != list00 && list00.size() > 3) {
			list0.add(list00.get(0));
			list0.add(list00.get(1));
			list0.add(list00.get(2));
			list0.add(list00.get(3));
		}
		List<NoticeLaw> list1 = new ArrayList<NoticeLaw>();
		List<NoticeLaw> list11 = noticeService.getNoticeLawList(param).getResponseData();
		if (null != list11 && list11.size() > 3) {
			list1.add(list11.get(0));
			list1.add(list11.get(1));
			list1.add(list11.get(2));
			list1.add(list11.get(3));
		}
		List<NoticeTrain> list2 = new ArrayList<NoticeTrain>();
		List<NoticeTrain> list22 = noticeService.getNoticeTrainList(param).getResponseData();
		if (null != list22 && list22.size() > 3) {
			list2.add(list22.get(0));
			list2.add(list22.get(1));
			list2.add(list22.get(2));
			list2.add(list22.get(3));
		}
		NoticeDetail detail = new NoticeDetail();
		detail.setNoticeInf(list0);
		detail.setNoticeLaw(list1);
		detail.setNoticeTrain(list2);
		return detail;
	}

}

package com.jtzh.service;

import java.util.List;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.NoticeInf;
import com.jtzh.entity.NoticeLaw;
import com.jtzh.entity.NoticeTrain;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NoticeParam;

public interface NoticeService {
	
	// 通知公告
	public BaseResponse<List<NoticeInf>> getNoticeInfList(NoticeParam param); // 查询
	public Object getInfoListApp(NoticeParam param);
	public NoticeInf getNoticeInf(String id); // 查看详情
	
	public Object addNoticeInf(NoticeInf inf, LoginUserTest user); // 新建
	
	Object updateNoticeInf(NoticeInf param); // 修改
	
	public Object deleteNoticeInf(String id); // 删除
	
	// 法律法规
	public BaseResponse<List<NoticeLaw>> getNoticeLawList(NoticeParam param); // 查询
	
	public NoticeLaw getNoticeLaw(String id); // 查看详情
	
	public Object addNoticeLaw(NoticeLaw law, LoginUserTest user); // 新建
	
	Object updateNoticeLaw(NoticeLaw param); // 修改
	
	public Object deleteNoticeLaw(String id); // 删除
	
	// 教育培训
	public BaseResponse<List<NoticeTrain>> getNoticeTrainList(NoticeParam param); // 查询
	
	public NoticeTrain getNoticeTrain(String id); // 查看详情
	
	public Object addNoticeTrain(NoticeTrain train, LoginUserTest user); // 新建
	
	Object updateNoticeTrain(NoticeTrain param); // 修改
	
	public Object deleteNoticeTrain(String id); // 删除
	

}

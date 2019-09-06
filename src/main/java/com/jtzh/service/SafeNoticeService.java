package com.jtzh.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.NoticeInf;
import com.jtzh.entity.SecurityInfReceive;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NoticeParam;
import com.jtzh.responsevo.SecurityInfReceiveDetailVo;
import com.jtzh.dto.SafeNoticeAndPicDto;
import com.jtzh.dto.SafeNoticeDto;

public interface SafeNoticeService {
	public BaseResponse<List<NoticeInf>> getSafeNoticeList(NoticeParam param);
	
	public NoticeInf getSafeNotice(String id);
	
	public Object addSafeNotice(SafeNoticeDto inf, LoginUserTest user);
	
	public Object updateSafeNotice(NoticeInf param);
	
	public Object deleteSafeNotice(String id);
	
	public Object receiveSafeNotice(SafeNoticeAndPicDto param);
	
	public Object readSafeNotice(SecurityInfReceive param);
	
	public BaseResponse <SecurityInfReceiveDetailVo> getSafeNoticeDetail(SecurityInfReceive param);
	
	public BaseResponse <List<Userinformation>> getSafeUser(String type);
	
	public BaseResponse<List<SecurityInfReceiveDetailVo>> getSafeNoticeDetailByNewId(Integer newsId);
}

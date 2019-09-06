package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.NoticeInf;
import com.jtzh.entity.NoticeLaw;
import com.jtzh.entity.NoticeTrain;
import com.jtzh.mapper.NoticeInfMapper;
import com.jtzh.mapper.NoticeLawMapper;
import com.jtzh.mapper.NoticeTrainMapper;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NoticeParam;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Resource
	private NoticeInfMapper noticeInfMapper;
	@Resource
	private NoticeLawMapper noticeLawMapper;
	@Resource
	private NoticeTrainMapper noticeTrainMapper;


	@Override
	public BaseResponse<List<NoticeInf>> getInfoListApp(NoticeParam param) {
		// 查询总数
		BaseResponse<List<NoticeInf>> res= new BaseResponse<>();
		int total = noticeInfMapper.selectInfoTotalAPP(param);
		List<NoticeInf> list = new ArrayList<NoticeInf>();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = noticeInfMapper.selectInfoAPP(param);
		}
		res.setResponseData(list);
		return res;
	}

	// 通知公告
	// 查询
	@Override
	public BaseResponse<List<NoticeInf>> getNoticeInfList(NoticeParam param) {
		// 查询总数
		BaseResponse<List<NoticeInf>> res = new BaseResponse<>();
		int total = noticeInfMapper.selectInfTotal(param);
		List<NoticeInf> list = new ArrayList<NoticeInf>();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = noticeInfMapper.selectInfo(param);
		}
		//res.setRows(list);
		res.setResponseData(list);
		return res;
	}
	
	// 查询详情
	@Override
	public NoticeInf getNoticeInf(String id) {
		// 根据id去查询通知公告信息
		NoticeInf noticeInf = noticeInfMapper.getNoticeInf(id);
		return noticeInf;
	}
	
	// 修改
	@Override
	public Object updateNoticeInf(NoticeInf param) {
		noticeInfMapper.updateNoticeInf(param);
		return new ResultObject();
	}
	
	// 新建
	@Override
	public Object addNoticeInf(NoticeInf inf, LoginUserTest user) {
		// inf.setYhzh("宝华镇");
		inf.setYhzh(Constants.YHZH_BAOHUA);
		inf.setCreateTime(new Date());
		inf.setIsdeleted("0");
		inf.setCreateId(user.getLoginId());
		noticeInfMapper.addNoticeInf(inf);
		return new ResultObject();
	}
	
	// 删除
	@Override
	public Object deleteNoticeInf(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		noticeInfMapper.deleteNoticeInf(id);
		return new ResultObject();
	}
	
	// 法律法规
	// 查询
	@Override
	public BaseResponse<List<NoticeLaw>> getNoticeLawList(NoticeParam param) {
		// 查询总数
		BaseResponse<List<NoticeLaw>> res = new BaseResponse<>();
		int total = noticeLawMapper.selectLawTotal(param);
		List<NoticeLaw> list = new ArrayList<NoticeLaw>();
		//PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = noticeLawMapper.selectInfo(param);
		}
		res.setResponseData(list);
		return res;
	}
		
	// 查询详情
	@Override
	public NoticeLaw getNoticeLaw(String id) {
		// 根据id去查询通知公告信息
		NoticeLaw noticeLaw = noticeLawMapper.getNoticeLaw(id);
		return noticeLaw;
	}
	
	// 修改
	@Override
	public Object updateNoticeLaw(NoticeLaw param) {
		noticeLawMapper.updateNoticeLaw(param);
		return new ResultObject();
	}
		
	// 新建
	@Override
	public Object addNoticeLaw(NoticeLaw law, LoginUserTest user) {
		law.setYhzh(Constants.YHZH_BAOHUA);
		law.setCreateTime(new Date());
		law.setIsdeleted("0");
		law.setCreateId(user.getLoginId());
		noticeLawMapper.addNoticeLaw(law);
		return new ResultObject();
	}
		
	// 删除
	@Override
	public Object deleteNoticeLaw(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		noticeLawMapper.deleteNoticeLaw(id);
		return new ResultObject();
	}
		
	// 教育培训
	// 查询
	@Override
	public BaseResponse<List<NoticeTrain>> getNoticeTrainList(NoticeParam param) {
		// 查询总数
		BaseResponse<List<NoticeTrain>> res = new BaseResponse<>();
		int total = noticeTrainMapper.selectTrainTotal(param);
		List<NoticeTrain> list = new ArrayList<NoticeTrain>();
		//PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = noticeTrainMapper.selectInfo(param);
		}
		res.setResponseData(list);
		return res;
	}
				
	@Override
	public NoticeTrain getNoticeTrain(String id) {
		// 根据id去查询通知公告信息
		NoticeTrain noticeTrain = noticeTrainMapper.getNoticeTrain(id);
		return noticeTrain;
	}
		
	// 修改
	@Override
	public Object updateNoticeTrain(NoticeTrain param) {
		noticeTrainMapper.updateNoticeTrain(param);
		return new ResultObject();
	}
		
	// 新建
	@Override
	public Object addNoticeTrain(NoticeTrain train, LoginUserTest user) {
		train.setYhzh(Constants.YHZH_BAOHUA);
		train.setCreateTime(new Date());
		train.setIsdeleted("0");
		train.setCreateId(user.getLoginId());
		noticeTrainMapper.addNoticeTrain(train);
		return new ResultObject();
	}
		
	// 删除
	@Override
	public Object deleteNoticeTrain(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		noticeTrainMapper.deleteNoticeTrain(id);
		return new ResultObject();
	}

}

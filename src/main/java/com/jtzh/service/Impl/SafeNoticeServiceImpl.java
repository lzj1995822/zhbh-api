package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.CommonUtil;
import com.jtzh.dto.NoticeParamAndIds;
import com.jtzh.dto.SafeNoticeAndPicDto;
import com.jtzh.dto.SafeNoticeDto;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.NoticeInf;
import com.jtzh.entity.SecurityInfAppoint;
import com.jtzh.entity.SecurityInfReceive;
import com.jtzh.entity.SecuritySource;
import com.jtzh.entity.Userinformation;
import com.jtzh.mapper.NoticeInfMapper;
import com.jtzh.mapper.SecurityInfAppointMapper;
import com.jtzh.mapper.SecurityInfReceiveMapper;
import com.jtzh.mapper.SecuritySourceMapper;
import com.jtzh.mapper.UserinformationMapper;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NoticeParam;
import com.jtzh.responsevo.SecurityInfReceiveDetailVo;
import com.jtzh.service.SafeNoticeService;

@Service("safeNoticeService")
public class SafeNoticeServiceImpl implements SafeNoticeService {
	@Resource
	private NoticeInfMapper noticeInfMapper;
	@Resource
	private SecurityInfAppointMapper securityInfAppointMapper;
	@Resource
	private SecurityInfReceiveMapper securityInfReceiveMapper;
	@Resource
	private SecuritySourceMapper securitySourceMapper;
	@Resource
	private UserinformationMapper userinformationMapper;
	// getSafeUser

	@Override
	public BaseResponse<List<NoticeInf>> getSafeNoticeList(NoticeParam param) {
		BaseResponse<List<NoticeInf>> res = new BaseResponse<>();
		res.setOk(true);
		List<NoticeInf> list = new ArrayList<NoticeInf>();
		int total = 0;
		// type值0，1对应user表中的datalevel
		// 不为空
		if (CommonUtil.verifyString(param.getType())) {
			// 村0
			int newsIds[];
			if (param.getType().equals(Constants.SAFE_INF_COUNTRY)) {
				newsIds = securityInfAppointMapper.getNewsIds(param.getUserId());
			}
			// 安委会成员1
			else {
				newsIds = securityInfAppointMapper.getNewsIds2(param.getUserId());
			}
			if (newsIds.length > 0) {
				NoticeParamAndIds page = new NoticeParamAndIds();
				BeanUtils.copyProperties(param, page);
				page.setNewsIds(newsIds);
				total = noticeInfMapper.selectTotal2(page);
				res.setTotal(total);
				// 如果存在，查询具体的数据作为分页数据
				if (total > 0) {
					list = noticeInfMapper.selectInfo2(page);
				}
			} else {
				res.setTotal(total);
				res.setResponseData(list);
				return res;
			}
		}
		// admin或者应急领导
		else {
			total = noticeInfMapper.selectInfTotal(param);
			list = noticeInfMapper.selectInfo(param);
		}
		res.setTotal(total);
		res.setResponseData(list);
		return res;
	}

	@Override
	public NoticeInf getSafeNotice(String id) {
		NoticeInf noticeInf = noticeInfMapper.getNoticeInf(id);
		return noticeInf;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Object addSafeNotice(SafeNoticeDto param, LoginUserTest user) {
		NoticeInf inf = param.getNoticeInf();
		int[] countrysideIds = param.getCountrysideIds();
		int[] committeeIds = param.getCommitteeIds();
		String depName = param.getDepName();
		inf.setYhzh(Constants.YHZH_BAOHUA);
		inf.setCreateTime(new Date());
		inf.setIsdeleted("0");
		inf.setCreateId(user.getLoginId());
		noticeInfMapper.addNoticeInf(inf);
		boolean flag = true;
		// 指派给村
		if (null != countrysideIds && countrysideIds.length > 0) {
			for (int countrysideId : countrysideIds) {
				this.addSecurityInfAppointAndReceive(countrysideId, inf.getId(), flag);
			}
		}
		// 指派给安委会成员
		if (null != committeeIds && committeeIds.length > 0) {
			for (int committeeId : committeeIds) {
				flag = false;
				this.addSecurityInfAppointAndReceive(committeeId, inf.getId(), flag);
			}
		}
		// 指派给部门
		if (CommonUtil.verifyString(depName)) {
			int[] userIds = userinformationMapper.getUserIdsByDep(depName);
			if (null != userIds && userIds.length > 0) {
				for (int userId : userIds) {
					this.addSecurityInfAppointAndReceive(userId, inf.getId(), flag);
				}
			}
		}
		return new ResultObject();
	}

	private void addSecurityInfAppointAndReceive(int userId, int newsId, boolean flag) {
		// SecurityInfAppoint表新增
		SecurityInfAppoint appoint = new SecurityInfAppoint();
		appoint.setNewsId(newsId);
		appoint.setCreateTime(new Date());
		appoint.setDelflag(Constants.String_DEL_FLG);
		appoint.setYhzh(Constants.YHZH_BAOHUA);
		if (flag) {
			appoint.setCountrysideId(userId);
		} else {
			appoint.setSecurityCommitteeId(userId);
		}
		securityInfAppointMapper.insert(appoint);
		// securityInfReceive表新增
		SecurityInfReceive securityInfReceive = new SecurityInfReceive();
		securityInfReceive.setUserId(userId);
		securityInfReceive.setNewsId(newsId);
		securityInfReceive.setIsReceive(Constants.RECEIVE_NOT);
		securityInfReceive.setCreateTime(new Date());
		securityInfReceive.setDelflag(Constants.String_DEL_FLG);
		securityInfReceive.setAttachmentSource(Constants.ATTACHSOURCE_SAFE_INF);
		securityInfReceiveMapper.insertSecurityInfReceive(securityInfReceive);
	}

	@Override
	public Object updateSafeNotice(NoticeInf param) {
		noticeInfMapper.updateNoticeInf(param);
		return new ResultObject();
	}

	@Override
	public Object deleteSafeNotice(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		noticeInfMapper.deleteNoticeInf(id);
		return new ResultObject();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Object receiveSafeNotice(SafeNoticeAndPicDto dto) {
		ResultObject res = new ResultObject();
		SecurityInfReceive param = dto.getSecurityInfReceive();
		int count = securityInfReceiveMapper.hasReceiveOrNot(param);
		if (count < 1) {
			SecurityInfReceive receiveInf = securityInfReceiveMapper.getReceiveInf(param);
			receiveInf.setIsReceive(Constants.RECEIVE_HAS_AND_DES);
			receiveInf.setDescription(param.getDescription());
			securityInfReceiveMapper.updateByPrimaryKeySelective(receiveInf);
			// 通知需要上传的图片资源
			List<SecuritySource> securityInfSource = dto.getSecurityInfSource();
			for (SecuritySource source : securityInfSource) {
				source.setSourceId(receiveInf.getId());
				source.setAttachmentSource(Constants.ATTACHSOURCE_SAFE_INF);
				source.setIsdeleted(Constants.String_DEL_FLG);
				source.setCreateTime(new Date());
				securitySourceMapper.insert(source);
			}
		} else {
			res.setMessage("此人已反馈");
		}
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Object readSafeNotice(SecurityInfReceive param) {
		ResultObject res = new ResultObject();
		int count = securityInfReceiveMapper.hasReadOrNot(param);
		if (count < 1) {
			SecurityInfReceive receiveInf = securityInfReceiveMapper.getReceiveInf(param);
			receiveInf.setIsReceive(Constants.RECEIVE_HAS);
			receiveInf.setDescription(param.getDescription());
			securityInfReceiveMapper.updateByPrimaryKeySelective(receiveInf);
		} else {
			res.setMessage("此人已查阅");
		}
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public BaseResponse<SecurityInfReceiveDetailVo> getSafeNoticeDetail(SecurityInfReceive param) {
		BaseResponse<SecurityInfReceiveDetailVo> res = new BaseResponse<>();
		SecurityInfReceiveDetailVo detail = new SecurityInfReceiveDetailVo();
		detail.setSecurityInfReceiveVo(securityInfReceiveMapper.getSafeNoticeDetail(param));
		List<SecuritySource> sourceInfo = securitySourceMapper.getSourceInfo(Constants.ATTACHSOURCE_SAFE_INF,
				param.getId().toString());
		detail.setSecurityInfSource(sourceInfo);
		res.setResponseData(detail);
		return res;
	}

	@Override
	public BaseResponse<List<Userinformation>> getSafeUser(String type) {
		BaseResponse<List<Userinformation>> res = new BaseResponse<>();
		res.setResponseData(userinformationMapper.getSafeUser(type));
		return res;
	}

	@Override
	public BaseResponse<List<SecurityInfReceiveDetailVo>> getSafeNoticeDetailByNewId(Integer newsId) {
		BaseResponse<List<SecurityInfReceiveDetailVo>> res = new BaseResponse<>();
		List<SecurityInfReceiveDetailVo> vos = new ArrayList<>();
		List<SecurityInfReceive> infReceives = securityInfReceiveMapper.getReceiveByNewsId(newsId);
		for (SecurityInfReceive infReceive : infReceives) {
			SecurityInfReceiveDetailVo detail = new SecurityInfReceiveDetailVo();
			detail.setSecurityInfReceiveVo(securityInfReceiveMapper.getSafeNoticeDetail(infReceive));
			List<SecuritySource> sourceInfo = securitySourceMapper.getSourceInfo(Constants.ATTACHSOURCE_SAFE_INF,
					infReceive.getId().toString());
			detail.setSecurityInfSource(sourceInfo);
			vos.add(detail);
		}
		res.setResponseData(vos);
		return res;
	}

}

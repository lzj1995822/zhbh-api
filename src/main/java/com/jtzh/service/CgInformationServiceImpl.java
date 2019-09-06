package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import com.jtzh.entity.CgInformationTypeCount;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.CgInformation;
import com.jtzh.entity.CgSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CgInformationMapper;
import com.jtzh.mapper.CgSourceMapper;
import com.jtzh.pojo.CgInformationDetail;
import com.jtzh.pojo.CgInformationParam;
import com.jtzh.pojo.PageResult;

@Service("cgInformationService")
public class CgInformationServiceImpl implements CgInformationService{
	@Resource
	private CgInformationMapper cgInformationMapper;

	@Resource
	private CgSourceMapper cgSourceMapper;
	
	@Override
	public Object getCgInformationList(CgInformationParam param) {
		// 查询总数
		int total = cgInformationMapper.selectCgITotal(param);
		List<CgInformation> list = new ArrayList<CgInformation>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = cgInformationMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public CgInformationDetail getCgInformationInfo(String id) {
		// 根据id去查询信息和图片资源信息
		CgInformationDetail cgInformationDetail = new CgInformationDetail();
		CgInformation hidden = cgInformationMapper.getCgInformationInfo(id);
		cgInformationDetail.setCgInformation(hidden);
		// 01
		cgInformationDetail.setSource(cgSourceMapper.getSourceInfo("01", id));
		return cgInformationDetail;
	}
	
	@Override
	public Object addCgInformation(CgInformationDetail cgInformationDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		CgInformation cgInformation = cgInformationDetail.getCgInformation();
		// 01
		cgInformation.setAttachmentSource("01");
		cgInformation.setYhzh(Constants.YHZH_BAOHUA);
		cgInformation.setCreateId(user.getLoginId());
		cgInformation.setCreateTime(new Date());
		cgInformation.setDelflag("A");
		cgInformationMapper.insertCgInformation(cgInformation);
		List<CgSource> cgiList = cgInformationDetail.getSource();
		// 如果图片存在
		if (cgiList != null && cgiList.size() > 0) {
			for (CgSource source : cgiList) {
				source.setAttachmentSource("01");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setDelflag("A");
				source.setSourceId(cgInformation.getId());
				cgSourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object deleteCgInformation(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		cgInformationMapper.deleteCgInformation(id);
		List<CgSource> cgiList = cgSourceMapper.getSourceInfo(sourceType, id);
		if (cgiList != null && cgiList.size() > 0) {
			for (CgSource source : cgiList) {
				Integer a = source.getId();
				cgSourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}
	// 修改
	@Override
	public Object updateCgInformation(CgInformation param) {
		cgInformationMapper.updateCgInformation(param);
		return new ResultObject();
	}

	//获取城管信息发布每种类型的数量
	@Override
	public List <CgInformationTypeCount> getCgInformationTypeCount() {
		List <CgInformationTypeCount> list=cgInformationMapper.getCgInformationTypeCount();
		return list;
	}


}

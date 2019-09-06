package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.CountrysideChuli;
import com.jtzh.entity.CountrysideSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CountrysideChuliMapper;
import com.jtzh.mapper.CountrysideSourceMapper;
import com.jtzh.pojo.CountrysideChuliDetail;
import com.jtzh.pojo.CountrysideChuliParam;
import com.jtzh.pojo.PageResult;

@Service("countrysideChuliService")
public class CountrysideChuliServiceImpl implements CountrysideChuliService {
	@Resource
	private CountrysideChuliMapper chuliMapper;

	@Resource
	private CountrysideSourceMapper sourceMapper;
	
	@Override
	public Object getCountrysideChuliList(CountrysideChuliParam param) {
		// 查询总数
		int total = chuliMapper.selectChlTotal(param);
		List<CountrysideChuli> list = new ArrayList<CountrysideChuli>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = chuliMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public Object Problemyichuli(CountrysideChuliDetail chuliDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		CountrysideChuli chuli = chuliDetail.getCountrysideChuli();
		// 03
		chuli.setChulitime(new Date());
		chuli.setShenheState("0");
		chuli.setAttachmentSource("04");
		chuli.setCreateId(user.getLoginId());
		chuli.setCreateTime(new Date());
		chuli.setDelflag("A");
		chuliMapper.Problemyichuli(chuli);
		List<CountrysideSource> couList = chuliDetail.getSource();
		// 如果图片存在
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				source.setAttachmentSource("04");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setDelflag("A");
				source.setSourceId(chuli.getId());
				sourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	// 审核
	@Override
	public Object Problemshenhe(CountrysideChuli shenhe) {
		shenhe.setShenhetime(new Date());
		chuliMapper.Problemshenhe(shenhe);
		return new ResultObject();
	}
	
	// 删除
	@Override
	public Object deletechuli(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		chuliMapper.deletechuli(id);
		List<CountrysideSource> couList = sourceMapper.getSourceInfo(sourceType, id);
		if (couList != null && couList.size() > 0) {
			for (CountrysideSource source : couList) {
				Integer a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object getChuliList(CountrysideChuliParam param) {
		// 查询总数
		int total = chuliMapper.selectAllTotal(param);
		List<CountrysideChuli> list = new ArrayList<CountrysideChuli>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = chuliMapper.selectInfoAll(param);
		}
		res.setRows(list);
		return res;
	}
	
	// 查询回退描述
	@Override
	public CountrysideChuli getHuituiInfo(String id) {
		// 根据id去查询回退信息
		CountrysideChuli huitui = chuliMapper.getHuituiInfo(id);
		return huitui;
	}
	
	@Override
	public Object getAllSolve(String shangbaoid) {
		List<CountrysideChuliDetail> chuliDetail = new ArrayList<>();
		List<CountrysideChuli> res = chuliMapper.selectAllBySid(shangbaoid);
		for (CountrysideChuli countrysideChuli : res) {
			CountrysideChuliDetail detail = new CountrysideChuliDetail();
			List<CountrysideSource> source;
			source = sourceMapper.selectSource("04", countrysideChuli.getId());
			detail.setCountrysideChuli(countrysideChuli);
			detail.setSource(source);
			chuliDetail.add(detail);
		}
		return chuliDetail;
	}

}

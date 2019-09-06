package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.jtzh.entity.HwInformationTypeCount;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.HwInformation;
import com.jtzh.entity.HwSource;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.HwInformationMapper;
import com.jtzh.mapper.HwSourceMapper;
import com.jtzh.pojo.HwInformationDetail;
import com.jtzh.pojo.HwInformationParam;
import com.jtzh.pojo.PageResult;

@Service("hwInformationService")
public class HwInformationServiceImpl implements HwInformationService{
	@Resource
	private HwInformationMapper hwInformationMapper;

	@Resource
	private HwSourceMapper hwSourceMapper;
	
	@Override
	public Object getHwInformationList(HwInformationParam param) {
		// 查询总数
		int total = hwInformationMapper.selectHwITotal(param);
		List<HwInformation> list = new ArrayList<HwInformation>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = hwInformationMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
	
	@Override
	public HwInformationDetail getHwInformationInfo(String id) {
		// 根据id去查询信息和图片资源信息
		HwInformationDetail hwInformationDetail = new HwInformationDetail();
		HwInformation hidden = hwInformationMapper.getHwInformationInfo(id);
		hwInformationDetail.setHwInformation(hidden);
		// 01
		hwInformationDetail.setSource(hwSourceMapper.getSourceInfo("01", id));
		return hwInformationDetail;
	}
	
	@Override
	public Object addHwInformation(HwInformationDetail hwInformationDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		HwInformation hwInformation = hwInformationDetail.getHwInformation();
		// 01
		hwInformation.setAttachmentSource("01");
		hwInformation.setYhzh(Constants.YHZH_BAOHUA);
		hwInformation.setCreateId(user.getLoginId());
		hwInformation.setCreateTime(new Date());
		hwInformation.setDelflag("A");
		hwInformationMapper.insertHwInformation(hwInformation);
		List<HwSource> hwiList = hwInformationDetail.getSource();
		// 如果图片存在
		if (hwiList != null && hwiList.size() > 0) {
			for (HwSource source : hwiList) {
				source.setAttachmentSource("01");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setDelflag("A");
				source.setSourceId(hwInformation.getId());
				hwSourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object deleteHwInformation(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		hwInformationMapper.deleteHwInformation(id);
		List<HwSource> hwiList = hwSourceMapper.getSourceInfo(sourceType, id);
		if (hwiList != null && hwiList.size() > 0) {
			for (HwSource source : hwiList) {
				Integer a = source.getId();
				hwSourceMapper.deleteSource(a);
			}
		}

		return new ResultObject();
	}
	// 修改
	@Override
	public Object updateHwInformation(HwInformation param) {
		hwInformationMapper.updateHwInformation(param);
		return new ResultObject();
	}

	//获取环卫信息发布每种类型的数量
	@Override
	public List <HwInformationTypeCount> getHwInformationTypeCount() {
		List <HwInformationTypeCount> list=hwInformationMapper.getHwInformationTypeCount();
		return list;
	}
}

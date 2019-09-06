package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.SecuritySource;
import com.jtzh.entity.WorkshopAdm;
import com.jtzh.mapper.InspectionMapper;
import com.jtzh.mapper.SecuritySourceMapper;
import com.jtzh.pojo.CountDay;
import com.jtzh.pojo.CountHiddenAndInspection;
import com.jtzh.pojo.CountMonth;
import com.jtzh.pojo.CountQuarter;
import com.jtzh.pojo.InspectionDetail;
import com.jtzh.pojo.InspectionParam;
import com.jtzh.pojo.PageResult;

@Service("inspectionService")
public class InspectionServiceImpl implements InspectionService{
	@Resource
	private InspectionMapper inspectionMapper;

	@Resource
	private SecuritySourceMapper securitySourceMapper;
	
	@Override
	public Object getInspectionList(InspectionParam param) {
		List<InspectionRecord> list = new ArrayList<InspectionRecord>();
		PageResult res = new PageResult();
		int total = inspectionMapper.selectInsTotal(param);
		if (total > 0) {
			list = inspectionMapper.selectInfo(param);
		}
		res.setOk(true);
		res.setTotal(total);
		res.setRows(list);
		return res;
	}
	
	@Override
	public InspectionDetail getInspectionInfo(String id) {
		// 根据id去查询信息和图片资源信息
		InspectionDetail inspectionDetail = new InspectionDetail();
		InspectionRecord inspection = inspectionMapper.getInspectionInfo(id);
		inspectionDetail.setInspectionRecord(inspection);
		// 01
		inspectionDetail.setSource(securitySourceMapper.getSourceInfo("01", id));
		return inspectionDetail;
	}
	
	@Override
	public Object addInspection(InspectionDetail inspectionDetail, LoginUserTest user) {
		// 图片资源存到source表，关联字段为attachmentSource
		InspectionRecord inspection = inspectionDetail.getInspectionRecord();
		// 01
		inspection.setAttachmentSource("01");
		inspection.setYhzh(Constants.YHZH_BAOHUA);
		inspection.setCreateTime(new Date());
		inspection.setIsdeleted("0");
		inspection.setCreateId(user.getLoginId());
		inspectionMapper.insertInspection(inspection);
		List<SecuritySource> insList = inspectionDetail.getSource();
		// 如果图片存在
		if (insList != null && insList.size() > 0) {
			for (SecuritySource source : insList) {
				source.setAttachmentSource("01");
				source.setType("01");
				source.setCreateTime(new Date());
				source.setIsdeleted("0");
				source.setSourceId(inspection.getId());
				securitySourceMapper.insertSelective(source);
			}
		}
		return new ResultObject();
	}
	
	@Override
	public Object updateInspection(InspectionRecord param) {
		inspectionMapper.updateInspection(param);
		return new ResultObject();
	}
	
	@Override
	public Object deleteInspection(String id, String sourceType) {
		// 删除问题---a).删除表记录; b)删除对应的资源表记录.
		inspectionMapper.deleteInspection(id);
		List<SecuritySource> insList = securitySourceMapper.getSourceInfo(sourceType, id);
		if (insList != null && insList.size() > 0) {
			for (SecuritySource source : insList) {
				Integer a = source.getId();
				securitySourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object countInspectionState() {
		List<CountHiddenAndInspection> count = inspectionMapper.countInspectionState();
		ResultObject res = new ResultObject();
		res.setObj(count);
		return res;
	}

	@Override
	public Object countInspectionYear(String year) {
		List<CountQuarter> list = inspectionMapper.countInspectionByYear(year);
		ResultObject res = new ResultObject();
		res.setObj(list);
		return res;
	}

	@Override
	public Object countInspectionByMonth(String year) {
		List<CountMonth> list = inspectionMapper.countInspectionByMonth(year);
		ResultObject res = new ResultObject();
		res.setObj(list);
		return res;
	}

	@Override
	public Object countInspectionByDay(String year) {
		List<CountDay> list = inspectionMapper.countInspectionByDay(year);
		ResultObject res = new ResultObject();
		res.setObj(list);
		return res;
	}

	@Override
	public Object getInspectionGis() {
		List<InspectionRecord> list = inspectionMapper.selectInfoWeb();
		PageResult response = new PageResult();
		if (list != null && list.size() > 0) {
			response.setOk(true);
			response.setTotal(list.size());
			response.setRows(list);
		} else {
			response.setOk(false);
			response.setTotal(0);
		}
		return response;
	}
	
	

}

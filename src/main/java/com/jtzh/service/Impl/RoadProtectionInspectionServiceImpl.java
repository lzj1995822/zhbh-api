package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.detail.pojo.RoadProtectionInspectionDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionInspection;
import com.jtzh.entity.RoadProtectionSource;
import com.jtzh.mapper.RoadProtectionInspectionMapper;
import com.jtzh.mapper.RoadProtectionSourceMapper;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.RoadProtectionInspectionPagination;
import com.jtzh.service.RoadProtectionInspectionService;

@Service("roadProtectionInspectionService")
public class RoadProtectionInspectionServiceImpl implements RoadProtectionInspectionService {
	@Resource
	private RoadProtectionInspectionMapper roadProtectionInspectionMapper;
	@Resource
	private RoadProtectionSourceMapper sourceMapper;

	@Override
	public BaseResponse<List<RoadProtectionInspection>> getRoadProtectionInspectionList(RoadProtectionInspectionPagination param) {
		// 查询总数
		BaseResponse<List<RoadProtectionInspection>> res = new BaseResponse<>();
		int total = roadProtectionInspectionMapper.selectTotal(param);
		List<RoadProtectionInspection> list = new ArrayList<RoadProtectionInspection>();
		if (total > 0) {
			list = roadProtectionInspectionMapper.selectInfo(param);
			res.setTotal(total);
		} else {
			res.setTotal(0);
		}
		res.setResponseData(list);
		return res;
	}

	@Override
	public BaseResponse<RoadProtectionInspectionDetail> getRoadProtectionInspection(Long id) {
		BaseResponse<RoadProtectionInspectionDetail> res = new BaseResponse<RoadProtectionInspectionDetail>();
		// Constants.ATTACHSOURCE_INSPECTION即"03"代表路线图片资源在source表中对应的attachsource
		RoadProtectionInspectionDetail inspectionDetail = new RoadProtectionInspectionDetail();
		RoadProtectionInspection inspection = roadProtectionInspectionMapper.selectInspection(id);
		inspectionDetail.setRoadProtectionInspection(inspection);
		inspectionDetail.setSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_INSPECTION, id));
		res.setResponseData(inspectionDetail);
		return res;
	}

	@Override
	public BaseResponse<String> removeRoadProtectionInspection(Long id) {
		// 删除路线---a).删除路线表记录; b)删除路线对应的资源表记录.
		roadProtectionInspectionMapper.deleteInspection(id);
		List<RoadProtectionSource> workList = sourceMapper.selectSource(Constants.ATTACHSOURCE_INSPECTION, id);
		if (workList != null && workList.size() > 0) {
			for (RoadProtectionSource source : workList) {
				Long a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new BaseResponse<String>();
	}

	@Override
	public BaseResponse<String> addRoadProtectionInspection(RoadProtectionInspectionDetail detail, LoginUserTest user) {
		// 1.add巡检资源
		RoadProtectionInspection ins = detail.getRoadProtectionInspection();
		ins.setCreateTime(new Date());
		ins.setDelflag(Constants.String_DEL_FLG);
		ins.setAttachmentSource(Constants.ATTACHSOURCE_INSPECTION);
		ins.setYhzh(Constants.YHZH_BAOHUA);
		ins.setCreateId(user.getLoginId());
		roadProtectionInspectionMapper.insertInspection(ins);
		// 2.add图片资源
		List<RoadProtectionSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (RoadProtectionSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.String_DEL_FLG);
				source.setAttachmentSource(Constants.ATTACHSOURCE_INSPECTION);
				source.setSourceId(ins.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new BaseResponse<String>();
	}

	@Override
	public BaseResponse<String> modifyRoadProtectionInspection(RoadProtectionInspectionDetail detail) {
		RoadProtectionInspection ins = detail.getRoadProtectionInspection();
		roadProtectionInspectionMapper.updateByPrimaryKeySelective(ins);
		List<RoadProtectionSource> workList = sourceMapper.selectSource(Constants.ATTACHSOURCE_INSPECTION, ins.getId());
		if (workList != null && workList.size() > 0) {
			for (RoadProtectionSource source : workList) {
				Long a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		List<RoadProtectionSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (RoadProtectionSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.String_DEL_FLG);
				source.setAttachmentSource(Constants.ATTACHSOURCE_INSPECTION);
				source.setSourceId(ins.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new BaseResponse<String>();
	}

}

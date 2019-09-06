package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.detail.pojo.RoadDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionRoad;
import com.jtzh.entity.RoadProtectionSource;
import com.jtzh.mapper.RoadProtectionRoadMapper;
import com.jtzh.mapper.RoadProtectionSourceMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.RoadProtectionRoadPagination;
import com.jtzh.service.RoadProtectionRoadService;

@Service("roadProtectionRoadService")
public class RoadProtectionRoadServiceImpl implements RoadProtectionRoadService {
	@Resource
	private RoadProtectionRoadMapper roadMapper;
	@Resource
	private RoadProtectionSourceMapper sourceMapper;

	@Override
	public Object getRoadProtectionRoadList(RoadProtectionRoadPagination param) {
		// 查询总数
		int total = roadMapper.selectTotal(param);
		List<RoadProtectionRoad> list = new ArrayList<RoadProtectionRoad>();
		PageResult response = new PageResult();
		if (total > 0) {
			list = roadMapper.selectInfo(param);
			response.setTotal(total);
			
		} else {
			response.setTotal(0);
		}
		response.setOk(true);
		response.setRows(list);
		return response;
	}

	@Override
	public Object getRoadProtectionRoad(Long id) {
		// Constants.ATTACHSOURCE_ROAD即"01"代表路线图片资源在source表中对应的attachsource
		RoadDetail roadDetail = new RoadDetail();
		RoadProtectionRoad road = roadMapper.selectRoad(id);
		roadDetail.setRoad(road);
		roadDetail.setSource(sourceMapper.selectSource(Constants.ATTACHSOURCE_ROAD, id));
		ResultObject obj = new ResultObject();
		obj.setObj(roadDetail);
		return obj;
	}

	@Override
	public Object removeRoadProtectionRoad(Long id) {
		// 删除路线---a).删除路线表记录; b)删除路线对应的资源表记录.
		roadMapper.deleteRoad(id);
		List<RoadProtectionSource> workList = sourceMapper.selectSource(Constants.ATTACHSOURCE_ROAD, id);
		if (workList != null && workList.size() > 0) {
			for (RoadProtectionSource source : workList) {
				Long a = source.getId();
				sourceMapper.deleteSource(a);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object addRoadProtectionRoad(RoadDetail detail, LoginUserTest user) {
		// 1.add路线资源
		RoadProtectionRoad road = detail.getRoad();
		road.setCreateTime(new Date());
		road.setDelflag(Constants.String_DEL_FLG);
		road.setAttachmentSource(Constants.ATTACHSOURCE_ROAD);
		road.setYhzh(Constants.YHZH_BAOHUA);
		road.setCreateId(user.getLoginId());
		roadMapper.insertRoad(road);
		// 2.add图片资源
		List<RoadProtectionSource> list = detail.getSource();
		if (list != null && list.size() > 0) {
			for (RoadProtectionSource source : list) {
				source.setCreateTime(new Date());
				source.setDelflag(Constants.String_DEL_FLG);
				source.setAttachmentSource(Constants.ATTACHSOURCE_ROAD);
				source.setSourceId(road.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

	@Override
	public Object modifyRoadProtectionRoad(RoadDetail detail) {
		RoadProtectionRoad road = detail.getRoad();
		roadMapper.updateByPrimaryKeySelective(road);
		List<RoadProtectionSource> workList = sourceMapper.selectSource(Constants.ATTACHSOURCE_ROAD, road.getId());
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
				source.setAttachmentSource(Constants.ATTACHSOURCE_ROAD);
				source.setSourceId(road.getId());
				source.setYhzh(Constants.YHZH_BAOHUA);
				sourceMapper.insert(source);
			}
		}
		return new ResultObject();
	}

}

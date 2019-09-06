package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProtectionGroup;
import com.jtzh.mapper.RoadProtectionGroupMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.RoadProtectionGroupPagination;
import com.jtzh.responsevo.RoadProtectionGroupVo;
import com.jtzh.service.RoadProtectionGroupService;

@Service("roadProtectionGroupService")
public class RoadProtectionGroupServiceImpl implements RoadProtectionGroupService {
	@Resource
	private RoadProtectionGroupMapper groupMapper;

	@Override
	public Object getRoadProtectionGroupList(RoadProtectionGroupPagination param) {
		// 查询总数
		int total = groupMapper.selectTotal(param);
		List<RoadProtectionGroupVo> list = new ArrayList<RoadProtectionGroupVo>();
		PageResult response = new PageResult();
		if (total > 0) {
			list = groupMapper.selectInfo(param);	
			response.setTotal(total);	
		} else {
			response.setTotal(0);
		}
		response.setOk(true);
		response.setRows(list);
		return response;
	}

	@Override
	public Object getRoadProtectionGroup(Integer id) {
		RoadProtectionGroup group = groupMapper.selectGroup(id);
		ResultObject res = new ResultObject();
		res.setObj(group);
		return res;
	}

	@Override
	public Object removeRoadProtectionGroup(Integer id) {
		groupMapper.deleteGroup(id);
		return new ResultObject();
	}

	@Override
	public Object addRoadProtectionGroup(RoadProtectionGroup param, LoginUserTest user) {
		param.setCreateTime(new Date());
		param.setDelflag(Constants.String_DEL_FLG);
		param.setYhzh(Constants.YHZH_BAOHUA);
		param.setCreateId(user.getLoginId());
		groupMapper.insertSelective(param);
		return new ResultObject();
	}

	@Override
	public Object modifyRoadProtectionGroup(RoadProtectionGroup param) {
		groupMapper.updateByPrimaryKeySelective(param);
		return new ResultObject();
	}

}

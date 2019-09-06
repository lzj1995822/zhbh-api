package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProGroPeople;
import com.jtzh.mapper.RoadProGroPeopleMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.RoadProGroPeopleParam;

@Service("roadProGroPeopleService")
public class RoadProGroPeopleServiceImpl implements RoadProGroPeopleService {

	@Resource
	private RoadProGroPeopleMapper roadProGroPeopleMapper;
	
	// 查询
		@Override
		public Object getRoadProGroPeopleList(RoadProGroPeopleParam param) {
			// 查询总数
			int total = roadProGroPeopleMapper.selectRPGTotal(param);
			List<RoadProGroPeople> list = new ArrayList<RoadProGroPeople>();
			PageResult res = new PageResult();
			res.setOk(true);
			res.setTotal(total);
			// 如果存在，查询具体的数据作为分页数据
			if (total > 0) {
				list = roadProGroPeopleMapper.selectRPGInfo(param);
			}
			res.setRows(list);
			return res;
		}
				
		// 查询详情
		@Override
		public RoadProGroPeople getRoadProGroPeopleInfo(String id) {
			// 根据id去查询通知公告信息
			RoadProGroPeople cguser = roadProGroPeopleMapper.getRoadProGroPeopleInfo(id);
			return cguser;
		}
				
		// 新建
		@Override
		public Object addRoadProGroPeople(RoadProGroPeople roadProGroPeople, LoginUserTest user) {
			roadProGroPeople.setYhzh(Constants.YHZH_BAOHUA);
			roadProGroPeople.setCreateId(user.getLoginId());
			roadProGroPeople.setCreateTime(new Date());
			roadProGroPeople.setDelflag("A");
			roadProGroPeopleMapper.addRoadProGroPeople(roadProGroPeople);
			return new ResultObject();
		}
				
		// 删除
		@Override
		public Object deleteRoadProGroPeople(String id) {
			// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
			roadProGroPeopleMapper.deleteRoadProGroPeople(id);
			return new ResultObject();
		}
			
		// 修改
		@Override
		public Object updateRoadProGroPeople(RoadProGroPeople param) {
			roadProGroPeopleMapper.updateRoadProGroPeople(param);
			return new ResultObject();
		}

}

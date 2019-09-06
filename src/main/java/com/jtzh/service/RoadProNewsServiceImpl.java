package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoadProNews;
import com.jtzh.mapper.RoadProNewsMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.RoadProNewsParam;

@Service("roadProNewsService")
public class RoadProNewsServiceImpl implements RoadProNewsService {
	@Resource
	private RoadProNewsMapper roadProNewsMapper;
	
	// 查询
		@Override
		public Object getRoadProNewsList(RoadProNewsParam param) {
			// 查询总数
			int total = roadProNewsMapper.selectRPNTotal(param);
			List<RoadProNews> list = new ArrayList<RoadProNews>();
			PageResult res = new PageResult();
			res.setOk(true);
			res.setTotal(total);
			// 如果存在，查询具体的数据作为分页数据
			if (total > 0) {
				list = roadProNewsMapper.selectRPNInfo(param);
			}
			res.setRows(list);
			return res;
		}
			
		// 查询详情
		@Override
		public RoadProNews getRoadProNewsInfo(String id) {
			// 根据id去查询通知公告信息
			RoadProNews meeting = roadProNewsMapper.getRoadProNewsInfo(id);
			return meeting;
		}
			
		// 修改
		@Override
		public Object updateRoadProNews(RoadProNews param) {
			roadProNewsMapper.updateRoadProNews(param);
			return new ResultObject();
		}
			
		// 新建
		@Override
		public Object addRoadProNews(RoadProNews meeting, LoginUserTest user) {
			meeting.setYhzh(Constants.YHZH_BAOHUA);
			meeting.setCreateId(user.getLoginId());
			meeting.setCreateTime(new Date());
			meeting.setDelflag("A");
			roadProNewsMapper.addRoadProNews(meeting);
			return new ResultObject();
		}
			
		// 删除
		@Override
		public Object deleteRoadProNews(String id) {
			// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
			roadProNewsMapper.deleteRoadProNews(id);
			return new ResultObject();
		}

}

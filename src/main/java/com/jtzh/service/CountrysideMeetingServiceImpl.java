package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.CountrysideMeeting;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CountrysideMeetingMapper;
import com.jtzh.pojo.CountrysideMeetingParam;
import com.jtzh.pojo.PageResult;

@Service("meetingService")
public class CountrysideMeetingServiceImpl implements CountrysideMeetingService {
	@Resource
	private CountrysideMeetingMapper meetingMapper;
	
	// 查询
	@Override
	public Object getCountrysideMeetingList(CountrysideMeetingParam param) {
		// 查询总数
		int total = meetingMapper.selectCoMTotal(param);
		List<CountrysideMeeting> list = new ArrayList<CountrysideMeeting>();
		PageResult res = new PageResult();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = meetingMapper.selectInfo(param);
		}
		res.setRows(list);
		return res;
	}
		
	// 查询详情
	@Override
	public CountrysideMeeting getCountrysideMeetingInfo(String id) {
		// 根据id去查询通知公告信息
		CountrysideMeeting meeting = meetingMapper.getCountrysideMeetingInfo(id);
		return meeting;
	}
		
	// 修改
	@Override
	public Object updateCountrysideMeeting(CountrysideMeeting param) {
		meetingMapper.updateCountrysideMeeting(param);
		return new ResultObject();
	}
		
	// 新建
	@Override
	public Object addCountrysideMeeting(CountrysideMeeting meeting, LoginUserTest user) {
		meeting.setYhzh(Constants.YHZH_BAOHUA);
		meeting.setCreateId(user.getLoginId());
		meeting.setCreateTime(new Date());
		meeting.setDelflag("A");
		meetingMapper.addCountrysideMeeting(meeting);
		return new ResultObject();
	}
		
	// 删除
	@Override
	public Object deleteCountrysideMeeting(String id) {
		// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
		meetingMapper.deleteCountrysideMeeting(id);
		return new ResultObject();
	}

}

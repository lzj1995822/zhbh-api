package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.entity.RoadProtectionRoad;
import com.jtzh.entity.UserLoginLog;
import com.jtzh.mapper.RoadProtectionRoadMapper;
import com.jtzh.mapper.UserLoginLogMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.UserLoginLogPagination;
import com.jtzh.pojo.UserPassword;
import com.jtzh.service.UserLoginLogService;

@Service("userLoginLogService")
public class UserLoginLogServiceImpl implements UserLoginLogService{
	@Resource
	private UserLoginLogMapper userLoginLogMapper;
	
	@Override
	public Object addUserLoginLog(UserLoginLog userLoginLog) {
		return userLoginLogMapper.insertSelective(userLoginLog);
	}

	@Override
	public Object getUserLoginLogList(UserLoginLogPagination param) {
		// 查询总数
		int total = userLoginLogMapper.selectTotal(param);
		List<UserLoginLog> list = new ArrayList<UserLoginLog>();
		PageResult response = new PageResult();
		if (total > 0) {
			list = userLoginLogMapper.selectInfo(param);
			response.setOk(true);
			response.setTotal(total);
			response.setRows(list);
		} else {
			response.setOk(false);
			response.setTotal(0);
		}
		return response;
	}
	
}

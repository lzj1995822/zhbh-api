package com.jtzh.service;

import com.jtzh.entity.CountrysideMeeting;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideMeetingParam;

public interface CountrysideMeetingService {

public Object getCountrysideMeetingList(CountrysideMeetingParam param); // 查询
	
	public CountrysideMeeting getCountrysideMeetingInfo(String id); // 查看详情
	
	public Object addCountrysideMeeting(CountrysideMeeting meeting, LoginUserTest user); // 新建
	
	Object updateCountrysideMeeting(CountrysideMeeting param); // 修改
	
	public Object deleteCountrysideMeeting(String id); // 删除
}

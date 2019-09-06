package com.jtzh.service;

import com.jtzh.entity.CountrysideChuli;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideChuliDetail;
import com.jtzh.pojo.CountrysideChuliParam;

public interface CountrysideChuliService {
	
	public Object getCountrysideChuliList(CountrysideChuliParam param); // 查询
	
	public Object Problemyichuli(CountrysideChuliDetail chuliDetail, LoginUserTest user); // 处理
	
	Object Problemshenhe(CountrysideChuli shenhe); // 审核
	
	public Object deletechuli(String id, String sourceType); // 删除
	
	public Object getChuliList(CountrysideChuliParam param); // 查询
	
	public CountrysideChuli getHuituiInfo(String id); // 查看详情
	
	public Object getAllSolve(String shangbaoid);

}

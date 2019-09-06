package com.jtzh.service;

import java.util.List;

import com.jtzh.entity.CountrysideProblem;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountIsdeleted;
import com.jtzh.pojo.CountrysideProblemDetail;
import com.jtzh.pojo.CountrysideProblemParam;

public interface CountrysideProblemService {
	
	public Object getCountrysideProblemList(CountrysideProblemParam param); // 查询

	public CountrysideProblemDetail getCountrysideProblemInfo(String id); // 查看详情
	
	public Object deleteCountrysideProblem(String id, String sourceType); // 删除
	
	Object updateCountrysideProblem(CountrysideProblem param); // 修改
	
	public Object addCountrysideProblem(CountrysideProblemDetail problemDetail, LoginUserTest user); // 新建
	
	Object Problemlian(CountrysideProblem param); // 立案
	
	Object Problempaifa(CountrysideProblem param); // 派发
	
	public Object findbystate(CountrysideProblemParam param);
	
	public Object findbyId(String id);
	
	public Object getshangbaorenProblemList(CountrysideProblemParam param); // 查询
	
	public Object getpaifarenProblemList(CountrysideProblemParam param); // 查询
	
	public Object getPeopleProblemList(CountrysideProblemParam param); // 查询
	
	Object updateIsdeleted(CountrysideProblem param); // 修改状态
	
	public CountrysideProblem getxyInfo(String id); // 根据id查询坐标
	
	public Object getxyList(CountrysideProblemParam param); // 查询xy
	
	public Object getAllxyList(CountrysideProblemParam param); // 查询xy
	
	public Long getCountListfeiqi();
	
	public Long getCountListdaipaifa();
	
	public Long getCountListchulizhong();
	
	public Long getCountListdaishenhe();
	
	public Long getCountListyijiean();
	
	public Object getCountListjidu(String year);
	
	public List <CountIsdeleted> getAllCountList(CountrysideProblem param);
	
	public Long getCountList(CountrysideProblem param); // 统计

}

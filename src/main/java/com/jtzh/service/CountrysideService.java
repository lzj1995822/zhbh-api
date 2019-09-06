package com.jtzh.service;

import java.util.List;

import com.jtzh.entity.CountrysideBuild;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideBuildCount;
import com.jtzh.pojo.CountrysideDetail;
import com.jtzh.pojo.CountrysideParam;

public interface CountrysideService {
	
	public Object getCountrysideList(CountrysideParam param); // 查询

	public CountrysideDetail getCountrysideInfo(String id); // 查看详情

	public Object addCountryside(CountrysideDetail countrysideDetail, LoginUserTest user); // 新建
	
	public Object deleteCountryside(String id, String sourceType); // 删除
	
	Object updateCountryside(CountrysideBuild param); // 修改
	
	Object testCountryside(CountrysideBuild param); // 申请审核
	
	public Object getAllxyList(CountrysideParam param); // 查询xy
	
	Object commitCountryside(CountrysideBuild param); // 提交验收
	
	Object shenheCountryside(CountrysideBuild param); // 验收审核
	
	public Object getCountrysideYanshouList(CountrysideParam param); // 查询
	
	public Long getCountList1(CountrysideBuild param); // 统计1
	
	public Long getCountList2(CountrysideBuild param); // 统计2
	
	public Long getCountList3(CountrysideBuild param); // 统计3
	
	public List<CountrysideBuildCount> getapplyList(CountrysideBuild param);
	
	public List<CountrysideBuildCount> getexamineList(CountrysideBuild param);

}

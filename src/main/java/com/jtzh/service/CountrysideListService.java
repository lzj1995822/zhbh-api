package com.jtzh.service;

import com.jtzh.entity.CountrysideList;
import com.jtzh.pojo.CountrysideListParam;

public interface CountrysideListService {
	
	public Object getCountrysideList(CountrysideListParam param); // 查询
	
	public CountrysideList getCountrysideListInfo(String id); // 查看详情
	
	public Object addCountrysideList(CountrysideList list); // 新建
	
	Object updateCountrysideList(CountrysideList param); // 修改
	
	public Object deleteCountrysideList(String id); // 删除

}

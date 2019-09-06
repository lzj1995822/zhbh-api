package com.jtzh.service;

import com.jtzh.entity.CountrysideNews;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CountrysideNewsDetail;
import com.jtzh.pojo.CountrysideParam;

public interface CountrysideNewsService {
	
	public Object getCountrysideNewsList(CountrysideParam param); // 查询

	public CountrysideNewsDetail getCountrysideNewsInfo(String id); // 查看详情

	public Object addCountrysideNews(CountrysideNewsDetail countrysideNewsDetail, LoginUserTest user); // 新建
	
	public Object deleteCountrysideNews(String id, String sourceType); // 删除
	
	Object updateCountrysideNews(CountrysideNews param); // 修改
	
	public Object getAllNewsList();

}

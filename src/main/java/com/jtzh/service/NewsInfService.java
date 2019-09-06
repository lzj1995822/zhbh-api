package com.jtzh.service;

import java.util.List;

import com.jtzh.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NewsDepReq;
import com.jtzh.pojo.NewsInfDto;
import com.jtzh.pojo.NewsInfPagination;

public interface NewsInfService {
	public BaseResponse<List<NewsInf>> getNewsInfList(NewsInfPagination param);

	public BaseResponse<NewsInf> getNewsInf(NewsDepReq param);

	public BaseResponse<String> removeNewsInf(Integer id);

	public BaseResponse<String> addNewsInf(NewsInfDto param);

	public BaseResponse<String> modifyNewsInf(NewsInfDto param);
	
	public BaseResponse<String> updateReadNum(Integer id);
	
	public int getTotal();
	
	public Object receiveNews(NewsUserReceive param);
	
	public Object getReceiveNameAndDep(NewsDepReq id);

	public BaseResponse<String> updateState(NewsInf param);

	public BaseResponse<String> insertBrowsingHistory(NewsBrowsingHistory param);

	public BaseResponse<List<NewsBrowsingHistory>> getBrowsingHistory(BrowsingPage param);

	public  BaseResponse<List<NewsBrowsingHistory>> getBrowsingList(BrowsingPage param);

}
	

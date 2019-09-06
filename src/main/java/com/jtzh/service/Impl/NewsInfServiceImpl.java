package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.jtzh.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.CommonUtil;
import com.jtzh.mapper.NewsDepMapper;
import com.jtzh.mapper.NewsInfMapper;
import com.jtzh.mapper.NewsUserReceiveMapper;
import com.jtzh.mapper.UserinformationMapper;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.NewsDepReq;
import com.jtzh.pojo.NewsInf2Pagination;
import com.jtzh.pojo.NewsInfDto;
import com.jtzh.pojo.NewsInfPagination;
import com.jtzh.pojo.ReceivePerson;
import com.jtzh.service.NewsInfService;

@Service("newsInfService")
public class NewsInfServiceImpl implements NewsInfService {
	@Resource
	private NewsInfMapper newsInfMapper;
	@Resource
	private NewsDepMapper newsDepMapper;
	@Resource
	private UserinformationMapper userinformationMapper;
	@Resource
	private NewsUserReceiveMapper newsUserReceiveMapper;

	@Override
	public BaseResponse<List<NewsInf>> getNewsInfList(NewsInfPagination param) {
		BaseResponse<List<NewsInf>> res = new BaseResponse<>();
		List<NewsInf> list = new ArrayList<NewsInf>();
		res.setOk(true);

		// 1.如果depName是 超级管理员 或者 宝华镇 拉所有
		if (CommonUtil.verifyString(param.getDepName())) {
			if (param.getDepName().equals(Constants.DEPNAME_ADMIN) || param.getDepName().equals(Constants.DEPNAME_BAOHUA)) {
				// 查询总数
				int total = newsInfMapper.selectTotal(param);
				res.setTotal(total);
				// 如果存在，查询具体的数据作为分页数据
				if (total > 0) {
					list = newsInfMapper.selectInfo(param);
				}
			}
			// 2.不是的话根据depName去拉取对应的 newsId数组 然后拉出对应的通知公告数组。
			else {
				int newsIds[] = newsDepMapper.getNewsIds(param.getDepName());
				if (newsIds.length > 0) {
					NewsInf2Pagination page = new NewsInf2Pagination();
					BeanUtils.copyProperties(param, page);
					page.setNewsIds(newsIds);
					int total = newsInfMapper.selectTotal2(page);
					res.setTotal(total);
					// 如果存在，查询具体的数据作为分页数据
					if (total > 0) {
						list = newsInfMapper.selectInfo2(page);
					}
				} else {
					res.setResponseData(list);
					return res;
				}
			}
		} else {
		}
		res.setResponseData(list);
		return res;
	}

	@Override
	public BaseResponse<NewsInf> getNewsInf(NewsDepReq param) {
		BaseResponse<NewsInf> res = new BaseResponse<>();
		NewsInf user = new NewsInf();
		if (CommonUtil.verifyString(param.getDepName())) {
			user = newsInfMapper.selectNewsOnlyDep(param);
		}
		else{
			user = newsInfMapper.selectNews(param.getNewsId());
		}
		res.setResponseData(user);
		return res;
	}

	@Override
	public BaseResponse<String> removeNewsInf(Integer id) {
		newsInfMapper.deleteNews(id);
		return new BaseResponse();
	}

	@Override
	public BaseResponse<String> addNewsInf(NewsInfDto param) {
		NewsInf newsInf = param.getNewsInf();
		String depNames[] = param.getDepNames();
		int needReceiveNum = 0;
		newsInf.setCreateTime(new Date());
		newsInf.setDelflag(Constants.String_DEL_FLG);
		newsInf.setYhzh(Constants.YHZH_BAOHUA);
		newsInf.setReadNum(Constants.DEFAULT_READ_NUM);
		newsInf.setDepNum(depNames.length);
		newsInf.setHasReceiveNum(Constants.DEFAULT_READ_NUM);
		for (String depName : depNames) {
			needReceiveNum += userinformationMapper.countPersonNumByDep(depName);
		}
		newsInf.setNeedReceiveNum(needReceiveNum);
		newsInfMapper.insertNewsInf(newsInf);
		for (String depName : depNames) {
			NewsDep newsDep = new NewsDep();
			newsDep.setDepName(depName);
			newsDep.setCreateTime(new Date());
			newsDep.setDelflag(Constants.String_DEL_FLG);
			newsDep.setYhzh(Constants.YHZH_BAOHUA);
			newsDep.setNewsId(newsInf.getId());
			newsDep.setDepNeedReceiveNum(userinformationMapper.countPersonNumByDep(depName));
			newsDep.setDepHasReceiveNum(Constants.DEFAULT_READ_NUM);
			newsDepMapper.insertSelective(newsDep);
		}
		return new BaseResponse();
	}

	@Override
	public BaseResponse<String> modifyNewsInf(NewsInfDto param) {
		NewsInf newsInf = param.getNewsInf();
		newsInfMapper.updateByPrimaryKeySelective(newsInf);
		return new BaseResponse();
	}

	@Override
	public BaseResponse<String> updateReadNum(Integer id) {
		newsInfMapper.updateReadNum(id);
		return new BaseResponse();
	}

	@Override
	public int getTotal() {
		return newsInfMapper.selectTotal3();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Object receiveNews(NewsUserReceive param) {
		ResultObject res = new ResultObject();
		param.setIsReceive(Constants.RECEIVE_HAS);
		param.setDelflag(Constants.String_DEL_FLG);
		param.setCreateTime(new Date());
		param.setYhzh(Constants.YHZH_BAOHUA);
		int count = newsUserReceiveMapper.hasReceiveOrNot(param);
		if (count < 1) {
			// 更新主表所有阅读次数
			newsUserReceiveMapper.insert(param);
			newsInfMapper.updateHasReceiveNum(param.getNewsId());
			Userinformation receiver = userinformationMapper.selectByPrimaryKey(param.getUserId());
			// 更新部门表阅读次数
			NewsDep newsDep = new NewsDep();
			newsDep.setNewsId(param.getNewsId());
			newsDep.setDepName(receiver.getUisubordinatedepartment());
			newsDepMapper.updateDepHasReceiveNum(newsDepMapper.selectIdByNewsDep(newsDep));
		} else {
			res.setMessage("此人已查阅接受完毕");
		}

		return res;
	}

	@Override
	public Object getReceiveNameAndDep(NewsDepReq param) {
		List<ReceivePerson> receiveNameAndDep = newsUserReceiveMapper.getReceiveNameAndDep(param);
		ResultObject res = new ResultObject();
		res.setObj(receiveNameAndDep);
		return res;
	}

	@Override
	public BaseResponse<String> updateState(NewsInf param){
		newsInfMapper.updateState(param);
		return new BaseResponse();
	}

	@Override
	public BaseResponse<String> insertBrowsingHistory(NewsBrowsingHistory param){
		newsInfMapper.insertBrowsingHistory(param);
		return new BaseResponse();
	}

	@Override
	public BaseResponse<List<NewsBrowsingHistory>> getBrowsingHistory(BrowsingPage param){
		BaseResponse<List<NewsBrowsingHistory>> res = new BaseResponse<>();
		List<NewsBrowsingHistory> list = new ArrayList<NewsBrowsingHistory>();
		res.setOk(true);

		int total = newsInfMapper.getBrowsingHistoryTotal(param);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = newsInfMapper.getBrowsingHistory(param);
		}
		res.setResponseData(list);
		return res;
	}

	@Override
	public BaseResponse<List<NewsBrowsingHistory>> getBrowsingList(BrowsingPage param){
		BaseResponse<List<NewsBrowsingHistory>> res = new BaseResponse<>();
		List<NewsBrowsingHistory> list = new ArrayList<NewsBrowsingHistory>();
		res.setOk(true);
		int total = newsInfMapper.getBrowsingListTotal(param);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = newsInfMapper.getBrowsingList(param);
		}
		res.setResponseData(list);
		return res;
	}



}

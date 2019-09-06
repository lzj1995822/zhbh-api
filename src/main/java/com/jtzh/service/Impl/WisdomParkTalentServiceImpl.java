package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkTalent;
import com.jtzh.mapper.WisdomParkTalentMapper;
import com.jtzh.pojo.CountWisdomTalent;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.WisdomParkTalentPagination;
import com.jtzh.service.WisdomParkTalentService;

@Service("wisdomParkTalentService")
public class WisdomParkTalentServiceImpl implements WisdomParkTalentService {
	@Resource
	private WisdomParkTalentMapper talentMapper;

	@Override
	public Object getWisdomParkTalentList(WisdomParkTalentPagination param) {
		List<WisdomParkTalent> list = new ArrayList<WisdomParkTalent>();			
		PageResult res = new PageResult();
		int count = talentMapper.selectTotal(param);
		res.setTotal(count);
		if (count > 0) {
			list = talentMapper.selectInfo(param);	
		}
		res.setOk(true);
		res.setRows(list);
		return res;
	}

	@Override
	public Object getWisdomParkTalent(String id) {
		WisdomParkTalent wisdomParkTalent = talentMapper.selectWisdomParkTalent(id);
		ResultObject obj = new ResultObject();
		obj.setObj(wisdomParkTalent);
		return obj;
	}

	@Override
	public Object removeWisdomParkTalent(String id) {
		talentMapper.deleteWisdomParkTalent(id);
		return new ResultObject();
	}

	@Override
	public Object insertWisdomParkTalent(WisdomParkTalent param, LoginUserTest user) {
		param.setIsDeleted(Constants.String_DEL_FLG);
		param.setCreateTime(new Date());
		param.setCreateId(user.getLoginId());
		talentMapper.insertSelective(param);
		return new ResultObject();
	}

	@Override
	public Object updateWisdomParkTalent(WisdomParkTalent param) {
		//param.setDelflag(Constants.DELFLAG_FALSE);
		talentMapper.updateByPrimaryKeySelective(param);
		return new ResultObject();
	}

	@Override
	public Object getWisdomParkTalentGis() {
		List<WisdomParkTalent> list = talentMapper.selectInfoWeb();
		PageResult response = new PageResult();
		if (list != null && list.size() > 0) {
			response.setOk(true);
			response.setTotal(list.size());
			response.setRows(list);
		} else {
			response.setOk(false);
			response.setTotal(0);
		}
		return response;
	}

	@Override
	public Object countWTHighestMajor() {
		ResultObject res = new ResultObject();
		res.setObj(talentMapper.countWTHighestMajor());
		return res;
	}

	@Override
	public Object countWTDecade() {
		ResultObject res = new ResultObject();
		List<CountWisdomTalent> decade = talentMapper.countWTDecade();
		Map<String,Integer> targetDecade = new HashMap<>();
		Map <Integer,String> yearMap = new HashMap<>();
		Integer startYear = Constants.DEFAULT_YEAR;
		for(int i =0;i <10;i++){
			int count = 0;
			yearMap.put(i, startYear.toString());
			for(CountWisdomTalent param: decade){
				if(param.getType().equals(yearMap.get(i)))
				count += param.getCount();
			}
			targetDecade.put(startYear.toString(), count);
			startYear ++;
		}
		res.setObj(targetDecade);
		//res.setObj(talentMapper.countWTDecade());
		return res;
	}
		
}

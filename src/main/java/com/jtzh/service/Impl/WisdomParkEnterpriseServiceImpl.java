package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.detail.pojo.KeyproBuildDetail;
import com.jtzh.entity.KeyproInformation;
import com.jtzh.entity.KeyproPro;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkEnterprise;
import com.jtzh.entity.WisdomParkTalent;
import com.jtzh.mapper.KeyproInformationMapper;
import com.jtzh.mapper.KeyproProMapper;
import com.jtzh.mapper.KeyproSourceMapper;
import com.jtzh.mapper.WisdomParkEnterpriseMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.WisdomParkEnterprisePagination;
import com.jtzh.service.WisdomParkEnterpriseService;

@Service("wisdomParkEnterpriseService")
public class WisdomParkEnterpriseServiceImpl implements WisdomParkEnterpriseService {
	@Resource
	private WisdomParkEnterpriseMapper enterpriseMapper;

	@Override
	public Object getWisdomParkEnterpriseList(WisdomParkEnterprisePagination param) {
		List<WisdomParkEnterprise> list = new ArrayList<WisdomParkEnterprise>();
		PageResult res = new PageResult();
		int total = enterpriseMapper.selectTotal(param);
		if (total > 0) {
			list = enterpriseMapper.selectInfo(param);
		}
		res.setTotal(total);
		res.setOk(true);
		res.setRows(list);
		return res;
	}

	@Override
	public Object getWisdomParkEnterpriseInfo(String id) {
		WisdomParkEnterprise wisdomParkEnterprise = enterpriseMapper.selectWisdomParkEnterprise(id);
		ResultObject obj = new ResultObject();
		obj.setObj(wisdomParkEnterprise);
		return obj;
	}

	@Override
	public Object removeWisdomParkEnterprise(String id) {
		enterpriseMapper.deleteWisdomParkEnterprise(id);
		return new ResultObject();
	}

	@Override
	public Object addWisdomParkEnterprise(WisdomParkEnterprise param, LoginUserTest user) {
		param.setIsDeleted(Constants.String_DEL_FLG);
		param.setCreateTime(new Date());
		param.setCreateId(user.getLoginId());
		enterpriseMapper.insertSelective(param);
		return new ResultObject();
	}

	@Override
	public Object modifyWisdomParkEnterprise(WisdomParkEnterprise param) {
		//param.setIsDeleted(Constants.String_DEL_FLG);
		enterpriseMapper.updateByPrimaryKeySelective(param);
		return new ResultObject();
	}

	@Override
	public Object getWisdomParkEnterpriseGis() {
		List<WisdomParkEnterprise> list = enterpriseMapper.selectInfoWeb();
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
	public Object countWEIndustryBelong() {
		ResultObject res = new ResultObject();
		res.setObj(enterpriseMapper.countWEIndustryBelong());
		return res;
	}

	@Override
	public Object countWEParkBelong() {
		ResultObject res = new ResultObject();
		res.setObj(enterpriseMapper.countWEParkBelong());
		return res;
	}

}

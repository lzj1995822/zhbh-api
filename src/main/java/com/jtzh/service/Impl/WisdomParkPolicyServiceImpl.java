package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.CommonUtil;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.WisdomParkPolicy;
import com.jtzh.mapper.WisdomParkPolicyMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.WisdomParkPolicyPagination;
import com.jtzh.service.WisdomParkPolicyService;

@Service("wisdomParkPolicyService")
public class WisdomParkPolicyServiceImpl implements WisdomParkPolicyService {
	@Resource
	private WisdomParkPolicyMapper policyMapper;
	
	@Override
	public Object getWisdomParkPolicyList(WisdomParkPolicyPagination param) {
		List<WisdomParkPolicy> list = new ArrayList<WisdomParkPolicy>();
		PageResult res = new PageResult();
		int count = policyMapper.selectTotal(param);
		if (count > 0) {
			list = policyMapper.selectInfo(param);
		}
		res.setOk(true);
		res.setRows(list);
		res.setTotal(count);
		return res;
	}

	@Override
	public Object getWisdomParkPolicy(String id) {
		WisdomParkPolicy wisdomParkPolicy = policyMapper.selectWisdomParkPolicy(id);
		ResultObject obj = new ResultObject();
		obj.setObj(wisdomParkPolicy);
		return obj;
	}

	@Override
	public Object removeWisdomParkPolicy(String id) {
		policyMapper.deleteWisdomParkPolicy(id);
		return new ResultObject();
	}

	@Override
	public Object insertWisdomParkPolicy(WisdomParkPolicy param, LoginUserTest user) {
		if(!CommonUtil.verifyString(param.getPolicyReleaseTime().toString())){
			param.setPolicyReleaseTime(new Date());
		}
		param.setIsDeleted(Constants.String_DEL_FLG);
		param.setCreateTime(new Date());
		param.setCreateId(user.getLoginId());
		policyMapper.insertSelective(param);
		return new ResultObject();
	}

	@Override
	public Object updateWisdomParkPolicy(WisdomParkPolicy param) {
		//param.setIsDeleted(Constants.String_DEL_FLG);
		policyMapper.updateByPrimaryKeySelective(param);
		return new ResultObject();
	}

}

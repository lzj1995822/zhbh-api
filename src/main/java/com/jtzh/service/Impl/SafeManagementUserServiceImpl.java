package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.SafeManagementUser;
import com.jtzh.mapper.SafeManagementUserMapper;
import com.jtzh.pojo.BaseResponse;
import com.jtzh.pojo.SafeUserPagination;
import com.jtzh.service.SafeManagementUserService;

@Service("safeManagementUserService")
public class SafeManagementUserServiceImpl implements SafeManagementUserService {
	@Resource
	private SafeManagementUserMapper smuserMapper;

	@Override
	public BaseResponse<List<SafeManagementUser>> getSafeManagementUserList(SafeUserPagination param) {
		// 查询总数
		BaseResponse<List<SafeManagementUser>> res = new BaseResponse<>();
		int total = smuserMapper.selectTotal(param);
		List<SafeManagementUser> list = new ArrayList<SafeManagementUser>();
		res.setOk(true);
		res.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = smuserMapper.selectInfo(param);
		}
		// res.setRows(list);
		res.setResponseData(list);
		return res;
	}

	@Override
	public BaseResponse<SafeManagementUser> getSafeManagementUser(Integer id) {
		BaseResponse<SafeManagementUser> res = new BaseResponse<>();
		SafeManagementUser user = smuserMapper.selectUser(id);
		res.setResponseData(user);
		return res;
	}

	@Override
	public BaseResponse<String> removeSafeManagementUser(Integer id) {
		smuserMapper.deleteUser(id);
		return new BaseResponse();
	}

	@Override
	public BaseResponse<String> addSafeManagementUser(SafeManagementUser param, LoginUserTest user) {
		param.setCreateTime(new Date());
		param.setDelflag(Constants.String_DEL_FLG);
		param.setYhzh(Constants.YHZH_BAOHUA);
		param.setCreateId(user.getLoginId());
		smuserMapper.insertSelective(param);
		return new BaseResponse();
	}

	@Override
	public BaseResponse<String> modifySafeManagementUser(SafeManagementUser param) {
		smuserMapper.updateByPrimaryKeySelective(param);
		return new BaseResponse();
	}

}

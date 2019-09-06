package com.jtzh.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jtzh.entity.Userinfo;
import com.jtzh.util.JWTUtils;
import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.common.util.CommonUtil;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.Userinformation;
import com.jtzh.mapper.UserinformationMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.UserInfomationPagination;
import com.jtzh.pojo.UserPassword;
import com.jtzh.service.UserinfomationService;
@Service("userinfoServiceImpl")
public class UserinfoServiceImpl implements UserinfomationService{


	@Resource
	private UserinformationMapper userinformationMapper;
	/**
	 * 获取用户详情信息
	 * 通过id获取
	 */
	@Override
	public Object getUserinfo(Integer id) {
		Userinformation detail = userinformationMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}
	/**
	 * 删除用户
	 */
	@Override
	public Object removeUserinfo(Integer id) {
		userinformationMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}
	/**
	 * 添加用户
	 */
	@Override
	public Object addUserinfo(Userinformation detail) {
		detail.setCreateon(new Date());
		detail.setUibackwardness("正常");
		userinformationMapper.insertSelective(detail);
		return new ResultObject();
	}
	/**
	 *修改用户信息
	 */
	@Override
	public Object modifyUserinfo(Userinformation detail) {
		detail.setUpdateon(new Date());
		userinformationMapper.updateStrict(detail);
		return new ResultObject();
	}
	/**
	 * 获得分页用户详情
	 */
	@Override
	public Object getUserinfoList(UserInfomationPagination param) {
		//查询总数
		int total = userinformationMapper.selectUserinfoTotal(param);
		List<Userinformation> list = new ArrayList<Userinformation>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = userinformationMapper.selectUserinfo(param);
		}	
		response.setRows(list);
		return response;	
	}

	@Override
	public Object getLoginInfo(Userinformation user) {
		return  userinformationMapper.getLoginInfo(user);
	}

	@Override
	public Object modifyUserPwd(UserPassword param) {
		ResultObject res = new ResultObject();
		Userinformation user = new Userinformation();
		if (CommonUtil.verifyString(param.getUserName()) && CommonUtil.verifyString(param.getOldPassword())
				&& CommonUtil.verifyString(param.getNewPassword())) {
			Userinformation oldUser = new Userinformation();
			oldUser.setUiloginname(param.getUserName());
			oldUser.setUicode(param.getOldPassword());
			Userinformation u = userinformationMapper.getLoginInfo(oldUser);
			if (u != null) {
				user.setUiloginname(param.getUserName());
				user.setUicode(param.getNewPassword());
				user.setId(u.getId());
			}
			else{
				res.setResult(false);
				res.setMessage("旧密码不正确");
				return res;
			}

		}
		else if(CommonUtil.verifyString(param.getUserName()) && !CommonUtil.verifyString(param.getOldPassword())
				&& !CommonUtil.verifyString(param.getNewPassword())){
			user.setUiloginname(param.getUserName());
			Userinformation u = userinformationMapper.getIdByName(user);
			user.setUicode(Constants.DEFAULT_USER_PASSWORD);
			user.setId(u.getId());
		}else{
			res.setResult(false);
			return res;
		}
		return userinformationMapper.updateByPrimaryKeySelective(user);
	}

}

package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.RoleUser;
import com.jtzh.mapper.RoleUserMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.RoleUserPagination;
import com.jtzh.service.RoleUserService;
@Service("roleUserServiceImpl")
public class RoleUserServiceImpl implements RoleUserService{
	@Resource
	private RoleUserMapper roleUserMapper;
	@Override
	public Object getRoleUser(Integer id) {
		RoleUser detail = roleUserMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}

	@Override
	public Object removeRoleUser(Integer id) {
		roleUserMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}

	@Override
	public Object addRoleUser(RoleUser detail) {
		RoleUser r = roleUserMapper.selectByUserId(String.valueOf(detail.getPcuser()));
		if(r != null){
			detail.setId(r.getId());
			roleUserMapper.updateByPrimaryKeySelective(detail);
			return new ResultObject();
		}
		roleUserMapper.insertSelective(detail);
		return new ResultObject();
	}

	@Override
	public Object modifyRoleUser(RoleUser detail) {
		roleUserMapper.updateByPrimaryKeySelective(detail);
		return new ResultObject();
	}

	@Override
	public Object getRoleUserList(RoleUserPagination param) {
		//查询总数
		int total = roleUserMapper.selectRoleUserTotal(param);
		List<RoleUser> list = new ArrayList<RoleUser>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			
			list = roleUserMapper.selectRoleUserList(param);
		}	
		response.setRows(list);
		return response;	
	}

	@Override
	public Object selectRoleNameByUserId(Integer id) {
		ResultObject res = new ResultObject();
		res.setObj(roleUserMapper.selectRoleNameByUserId(id));
		return res;
	}

}

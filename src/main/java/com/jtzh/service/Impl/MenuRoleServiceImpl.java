package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.MenuRole;
import com.jtzh.entity.Userinformation;
import com.jtzh.mapper.MenuRoleMapper;
import com.jtzh.pojo.MenuRolePagination;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.MenuRoleService;
@Service("menuRoleServiceImpl")
public class MenuRoleServiceImpl implements MenuRoleService{
	@Resource
	private MenuRoleMapper menuRoleMapper;
	@Override
	public Object getMenuRole(Integer id) {
		MenuRole detail = menuRoleMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
		
	}

	@Override
	public Object removeMenuRole(Integer id) {
		menuRoleMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}

	@Override
	public Object addMenuRole(MenuRole detail) {
		menuRoleMapper.insertSelective(detail);
		return new ResultObject();
	}

	@Override
	public Object modifyMenuRole(MenuRole detail) {
		menuRoleMapper.updateByPrimaryKeySelective(detail);
		return new ResultObject();
	}

	@Override
	public Object getMenuRoleList(MenuRolePagination param) {
		//查询总数
		int total = menuRoleMapper.selectMenuRoleTotal(param);
		List<MenuRole> list = new ArrayList<MenuRole>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = menuRoleMapper.selectMenuRoleList(param);
		}	
		response.setRows(list);
		return response;	}

	@Override
	public Object getMenuRoleUserList(Userinformation parpm) {
		List<String> list = new ArrayList<String>();
		list=menuRoleMapper.selectMenuRoleUserList(parpm);
		PageResult response = new PageResult();
		response.setOk(true);
		response.setRows(list);
		return response;
	}

}

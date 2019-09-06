package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PermissionName;
import com.jtzh.entity.Permissionconfiguration;
import com.jtzh.mapper.PermissionconfigurationMapper;
import com.jtzh.pojo.PageResult;
import com.jtzh.pojo.PermissionconfigurationPagination;
import com.jtzh.service.PermissionconfigurationService;

@Service("permissionconfigurationServiceImpl")
public class PermissionconfigurationServiceImpl implements PermissionconfigurationService{
	@Resource
	private PermissionconfigurationMapper permissionconfigurationMapper;
	/**
	 * 获得权限详情
	 */
	@Override
	public Object getPermissionconfig(Integer id) {
		Permissionconfiguration detail = permissionconfigurationMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}
	/**
	 * 删除权限
	 */
	@Override
	public Object removePermissionconfig(Integer id) {
		permissionconfigurationMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}
	/**
	 * 添加权限
	 */
	@Override
	public Object addPermissionconfig(Permissionconfiguration detail, LoginUserTest user) {
		permissionconfigurationMapper.insertSelective(detail);
		return new ResultObject();
	}
	/**
	 * 修改权限详情信息
	 */
	@Override
	public Object modifyPermissionconfig(Permissionconfiguration detail) {
		permissionconfigurationMapper.updateByPrimaryKeySelective(detail);
		return new ResultObject();
	}
	/**
	 * 获得分页的权限信息
	 */
	@Override
	public Object getPermissionconfigList(PermissionconfigurationPagination param) {
		//查询总数
		int total = permissionconfigurationMapper.selectPermissionconfigTotal(param);
		List<Permissionconfiguration> list = new ArrayList<Permissionconfiguration>();
		PageResult response = new PageResult();
		response.setOk(true);
		
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = permissionconfigurationMapper.selectPermissionconfig(param);
		}	
		
		response.setRows(list);
		return response;	
	}
	/**
	 * //查询权限对应的角色、用户、菜单的中文名称
	 */
	@Override
	public List<PermissionName> getPCNumberName() {
		List<PermissionName> detail = permissionconfigurationMapper.SelectPCNumberName();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setRows(detail);
		return detail;
	}
	}

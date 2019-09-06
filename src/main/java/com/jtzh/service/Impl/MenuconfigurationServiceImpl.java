package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.Menuconfiguration;
import com.jtzh.mapper.MenuconfigurationMapper;
import com.jtzh.pojo.MenuconfigurationPagination;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.MenuconfigurationService;

@Service("menuconfigurationServiceImpl")
public class MenuconfigurationServiceImpl implements MenuconfigurationService {
	@Resource
	private MenuconfigurationMapper menuconfigurationMapper;

	/**
	 * 获得菜单 id：菜单的主键
	 */
	@Override
	public Object getMenuconfig(Integer id) {
		Menuconfiguration detail = menuconfigurationMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}

	/**
	 * 删除菜单
	 */
	@Override
	public Object removeMenuconfig(Integer id) {
		menuconfigurationMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}

	/**
	 * 添加菜单
	 */
	@Override
	public Object addMenuconfig(Menuconfiguration detail) {
		detail.setCreateon(new Date());
		menuconfigurationMapper.insertSelective(detail);
		return new ResultObject();
	}

	/**
	 * 修改菜单详情
	 */
	@Override
	public Object modifyMenuconfig(Menuconfiguration detail) {
		menuconfigurationMapper.updateByPrimaryKeySelective(detail);
		return new ResultObject();
	}

	/**
	 * 获得分页的菜单详情
	 */
	@Override
	public Object getMenuconfigList(MenuconfigurationPagination param) {
		// 查询总数
		int total = menuconfigurationMapper.selectMenuconfigTotal(param);
		List<Menuconfiguration> list = new ArrayList<Menuconfiguration>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = menuconfigurationMapper.selectMenuconfig(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getAllMenuconfig() {
		List<Menuconfiguration> list = new ArrayList<Menuconfiguration>();
		PageResult response = new PageResult();
		response.setOk(true);	
		list = menuconfigurationMapper.getAllMenuconfig();
		response.setTotal(list.size());
		response.setRows(list);
		return response;
	}

}

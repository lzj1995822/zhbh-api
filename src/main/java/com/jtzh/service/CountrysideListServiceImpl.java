package com.jtzh.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.CountrysideList;
import com.jtzh.mapper.CountrysideListMapper;
import com.jtzh.pojo.CountrysideListParam;
import com.jtzh.pojo.PageResult;

@Service("listService")
public class CountrysideListServiceImpl implements CountrysideListService {
	@Resource
	private CountrysideListMapper listMapper;

	// 查询
		@Override
		public Object getCountrysideList(CountrysideListParam param) {
			// 查询总数
			int total = listMapper.selectTotal(param);
			List<CountrysideList> list = new ArrayList<CountrysideList>();
			PageResult res = new PageResult();
			res.setOk(true);
			res.setTotal(total);
			// 如果存在，查询具体的数据作为分页数据
			if (total > 0) {
				list = listMapper.selectInfo(param);
			}
			res.setRows(list);
			return res;
		}
			
		// 查询详情
		@Override
		public CountrysideList getCountrysideListInfo(String id) {
			// 根据id去查询通知公告信息
			CountrysideList list = listMapper.getCountrysideListInfo(id);
			return list;
		}
			
		// 修改
		@Override
		public Object updateCountrysideList(CountrysideList param) {
			listMapper.updateCountrysideList(param);
			return new ResultObject();
		}
			
		// 新建
		@Override
		public Object addCountrysideList(CountrysideList list) {
			listMapper.addCountrysideList(list);
			return new ResultObject();
		}
			
		// 删除
		@Override
		public Object deleteCountrysideList(String id) {
			// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
			listMapper.deleteCountrysideList(id);
			return new ResultObject();
		}
	
}

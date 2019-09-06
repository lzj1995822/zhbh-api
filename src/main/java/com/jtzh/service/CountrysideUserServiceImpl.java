package com.jtzh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.Constants;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.CountrysideUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.CountrysideUserMapper;
import com.jtzh.pojo.CountrysideUserParam;
import com.jtzh.pojo.PageResult;

@Service("countrysideUserService")
public class CountrysideUserServiceImpl implements CountrysideUserService{
	@Resource
	private CountrysideUserMapper countrysideUserMapper;
	
	// 查询
		@Override
		public Object getCountrysideUserList(CountrysideUserParam param) {
			// 查询总数
			int total = countrysideUserMapper.selectCsUTotal(param);
			List<CountrysideUser> list = new ArrayList<CountrysideUser>();
			PageResult res = new PageResult();
			res.setOk(true);
			res.setTotal(total);
			// 如果存在，查询具体的数据作为分页数据
			if (total > 0) {
				list = countrysideUserMapper.selectCsUInfo(param);
			}
			res.setRows(list);
			return res;
		}
				
		// 查询详情
		@Override
		public CountrysideUser getCountrysideUserInfo(String id) {
			// 根据id去查询通知公告信息
			CountrysideUser cguser = countrysideUserMapper.getCountrysideUserInfo(id);
			return cguser;
		}
				
		// 新建
		@Override
		public Object addCountrysideUser(CountrysideUser countrysideUser, LoginUserTest user) {
			countrysideUser.setPassword("123456");
			countrysideUser.setYhzh(Constants.YHZH_BAOHUA);
			countrysideUser.setCreateId(user.getLoginId());
			countrysideUser.setCreateTime(new Date());
			countrysideUser.setDelflag("A");
			countrysideUserMapper.addCountrysideUser(countrysideUser);
			return new ResultObject();
		}
				
		// 删除
		@Override
		public Object deleteCountrysideUser(String id) {
			// 删除问题---a).删除问题表记录; b)删除对应的资源表记录.
			countrysideUserMapper.deleteCountrysideUser(id);
			return new ResultObject();
		}
			
		// 修改
		@Override
		public Object updateCountrysideUser(CountrysideUser param) {
			countrysideUserMapper.updateCountrysideUser(param);
			return new ResultObject();
		}

}

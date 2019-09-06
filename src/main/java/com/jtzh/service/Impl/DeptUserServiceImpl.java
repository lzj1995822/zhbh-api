package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.entity.DeptUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.DeptUserMapper;
import com.jtzh.pojo.DeptUserPagination;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.DeptUserService;
@Service("deptUserServiceImpl")
public class DeptUserServiceImpl implements DeptUserService{
	@Resource	
	private DeptUserMapper deptUserMapper;
	@Override
	public Object getDeptUser(Integer id) {
		DeptUser detail = deptUserMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}

	@Override
	public Object removeDeptUser(Integer id) {
		deptUserMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}

	@Override
	public Object addDeptUser(DeptUser detail) {
		deptUserMapper.insertSelective(detail);
		return new ResultObject();
	}

	@Override
	public Object modifyDeptUser(DeptUser detail) {
		deptUserMapper.updateByPrimaryKeySelective(detail);
		return new ResultObject();
	}

	@Override
	public Object getDeptUserList(DeptUserPagination param) {
		//查询总数
		int total = deptUserMapper.selectDeptUserTotal(param);
		List<DeptUser> list = new ArrayList<DeptUser>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			
			list = deptUserMapper.selectDeptUserList(param);
		}	
		response.setRows(list);
		return response;	}

}

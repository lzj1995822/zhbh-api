package com.jtzh.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jtzh.common.ResultObject;
import com.jtzh.entity.Department;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.mapper.DepartmentMapper;
import com.jtzh.pojo.Departmentpagination;
import com.jtzh.pojo.PageResult;
import com.jtzh.service.DepartmentService;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;

	@Override
	public Object getDepartment(Integer id) {
		Department detail = departmentMapper.selectByPrimaryKey(id);
		ResultObject obj = new ResultObject();
		obj.setObj(detail);
		return obj;
	}

	@Override
	public Object removeDepartment(Integer id) {
		departmentMapper.deleteByPrimaryKey(id);
		return new ResultObject();
	}

	@Override
	public Object addDepartment(Department detail, LoginUserTest user) {
		detail.setCreateby(user.getUserName());
		detail.setCreateon(new Date());
		departmentMapper.insertSelective(detail);
		return new ResultObject();
	}

	@Override
	public Object modifyDepartment(Department detail) {
		detail.setUpdateon(new Date());
		departmentMapper.updateByPrimaryKeySelective(detail);
		return new ResultObject();
	}

	@Override
	public Object getDepartmentList(Departmentpagination param) {
		// 查询总数
		int total = departmentMapper.selectDepartmentTotal(param);
		List<Department> list = new ArrayList<Department>();
		PageResult response = new PageResult();
		response.setOk(true);
		response.setTotal(total);
		// 如果存在，查询具体的数据作为分页数据
		if (total > 0) {
			list = departmentMapper.selectDepartment(param);
		}
		response.setRows(list);
		return response;
	}

	@Override
	public Object getAllDepartment() {
		ResultObject res = new ResultObject();
		List<Department> dep = departmentMapper.getAllDepartment();
		res.setObj(dep);
		return res;
	}
	
}

package com.jtzh.service;

import com.jtzh.entity.Department;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.Departmentpagination;

public interface DepartmentService {
	public Object getDepartment(Integer id);

	public Object removeDepartment(Integer id);

	public Object addDepartment(Department detail,LoginUserTest user);

	public Object modifyDepartment(Department detail);
	
	public Object getDepartmentList(Departmentpagination param);
	
	public Object getAllDepartment();
}

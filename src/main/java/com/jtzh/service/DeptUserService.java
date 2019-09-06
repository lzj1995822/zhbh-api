package com.jtzh.service;

import com.jtzh.entity.DeptUser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.DeptUserPagination;

public interface DeptUserService {

	public Object getDeptUser(Integer id);

	public Object removeDeptUser(Integer id);

	public Object addDeptUser(DeptUser detail);

	public Object modifyDeptUser(DeptUser detail);
	
	public Object getDeptUserList(DeptUserPagination param);
	//

}

package com.jtzh.service;

import com.jtzh.entity.Cglog;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CglogParam;

public interface CglogService {
	
	public Object getCglogList(CglogParam param); // 查询

	public Cglog getCglogInfo(String id); // 查看详情

	public Object addCglog(Cglog cguser, LoginUserTest user); // 新建
	
	public Object deleteCglog(String id); // 删除
	
	Object updateCglog(Cglog param); // 修改

}

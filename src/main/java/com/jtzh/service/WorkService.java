package com.jtzh.service;

import com.jtzh.detail.pojo.WorkDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.WorkPagination;
import com.jtzh.pojo.WorkSourceParam;

public interface WorkService {
	public Object getWorkList(WorkPagination param);

	public Object getWork(String type, String id);

	public Object removeWork(String id);

	public Object addWork(WorkDetail detail, LoginUserTest user);

	public Object modifyWork(WorkDetail detail);
	
	public Object getphotoList(WorkSourceParam param);
}

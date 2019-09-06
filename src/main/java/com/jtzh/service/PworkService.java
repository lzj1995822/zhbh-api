package com.jtzh.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PworkBuild;
import com.jtzh.pojo.PworkPagination;

public interface PworkService {
	public Object getPworkList(PworkPagination param);

	public Object getPwork(String type, String id);

	public Object removePwork(String id);

	public Object addPwork(PworkBuild work, LoginUserTest user);

	public Object modifyPwork(PworkBuild work);
	
	public void downloadPwork(HttpServletResponse res, PworkBuild work);
}

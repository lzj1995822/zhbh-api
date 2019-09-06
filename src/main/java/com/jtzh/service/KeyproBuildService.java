package com.jtzh.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.jtzh.detail.pojo.KeyproBuildDetail;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.KbuildPagination;

public interface KeyproBuildService {
	public Object getKeyproBuildList(KbuildPagination param);

	public Object getKeyproBuildInfo(String id);

	public Object removePro(String id);

	public Object addPro(KeyproBuildDetail detail, LoginUserTest user);

	public Object modifyPro(KeyproBuildDetail detail);

	public Object exportExcel(HttpServletResponse response);

	public boolean batchImport(String fileName, MultipartFile file, LoginUserTest user) throws Exception;

	public Object getKeyProjectCoordinate();
	
	public Object getProNameAndId();
	
	public Object countProAllCountryside();
}

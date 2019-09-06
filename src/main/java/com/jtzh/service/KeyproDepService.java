package com.jtzh.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.jtzh.entity.KeyproDep;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.DepPagination;

public interface KeyproDepService {
	public Object getDepList(DepPagination param);

	public Object getDep(String id);

	public Object removeDep(String id);

	public Object insertDep(KeyproDep dep, LoginUserTest user);

	public Object updateDep(KeyproDep dep);

	public Object exportExcel(HttpServletResponse response);

	public boolean batchImport(String fileName, MultipartFile file, LoginUserTest user) throws Exception;
}

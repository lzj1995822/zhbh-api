package com.jtzh.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.jtzh.entity.LoginUserTest;
import com.jtzh.entity.PworkUser;
import com.jtzh.pojo.UserPagination;

public interface PbuildUserService {
	public Object getPbuserList(UserPagination param);

	public Object getPbuser(String id);

	public Object removePbuser(String id);

	public Object insertUser(PworkUser user, LoginUserTest loginUser);

	public Object updatePbuser(PworkUser user);

	public Object exportExcel(HttpServletResponse response);

	public boolean batchImport(String fileName, MultipartFile file) throws Exception;
}

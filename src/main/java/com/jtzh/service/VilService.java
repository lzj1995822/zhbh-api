package com.jtzh.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface VilService {
	public Object exportExcel(HttpServletResponse response);

	public boolean batchImport(String fileName, MultipartFile file) throws Exception;
	
	public boolean batchImportLddy(String fileName, MultipartFile file) throws Exception;
	
	public boolean batchImportDy(String fileName, MultipartFile file) throws Exception;
	
	public boolean batchImportQYGL(String fileName, MultipartFile file) throws Exception;
}

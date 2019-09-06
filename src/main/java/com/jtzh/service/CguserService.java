package com.jtzh.service;

import com.jtzh.entity.Cguser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.CguserParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CguserService {
	
	public Object getCguserList(CguserParam param); // 查询

	public Cguser getCguserInfo(String id); // 查看详情

	public Object addCguser(Cguser cguser, LoginUserTest user); // 新建
	
	public Object deleteCguser(String id); // 删除
	
	Object updateCguser(Cguser param); // 修改
	public boolean batchImport(String fileName, MultipartFile file) throws Exception;
	public List<Cguser> find();

}

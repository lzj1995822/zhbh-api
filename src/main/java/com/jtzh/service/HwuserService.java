package com.jtzh.service;

import com.jtzh.entity.Hwuser;
import com.jtzh.entity.LoginUserTest;
import com.jtzh.pojo.HwuserParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HwuserService {
	
	public Object getHwuserList(HwuserParam param); // 查询

	public Hwuser getHwuserInfo(String id); // 查看详情

	public Object addHwuser(Hwuser hwuser, LoginUserTest user); // 新建
	
	public Object deleteHwuser(String id); // 删除
	
	Object updateHwuser(Hwuser param); // 修改
	public boolean batchImport(String fileName, MultipartFile file) throws Exception;
	public List<Hwuser> find();

}

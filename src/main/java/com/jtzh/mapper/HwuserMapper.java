package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.Hwuser;
import com.jtzh.pojo.HwuserParam;

public interface HwuserMapper {
	
	// 查询id
	Hwuser selectByPrimaryKey(Integer id);
	// 查询总数
	int selectHwuTotal(@Param("page") HwuserParam param);
	// 分页查询
	List<Hwuser> selectInfo(@Param("page") HwuserParam param);
	// 根据id查询
	Hwuser getHwuserInfo(@Param("id") String id);
	// 修改
	void updateHwuser(Hwuser param);
	// 新建
	int addHwuser(Hwuser cguser);
	// 删除
	int deleteHwuser(@Param("id") String id);
	Hwuser findbyidcard(String idcard);
	List<Hwuser> find();
}

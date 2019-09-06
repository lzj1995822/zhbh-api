package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.Cguser;
import com.jtzh.pojo.CguserParam;

public interface CguserMapper {
	
	// 查询id
	Cguser selectByPrimaryKey(Integer id);
	// 查询总数
	int selectCguTotal(@Param("page") CguserParam param);
	// 分页查询
	List<Cguser> selectInfo(@Param("page") CguserParam param);
	// 根据id查询
	Cguser getCguserInfo(@Param("id") String id);
	// 修改
	void updateCguser(Cguser param);
	// 新建
	int addCguser(Cguser cguser);
	// 删除
	int deleteCguser(@Param("id") String id);
	Cguser findbyidcard(String idcard);
	List<Cguser> find();

}

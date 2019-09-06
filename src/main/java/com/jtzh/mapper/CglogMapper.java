package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.Cglog;
import com.jtzh.pojo.CglogParam;

public interface CglogMapper {
	
	// 查询id
	Cglog selectByPrimaryKey(Integer id);
	// 查询总数
	int selectCglTotal(@Param("page") CglogParam param);
	// 分页查询
	List<Cglog> selectInfo(@Param("page") CglogParam param);
	// 根据id查询
	Cglog getCglogInfo(@Param("id") String id);
	// 修改
	void updateCglog(Cglog param);
	// 新建
	int addCglog(Cglog cglog);
	// 删除
	int deleteCglog(@Param("id") String id);

}

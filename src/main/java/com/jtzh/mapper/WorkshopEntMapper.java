package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.WorkshopEnt;
import com.jtzh.pojo.WorkshopParam;

public interface WorkshopEntMapper {
	//企业档案
	// 查询id
	WorkshopEnt selectByPrimaryKey(Integer id);
	// 查询总数
	int selectEntTotal(@Param("page") WorkshopParam param);
	// 分页查询
	List<WorkshopEnt> selectInfo(@Param("page") WorkshopParam param);
	// 根据id查询
	WorkshopEnt getWorkshopEnt(@Param("id") String id);
	// 修改
	void updateWorkshopEnt(WorkshopEnt param);
	// 新建
	int addWorkshopEnt(WorkshopEnt record);
	// 删除
	int deleteWorkshopEnt(@Param("id") String id);

}

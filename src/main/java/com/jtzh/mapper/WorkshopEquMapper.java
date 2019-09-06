package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.WorkshopEqu;
import com.jtzh.pojo.CountSafe;
import com.jtzh.pojo.WorkshopParam;

public interface WorkshopEquMapper {
	// 器材管理
	// 查询id
	WorkshopEqu selectByPrimaryKey(Integer id);
	// 查询总数
	int selectEquTotal(@Param("page") WorkshopParam param);
	// 分页查询
	List<WorkshopEqu> selectInfo(@Param("page") WorkshopParam param);
	// 根据id查询
	WorkshopEqu getWorkshopEqu(@Param("id") String id);
	// 修改
	void updateWorkshopEqu(WorkshopEqu param);
	// 新建
	int addWorkshopEqu(WorkshopEqu record);
	// 删除
	int deleteWorkshopEqu(@Param("id") String id);
}

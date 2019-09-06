package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.HiddenDanger;
import com.jtzh.entity.WorkshopAdm;
import com.jtzh.pojo.CountSafe;
import com.jtzh.pojo.HiddenParam;
import com.jtzh.pojo.WorkshopParam;

public interface WorkshopAdmMapper {
	// 厂区概况
	// 查询id
	WorkshopAdm selectByPrimaryKey(Integer id);
	// 查询总数
	int selectAdmTotal(@Param("page") WorkshopParam param);
	// 分页查询
	List<WorkshopAdm> selectInfo(@Param("page") WorkshopParam param);
	// 根据id查询
	WorkshopAdm getWorkshopAdm(@Param("id") String id);
	// 修改
	void updateWorkshopAdm(WorkshopAdm param);
	// 新建
	int addWorkshopAdm(WorkshopAdm record);
	// 删除
	int deleteWorkshopAdm(@Param("id") String id);
	
	// 获取厂房坐标所有字段
	List<WorkshopAdm> selectInfoWeb();
	
	List<CountSafe> countAdmAllCountryside();
}

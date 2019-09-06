package com.jtzh.mapper;

import java.util.List;


import com.jtzh.entity.CgInformationTypeCount;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CgInformation;
import com.jtzh.pojo.CgInformationParam;

public interface CgInformationMapper {
	
	int insert(CgInformation record);

	int insertSelective(CgInformation record);

	CgInformation selectByPrimaryKey(Integer id);
	
	// 查询总数
	int selectCgITotal(@Param("page") CgInformationParam param);

	// 分页查询
	List<CgInformation> selectInfo(@Param("page") CgInformationParam param);

	// 根据id查询
	CgInformation getCgInformationInfo(@Param("id") String id);
	
	// 删除
	int deleteCgInformation(@Param("id") String id);

	// 新增可以返回主键
	int insertCgInformation(CgInformation param);
	
	// 修改
	void updateCgInformation(CgInformation param);

	//获取城管信息发布每种类型的数量
	List<CgInformationTypeCount> getCgInformationTypeCount();

}

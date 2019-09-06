package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.HwInformationTypeCount;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.HwInformation;
import com.jtzh.pojo.HwInformationParam;

public interface HwInformationMapper {
	
	int insert(HwInformation record);

	int insertSelective(HwInformation record);

	HwInformation selectByPrimaryKey(Integer id);
	
	// 查询总数
	int selectHwITotal(@Param("page") HwInformationParam param);

	// 分页查询
	List<HwInformation> selectInfo(@Param("page") HwInformationParam param);

	// 根据id查询
	HwInformation getHwInformationInfo(@Param("id") String id);
	
	// 删除
	int deleteHwInformation(@Param("id") String id);

	// 新增可以返回主键
	int insertHwInformation(HwInformation param);
	
	// 修改
	void updateHwInformation(HwInformation param);

	List <HwInformationTypeCount> getHwInformationTypeCount();

}

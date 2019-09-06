package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideMeeting;
import com.jtzh.pojo.CountrysideMeetingParam;

public interface CountrysideMeetingMapper {
	
	// 查询id
	CountrysideMeeting selectByPrimaryKey(Integer id);
	// 查询总数
	int selectCoMTotal(@Param("page") CountrysideMeetingParam param);
	// 分页查询
	List<CountrysideMeeting> selectInfo(@Param("page") CountrysideMeetingParam param);
	// 根据id查询
	CountrysideMeeting getCountrysideMeetingInfo(@Param("id") String id);
	// 修改
	void updateCountrysideMeeting(CountrysideMeeting param);
	// 新建
	int addCountrysideMeeting(CountrysideMeeting meeting);
	// 删除
	int deleteCountrysideMeeting(@Param("id") String id);

}

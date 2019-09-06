package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.WorkshopAdm;
import com.jtzh.pojo.CountDay;
import com.jtzh.pojo.CountHiddenAndInspection;
import com.jtzh.pojo.CountMonth;
import com.jtzh.pojo.CountQuarter;
import com.jtzh.pojo.InspectionParam;

public interface InspectionMapper {
	
	int insert(InspectionRecord record);

	int insertSelective(InspectionRecord record);

	InspectionRecord selectByPrimaryKey(Integer id);
	
	int selectInsTotal(@Param("page") InspectionParam param);

	List<InspectionRecord> selectInfo(@Param("page") InspectionParam param);

	InspectionRecord getInspectionInfo(@Param("id") String id);
	
	int deleteInspection(@Param("id") String id);

	int insertInspection(InspectionRecord record);
	
	void updateInspection(InspectionRecord param);

	List<CountHiddenAndInspection> countInspectionState();
	
	// 根据年份季度统计
	List<CountQuarter> countInspectionByYear(@Param("year")String year);
	
	// 根据月份统计
	List<CountMonth> countInspectionByMonth(@Param("year")String year);
		
	// 一周的统计结果
	List<CountDay> countInspectionByDay(@Param("year")String year);
	
	// 获取巡检坐标所有字段
	List<InspectionRecord> selectInfoWeb();

}

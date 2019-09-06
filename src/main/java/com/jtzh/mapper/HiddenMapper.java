package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.detail.pojo.HiddenCoordinate;
import com.jtzh.entity.HiddenDanger;
import com.jtzh.pojo.CountDay;
import com.jtzh.pojo.CountHiddenAndInspection;
import com.jtzh.pojo.CountMonth;
import com.jtzh.pojo.CountQuarter;
import com.jtzh.pojo.CountSafe;
import com.jtzh.pojo.CountState;
import com.jtzh.pojo.HiddenParam;
import com.jtzh.responsevo.CountHiddenType;

public interface HiddenMapper {
	
	int insert(HiddenDanger record);

	int insertSelective(HiddenDanger record);

	HiddenDanger selectByPrimaryKey(Integer id);
	
	// 查询总数
	int selectHidTotal(@Param("page") HiddenParam param);

	// 分页查询
	List<HiddenDanger> selectInfo(@Param("page") HiddenParam param);

	// 根据id查询
	HiddenDanger getHiddenInfo(@Param("id") String id);
	
	// 删除
	int deleteHidden(@Param("id") String id);

	// 新增可以返回主键
	int insertHidden(HiddenDanger record);
	
	// 修改
	void updateHidden(HiddenDanger param);
	
	// 移交
	void moveHidden(HiddenDanger param);
	
	// 指派
	void sendHidden(HiddenDanger param);
	
	// 整改
	int solveHidden(HiddenDanger record);
	
	// 获取隐患坐标id,x,y
	List<HiddenCoordinate> getHiddenCoordinate();

	List<CountHiddenAndInspection> countHiddenState();

	// 获取隐患坐标所有字段
	List<HiddenDanger> selectInfoWeb(@Param("page") HiddenParam param);
	
	// 根据年份季度统计
	List<CountQuarter> countHiddenByYear(@Param("year")String year);
	
	int countHiddenByState(@Param("state")String state);

	List<CountState> countHiddenStateNoParam();
	
	// 根据月份统计
	List<CountMonth> countHiddenByMonth(@Param("year")String year);
	
	// 一周的统计结果
	List<CountDay> countHiddenByDay(@Param("year")String year);
	
	List<CountSafe> countHiddenAllCountryside();
	
	List<CountHiddenType> countHiddenByType(String state);
	
	List<CountHiddenType> countHiddenByPeople(String state);

	List<CountHiddenType> getHiddenCountByType(String state);

}

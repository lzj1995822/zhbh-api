package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideChuli;
import com.jtzh.pojo.CountrysideChuliParam;

public interface CountrysideChuliMapper {
	
	// 查询总数
	int selectChlTotal(@Param("page") CountrysideChuliParam param);

	// 分页查询
	List<CountrysideChuli> selectInfo(@Param("page") CountrysideChuliParam param);
	
	// 处理可以返回主键
	int Problemyichuli(CountrysideChuli chuli);
		
	// 审核
	void Problemshenhe(CountrysideChuli shenhe);
	
	// 删除
	int deletechuli(@Param("id") String id);
	
	// 查询总数
	int selectAllTotal(@Param("page") CountrysideChuliParam param);

	// 分页查询
	List<CountrysideChuli> selectInfoAll(@Param("page") CountrysideChuliParam param);
	
	// 根据id查询
	CountrysideChuli getHuituiInfo(@Param("id") String id);
	
	// 根据shangbaoid拉取处理信息 多条
	List<CountrysideChuli> selectAllBySid(@Param("shangbaoid") String shangbaoid);

}

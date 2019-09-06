package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideNews;
import com.jtzh.pojo.CountrysideParam;

public interface CountrysideNewsMapper {
	
	int insert(CountrysideNews record);

	int insertSelective(CountrysideNews record);

	CountrysideNews selectByPrimaryKey(Integer id);
	
	// 查询总数
	int selectCNTotal(@Param("page") CountrysideParam param);

	// 分页查询
	List<CountrysideNews> selectInfo(@Param("page") CountrysideParam param);

	// 根据id查询
	CountrysideNews getCountrysideNewsInfo(@Param("id") String id);
	
	// 删除
	int deleteCountrysideNews(@Param("id") String id);

	// 新增可以返回主键
	int insertCountrysideNews(CountrysideNews record);
	
	// 修改
	void updateCountrysideNews(CountrysideNews param);

}

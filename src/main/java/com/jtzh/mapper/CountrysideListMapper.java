package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideList;
import com.jtzh.pojo.CountrysideListParam;

public interface CountrysideListMapper {
	
	// 查询id
	CountrysideList selectByPrimaryKey(Integer id);
	// 查询总数
	int selectTotal(@Param("page") CountrysideListParam param);
	// 分页查询
	List<CountrysideList> selectInfo(@Param("page") CountrysideListParam param);
	// 根据id查询
	CountrysideList getCountrysideListInfo(@Param("id") String id);
	// 修改
	void updateCountrysideList(CountrysideList param);
	// 新建
	int addCountrysideList(CountrysideList list);
	// 删除
	int deleteCountrysideList(@Param("id") String id);
	
	List<CountrysideList> getAllCountryside();

}

package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideUser;
import com.jtzh.pojo.CountrysideUserParam;

public interface CountrysideUserMapper {
	
	// 查询id
	CountrysideUser selectByPrimaryKey(Integer id);
	// 查询总数
	int selectCsUTotal(@Param("page") CountrysideUserParam param);
	// 分页查询
	List<CountrysideUser> selectCsUInfo(@Param("page") CountrysideUserParam param);
	// 根据id查询
	CountrysideUser getCountrysideUserInfo(@Param("id") String id);
	// 修改
	void updateCountrysideUser(CountrysideUser param);
	// 新建
	int addCountrysideUser(CountrysideUser cguser);
	// 删除
	int deleteCountrysideUser(@Param("id") String id);

}

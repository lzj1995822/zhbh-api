package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideSource;

public interface CountrysideSourceMapper {
	
	CountrysideSource selectByPrimaryKey(Integer id);
	
	int insert(CountrysideSource record);

    int insertSelective(CountrysideSource record);
    
    // 查询问题对应的图片资源根据id
 	List<CountrysideSource> getSourceInfo(@Param("sourceType") String sourceType, @Param("id") String id);

 	// 获取问题对应的来源根据id和类型
 	List<CountrysideSource> selectSourceList(@Param("id") String id, @Param("sourceType") String sourceType);

 	// 单个删除source
 	int deleteSource(Integer a);
 	
 	// 获取source
 	List<CountrysideSource> selectSource(@Param("source") String source, @Param("id") Integer id);

}

package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.SecuritySource;

public interface SecuritySourceMapper {
	
	SecuritySource selectByPrimaryKey(Integer id);
	
	int insert(SecuritySource record);

    int insertSelective(SecuritySource record);
    
    // 查询问题对应的图片资源根据id
 	List<SecuritySource> getSourceInfo(@Param("sourceType") String sourceType, @Param("id") String id);

 	// 获取问题对应的来源根据id和类型
 	List<SecuritySource> selectSourceList(@Param("id") String id, @Param("sourceType") String sourceType);

 	// 单个删除source
 	int deleteSource(Integer a);

}

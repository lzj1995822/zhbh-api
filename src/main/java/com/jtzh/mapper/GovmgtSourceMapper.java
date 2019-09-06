package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.GovmgtSource;
import com.jtzh.entity.GovmgtWork;
import com.jtzh.pojo.WorkPagination;
import com.jtzh.pojo.WorkSourceParam;

public interface GovmgtSourceMapper {
	int deleteByPrimaryKey(Long id);

	int insert(GovmgtSource record);

	int insertSelective(GovmgtSource record);

	GovmgtSource selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(GovmgtSource record);

	int updateByPrimaryKey(GovmgtSource record);

	// 获取source
	List<GovmgtSource> selectSource(@Param("source") String source, @Param("id") String id);//

	// 查询问题对应的图片资源根据id
	List<GovmgtSource> getSourceInfo(@Param("sourceType") String sourceType, @Param("id") String id);

	// 单个删除source
	int deleteSource(String a);
	
	// 查询总数
	int selectphotoTotal(@Param("page") WorkSourceParam param);

	// 分页查询
	List<GovmgtSource> selectphotoInfo(@Param("page") WorkSourceParam param);
}
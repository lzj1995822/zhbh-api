package com.jtzh.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerOrg;
import com.jtzh.pojo.PioneerOrgCount;
import com.jtzh.pojo.PioneerOrgPagination;
import com.jtzh.pojo.PioneerOrgTree;

public interface PioneerOrgMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(PioneerOrg record);

	int insertSelective(PioneerOrg record);

	PioneerOrg selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(PioneerOrg record);

	int updateByPrimaryKey(PioneerOrg record);

	List<Map<String,Integer>> getOrgCount();

	// 查询总数
	int selectTotal(@Param("page") PioneerOrgPagination param);

	// 分页查询
	List<PioneerOrg> selectInfo(@Param("page") PioneerOrgPagination param);

	// 获取所选的user
	PioneerOrg selectOrg(@Param("id") String id);

	// 删除
	int deleteOrg(@Param("id") String id);

	// 根据父id获取子list
	List<PioneerOrgTree> selectBySId(String id);

	List<PioneerOrg> selectAllOrg();
	
	Long getCountList();
	
	Long getCountOrgList(String id);
	
	List<PioneerOrgCount> selectBySId2(String id);
}
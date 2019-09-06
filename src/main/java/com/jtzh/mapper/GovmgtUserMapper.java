package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.GovmgtUser;
import com.jtzh.pojo.TreeParam;
import com.jtzh.pojo.UserPagination;

public interface GovmgtUserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(GovmgtUser record);

	int insertSelective(GovmgtUser record);

	GovmgtUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(GovmgtUser record);

	int updateByPrimaryKey(GovmgtUser record);

	// 查询总数
	int selectTotal(@Param("page") UserPagination param);

	// 分页查询
	List<GovmgtUser> selectInfo(@Param("page") UserPagination param);

	// 获取所选的user
	GovmgtUser selectUser(@Param("id") String id);

	// 删除
	int deleteUser(@Param("id") String id);

	// 根据父id获取子list
	List<TreeParam> selectBySId(String id);
	
	// 查询总数
	int selectAllTotal(GovmgtUser param);
	
	// 分页查询
	List<GovmgtUser> selectAllInfo(GovmgtUser param);
}
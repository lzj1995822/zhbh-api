package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PworkUser;
import com.jtzh.pojo.UserPagination;

public interface PworkUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(PworkUser record);

	int insertSelective(PworkUser record);

	PworkUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(PworkUser record);

	int updateByPrimaryKey(PworkUser record);

	// 查询总数
	int selectTotal(@Param("page") UserPagination param);

	// 分页查询
	List<PworkUser> selectInfo(@Param("page") UserPagination param);

	// 获取所选的user
	PworkUser selectUser(@Param("id") String id);

	// 删除
	int deleteUser(@Param("id") String id);

	// 为了导出进行的查询
	List<PworkUser> getUserList();
}
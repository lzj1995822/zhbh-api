package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.UserLoginLog;
import com.jtzh.pojo.UserLoginLogPagination;

public interface UserLoginLogMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserLoginLog record);

	int insertSelective(UserLoginLog record);

	UserLoginLog selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserLoginLog record);

	int updateByPrimaryKey(UserLoginLog record);

	// 查询总数
	int selectTotal(@Param("page") UserLoginLogPagination param);

	// 分页查询
	List<UserLoginLog> selectInfo(@Param("page") UserLoginLogPagination param);

}
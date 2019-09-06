package com.jtzh.mapper;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.LoginUserTest;

public interface LoginUserTestMapper {
	int deleteByPrimaryKey(Long id);

	int insert(LoginUserTest record);

	int insertSelective(LoginUserTest record);

	LoginUserTest selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(LoginUserTest record);

	int updateByPrimaryKey(LoginUserTest record);

	// 登录后返回用户信息
	LoginUserTest getTestUser(@Param("loginId") String loginId);
}
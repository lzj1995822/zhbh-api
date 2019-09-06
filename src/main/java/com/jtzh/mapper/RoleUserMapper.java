package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoleUser;
import com.jtzh.pojo.RoleUserPagination;

public interface RoleUserMapper {
	
	int deleteByPrimaryKey(Integer id);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
    // 查询总数
   	int selectRoleUserTotal(@Param("page")RoleUserPagination param);
  	// 分页查询
   	List<RoleUser> selectRoleUserList(@Param("page") RoleUserPagination param);

   	RoleUser selectByUserId(@Param("id")String id);
   	
   	String selectRoleNameByUserId(Integer id);
}
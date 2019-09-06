package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.SafeManagementUser;
import com.jtzh.pojo.SafeUserPagination;

public interface SafeManagementUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SafeManagementUser record);

    int insertSelective(SafeManagementUser record);

    SafeManagementUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SafeManagementUser record);

    int updateByPrimaryKey(SafeManagementUser record);
    
    // 查询总数
 	int selectTotal(@Param("page") SafeUserPagination param);

 	// 分页查询
 	List<SafeManagementUser> selectInfo(@Param("page") SafeUserPagination param);

 	// 查询具体的路
 	SafeManagementUser selectUser(Integer id);

 	// 删除
 	int deleteUser(Integer id);
}
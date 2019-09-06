package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.DeptUser;
import com.jtzh.entity.RoleUser;
import com.jtzh.pojo.DeptUserPagination;

public interface DeptUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeptUser record);

    int insertSelective(DeptUser record);

    DeptUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeptUser record);

    int updateByPrimaryKey(DeptUser record);
    
    // 查询总数
   	int selectDeptUserTotal(@Param("page")DeptUserPagination param);
  	// 分页查询
   	List<DeptUser> selectDeptUserList(@Param("page") DeptUserPagination param); 
}
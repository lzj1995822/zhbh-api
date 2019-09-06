package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.MenuRole;
import com.jtzh.entity.Userinformation;
import com.jtzh.pojo.MenuRolePagination;

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);
    // 查询总数
   	int selectMenuRoleTotal(@Param("page")MenuRolePagination param);
  	// 分页查询
   	List<MenuRole> selectMenuRoleList(@Param("page") MenuRolePagination param); 	
   	
   	List<String> selectMenuRoleUserList(@Param("page") Userinformation param);
   	
   	List<String> selectMenusByRoleId(Integer id);
   	
}
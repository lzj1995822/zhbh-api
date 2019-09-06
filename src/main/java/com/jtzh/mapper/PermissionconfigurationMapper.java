package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PermissionName;
import com.jtzh.entity.Permissionconfiguration;
import com.jtzh.pojo.PermissionconfigurationPagination;

public interface PermissionconfigurationMapper {
	//通过主键删除
	int deleteByPrimaryKey(Integer id);
	//新增全部信息
	int insert(Permissionconfiguration record);
	//新增信息
	int insertSelective(Permissionconfiguration record);
	//通过主键查询
	Permissionconfiguration selectByPrimaryKey(Integer id);
	//修改
	int updateByPrimaryKeySelective(Permissionconfiguration record);
	//通过主键修改
	int updateByPrimaryKey(Permissionconfiguration record);
	// 查询总数
	int selectPermissionconfigTotal(@Param("page") PermissionconfigurationPagination param);
	// 分页查询
	List<Permissionconfiguration> selectPermissionconfig(@Param("page") PermissionconfigurationPagination param);
	//查询权限对应的角色、用户、菜单的中文名称
	List<PermissionName> SelectPCNumberName();
}
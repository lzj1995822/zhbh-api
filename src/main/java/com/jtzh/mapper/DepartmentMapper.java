package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.Department;
import com.jtzh.pojo.Departmentpagination;

public interface DepartmentMapper {
   
	int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    // 查询总数
   	int selectDepartmentTotal(@Param("page")Departmentpagination param);
  	// 分页查询
   	List<Department> selectDepartment(@Param("page") Departmentpagination param); 	
   	
   	// 查询所有部门
   	List<Department> getAllDepartment(); 	
   	
}
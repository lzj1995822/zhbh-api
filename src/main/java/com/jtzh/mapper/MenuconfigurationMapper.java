package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.Menuconfiguration;
import com.jtzh.pojo.CharacterUserTree;
import com.jtzh.pojo.MenuTree;
import com.jtzh.pojo.MenuconfigurationPagination;

public interface MenuconfigurationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menuconfiguration record);

    int insertSelective(Menuconfiguration record);

    Menuconfiguration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menuconfiguration record);

    int updateByPrimaryKey(Menuconfiguration record);
    // 查询总数
  	int selectMenuconfigTotal(@Param("page") MenuconfigurationPagination param);
 	// 分页查询
  	List<Menuconfiguration> selectMenuconfig(@Param("page") MenuconfigurationPagination param);
  	
  	// 根据父id获取子list
  	List<MenuTree> selectBySId(Integer id);
  	
  	// 查询所有菜单
   	List<Menuconfiguration> getAllMenuconfig();
}
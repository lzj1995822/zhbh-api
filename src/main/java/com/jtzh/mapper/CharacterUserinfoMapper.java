package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CharacterUserinfo;
import com.jtzh.pojo.CharacterUserTree;
import com.jtzh.pojo.CharacterUserinfoPagination;
import com.jtzh.pojo.PioneerOrgTree;

public interface CharacterUserinfoMapper {
	//通过主键删除
    int deleteByPrimaryKey(Integer id);
    //新增全部信息
    int insert(CharacterUserinfo record);
    //新增
    int insertSelective(CharacterUserinfo record);
    //通过主键查询
    CharacterUserinfo selectByPrimaryKey(Integer id);
    //修改
    int updateByPrimaryKeySelective(CharacterUserinfo record);
    //通过主键修改
    int updateByPrimaryKey(CharacterUserinfo record);
    // 查询总数
 	int selectCharacterUserinfofigTotal(@Param("page")CharacterUserinfoPagination param);
	// 分页查询
 	List<CharacterUserinfo> selectCharacterUserinfo(@Param("page") CharacterUserinfoPagination param); 	
 	//查询名称
 	String SelectNameById(Integer id);
 	
 	// 根据父id获取子list
 	List<CharacterUserTree> selectBySId(Integer id);
 	
 	// 拉取所有角色
  	List<CharacterUserinfo> getAllRole(); 	
}
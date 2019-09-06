package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoadProtectionInspection;
import com.jtzh.pojo.RoadProtectionInspectionPagination;

public interface RoadProtectionInspectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoadProtectionInspection record);

    int insertSelective(RoadProtectionInspection record);

    RoadProtectionInspection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoadProtectionInspection record);

    int updateByPrimaryKey(RoadProtectionInspection record);
    
    // 查询总数
 	int selectTotal(@Param("page") RoadProtectionInspectionPagination param);

 	// 分页查询
 	List<RoadProtectionInspection> selectInfo(@Param("page") RoadProtectionInspectionPagination param);

 	// 查询具体的记录
 	RoadProtectionInspection selectInspection(Long  id);

 	// 删除
 	int deleteInspection(Long id);

 	// 新建记录
 	int insertInspection(RoadProtectionInspection record);
}
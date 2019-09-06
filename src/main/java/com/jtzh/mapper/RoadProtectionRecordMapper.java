package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.RoadProtectionRecord;
import com.jtzh.pojo.RoadProtectionRecordPagination;

public interface RoadProtectionRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoadProtectionRecord record);

    int insertSelective(RoadProtectionRecord record);

    RoadProtectionRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoadProtectionRecord record);

    int updateByPrimaryKey(RoadProtectionRecord record);
    
    // 查询总数
 	int selectTotal(@Param("page") RoadProtectionRecordPagination param);

 	// 分页查询
 	List<RoadProtectionRecord> selectInfo(@Param("page") RoadProtectionRecordPagination param);

 	// 查询具体的记录
 	RoadProtectionRecord selectRecord(Long  id);

 	// 删除
 	int deleteRecord(Long id);

 	// 新建记录
 	int insertRecord(RoadProtectionRecord record);
}
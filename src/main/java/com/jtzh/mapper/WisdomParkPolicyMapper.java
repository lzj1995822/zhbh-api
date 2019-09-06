package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.WisdomParkPolicy;
import com.jtzh.pojo.WisdomParkPolicyPagination;

public interface WisdomParkPolicyMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(WisdomParkPolicy record);

	int insertSelective(WisdomParkPolicy record);

	WisdomParkPolicy selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(WisdomParkPolicy record);

	int updateByPrimaryKey(WisdomParkPolicy record);

	// 查询总数
	int selectTotal(@Param("page") WisdomParkPolicyPagination param);

	// 分页查询
	List<WisdomParkPolicy> selectInfo(@Param("page") WisdomParkPolicyPagination param);

	// 获取所选的user
	WisdomParkPolicy selectWisdomParkPolicy(@Param("id") String id);

	// 删除
	int deleteWisdomParkPolicy(@Param("id") String id);
	
}
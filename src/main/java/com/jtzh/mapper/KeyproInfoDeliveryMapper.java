package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.KeyproInfoDelivery;
import com.jtzh.pojo.KeyproInfoPagination;

public interface KeyproInfoDeliveryMapper {
	int deleteByPrimaryKey(Long id);

	int insert(KeyproInfoDelivery record);

	int insertSelective(KeyproInfoDelivery record);

	KeyproInfoDelivery selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(KeyproInfoDelivery record);

	int updateByPrimaryKey(KeyproInfoDelivery record);

	// 查询总数
	int selectTotal(@Param("page") KeyproInfoPagination param);

	// 分页查询
	List<KeyproInfoDelivery> selectInfo(@Param("page") KeyproInfoPagination param);

	// 查询具体的信息发布
	KeyproInfoDelivery selectInf(@Param("type") String type, @Param("id") String id);

	// 删除
	int deleteInf(@Param("id") String id);

	// 新建信息发布
	int insertInf(KeyproInfoDelivery record);
}
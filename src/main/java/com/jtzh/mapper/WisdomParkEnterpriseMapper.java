package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.WisdomParkEnterprise;
import com.jtzh.pojo.CountWisdomTalent;
import com.jtzh.pojo.WisdomParkEnterprisePagination;

public interface WisdomParkEnterpriseMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(WisdomParkEnterprise record);

	int insertSelective(WisdomParkEnterprise record);

	WisdomParkEnterprise selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(WisdomParkEnterprise record);

	int updateByPrimaryKey(WisdomParkEnterprise record);

	// 查询总数
	int selectTotal(@Param("page") WisdomParkEnterprisePagination param);

	// 分页查询
	List<WisdomParkEnterprise> selectInfo(@Param("page") WisdomParkEnterprisePagination param);

	// 查询具体的pro
	WisdomParkEnterprise selectWisdomParkEnterprise(@Param("id") String id);

	// 删除
	int deleteWisdomParkEnterprise(@Param("id") String id);
	
	// 获取企业坐标所有字段
	List<WisdomParkEnterprise> selectInfoWeb();
	
	List<CountWisdomTalent> countWEIndustryBelong();
	
	List<CountWisdomTalent> countWEParkBelong();
}
package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.InspectionRecord;
import com.jtzh.entity.WisdomParkTalent;
import com.jtzh.pojo.CountWisdomTalent;
import com.jtzh.pojo.WisdomParkTalentPagination;

public interface WisdomParkTalentMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(WisdomParkTalent record);

	int insertSelective(WisdomParkTalent record);

	WisdomParkTalent selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(WisdomParkTalent record);

	int updateByPrimaryKey(WisdomParkTalent record);

	// 查询总数
	int selectTotal(@Param("page") WisdomParkTalentPagination param);

	// 分页查询
	List<WisdomParkTalent> selectInfo(@Param("page") WisdomParkTalentPagination param);

	// 获取所选的user
	WisdomParkTalent selectWisdomParkTalent(@Param("id") String id);

	// 删除
	int deleteWisdomParkTalent(@Param("id") String id);
	
	// 获取人才坐标所有字段
	List<WisdomParkTalent> selectInfoWeb();
	
	List<CountWisdomTalent> countWTHighestMajor();
	
	List<CountWisdomTalent> countWTDecade();
}
package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.GovmgtLog;
import com.jtzh.pojo.GovmgtLogParam;

public interface GovmgtLogMapper {
	
		// 查询id
		GovmgtLog selectByPrimaryKey(Integer id);
		// 查询总数
		int selectTotal(@Param("page") GovmgtLogParam param);
		// 分页查询
		List<GovmgtLog> selectInfo(@Param("page") GovmgtLogParam param);
		// 根据id查询
		GovmgtLog getGovmgtLogInfo(@Param("id") String id);
		// 修改
		void updateGovmgtLog(GovmgtLog param);
		// 新建
		int addGovmgtLog(GovmgtLog meeting);
		// 删除
		int deleteGovmgtLog(@Param("id") String id);

}

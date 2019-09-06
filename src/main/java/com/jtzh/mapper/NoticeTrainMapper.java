package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.pojo.NoticeParam;
import com.jtzh.entity.NoticeTrain;

public interface NoticeTrainMapper {
	
	// 查询id
	NoticeTrain selectByPrimaryKey(Integer id);
	// 查询总数
	int selectTrainTotal(@Param("page") NoticeParam param);
	// 分页查询
	List<NoticeTrain> selectInfo(@Param("page") NoticeParam param);
	// 根据id查询
	NoticeTrain getNoticeTrain(@Param("id") String id);
	// 修改
	void updateNoticeTrain(NoticeTrain param);
	// 新建
	int addNoticeTrain(NoticeTrain record);
	// 删除
	int deleteNoticeTrain(@Param("id") String id);

}

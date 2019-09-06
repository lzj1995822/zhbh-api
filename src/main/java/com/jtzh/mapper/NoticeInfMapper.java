package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.dto.NoticeParamAndIds;
import com.jtzh.entity.NoticeInf;
import com.jtzh.pojo.NoticeParam;

public interface NoticeInfMapper {

	// 查询id
	NoticeInf selectByPrimaryKey(Integer id);

	// 查询总数
	int selectInfTotal(@Param("page") NoticeParam param);

	// 分页查询
	List<NoticeInf> selectInfo(@Param("page") NoticeParam param);

	int selectInfoTotalAPP(@Param("page") NoticeParam param);

	// 分页查询
	List<NoticeInf> selectInfoAPP(@Param("page") NoticeParam param);

	// 根据id查询
	NoticeInf getNoticeInf(@Param("id") String id);

	// 修改
	void updateNoticeInf(NoticeInf param);

	// 新建
	int addNoticeInf(NoticeInf record);

	// 删除
	int deleteNoticeInf(@Param("id") String id);

	// 分页查询
	List<NoticeInf> selectInfo2(@Param("page") NoticeParamAndIds param);

	// 查询总数
	int selectTotal2(@Param("page") NoticeParamAndIds param);
}

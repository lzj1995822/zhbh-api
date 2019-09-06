package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.NoticeLaw;
import com.jtzh.pojo.NoticeParam;

public interface NoticeLawMapper {
	
	// 查询id
	NoticeLaw selectByPrimaryKey(Integer id);
	// 查询总数
	int selectLawTotal(@Param("page") NoticeParam param);
	// 分页查询
	List<NoticeLaw> selectInfo(@Param("page") NoticeParam param);
	// 根据id查询
	NoticeLaw getNoticeLaw(@Param("id") String id);
	// 修改
	void updateNoticeLaw(NoticeLaw param);
	// 新建
	int addNoticeLaw(NoticeLaw record);
	// 删除
	int deleteNoticeLaw(@Param("id") String id);
		

}

package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.GovmgtProblem;
import com.jtzh.pojo.ProblemPagination;

public interface GovmgtProblemMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(GovmgtProblem record);

	int insertSelective(GovmgtProblem record);

	GovmgtProblem selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(GovmgtProblem record);

	int updateByPrimaryKey(GovmgtProblem record);

	// 查询总数
	int selectTotal(@Param("page") ProblemPagination param);

	// 分页查询
	List<GovmgtProblem> selectInfo(@Param("page") ProblemPagination param);

	// 查询具体的work
	GovmgtProblem selectProblem(@Param("id") String id);

	// 删除
	int deleteProblem(@Param("id") String id);

	// 新建work
	int insertProblem(GovmgtProblem param);
}
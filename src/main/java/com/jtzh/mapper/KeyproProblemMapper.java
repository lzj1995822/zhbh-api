package com.jtzh.mapper;

import java.util.List;

import com.jtzh.pojo.*;
import org.apache.ibatis.annotations.Param;

import com.jtzh.detail.pojo.KeyCoordinateRes;
import com.jtzh.entity.KeyproProblem;

public interface KeyproProblemMapper {
	int deleteByPrimaryKey(Integer id);
	int deleteBySourceId(@Param("sourceId") String sourceId,@Param("source") String source);
	int insert(KeyproProblem record);

	int insertSelective(KeyproProblem record);

	KeyproProblem selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(KeyproProblem record);

	int updateByPrimaryKey(KeyproProblem record);

	// 查询总数
	int selectTotal(@Param("page") ProblemPagination param);

	// 分页查询
	List<KeyproProblem> selectInfo(@Param("page") ProblemPagination param, @Param("name") String name);
	int selectCount(@Param("page") ProblemPagination param, @Param("name") String name);

	// 分页查询
	List<KeyproProblem> selectInfoApp(@Param("page") ProblemPagination param, @Param("name") String name);
	int selectCountApp(@Param("page") ProblemPagination param, @Param("name") String name);

	// 分页查询2
	List<KeyproProblem> selectInfo1(@Param("page") ProblemPagination param, @Param("name") String name);
	int selectCount1(@Param("page") ProblemPagination param, @Param("name") String name);

	// 分页查询web
	List<KeyproProblem> selectInfoWeb(@Param("page") ProblemPagination param);
	int selectCountWeb(@Param("page") ProblemPagination param);

	// 查询具体的work
	KeyproProblem selectProblem(@Param("id") String id);
	
	// 查询具体的work
	KeyproProblemVo selectProblemVo(@Param("id") String id);

	// 删除
	int deleteProblem(@Param("id") String id);

	// 新建work
	int insertProblem(KeyproProblem record);

	// 问题流程处理sql
	// 更新状态
	int updateStatus(@Param("id") String id, @Param("zt") String zt);

	int yilian(KeyproProblem record);

	int paifa(KeyproProblem record);

	int chuli(KeyproProblem record);

	int huitui(KeyproProblem record);

	int yishenghe(KeyproProblem record);

	int yuqi(@Param("zt") String zt);

	// 统计状态
	List<CountState> countProblemState();

	// 根据状态连表查看所有问题信息
	List<KeyproProblemResponse> findAllByState(@Param("state") String state);

	// 根据id连表查看所有问题信息
	List<KeyproProblemResponse> findByStateRelax(@Param("id") String id);

	// 查询所有坐标及id
	List<KeyCoordinateRes> getKeyCoordinate();
	
	List<KeyproProblemVo> selectProblemAndProName(@Param("page") ProblemPagination param, @Param("name") String name);
	
	List<CountKeypro> countProblemAllCountryside();
	
	List<CountQuarter> countProblemByYear(@Param("year")String year);

	//按类型统计数量
	List<CountType> countProblemType();


}
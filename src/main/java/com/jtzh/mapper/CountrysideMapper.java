package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideBuild;
import com.jtzh.pojo.CountrysideBuildCount;
import com.jtzh.pojo.CountrysideParam;

public interface CountrysideMapper {
	
	int insert(CountrysideBuild record);

	int insertSelective(CountrysideBuild record);

	CountrysideBuild selectByPrimaryKey(Integer id);
	
	// 查询总数
	int selectCouTotal(@Param("page") CountrysideParam param);

	// 分页查询
	List<CountrysideBuild> selectInfo(@Param("page") CountrysideParam param);

	// 根据id查询
	CountrysideBuild getCountrysideInfo(@Param("id") String id);
	
	// 删除
	int deleteCountryside(@Param("id") String id);

	// 新增可以返回主键
	int insertCountryside(CountrysideBuild record);
	
	// 修改
	void updateCountryside(CountrysideBuild param);
	
	// 神奇审核
	void testCountryside(CountrysideBuild param);
	
	// 查询
	List<CountrysideBuild> selectInfoAllxy(@Param("page") CountrysideParam param);
	
	// 提交验收
	void commitCountryside(CountrysideBuild param);
		
	// 验收审核
	void shenheCountryside(CountrysideBuild param);
	
	// 查询总数
	int selectCouTotal1(@Param("page") CountrysideParam param);

	// 分页查询
	List<CountrysideBuild> selectInfo1(@Param("page") CountrysideParam param);
	
	// 统计1
	Long getCountList1(CountrysideBuild param);
	
	// 统计2
	Long getCountList2(CountrysideBuild param);
	
	// 统计3
	Long getCountList3(CountrysideBuild param);
	
	List<CountrysideBuildCount> getapplyList();
	 
	List<CountrysideBuildCount> getexamineList();

}

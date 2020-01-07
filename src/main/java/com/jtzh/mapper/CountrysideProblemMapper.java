package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.CountrysideProblem;
import com.jtzh.pojo.CountIsdeleted;
import com.jtzh.pojo.CountQuarter;
import com.jtzh.pojo.CountrysideFind;
import com.jtzh.pojo.CountrysideProblemParam;

public interface CountrysideProblemMapper {
	
	int insert(CountrysideProblem record);

	int insertSelective(CountrysideProblem record);

	CountrysideProblem selectByPrimaryKey(Integer id);
	
	// 查询总数
	int selectCoPTotal(@Param("page") CountrysideProblemParam param);

	// 分页查询
	List<CountrysideProblem> selectInfo(@Param("page") CountrysideProblemParam param);

	// 根据id查询
	CountrysideProblem getCountrysideProblemInfo(@Param("id") String id);
	
	// 删除
	int deleteCountrysideProblem(@Param("id") String id);

	// 新增可以返回主键
	int insertCountrysideProblem(CountrysideProblem record);
	
	// 修改
	void updateCountrysideProblem(CountrysideProblem param);
	
	// 立案
	void Problemlian(CountrysideProblem param);
		
	// 派发
	void Problempaifa(CountrysideProblem param);
	
	List<CountrysideProblem> findbystate(@Param("page") CountrysideProblemParam param);

	List<CountrysideProblem> getDcl();
	
	List <CountrysideFind> findbyId(String id);
	
	// 查询总数
	int selectCocTotal(@Param("page") CountrysideProblemParam param);

	// 分页查询
	List<CountrysideFind> selectInfo1(@Param("page") CountrysideProblemParam param);
	
	// 查询总数
	int selectSbrTotal(@Param("page") CountrysideProblemParam param);

	// 分页查询
	List<CountrysideProblem> selectInfoSbr(@Param("page") CountrysideProblemParam param);
	
	// 查询总数
	int selectPfrTotal(@Param("page") CountrysideProblemParam param);

	// 分页查询
	List<CountrysideProblem> selectInfoPfr(@Param("page") CountrysideProblemParam param);
		
	// 查询总数
	int selectPeoTotal(@Param("page") CountrysideProblemParam param);

	// 分页查询
	List<CountrysideProblem> selectInfoPeo(@Param("page") CountrysideProblemParam param);
	
	// 派发
	void updateIsdeleted(CountrysideProblem param);

	// 根据id查询
	CountrysideProblem getxyInfo(@Param("id") String id);
	
	// 分页查询
	List<CountrysideProblem> selectInfoxy(@Param("page") CountrysideProblemParam param);
	
	// 查询
	List<CountrysideProblem> selectInfoAllxy(@Param("page") CountrysideProblemParam param);
	
	Long getCountListfeiqi();
	
    Long getCountListdaipaifa();
    
    Long getCountListchulizhong();
    
    Long getCountListdaishenhe();
    
    Long getCountListyijiean();
    
    List<CountIsdeleted> getCountListjidu(@Param("col")String year);
    
    List<CountIsdeleted> getCount();
    
 	Long getCountList(CountrysideProblem param);
 	
 	List<CountQuarter> countProblemByYear(@Param("year")String year);
}

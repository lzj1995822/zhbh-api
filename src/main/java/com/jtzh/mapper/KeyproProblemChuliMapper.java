package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.detail.pojo.KeySolveResponse;
import com.jtzh.entity.KeyproProblemChuli;
import com.jtzh.pojo.KeyproProblemReq;

public interface KeyproProblemChuliMapper {
    int deleteByPrimaryKey(Long id);

    int insert(KeyproProblemChuli record);

    int insertSelective(KeyproProblemChuli record);

    KeyproProblemChuli selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KeyproProblemChuli record);

    int updateByPrimaryKey(KeyproProblemChuli record);

    // 根据shangbaoid查询指派数目
 	int countAppoints(@Param("shangbaoid") String shangbaoid);
 	
 	// 根据shangbaoid查询已处理的数目
  	int countHasSolved(@Param("shangbaoid") String shangbaoid);
  	
  	// 根据shangbaoid查询已审核通过的数目
  	int countCheckedYes(@Param("shangbaoid") String shangbaoid);
  	
 // 根据shangbaoid查询已审核失败的数目
   	int countCheckedNo(@Param("shangbaoid") String shangbaoid);
    
    //审核
	int shenghe(KeyproProblemReq record);

	// 根据shangbaoid拉取处理信息 一条
	KeySolveResponse selectBySid(@Param("shangbaoid") String shangbaoid);
	
	// 根据shangbaoid拉取处理信息 一条
	KeySolveResponse selectBySolveId(@Param("solveId") String solveId);

	// 根据shangbaoid拉取处理信息 多条
	List<KeySolveResponse> selectAllBySid(@Param("shangbaoid") String shangbaoid);

	// 删除处理信息
	int deleteSolve(@Param("id") String id);

	KeyproProblemChuli selectProblemChuli(String id);
	
	//回退
	int huitui(KeyproProblemChuli record);
	
	 //处理
	int chuli(KeyproProblemChuli record);
	
	int insertChuli(KeyproProblemChuli record);
	
	//审核
	int returnSolve(KeyproProblemReq record);
	
}
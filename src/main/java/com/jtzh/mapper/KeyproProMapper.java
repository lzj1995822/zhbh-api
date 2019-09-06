package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.KeyproPro;
import com.jtzh.pojo.CountKeypro;
import com.jtzh.pojo.KbuildPagination;
import com.jtzh.pojo.KeyproBuildVo;

public interface KeyproProMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(KeyproPro record);

	int insertSelective(KeyproPro record);

	KeyproPro selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(KeyproPro record);

	int updateByPrimaryKey(KeyproPro record);

	// 查询总数
	int selectTotal(@Param("page") KbuildPagination param);

	// 分页查询
	List<KeyproPro> selectInfo(@Param("page") KbuildPagination param);

	// 查询具体的pro
	KeyproPro selectPro(@Param("id") String id);

	// 删除
	int deletePro(@Param("id") String id);

	// 新建pro
	int insertPro(KeyproPro record);

	// 为了导出进行的查询
	List<KeyproPro> getProList();

	// 查询所有坐标及id
	List<KeyproPro> getKeyProjectCoordinate();
	
	List<KeyproBuildVo> getProNameAndId();
	
	List<CountKeypro> countProAllCountryside();
}
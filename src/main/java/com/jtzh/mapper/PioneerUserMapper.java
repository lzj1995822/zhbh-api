package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerUser;
import com.jtzh.pojo.CountParty;
import com.jtzh.pojo.PioneerUserPagination;

public interface PioneerUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerUser record);

    int insertSelective(PioneerUser record);

    PioneerUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PioneerUser record);

    int updateByPrimaryKey(PioneerUser record);

	// 查询总数
	int selectTotal(@Param("page") PioneerUserPagination param);

	// 分页查询
	List<PioneerUser> selectInfo(@Param("page") PioneerUserPagination param);

	// 获取所选的user
	PioneerUser selectUser(@Param("id") String id);

	// 删除
	int deleteUser(@Param("id") String id);

	// 统计党组织对应的人数
	List<CountParty> countNumber();

	// 为了导出进行的查询
	List<PioneerUser> getUserList();

}
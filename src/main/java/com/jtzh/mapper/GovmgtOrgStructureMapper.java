package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.GovmgtOrgStructure;
import com.jtzh.pojo.TreeParam;

public interface GovmgtOrgStructureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GovmgtOrgStructure record);

    int insertSelective(GovmgtOrgStructure record);

    GovmgtOrgStructure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GovmgtOrgStructure record);

    int updateByPrimaryKey(GovmgtOrgStructure record);

	// 根据父id获取子list
	List<TreeParam> selectBySId(String id);
}
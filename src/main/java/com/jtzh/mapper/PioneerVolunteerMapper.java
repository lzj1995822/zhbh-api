package com.jtzh.mapper;

import java.util.List;

import com.jtzh.model.VolunteerResultModel;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerVolunteer;
import com.jtzh.pojo.KeyParam;

public interface PioneerVolunteerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerVolunteer record);
    
    int getZyzInfoBySjh(@Param("sfz")String sfz);

    int insertSelective(PioneerVolunteer record);

    PioneerVolunteer selectByPrimaryKey(@Param("id")String id);
    
    int getZyzTotal(@Param("keyparam")KeyParam param);
    
    List<PioneerVolunteer> getZyz(@Param("keyparam")KeyParam param);

    int updateByPrimaryKeySelective(PioneerVolunteer record);

    int updateByPrimaryKey(PioneerVolunteer record);
    int updateById(@Param("id")String id);
    
    int updateZyzZt(@Param("id")String id,@Param("zt")String zt);

    List<VolunteerResultModel> countByMonthAndType();
}
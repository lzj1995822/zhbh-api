package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.PioneerVolunteerServiceE;
import com.jtzh.pojo.KeyParam;

public interface PioneerVolunteerServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PioneerVolunteerServiceE record);

    int insertSelective(PioneerVolunteerServiceE record);

    PioneerVolunteerServiceE selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PioneerVolunteerServiceE record);

    int updateByPrimaryKey(PioneerVolunteerServiceE record);
    
    int getZyzHdTotal(@Param("keyparam")KeyParam keyParam);
    
    List<PioneerVolunteerServiceE> getZyzHd(@Param("keyparam")KeyParam keyParam);
    int getZyzHdTotalApp(@Param("keyparam")KeyParam keyParam);
    
    List<PioneerVolunteerServiceE> getZyzHdApp(@Param("keyparam")KeyParam keyParam);
    
    int getZyzHdTotalAppYjs(@Param("keyparam")KeyParam keyParam);
    
    List<PioneerVolunteerServiceE> getZyzHdAppYjs(@Param("keyparam")KeyParam keyParam);

    int updateYjs(@Param("id") String id);
}
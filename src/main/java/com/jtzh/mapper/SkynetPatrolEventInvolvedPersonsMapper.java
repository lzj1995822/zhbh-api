package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.SkynetPatrolEventInvolvedPersons;

public abstract interface SkynetPatrolEventInvolvedPersonsMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteBySPEventID(Long paramLong);
  
  public abstract int insert(SkynetPatrolEventInvolvedPersons paramSkynetPatrolEventInvolvedPersons);
  
  public abstract SkynetPatrolEventInvolvedPersons selectByPrimaryKey(Long paramLong);
  
  public abstract List<SkynetPatrolEventInvolvedPersons> selectBySPEventID(@Param("id") Long paramLong);
  
  public abstract List<SkynetPatrolEventInvolvedPersons> selectAll();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEventInvolvedPersons paramSkynetPatrolEventInvolvedPersons);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventInvolvedPersonsMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
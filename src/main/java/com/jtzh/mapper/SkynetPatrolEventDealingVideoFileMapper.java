package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SkynetPatrolEventDealingVideoFile;

public abstract interface SkynetPatrolEventDealingVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SkynetPatrolEventDealingVideoFile paramSkynetPatrolEventDealingVideoFile);
  
  public abstract SkynetPatrolEventDealingVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract SkynetPatrolEventDealingVideoFile selectBySkynetPatrolEventDealingID(Long paramLong);
  
  public abstract List<SkynetPatrolEventDealingVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEventDealingVideoFile paramSkynetPatrolEventDealingVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventDealingVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SkynetPatrolEventVideoFile;

public abstract interface SkynetPatrolEventVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByFileID(Long paramLong);
  
  public abstract int insert(SkynetPatrolEventVideoFile paramSkynetPatrolEventVideoFile);
  
  public abstract SkynetPatrolEventVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract SkynetPatrolEventVideoFile selectBySPEventID(Long paramLong);
  
  public abstract List<SkynetPatrolEventVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEventVideoFile paramSkynetPatrolEventVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
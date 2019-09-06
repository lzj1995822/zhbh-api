package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SkynetPatrolEventPicture;

public abstract interface SkynetPatrolEventPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByPictureID(Long paramLong);
  
  public abstract int insert(SkynetPatrolEventPicture paramSkynetPatrolEventPicture);
  
  public abstract SkynetPatrolEventPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<SkynetPatrolEventPicture> selectBySPEventID(Long paramLong);
  
  public abstract List<SkynetPatrolEventPicture> selectAll();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEventPicture paramSkynetPatrolEventPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
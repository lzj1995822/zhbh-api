package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.DisputeEventPicture;

public abstract interface DisputeEventPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByPictureID(Long paramLong);
  
  public abstract int insert(DisputeEventPicture paramDisputeEventPicture);
  
  public abstract DisputeEventPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<DisputeEventPicture> selectAll();
  
  public abstract List<DisputeEventPicture> selectByDisputeEventID(Long paramLong);
  
  public abstract int updateByPrimaryKey(DisputeEventPicture paramDisputeEventPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
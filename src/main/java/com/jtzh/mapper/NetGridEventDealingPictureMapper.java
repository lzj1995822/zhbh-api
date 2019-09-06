package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.NetGridEventDealingPicture;

public abstract interface NetGridEventDealingPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventDealingPicture paramNetGridEventDealingPicture);
  
  public abstract NetGridEventDealingPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventDealingPicture> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventDealingPicture paramNetGridEventDealingPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventDealingPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
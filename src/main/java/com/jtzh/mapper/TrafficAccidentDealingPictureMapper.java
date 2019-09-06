package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.TrafficAccidentDealingPicture;

public abstract interface TrafficAccidentDealingPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(TrafficAccidentDealingPicture paramTrafficAccidentDealingPicture);
  
  public abstract TrafficAccidentDealingPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccidentDealingPicture> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentDealingPicture paramTrafficAccidentDealingPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentDealingPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
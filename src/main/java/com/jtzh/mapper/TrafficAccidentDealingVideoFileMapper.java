package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.TrafficAccidentDealingVideoFile;

public abstract interface TrafficAccidentDealingVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(TrafficAccidentDealingVideoFile paramTrafficAccidentDealingVideoFile);
  
  public abstract TrafficAccidentDealingVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccidentDealingVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentDealingVideoFile paramTrafficAccidentDealingVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentDealingVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
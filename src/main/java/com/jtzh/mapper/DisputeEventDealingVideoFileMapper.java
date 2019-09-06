package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.DisputeEventDealingVideoFile;

public abstract interface DisputeEventDealingVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(DisputeEventDealingVideoFile paramDisputeEventDealingVideoFile);
  
  public abstract DisputeEventDealingVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract List<DisputeEventDealingVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(DisputeEventDealingVideoFile paramDisputeEventDealingVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventDealingVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
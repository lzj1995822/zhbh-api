package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.NetGridEventDealingVideoFile;

public abstract interface NetGridEventDealingVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventDealingVideoFile paramNetGridEventDealingVideoFile);
  
  public abstract NetGridEventDealingVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventDealingVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventDealingVideoFile paramNetGridEventDealingVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventDealingVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SSEventDealingVideoFile;

public abstract interface SSEventDealingVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SSEventDealingVideoFile paramSSEventDealingVideoFile);
  
  public abstract SSEventDealingVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract List<SSEventDealingVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(SSEventDealingVideoFile paramSSEventDealingVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SSEventDealingVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
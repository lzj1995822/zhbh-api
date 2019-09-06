package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.DisputeEventVideoFile;

public abstract interface DisputeEventVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByFileID(Long paramLong);
  
  public abstract int insert(DisputeEventVideoFile paramDisputeEventVideoFile);
  
  public abstract DisputeEventVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract DisputeEventVideoFile selectByDisputeEventID(Long paramLong);
  
  public abstract List<DisputeEventVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(DisputeEventVideoFile paramDisputeEventVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
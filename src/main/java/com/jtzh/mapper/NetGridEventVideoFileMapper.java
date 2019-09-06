package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.NetGridEventVideoFile;

public abstract interface NetGridEventVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventVideoFile paramNetGridEventVideoFile);
  
  public abstract NetGridEventVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventVideoFile paramNetGridEventVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
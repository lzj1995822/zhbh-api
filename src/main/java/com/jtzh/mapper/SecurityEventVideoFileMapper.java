package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SecurityEventVideoFile;

public abstract interface SecurityEventVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByFileID(Long paramLong);
  
  public abstract int insert(SecurityEventVideoFile paramSecurityEventVideoFile);
  
  public abstract SecurityEventVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract SecurityEventVideoFile selectByFileID(Long paramLong);
  
  public abstract SecurityEventVideoFile selectBySSEventID(Long paramLong);
  
  public abstract List<SecurityEventVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(SecurityEventVideoFile paramSecurityEventVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SecurityEventVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
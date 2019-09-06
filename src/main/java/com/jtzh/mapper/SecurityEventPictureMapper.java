package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SecurityEventPicture;

public abstract interface SecurityEventPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByPictureID(Long paramLong);
  
  public abstract int insert(SecurityEventPicture paramSecurityEventPicture);
  
  public abstract SecurityEventPicture selectByPrimaryKey(Long paramLong);
  
  public abstract SecurityEventPicture selectByPictureID(Long paramLong);
  
  public abstract List<SecurityEventPicture> selectBySSEventID(Long paramLong);
  
  public abstract List<SecurityEventPicture> selectAll();
  
  public abstract int updateByPrimaryKey(SecurityEventPicture paramSecurityEventPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SecurityEventPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
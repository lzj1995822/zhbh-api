package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.NetGridEventPicture;

public abstract interface NetGridEventPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventPicture paramNetGridEventPicture);
  
  public abstract NetGridEventPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventPicture> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventPicture paramNetGridEventPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
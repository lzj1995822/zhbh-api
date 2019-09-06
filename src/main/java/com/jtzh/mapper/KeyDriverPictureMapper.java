package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.KeyDriverPicture;

public abstract interface KeyDriverPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(KeyDriverPicture paramKeyDriverPicture);
  
  public abstract KeyDriverPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<KeyDriverPicture> selectAll();
  
  public abstract int updateByPrimaryKey(KeyDriverPicture paramKeyDriverPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\KeyDriverPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
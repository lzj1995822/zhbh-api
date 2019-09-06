package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.EnterprisePicture;

public abstract interface EnterprisePictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByUSCode(String paramString);
  
  public abstract int insert(EnterprisePicture paramEnterprisePicture);
  
  public abstract EnterprisePicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<EnterprisePicture> selectAll();
  
  public abstract int updateByPrimaryKey(EnterprisePicture paramEnterprisePicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\EnterprisePictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
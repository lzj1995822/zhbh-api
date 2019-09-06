package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.ServedPersonPhoto;

public abstract interface ServedPersonPhotoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(ServedPersonPhoto paramServedPersonPhoto);
  
  public abstract ServedPersonPhoto selectByPrimaryKey(Long paramLong);
  
  public abstract List<ServedPersonPhoto> selectAll();
  
  public abstract int updateByPrimaryKey(ServedPersonPhoto paramServedPersonPhoto);
  
  public abstract List<ServedPersonPhoto> selectByServedPersonID(@Param("servedPersonID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedPersonPhotoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.ServedRecordPicture;

public abstract interface ServedRecordPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByPictureID(@Param("id") Long paramLong);
  
  public abstract int insert(ServedRecordPicture paramServedRecordPicture);
  
  public abstract ServedRecordPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<ServedRecordPicture> selectAll();
  
  public abstract List<ServedRecordPicture> selectByRecordID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(ServedRecordPicture paramServedRecordPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedRecordPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
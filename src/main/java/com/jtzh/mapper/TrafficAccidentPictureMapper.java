package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.TrafficAccidentPicture;

public abstract interface TrafficAccidentPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByPictureID(@Param("id") Long paramLong);
  
  public abstract int insert(TrafficAccidentPicture paramTrafficAccidentPicture);
  
  public abstract TrafficAccidentPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccidentPicture> selectByTrafficAccidentID(@Param("id") Long paramLong);
  
  public abstract List<TrafficAccidentPicture> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentPicture paramTrafficAccidentPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
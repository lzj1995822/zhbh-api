package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.TrafficAccidentVideoFile;

public abstract interface TrafficAccidentVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByFileID(@Param("id") Long paramLong);
  
  public abstract int insert(TrafficAccidentVideoFile paramTrafficAccidentVideoFile);
  
  public abstract TrafficAccidentVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract TrafficAccidentVideoFile selectByTrafficAccidentID(@Param("id") Long paramLong);
  
  public abstract List<TrafficAccidentVideoFile> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentVideoFile paramTrafficAccidentVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
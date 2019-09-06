package com.jtzh.mapper;

import com.jtzh.vo.trafficAccident.TrafficAccidentDealingVO;
import com.jtzh.entity.TrafficAccidentDealing;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface TrafficAccidentDealingMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(TrafficAccidentDealing paramTrafficAccidentDealing);
  
  public abstract TrafficAccidentDealing selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccidentDealingVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract List<TrafficAccidentDealing> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentDealing paramTrafficAccidentDealing);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentDealingMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import com.jtzh.vo.trafficAccident.TrafficAccidentDistributeVO;
import com.jtzh.entity.TrafficAccidentDistribute;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface TrafficAccidentDistributeMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(TrafficAccidentDistribute paramTrafficAccidentDistribute);
  
  public abstract TrafficAccidentDistribute selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccidentDistributeVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract List<TrafficAccidentDistribute> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentDistribute paramTrafficAccidentDistribute);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentDistributeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import com.jtzh.vo.trafficAccident.TrafficAccidentCheckedVO;
import com.jtzh.entity.TrafficAccidentChecked;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface TrafficAccidentCheckedMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(TrafficAccidentChecked paramTrafficAccidentChecked);
  
  public abstract TrafficAccidentChecked selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccidentCheckedVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract List<TrafficAccidentChecked> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentChecked paramTrafficAccidentChecked);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentCheckedMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
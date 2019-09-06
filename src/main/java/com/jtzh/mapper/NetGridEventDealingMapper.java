package com.jtzh.mapper;

import com.jtzh.vo.netGrid.NetGridEventDealingVO;
import com.jtzh.entity.NetGridEventDealing;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface NetGridEventDealingMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventDealing paramNetGridEventDealing);
  
  public abstract NetGridEventDealing selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventDealingVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract List<NetGridEventDealing> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventDealing paramNetGridEventDealing);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventDealingMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
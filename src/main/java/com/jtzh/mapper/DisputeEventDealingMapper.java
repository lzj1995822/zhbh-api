package com.jtzh.mapper;

import com.jtzh.vo.dispute.DisputeEventDealingVO;
import com.jtzh.entity.DisputeEventDealing;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface DisputeEventDealingMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(DisputeEventDealing paramDisputeEventDealing);
  
  public abstract DisputeEventDealing selectByPrimaryKey(Long paramLong);
  
  public abstract List<DisputeEventDealing> selectAll();
  
  public abstract List<DisputeEventDealingVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(DisputeEventDealing paramDisputeEventDealing);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventDealingMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
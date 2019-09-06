package com.jtzh.mapper;

import com.jtzh.vo.skynet.SPDealingVO;
import com.jtzh.entity.SkynetPatrolEventDealing;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SkynetPatrolEventDealingMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SkynetPatrolEventDealing paramSkynetPatrolEventDealing);
  
  public abstract SkynetPatrolEventDealing selectByPrimaryKey(Long paramLong);
  
  public abstract List<SPDealingVO> selectBySPEventID(@Param("id") Long paramLong);
  
  public abstract List<SkynetPatrolEventDealing> selectAll();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEventDealing paramSkynetPatrolEventDealing);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventDealingMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import com.jtzh.vo.ss.SSDealingVO;
import com.jtzh.entity.SSEventDealing;

import java.util.List;

public abstract interface SSEventDealingMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SSEventDealing paramSSEventDealing);
  
  public abstract SSEventDealing selectByPrimaryKey(Long paramLong);
  
  public abstract List<SSDealingVO> selectByEventID(Long paramLong);
  
  public abstract List<SSEventDealing> selectAll();
  
  public abstract int updateByPrimaryKey(SSEventDealing paramSSEventDealing);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SSEventDealingMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
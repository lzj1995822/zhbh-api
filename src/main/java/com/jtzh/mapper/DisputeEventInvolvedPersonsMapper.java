package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.DisputeEventInvolvedPersons;

public abstract interface DisputeEventInvolvedPersonsMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(DisputeEventInvolvedPersons paramDisputeEventInvolvedPersons);
  
  public abstract DisputeEventInvolvedPersons selectByPrimaryKey(Long paramLong);
  
  public abstract List<DisputeEventInvolvedPersons> selectAll();
  
  public abstract List<DisputeEventInvolvedPersons> selectByEventID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(DisputeEventInvolvedPersons paramDisputeEventInvolvedPersons);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventInvolvedPersonsMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
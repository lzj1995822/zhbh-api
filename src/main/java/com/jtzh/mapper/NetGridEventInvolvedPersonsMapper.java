package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.NetGridEventInvolvedPersons;

public abstract interface NetGridEventInvolvedPersonsMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventInvolvedPersons paramNetGridEventInvolvedPersons);
  
  public abstract NetGridEventInvolvedPersons selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventInvolvedPersons> selectByEventID(@Param("id") Long paramLong);
  
  public abstract List<NetGridEventInvolvedPersons> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventInvolvedPersons paramNetGridEventInvolvedPersons);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventInvolvedPersonsMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
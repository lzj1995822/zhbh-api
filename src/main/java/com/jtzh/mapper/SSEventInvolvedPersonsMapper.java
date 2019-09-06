package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SSEventInvolvedPersons;

public abstract interface SSEventInvolvedPersonsMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteBySSEventID(Long paramLong);
  
  public abstract int insert(SSEventInvolvedPersons paramSSEventInvolvedPersons);
  
  public abstract SSEventInvolvedPersons selectByPrimaryKey(Long paramLong);
  
  public abstract List<SSEventInvolvedPersons> selectBySSEventID(Long paramLong);
  
  public abstract List<SSEventInvolvedPersons> selectAll();
  
  public abstract int updateByPrimaryKey(SSEventInvolvedPersons paramSSEventInvolvedPersons);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SSEventInvolvedPersonsMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
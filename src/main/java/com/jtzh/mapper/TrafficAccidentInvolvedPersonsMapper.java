package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.TrafficAccidentInvolvedPersons;

public abstract interface TrafficAccidentInvolvedPersonsMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(TrafficAccidentInvolvedPersons paramTrafficAccidentInvolvedPersons);
  
  public abstract TrafficAccidentInvolvedPersons selectByPrimaryKey(Long paramLong);
  
  public abstract List<TrafficAccidentInvolvedPersons> selectByTrafficAccidentID(Long paramLong);
  
  public abstract List<TrafficAccidentInvolvedPersons> selectAll();
  
  public abstract int updateByPrimaryKey(TrafficAccidentInvolvedPersons paramTrafficAccidentInvolvedPersons);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TrafficAccidentInvolvedPersonsMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
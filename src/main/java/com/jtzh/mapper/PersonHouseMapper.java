package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.PersonHouse;

public abstract interface PersonHouseMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(PersonHouse paramPersonHouse);
  
  public abstract PersonHouse selectByPrimaryKey(Long paramLong);
  
  public abstract List<PersonHouse> selectAll();
  
  public abstract int updateByPrimaryKey(PersonHouse paramPersonHouse);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\PersonHouseMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
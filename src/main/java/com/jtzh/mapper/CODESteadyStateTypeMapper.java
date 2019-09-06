package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESteadyStateType;

public abstract interface CODESteadyStateTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESteadyStateType paramCODESteadyStateType);
  
  public abstract CODESteadyStateType selectByPrimaryKey(String paramString);
  
  public abstract List<CODESteadyStateType> selectAll();
  
  public abstract int updateByPrimaryKey(CODESteadyStateType paramCODESteadyStateType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESteadyStateTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESkynetPatrolEventType;

public abstract interface CODESkynetPatrolEventTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESkynetPatrolEventType paramCODESkynetPatrolEventType);
  
  public abstract CODESkynetPatrolEventType selectByPrimaryKey(String paramString);
  
  public abstract List<CODESkynetPatrolEventType> selectAll();
  
  public abstract int updateByPrimaryKey(CODESkynetPatrolEventType paramCODESkynetPatrolEventType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESkynetPatrolEventTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
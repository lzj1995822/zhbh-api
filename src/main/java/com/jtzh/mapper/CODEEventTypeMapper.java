package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEEventType;

public abstract interface CODEEventTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEEventType paramCODEEventType);
  
  public abstract CODEEventType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEEventType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEEventType paramCODEEventType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEEventTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
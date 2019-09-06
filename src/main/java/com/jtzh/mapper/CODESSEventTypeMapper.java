package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESSEventType;

public abstract interface CODESSEventTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESSEventType paramCODESSEventType);
  
  public abstract CODESSEventType selectByPrimaryKey(String paramString);
  
  public abstract List<CODESSEventType> selectAll();
  
  public abstract int updateByPrimaryKey(CODESSEventType paramCODESSEventType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESSEventTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
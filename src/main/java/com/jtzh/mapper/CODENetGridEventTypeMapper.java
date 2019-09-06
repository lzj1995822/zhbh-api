package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODENetGridEventType;

public abstract interface CODENetGridEventTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODENetGridEventType paramCODENetGridEventType);
  
  public abstract CODENetGridEventType selectByPrimaryKey(String paramString);
  
  public abstract List<CODENetGridEventType> selectAll();
  
  public abstract int updateByPrimaryKey(CODENetGridEventType paramCODENetGridEventType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODENetGridEventTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
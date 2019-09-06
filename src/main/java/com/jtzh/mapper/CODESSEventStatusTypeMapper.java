package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESSEventStatusType;

public abstract interface CODESSEventStatusTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESSEventStatusType paramCODESSEventStatusType);
  
  public abstract CODESSEventStatusType selectByPrimaryKey(String paramString);
  
  public abstract List<CODESSEventStatusType> selectAll();
  
  public abstract int updateByPrimaryKey(CODESSEventStatusType paramCODESSEventStatusType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESSEventStatusTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
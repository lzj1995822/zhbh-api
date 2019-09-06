package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEEventStatusType;

public abstract interface CODEEventStatusTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEEventStatusType paramCODEEventStatusType);
  
  public abstract CODEEventStatusType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEEventStatusType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEEventStatusType paramCODEEventStatusType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEEventStatusTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
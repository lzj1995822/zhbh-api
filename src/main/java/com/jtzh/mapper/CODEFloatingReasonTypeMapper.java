package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEFloatingReasonType;

public abstract interface CODEFloatingReasonTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEFloatingReasonType paramCODEFloatingReasonType);
  
  public abstract CODEFloatingReasonType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEFloatingReasonType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEFloatingReasonType paramCODEFloatingReasonType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEFloatingReasonTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
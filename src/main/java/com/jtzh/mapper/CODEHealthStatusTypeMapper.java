package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEHealthStatusType;

public abstract interface CODEHealthStatusTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEHealthStatusType paramCODEHealthStatusType);
  
  public abstract CODEHealthStatusType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEHealthStatusType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEHealthStatusType paramCODEHealthStatusType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEHealthStatusTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
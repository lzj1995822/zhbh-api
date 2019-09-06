package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEInfectedWayType;

public abstract interface CODEInfectedWayTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEInfectedWayType paramCODEInfectedWayType);
  
  public abstract CODEInfectedWayType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEInfectedWayType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEInfectedWayType paramCODEInfectedWayType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEInfectedWayTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
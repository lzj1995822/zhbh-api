package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEEconomicSourceType;

public abstract interface CODEEconomicSourceTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEEconomicSourceType paramCODEEconomicSourceType);
  
  public abstract CODEEconomicSourceType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEEconomicSourceType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEEconomicSourceType paramCODEEconomicSourceType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEEconomicSourceTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
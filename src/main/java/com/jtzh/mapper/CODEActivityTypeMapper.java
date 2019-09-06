package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEActivityType;

public abstract interface CODEActivityTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEActivityType paramCODEActivityType);
  
  public abstract CODEActivityType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEActivityType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEActivityType paramCODEActivityType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEActivityTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODELevelType;

public abstract interface CODELevelTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODELevelType paramCODELevelType);
  
  public abstract CODELevelType selectByPrimaryKey(String paramString);
  
  public abstract List<CODELevelType> selectAll();
  
  public abstract int updateByPrimaryKey(CODELevelType paramCODELevelType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODELevelTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
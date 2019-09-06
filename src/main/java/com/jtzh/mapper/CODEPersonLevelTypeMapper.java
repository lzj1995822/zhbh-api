package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEPersonLevelType;

public abstract interface CODEPersonLevelTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEPersonLevelType paramCODEPersonLevelType);
  
  public abstract CODEPersonLevelType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEPersonLevelType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEPersonLevelType paramCODEPersonLevelType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEPersonLevelTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
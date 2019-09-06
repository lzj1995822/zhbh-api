package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEPersonPositionType;

public abstract interface CODEPersonPositionTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEPersonPositionType paramCODEPersonPositionType);
  
  public abstract CODEPersonPositionType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEPersonPositionType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEPersonPositionType paramCODEPersonPositionType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEPersonPositionTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
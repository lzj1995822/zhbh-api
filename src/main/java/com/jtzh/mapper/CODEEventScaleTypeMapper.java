package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEEventScaleType;

public abstract interface CODEEventScaleTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEEventScaleType paramCODEEventScaleType);
  
  public abstract CODEEventScaleType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEEventScaleType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEEventScaleType paramCODEEventScaleType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEEventScaleTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
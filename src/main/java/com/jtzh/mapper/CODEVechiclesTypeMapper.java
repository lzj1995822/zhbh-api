package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEVechiclesType;

public abstract interface CODEVechiclesTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEVechiclesType paramCODEVechiclesType);
  
  public abstract CODEVechiclesType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEVechiclesType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEVechiclesType paramCODEVechiclesType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEVechiclesTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
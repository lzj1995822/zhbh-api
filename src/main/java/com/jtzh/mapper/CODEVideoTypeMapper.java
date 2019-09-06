package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEVideoType;

public abstract interface CODEVideoTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEVideoType paramCODEVideoType);
  
  public abstract CODEVideoType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEVideoType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEVideoType paramCODEVideoType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEVideoTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
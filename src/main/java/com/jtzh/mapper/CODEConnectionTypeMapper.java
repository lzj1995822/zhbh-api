package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEConnectionType;

public abstract interface CODEConnectionTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEConnectionType paramCODEConnectionType);
  
  public abstract CODEConnectionType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEConnectionType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEConnectionType paramCODEConnectionType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEConnectionTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
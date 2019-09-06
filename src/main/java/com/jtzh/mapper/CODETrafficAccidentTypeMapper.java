package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODETrafficAccidentType;

public abstract interface CODETrafficAccidentTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODETrafficAccidentType paramCODETrafficAccidentType);
  
  public abstract CODETrafficAccidentType selectByPrimaryKey(String paramString);
  
  public abstract List<CODETrafficAccidentType> selectAll();
  
  public abstract int updateByPrimaryKey(CODETrafficAccidentType paramCODETrafficAccidentType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODETrafficAccidentTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
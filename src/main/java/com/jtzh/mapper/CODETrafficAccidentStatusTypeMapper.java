package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODETrafficAccidentStatusType;

public abstract interface CODETrafficAccidentStatusTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODETrafficAccidentStatusType paramCODETrafficAccidentStatusType);
  
  public abstract CODETrafficAccidentStatusType selectByPrimaryKey(String paramString);
  
  public abstract List<CODETrafficAccidentStatusType> selectAll();
  
  public abstract int updateByPrimaryKey(CODETrafficAccidentStatusType paramCODETrafficAccidentStatusType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODETrafficAccidentStatusTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
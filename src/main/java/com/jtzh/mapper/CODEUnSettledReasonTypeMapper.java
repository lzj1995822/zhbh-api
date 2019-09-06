package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEUnSettledReasonType;

public abstract interface CODEUnSettledReasonTypeMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(CODEUnSettledReasonType paramCODEUnSettledReasonType);
  
  public abstract CODEUnSettledReasonType selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<CODEUnSettledReasonType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEUnSettledReasonType paramCODEUnSettledReasonType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEUnSettledReasonTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
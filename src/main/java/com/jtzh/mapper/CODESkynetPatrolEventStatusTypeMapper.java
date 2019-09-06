package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESkynetPatrolEventStatusType;

public abstract interface CODESkynetPatrolEventStatusTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESkynetPatrolEventStatusType paramCODESkynetPatrolEventStatusType);
  
  public abstract CODESkynetPatrolEventStatusType selectByPrimaryKey(String paramString);
  
  public abstract List<CODESkynetPatrolEventStatusType> selectAll();
  
  public abstract int updateByPrimaryKey(CODESkynetPatrolEventStatusType paramCODESkynetPatrolEventStatusType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESkynetPatrolEventStatusTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
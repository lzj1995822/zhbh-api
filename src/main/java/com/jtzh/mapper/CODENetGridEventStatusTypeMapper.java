package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODENetGridEventStatusType;

public abstract interface CODENetGridEventStatusTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODENetGridEventStatusType paramCODENetGridEventStatusType);
  
  public abstract CODENetGridEventStatusType selectByPrimaryKey(String paramString);
  
  public abstract List<CODENetGridEventStatusType> selectAll();
  
  public abstract int updateByPrimaryKey(CODENetGridEventStatusType paramCODENetGridEventStatusType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODENetGridEventStatusTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
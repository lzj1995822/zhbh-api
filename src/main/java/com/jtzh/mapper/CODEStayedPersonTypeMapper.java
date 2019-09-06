package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEStayedPersonType;

public abstract interface CODEStayedPersonTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEStayedPersonType paramCODEStayedPersonType);
  
  public abstract CODEStayedPersonType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEStayedPersonType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEStayedPersonType paramCODEStayedPersonType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEStayedPersonTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEServedPersonType;

public abstract interface CODEServedPersonTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEServedPersonType paramCODEServedPersonType);
  
  public abstract CODEServedPersonType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEServedPersonType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEServedPersonType paramCODEServedPersonType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEServedPersonTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
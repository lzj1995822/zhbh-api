package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEHiddenDangerType;

public abstract interface CODEHiddenDangerTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEHiddenDangerType paramCODEHiddenDangerType);
  
  public abstract CODEHiddenDangerType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEHiddenDangerType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEHiddenDangerType paramCODEHiddenDangerType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEHiddenDangerTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
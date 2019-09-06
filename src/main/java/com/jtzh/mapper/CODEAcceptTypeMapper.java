package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEAcceptType;

public abstract interface CODEAcceptTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEAcceptType paramCODEAcceptType);
  
  public abstract CODEAcceptType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEAcceptType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEAcceptType paramCODEAcceptType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEAcceptTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
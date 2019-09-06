package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODECaseType;

public abstract interface CODECaseTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODECaseType paramCODECaseType);
  
  public abstract CODECaseType selectByPrimaryKey(String paramString);
  
  public abstract List<CODECaseType> selectAll();
  
  public abstract int updateByPrimaryKey(CODECaseType paramCODECaseType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODECaseTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
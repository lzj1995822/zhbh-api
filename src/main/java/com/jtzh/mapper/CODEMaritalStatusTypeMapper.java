package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEMaritalStatusType;

public abstract interface CODEMaritalStatusTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEMaritalStatusType paramCODEMaritalStatusType);
  
  public abstract CODEMaritalStatusType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEMaritalStatusType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEMaritalStatusType paramCODEMaritalStatusType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEMaritalStatusTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
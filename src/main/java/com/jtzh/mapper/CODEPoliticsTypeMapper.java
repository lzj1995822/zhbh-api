package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEPoliticsType;

public abstract interface CODEPoliticsTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEPoliticsType paramCODEPoliticsType);
  
  public abstract CODEPoliticsType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEPoliticsType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEPoliticsType paramCODEPoliticsType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEPoliticsTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEHiddenTroubleType;

public abstract interface CODEHiddenTroubleTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEHiddenTroubleType paramCODEHiddenTroubleType);
  
  public abstract CODEHiddenTroubleType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEHiddenTroubleType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEHiddenTroubleType paramCODEHiddenTroubleType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEHiddenTroubleTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
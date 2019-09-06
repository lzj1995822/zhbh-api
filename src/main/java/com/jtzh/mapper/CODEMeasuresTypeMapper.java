package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEMeasuresType;

public abstract interface CODEMeasuresTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEMeasuresType paramCODEMeasuresType);
  
  public abstract CODEMeasuresType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEMeasuresType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEMeasuresType paramCODEMeasuresType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEMeasuresTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
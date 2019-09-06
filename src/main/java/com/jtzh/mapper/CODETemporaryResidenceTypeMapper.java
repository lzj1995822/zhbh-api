package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODETemporaryResidenceType;

public abstract interface CODETemporaryResidenceTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODETemporaryResidenceType paramCODETemporaryResidenceType);
  
  public abstract CODETemporaryResidenceType selectByPrimaryKey(String paramString);
  
  public abstract List<CODETemporaryResidenceType> selectAll();
  
  public abstract int updateByPrimaryKey(CODETemporaryResidenceType paramCODETemporaryResidenceType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODETemporaryResidenceTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
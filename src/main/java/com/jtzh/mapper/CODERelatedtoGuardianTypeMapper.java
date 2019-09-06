package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODERelatedtoGuardianType;

public abstract interface CODERelatedtoGuardianTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODERelatedtoGuardianType paramCODERelatedtoGuardianType);
  
  public abstract CODERelatedtoGuardianType selectByPrimaryKey(String paramString);
  
  public abstract List<CODERelatedtoGuardianType> selectAll();
  
  public abstract int updateByPrimaryKey(CODERelatedtoGuardianType paramCODERelatedtoGuardianType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODERelatedtoGuardianTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
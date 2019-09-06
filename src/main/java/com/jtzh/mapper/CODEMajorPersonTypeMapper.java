package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEMajorPersonType;

public abstract interface CODEMajorPersonTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEMajorPersonType paramCODEMajorPersonType);
  
  public abstract CODEMajorPersonType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEMajorPersonType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEMajorPersonType paramCODEMajorPersonType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEMajorPersonTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
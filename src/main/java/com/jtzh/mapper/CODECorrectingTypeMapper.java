package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODECorrectingType;

public abstract interface CODECorrectingTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODECorrectingType paramCODECorrectingType);
  
  public abstract CODECorrectingType selectByPrimaryKey(String paramString);
  
  public abstract List<CODECorrectingType> selectAll();
  
  public abstract int updateByPrimaryKey(CODECorrectingType paramCODECorrectingType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODECorrectingTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
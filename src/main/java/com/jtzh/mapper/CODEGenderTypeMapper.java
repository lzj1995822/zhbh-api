package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEGenderType;

public abstract interface CODEGenderTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEGenderType paramCODEGenderType);
  
  public abstract CODEGenderType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEGenderType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEGenderType paramCODEGenderType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEGenderTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
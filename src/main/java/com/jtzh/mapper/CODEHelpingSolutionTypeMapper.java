package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEHelpingSolutionType;

public abstract interface CODEHelpingSolutionTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEHelpingSolutionType paramCODEHelpingSolutionType);
  
  public abstract CODEHelpingSolutionType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEHelpingSolutionType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEHelpingSolutionType paramCODEHelpingSolutionType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEHelpingSolutionTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESchoolRunningType;

public abstract interface CODESchoolRunningTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESchoolRunningType paramCODESchoolRunningType);
  
  public abstract CODESchoolRunningType selectByPrimaryKey(String paramString);
  
  public abstract List<CODESchoolRunningType> selectAll();
  
  public abstract int updateByPrimaryKey(CODESchoolRunningType paramCODESchoolRunningType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESchoolRunningTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
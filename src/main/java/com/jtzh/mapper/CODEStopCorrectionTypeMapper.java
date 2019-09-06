package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEStopCorrectionType;

public abstract interface CODEStopCorrectionTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEStopCorrectionType paramCODEStopCorrectionType);
  
  public abstract CODEStopCorrectionType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEStopCorrectionType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEStopCorrectionType paramCODEStopCorrectionType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEStopCorrectionTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
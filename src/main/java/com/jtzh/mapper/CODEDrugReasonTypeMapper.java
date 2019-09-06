package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEDrugReasonType;

public abstract interface CODEDrugReasonTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEDrugReasonType paramCODEDrugReasonType);
  
  public abstract CODEDrugReasonType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEDrugReasonType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEDrugReasonType paramCODEDrugReasonType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEDrugReasonTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
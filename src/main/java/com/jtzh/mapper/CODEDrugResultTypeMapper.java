package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEDrugResultType;

public abstract interface CODEDrugResultTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEDrugResultType paramCODEDrugResultType);
  
  public abstract CODEDrugResultType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEDrugResultType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEDrugResultType paramCODEDrugResultType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEDrugResultTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
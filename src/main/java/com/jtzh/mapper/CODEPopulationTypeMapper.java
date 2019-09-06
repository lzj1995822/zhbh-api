package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEPopulationType;

public abstract interface CODEPopulationTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEPopulationType paramCODEPopulationType);
  
  public abstract CODEPopulationType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEPopulationType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEPopulationType paramCODEPopulationType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEPopulationTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
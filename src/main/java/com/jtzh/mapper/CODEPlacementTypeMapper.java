package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEPlacementType;

public abstract interface CODEPlacementTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEPlacementType paramCODEPlacementType);
  
  public abstract CODEPlacementType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEPlacementType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEPlacementType paramCODEPlacementType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEPlacementTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
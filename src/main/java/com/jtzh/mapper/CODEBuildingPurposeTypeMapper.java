package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEBuildingPurposeType;

public abstract interface CODEBuildingPurposeTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEBuildingPurposeType paramCODEBuildingPurposeType);
  
  public abstract CODEBuildingPurposeType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEBuildingPurposeType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEBuildingPurposeType paramCODEBuildingPurposeType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEBuildingPurposeTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
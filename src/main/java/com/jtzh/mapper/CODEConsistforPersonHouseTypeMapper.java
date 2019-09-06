package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEConsistforPersonHouseType;

public abstract interface CODEConsistforPersonHouseTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEConsistforPersonHouseType paramCODEConsistforPersonHouseType);
  
  public abstract CODEConsistforPersonHouseType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEConsistforPersonHouseType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEConsistforPersonHouseType paramCODEConsistforPersonHouseType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEConsistforPersonHouseTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
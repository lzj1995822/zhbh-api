package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEEthnicityType;

public abstract interface CODEEthnicityTypeMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(CODEEthnicityType paramCODEEthnicityType);
  
  public abstract CODEEthnicityType selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<CODEEthnicityType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEEthnicityType paramCODEEthnicityType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEEthnicityTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
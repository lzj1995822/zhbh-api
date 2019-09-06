package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEDangerousEvaulationLevelType;

public abstract interface CODEDangerousEvaulationLevelTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEDangerousEvaulationLevelType paramCODEDangerousEvaulationLevelType);
  
  public abstract CODEDangerousEvaulationLevelType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEDangerousEvaulationLevelType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEDangerousEvaulationLevelType paramCODEDangerousEvaulationLevelType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEDangerousEvaulationLevelTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
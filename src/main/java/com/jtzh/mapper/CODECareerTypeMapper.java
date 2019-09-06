package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODECareerType;

public abstract interface CODECareerTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODECareerType paramCODECareerType);
  
  public abstract CODECareerType selectByPrimaryKey(String paramString);
  
  public abstract List<CODECareerType> selectAll();
  
  public abstract int updateByPrimaryKey(CODECareerType paramCODECareerType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODECareerTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
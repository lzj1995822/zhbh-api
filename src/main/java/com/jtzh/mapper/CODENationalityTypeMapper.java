package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODENationalityType;

public abstract interface CODENationalityTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODENationalityType paramCODENationalityType);
  
  public abstract CODENationalityType selectByPrimaryKey(String paramString);
  
  public abstract List<CODENationalityType> selectAll();
  
  public abstract int updateByPrimaryKey(CODENationalityType paramCODENationalityType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODENationalityTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
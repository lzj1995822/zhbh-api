package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESocietyOrgTypeValue;

public abstract interface CODESocietyOrgTypeValueMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESocietyOrgTypeValue paramCODESocietyOrgTypeValue);
  
  public abstract CODESocietyOrgTypeValue selectByPrimaryKey(String paramString);
  
  public abstract List<CODESocietyOrgTypeValue> selectAll();
  
  public abstract int updateByPrimaryKey(CODESocietyOrgTypeValue paramCODESocietyOrgTypeValue);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESocietyOrgTypeValueMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
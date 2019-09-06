package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEFamilySituationType;

public abstract interface CODEFamilySituationTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEFamilySituationType paramCODEFamilySituationType);
  
  public abstract CODEFamilySituationType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEFamilySituationType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEFamilySituationType paramCODEFamilySituationType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEFamilySituationTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
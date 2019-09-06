package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEControlSituationType;

public abstract interface CODEControlSituationTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEControlSituationType paramCODEControlSituationType);
  
  public abstract CODEControlSituationType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEControlSituationType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEControlSituationType paramCODEControlSituationType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEControlSituationTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
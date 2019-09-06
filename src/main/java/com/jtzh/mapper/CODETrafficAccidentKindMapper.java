package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODETrafficAccidentKind;

public abstract interface CODETrafficAccidentKindMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODETrafficAccidentKind paramCODETrafficAccidentKind);
  
  public abstract CODETrafficAccidentKind selectByPrimaryKey(String paramString);
  
  public abstract List<CODETrafficAccidentKind> selectAll();
  
  public abstract int updateByPrimaryKey(CODETrafficAccidentKind paramCODETrafficAccidentKind);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODETrafficAccidentKindMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
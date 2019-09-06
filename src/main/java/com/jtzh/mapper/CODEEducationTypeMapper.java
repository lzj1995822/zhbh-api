package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEEducationType;

public abstract interface CODEEducationTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEEducationType paramCODEEducationType);
  
  public abstract CODEEducationType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEEducationType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEEducationType paramCODEEducationType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEEducationTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
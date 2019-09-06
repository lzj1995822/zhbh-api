package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEOriginalSinType;

public abstract interface CODEOriginalSinTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEOriginalSinType paramCODEOriginalSinType);
  
  public abstract CODEOriginalSinType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEOriginalSinType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEOriginalSinType paramCODEOriginalSinType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEOriginalSinTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
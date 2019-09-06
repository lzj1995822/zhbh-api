package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEDocumentType;

public abstract interface CODEDocumentTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEDocumentType paramCODEDocumentType);
  
  public abstract CODEDocumentType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEDocumentType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEDocumentType paramCODEDocumentType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEDocumentTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
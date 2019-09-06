package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODERentalPurposeType;

public abstract interface CODERentalPurposeTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODERentalPurposeType paramCODERentalPurposeType);
  
  public abstract CODERentalPurposeType selectByPrimaryKey(String paramString);
  
  public abstract List<CODERentalPurposeType> selectAll();
  
  public abstract int updateByPrimaryKey(CODERentalPurposeType paramCODERentalPurposeType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODERentalPurposeTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEAttentionTypeValue;

public abstract interface CODEAttentionTypeValueMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEAttentionTypeValue paramCODEAttentionTypeValue);
  
  public abstract CODEAttentionTypeValue selectByPrimaryKey(String paramString);
  
  public abstract List<CODEAttentionTypeValue> selectAll();
  
  public abstract int updateByPrimaryKey(CODEAttentionTypeValue paramCODEAttentionTypeValue);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEAttentionTypeValueMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
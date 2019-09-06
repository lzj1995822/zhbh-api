package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEAIDSAttentionType;

public abstract interface CODEAIDSAttentionTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEAIDSAttentionType paramCODEAIDSAttentionType);
  
  public abstract CODEAIDSAttentionType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEAIDSAttentionType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEAIDSAttentionType paramCODEAIDSAttentionType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEAIDSAttentionTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEAIDSReceiveCType;

public abstract interface CODEAIDSReceiveCTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEAIDSReceiveCType paramCODEAIDSReceiveCType);
  
  public abstract CODEAIDSReceiveCType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEAIDSReceiveCType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEAIDSReceiveCType paramCODEAIDSReceiveCType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEAIDSReceiveCTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
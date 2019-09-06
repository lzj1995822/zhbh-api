package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODESolvingMethodType;

public abstract interface CODESolvingMethodTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODESolvingMethodType paramCODESolvingMethodType);
  
  public abstract CODESolvingMethodType selectByPrimaryKey(String paramString);
  
  public abstract List<CODESolvingMethodType> selectAll();
  
  public abstract int updateByPrimaryKey(CODESolvingMethodType paramCODESolvingMethodType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODESolvingMethodTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
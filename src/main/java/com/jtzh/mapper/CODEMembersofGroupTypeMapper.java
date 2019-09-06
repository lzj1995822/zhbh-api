package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEMembersofGroupType;

public abstract interface CODEMembersofGroupTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEMembersofGroupType paramCODEMembersofGroupType);
  
  public abstract CODEMembersofGroupType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEMembersofGroupType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEMembersofGroupType paramCODEMembersofGroupType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEMembersofGroupTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
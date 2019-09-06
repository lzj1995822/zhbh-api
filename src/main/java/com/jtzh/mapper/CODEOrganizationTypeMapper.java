package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEOrganizationType;

public abstract interface CODEOrganizationTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEOrganizationType paramCODEOrganizationType);
  
  public abstract CODEOrganizationType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEOrganizationType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEOrganizationType paramCODEOrganizationType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEOrganizationTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
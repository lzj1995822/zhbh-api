package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEFamilyEconomicSituationType;

public abstract interface CODEFamilyEconomicSituationTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEFamilyEconomicSituationType paramCODEFamilyEconomicSituationType);
  
  public abstract CODEFamilyEconomicSituationType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEFamilyEconomicSituationType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEFamilyEconomicSituationType paramCODEFamilyEconomicSituationType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEFamilyEconomicSituationTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
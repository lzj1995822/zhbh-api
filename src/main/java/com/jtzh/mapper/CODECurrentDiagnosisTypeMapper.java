package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODECurrentDiagnosisType;

public abstract interface CODECurrentDiagnosisTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODECurrentDiagnosisType paramCODECurrentDiagnosisType);
  
  public abstract CODECurrentDiagnosisType selectByPrimaryKey(String paramString);
  
  public abstract List<CODECurrentDiagnosisType> selectAll();
  
  public abstract int updateByPrimaryKey(CODECurrentDiagnosisType paramCODECurrentDiagnosisType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODECurrentDiagnosisTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
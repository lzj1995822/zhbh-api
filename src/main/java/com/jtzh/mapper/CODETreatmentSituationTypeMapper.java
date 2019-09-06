package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODETreatmentSituationType;

public abstract interface CODETreatmentSituationTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODETreatmentSituationType paramCODETreatmentSituationType);
  
  public abstract CODETreatmentSituationType selectByPrimaryKey(String paramString);
  
  public abstract List<CODETreatmentSituationType> selectAll();
  
  public abstract int updateByPrimaryKey(CODETreatmentSituationType paramCODETreatmentSituationType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODETreatmentSituationTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
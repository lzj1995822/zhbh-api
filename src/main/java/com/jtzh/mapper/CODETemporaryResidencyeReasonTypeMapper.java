package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODETemporaryResidencyeReasonType;

public abstract interface CODETemporaryResidencyeReasonTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODETemporaryResidencyeReasonType paramCODETemporaryResidencyeReasonType);
  
  public abstract CODETemporaryResidencyeReasonType selectByPrimaryKey(String paramString);
  
  public abstract List<CODETemporaryResidencyeReasonType> selectAll();
  
  public abstract int updateByPrimaryKey(CODETemporaryResidencyeReasonType paramCODETemporaryResidencyeReasonType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODETemporaryResidencyeReasonTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
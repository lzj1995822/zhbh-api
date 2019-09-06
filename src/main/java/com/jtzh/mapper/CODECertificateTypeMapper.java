package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODECertificateType;

public abstract interface CODECertificateTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODECertificateType paramCODECertificateType);
  
  public abstract CODECertificateType selectByPrimaryKey(String paramString);
  
  public abstract List<CODECertificateType> selectAll();
  
  public abstract int updateByPrimaryKey(CODECertificateType paramCODECertificateType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODECertificateTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
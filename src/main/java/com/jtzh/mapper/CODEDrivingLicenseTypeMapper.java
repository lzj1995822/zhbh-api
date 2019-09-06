package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.CODEDrivingLicenseType;

public abstract interface CODEDrivingLicenseTypeMapper
{
  public abstract int deleteByPrimaryKey(String paramString);
  
  public abstract int insert(CODEDrivingLicenseType paramCODEDrivingLicenseType);
  
  public abstract CODEDrivingLicenseType selectByPrimaryKey(String paramString);
  
  public abstract List<CODEDrivingLicenseType> selectAll();
  
  public abstract int updateByPrimaryKey(CODEDrivingLicenseType paramCODEDrivingLicenseType);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\CODEDrivingLicenseTypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
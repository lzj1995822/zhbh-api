package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.APPVersion;

public abstract interface APPVersionMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(APPVersion paramAPPVersion);
  
  public abstract APPVersion selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<APPVersion> selectAll();
  
  public abstract int updateByPrimaryKey(APPVersion paramAPPVersion);
  
  public abstract APPVersion getAPPVersion();
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\APPVersionMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
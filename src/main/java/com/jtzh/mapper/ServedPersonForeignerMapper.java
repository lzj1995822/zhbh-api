package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.ServedPersonForeigner;

public abstract interface ServedPersonForeignerMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(ServedPersonForeigner paramServedPersonForeigner);
  
  public abstract ServedPersonForeigner selectByPrimaryKey(Long paramLong);
  
  public abstract List<ServedPersonForeigner> selectAll();
  
  public abstract int updateByPrimaryKey(ServedPersonForeigner paramServedPersonForeigner);
  
  public abstract Long getServedPersonIDByName(@Param("name") String paramString1, @Param("certifID") String paramString2);
  
  public abstract List<ServedPersonForeigner> queryByCerfitID(@Param("certifID") String paramString);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedPersonForeignerMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
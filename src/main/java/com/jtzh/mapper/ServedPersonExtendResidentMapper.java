package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.ServedPersonExtendResident;

public abstract interface ServedPersonExtendResidentMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByCertifID(@Param("id") String paramString);
  
  public abstract int insert(ServedPersonExtendResident paramServedPersonExtendResident);
  
  public abstract ServedPersonExtendResident selectByPrimaryKey(Long paramLong);
  
  public abstract List<ServedPersonExtendResident> selectAll();
  
  public abstract int updateByPrimaryKey(ServedPersonExtendResident paramServedPersonExtendResident);
  
  public abstract List<ServedPersonExtendResident> queryByCerfitID(@Param("certifID") String paramString);
  
  void updateExtendRecord(ServedPersonExtendResident extend);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedPersonExtendResidentMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
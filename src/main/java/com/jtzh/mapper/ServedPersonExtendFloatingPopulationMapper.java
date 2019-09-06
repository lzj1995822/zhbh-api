package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.ServedPersonExtendFloatingPopulation;

public abstract interface ServedPersonExtendFloatingPopulationMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(ServedPersonExtendFloatingPopulation paramServedPersonExtendFloatingPopulation);
  
  public abstract ServedPersonExtendFloatingPopulation selectByPrimaryKey(Long paramLong);
  
  public abstract List<ServedPersonExtendFloatingPopulation> selectAll();
  
  public abstract int updateByPrimaryKey(ServedPersonExtendFloatingPopulation paramServedPersonExtendFloatingPopulation);
  
  public abstract int deleteByCertifID(@Param("id") String paramString);
  
  public abstract List<ServedPersonExtendFloatingPopulation> queryByCerfitID(@Param("certifID") String paramString);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedPersonExtendFloatingPopulationMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
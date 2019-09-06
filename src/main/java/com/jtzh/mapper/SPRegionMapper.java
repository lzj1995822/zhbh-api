package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.SPRegion;

public abstract interface SPRegionMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SPRegion paramSPRegion);
  
  public abstract SPRegion selectByPrimaryKey(Long paramLong);
  
  public abstract List<SPRegion> selectAll();
  
  public abstract List<SPRegion> selectByRegionName(@Param("name") String paramString);
  
  public abstract int updateByPrimaryKey(SPRegion paramSPRegion);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SPRegionMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
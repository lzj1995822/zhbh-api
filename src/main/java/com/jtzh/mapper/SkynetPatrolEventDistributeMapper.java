package com.jtzh.mapper;

import com.jtzh.vo.skynet.SPDistributeVO;
import com.jtzh.entity.SkynetPatrolEventDistribute;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SkynetPatrolEventDistributeMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SkynetPatrolEventDistribute paramSkynetPatrolEventDistribute);
  
  public abstract SkynetPatrolEventDistribute selectByPrimaryKey(Long paramLong);
  
  public abstract List<SPDistributeVO> selectBySPEventID(@Param("id") Long paramLong);
  
  public abstract List<SkynetPatrolEventDistribute> selectAll();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEventDistribute paramSkynetPatrolEventDistribute);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventDistributeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
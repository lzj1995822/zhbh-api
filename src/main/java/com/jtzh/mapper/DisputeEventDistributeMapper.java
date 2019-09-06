package com.jtzh.mapper;

import com.jtzh.vo.dispute.DisputeEventDistributeVO;
import com.jtzh.entity.DisputeEventDistribute;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface DisputeEventDistributeMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(DisputeEventDistribute paramDisputeEventDistribute);
  
  public abstract DisputeEventDistribute selectByPrimaryKey(Long paramLong);
  
  public abstract List<DisputeEventDistribute> selectAll();
  
  public abstract List<DisputeEventDistributeVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(DisputeEventDistribute paramDisputeEventDistribute);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventDistributeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
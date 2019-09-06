package com.jtzh.mapper;

import com.jtzh.vo.netGrid.NetGridEventDistributeVO;
import com.jtzh.entity.NetGridEventDistribute;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface NetGridEventDistributeMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventDistribute paramNetGridEventDistribute);
  
  public abstract NetGridEventDistribute selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventDistributeVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract List<NetGridEventDistribute> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventDistribute paramNetGridEventDistribute);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventDistributeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
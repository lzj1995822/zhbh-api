package com.jtzh.mapper;

import com.jtzh.vo.ss.SSDistributeVO;
import com.jtzh.entity.SSEventDistribute;

import java.util.List;

public abstract interface SSEventDistributeMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SSEventDistribute paramSSEventDistribute);
  
  public abstract SSEventDistribute selectByPrimaryKey(Long paramLong);
  
  public abstract List<SSDistributeVO> selectByEventID(Long paramLong);
  
  public abstract List<SSEventDistribute> selectAll();
  
  public abstract int updateByPrimaryKey(SSEventDistribute paramSSEventDistribute);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SSEventDistributeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
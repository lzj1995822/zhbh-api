package com.jtzh.mapper;

import com.jtzh.vo.skynet.SPCheckedVO;
import com.jtzh.entity.SkynetPatrolEventChecked;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SkynetPatrolEventCheckedMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SkynetPatrolEventChecked paramSkynetPatrolEventChecked);
  
  public abstract SkynetPatrolEventChecked selectByPrimaryKey(Long paramLong);
  
  public abstract List<SPCheckedVO> selectBySPEventID(@Param("id") Long paramLong);
  
  public abstract List<SkynetPatrolEventChecked> selectAll();
  
  public abstract int updateByPrimaryKey(SkynetPatrolEventChecked paramSkynetPatrolEventChecked);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPatrolEventCheckedMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
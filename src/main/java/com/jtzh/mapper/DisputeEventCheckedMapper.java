package com.jtzh.mapper;

import com.jtzh.vo.dispute.DisputeEventCheckedVO;
import com.jtzh.entity.DisputeEventChecked;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface DisputeEventCheckedMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(DisputeEventChecked paramDisputeEventChecked);
  
  public abstract DisputeEventChecked selectByPrimaryKey(Long paramLong);
  
  public abstract List<DisputeEventChecked> selectAll();
  
  public abstract List<DisputeEventCheckedVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(DisputeEventChecked paramDisputeEventChecked);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeEventCheckedMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
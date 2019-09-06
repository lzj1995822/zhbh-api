package com.jtzh.mapper;

import com.jtzh.vo.netGrid.NetGridEventCheckedVO;
import com.jtzh.entity.NetGridEventChecked;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface NetGridEventCheckedMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridEventChecked paramNetGridEventChecked);
  
  public abstract NetGridEventChecked selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridEventCheckedVO> selectByEventID(@Param("id") Long paramLong);
  
  public abstract List<NetGridEventChecked> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridEventChecked paramNetGridEventChecked);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridEventCheckedMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
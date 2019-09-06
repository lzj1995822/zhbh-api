package com.jtzh.mapper;

import com.jtzh.vo.ss.SSCheckedVO;
import com.jtzh.entity.SSEventChecked;

import java.util.List;

public abstract interface SSEventCheckedMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SSEventChecked paramSSEventChecked);
  
  public abstract SSEventChecked selectByPrimaryKey(Long paramLong);
  
  public abstract List<SSCheckedVO> selectByEventID(Long paramLong);
  
  public abstract List<SSEventChecked> selectAll();
  
  public abstract int updateByPrimaryKey(SSEventChecked paramSSEventChecked);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SSEventCheckedMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
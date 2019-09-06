package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.NetGridMemberT;

public abstract interface NetGridMemberTMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(NetGridMemberT paramNetGridMemberT);
  
  public abstract NetGridMemberT selectByPrimaryKey(Long paramLong);
  
  public abstract List<NetGridMemberT> getByFatherID(@Param("id") Long paramLong);
  
  public abstract List<NetGridMemberT> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridMemberT paramNetGridMemberT);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridMemberTMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
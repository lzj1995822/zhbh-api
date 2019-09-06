package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.Role;

public abstract interface RoleMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(Role paramRole);
  
  public abstract Role selectByPrimaryKey(Long paramLong);
  
  public abstract List<Role> selectAll();
  
  public abstract int updateByPrimaryKey(Role paramRole);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\RoleMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
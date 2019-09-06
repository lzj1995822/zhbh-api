package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.UserRole;

public abstract interface UserRoleMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(UserRole paramUserRole);
  
  public abstract UserRole selectByPrimaryKey(Long paramLong);
  
  public abstract List<UserRole> selectAll();
  
  public abstract int updateByPrimaryKey(UserRole paramUserRole);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\UserRoleMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
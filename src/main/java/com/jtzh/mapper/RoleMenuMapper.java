package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.RoleMenu;

public abstract interface RoleMenuMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(RoleMenu paramRoleMenu);
  
  public abstract RoleMenu selectByPrimaryKey(Long paramLong);
  
  public abstract List<RoleMenu> selectAll();
  
  public abstract int updateByPrimaryKey(RoleMenu paramRoleMenu);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\RoleMenuMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
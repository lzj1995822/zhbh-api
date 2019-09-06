package com.jtzh.service;

import java.util.List;

import com.jtzh.entity.Role;

public abstract interface RoleService
{
  public abstract boolean updateRoleMenu(Role paramRole);
  
  public abstract boolean addRoleMenu(Role paramRole);
  
  public abstract boolean deleteRoleMenu(Long paramLong);
  
  public abstract List<Role> getAllRoleMenu();
  
  public abstract Role getRoleInfoByID(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\RoleService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
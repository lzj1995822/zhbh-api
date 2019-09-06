package com.jtzh.service;

import com.jtzh.vo.user.UserQueryVO;
import com.jtzh.entity.User;

public abstract interface UserService
{
  public abstract boolean addUser(User paramUser);
  
  public abstract UserQueryVO getUserQuery(String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean updateUser(User paramUser);
  
  public abstract boolean deleteUser(Long paramLong);
  
  public abstract User getUserDetail(Long paramLong);
  
  public abstract String getRoleNameByUserID(Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\UserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
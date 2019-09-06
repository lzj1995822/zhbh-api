package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.User;

public abstract interface UserMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(User paramUser);
  
  public abstract User selectByPrimaryKey(Long paramLong);
  
  public abstract List<com.jtzh.vo.skynet.UserVO> selectUserByKey(@Param("key") String paramString);
  public abstract List<com.jtzh.vo.skynet.UserVO> selectUserByKeyDept(@Param("key") String paramString);
  public abstract com.jtzh.vo.app.UserVO checkLogin(@Param("username") String paramString1);
  
  public abstract List<User> selectAll();
  
  public abstract List<com.jtzh.vo.app.UserVO> getUserQuery(@Param("key") String paramString, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getUserQueryCount(@Param("key") String paramString);
  
  public abstract String getRoleNameByUserID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(User paramUser);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\UserMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
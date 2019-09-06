package com.jtzh.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.LoginLog;

public abstract interface LoginLogMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(LoginLog paramLoginLog);
  
  public abstract LoginLog selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<LoginLog> selectAll();
  
  public abstract int getLoginCount(@Param("username") String paramString);
  
  public abstract Date getLastLoginDate(@Param("username") String paramString);
  
  public abstract List<LoginLog> getLoginLog(@Param("startTime") String paramString1, @Param("endTime") String paramString2, @Param("username") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getLoginLogCount(@Param("startTime") String paramString1, @Param("endTime") String paramString2, @Param("username") String paramString3);
  
  public abstract int updateByPrimaryKey(LoginLog paramLoginLog);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\LoginLogMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
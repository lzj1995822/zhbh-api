package com.jtzh.service;

import com.jtzh.vo.log.LoginLogQueryVO;
import com.jtzh.entity.LoginLog;

import java.util.Map;

public abstract interface LoginLogService
{
  public abstract boolean addLog(LoginLog paramLoginLog);
  
  public abstract LoginLogQueryVO getLoginLog(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Map getLoginInfo(String paramString);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\LoginLogService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
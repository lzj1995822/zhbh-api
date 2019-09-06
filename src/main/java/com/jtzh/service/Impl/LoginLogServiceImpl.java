/*    */ package com.jtzh.service.Impl;
/*    */ import com.jtzh.util.DateUtil;
/*    */ import com.jtzh.util.Page;
/*    */ import com.jtzh.util.PageUtil;
/*    */ import com.jtzh.vo.log.LoginLogQueryVO;
import com.jtzh.entity.LoginLog;
import com.jtzh.mapper.LoginLogMapper;
import com.jtzh.service.LoginLogService;

/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class LoginLogServiceImpl
/*    */   implements LoginLogService
/*    */ {
/*    */   @Autowired
/*    */   private LoginLogMapper loginLogMapper;
/*    */   
/*    */   public boolean addLog(LoginLog log)
/*    */   {
/* 28 */     return this.loginLogMapper.insert(log) != 0;
/*    */   }
/*    */   
/*    */   public LoginLogQueryVO getLoginLog(String startTime, String endTime, String username, int page, int pageSize)
/*    */   {
/* 33 */     int start = 0;
/* 34 */     if (page > 1)
/* 35 */       start = (page - 1) * pageSize;
/* 36 */     List<LoginLog> list = this.loginLogMapper.getLoginLog(startTime, endTime, username, start, pageSize);
/* 37 */     int count = this.loginLogMapper.getLoginLogCount(startTime, endTime, username);
/* 38 */     Page p = PageUtil.createPage(pageSize, count, page - 1);
/* 39 */     LoginLogQueryVO vo = new LoginLogQueryVO();
/* 40 */     vo.setList(list);
/* 41 */     vo.setPage(p);
/* 42 */     return vo;
/*    */   }
/*    */   
/*    */   public Map getLoginInfo(String username)
/*    */   {
/* 47 */     Map map = new HashMap();
/* 48 */     int count = this.loginLogMapper.getLoginCount(username);
/* 49 */     Date date = this.loginLogMapper.getLastLoginDate(username);
/* 50 */     String date_ = DateUtil.transferLongToDate("yyyy-MM-dd HH:mm:ss", Long.valueOf(date.getTime()));
/* 51 */     map.put("count", Integer.valueOf(count));
/* 52 */     map.put("date", date_);
/*    */     
/* 54 */     return map;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\impl\LoginLogServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
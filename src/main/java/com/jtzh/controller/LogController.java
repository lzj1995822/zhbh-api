/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.LoginLogService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/api/log"})
/*    */ public class LogController
/*    */ {
/*    */   @Autowired
/*    */   private LoginLogService loginLogService;
/*    */   
/*    */   @RequestMapping({"/getLoginLog"})
/*    */   @ResponseBody
/*    */   public ExtResponse getLoginLog(String startTime, String endTime, String username, int page, int pageSize)
/*    */   {
/* 23 */     return ResponseUtil.success(this.loginLogService.getLoginLog(startTime, endTime, username, page, pageSize));
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\LogController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package com.jtzh.controller;
/*    */ 
/*    */ import com.jtzh.jpush.Push;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class PageController
/*    */ {
/*    */   @Autowired
/*    */   private Push push;
/*    */   
/*    */   @RequestMapping({"/send"})
/*    */   @ResponseBody
/*    */   public String send(String userid, String content)
/*    */   {
/* 23 */     Push.sendMsgToAndroid(content, userid);
/* 24 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\PageController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
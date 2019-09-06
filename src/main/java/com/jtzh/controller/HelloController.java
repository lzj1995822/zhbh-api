/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.APPService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/hello"})
/*    */ public class HelloController
/*    */ {
/*    */   @Autowired
/*    */   private APPService APPService;
/*    */   
/*    */   @RequestMapping
/*    */   public String hello()
/*    */   {
/* 21 */     return "hello";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/insert"})
/*    */   @ResponseBody
/*    */   public ExtResponse insert() {
/* 27 */     int result = this.APPService.insertData();
/* 28 */     return ResponseUtil.success(Integer.valueOf(result));
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\HelloController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
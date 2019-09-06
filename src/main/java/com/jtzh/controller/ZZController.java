/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.ZZService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/api/zz"})
/*    */ public class ZZController
/*    */ {
/*    */   @Autowired
/*    */   private ZZService zzService;
/*    */   
/*    */   @RequestMapping({"/getZZHomePageCount"})
/*    */   @ResponseBody
/*    */   public ExtResponse getZZHomePageCount()
/*    */   {
/* 27 */     return ResponseUtil.success(this.zzService.getZZHomePageCount());
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\ZZController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package com.jtzh.common;
/*    */ 
/*    */ import com.jtzh.util.ResponseUtil;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.web.bind.annotation.ControllerAdvice;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ @ControllerAdvice
/*    */ public class ExceptionHandle
/*    */ {
/* 14 */   private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
/*    */   
/*    */   @ExceptionHandler({Exception.class})
/*    */   @ResponseBody
/*    */   public ExtResponse handle(Exception e) {
/* 19 */     logger.error("异常{}", e);
/* 20 */     return ResponseUtil.error(e.getMessage());
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\common\ExceptionHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
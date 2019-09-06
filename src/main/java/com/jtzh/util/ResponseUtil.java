/*    */ package com.jtzh.util;
import com.jtzh.common.ExtResponse;
/*    */ 
/*    */ public class ResponseUtil
/*    */ {
/*    */   public static ExtResponse build(int code, String message, Object data) {
/*  8 */     ExtResponse response = new ExtResponse(data, message, code);
/*  9 */     return response;
/*    */   }
/*    */   
/*    */   public static ExtResponse success(Object data) {
/* 13 */     return build(200, "", data);
/*    */   }
/*    */   
/*    */   public static ExtResponse error(String message) {
/* 17 */     return build(201, message, null);
/*    */   }
/*    */ }


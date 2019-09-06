/*    */ package com.jtzh.common;
/*    */ 
/*    */ public class ExtResponse<T>
/*    */ {
/*    */   private T data;
/*    */   private String message;
/*    */   private int code;
/*    */   
/*    */   public ExtResponse() {}
/*    */   
/*    */   public ExtResponse(T data, String message, int code)
/*    */   {
/* 13 */     this.data = data;
/* 14 */     this.message = message;
/* 15 */     this.code = code;
/*    */   }
/*    */   
/* 18 */   public T getData() { return (T)this.data; }
/*    */   
/*    */   public void setData(T data) {
/* 21 */     this.data = data;
/*    */   }
/*    */   
/* 24 */   public String getMessage() { return this.message; }
/*    */   
/*    */   public void setMessage(String message) {
/* 27 */     this.message = message;
/*    */   }
/*    */   
/* 30 */   public int getCode() { return this.code; }
/*    */   
/*    */   public void setCode(int code) {
/* 33 */     this.code = code;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\common\ExtResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
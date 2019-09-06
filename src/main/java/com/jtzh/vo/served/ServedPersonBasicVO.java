/*    */ package com.jtzh.vo.served;
import com.jtzh.entity.ServedPersonBasic;
/*    */ 
/*    */ 
/*    */ public class ServedPersonBasicVO
/*    */   extends ServedPersonBasic
/*    */ {
/*    */   private String birthDateStr;
/*    */   private String servedPersonTypeName;
/*    */   
/*    */   public String getServedPersonTypeName()
/*    */   {
/* 14 */     return this.servedPersonTypeName;
/*    */   }
/*    */   
/* 17 */   public void setServedPersonTypeName(String servedPersonTypeName) { this.servedPersonTypeName = servedPersonTypeName; }
/*    */   
/*    */   public String getBirthDateStr() {
/* 20 */     return this.birthDateStr;
/*    */   }
/*    */   
/* 23 */   public void setBirthDateStr(String birthDateStr) { this.birthDateStr = birthDateStr; }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\served\ServedPersonBasicVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
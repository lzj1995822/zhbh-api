/*    */ package com.jtzh.vo.netGrid;
import com.jtzh.entity.NetGridEvent;
/*    */ 
/*    */ public class NetGridEventVO extends NetGridEvent
/*    */ {
/*    */   private String eventTypeName;
/*    */   private String eventStatusTypeName;
/*    */   private String netGridName;
/*    */   
/*    */   public String getEventTypeName()
/*    */   {
/* 13 */     return this.eventTypeName;
/*    */   }
/*    */   
/*    */   public void setEventTypeName(String eventTypeName) {
/* 17 */     this.eventTypeName = eventTypeName;
/*    */   }
/*    */   
/*    */   public String getEventStatusTypeName() {
/* 21 */     return this.eventStatusTypeName;
/*    */   }
/*    */   
/*    */   public void setEventStatusTypeName(String eventStatusTypeName) {
/* 25 */     this.eventStatusTypeName = eventStatusTypeName;
/*    */   }
/*    */   
/*    */   public String getNetGridName() {
/* 29 */     return this.netGridName;
/*    */   }
/*    */   
/*    */   public void setNetGridName(String netGridName) {
/* 33 */     this.netGridName = netGridName;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\netGrid\NetGridEventVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
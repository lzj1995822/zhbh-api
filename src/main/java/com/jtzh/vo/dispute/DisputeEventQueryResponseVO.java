/*    */ package com.jtzh.vo.dispute;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class DisputeEventQueryResponseVO
/*    */ {
/*    */   private List<DisputeEventVO> disputeEvents;
/*    */   private Page page;
/*    */   
/*    */   public List<DisputeEventVO> getDisputeEvents()
/*    */   {
/* 14 */     return this.disputeEvents;
/*    */   }
/*    */   
/*    */   public void setDisputeEvents(List<DisputeEventVO> disputeEvents) {
/* 18 */     this.disputeEvents = disputeEvents;
/*    */   }
/*    */   
/*    */   public Page getPage() {
/* 22 */     return this.page;
/*    */   }
/*    */   
/*    */   public void setPage(Page page) {
/* 26 */     this.page = page;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\dispute\DisputeEventQueryResponseVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
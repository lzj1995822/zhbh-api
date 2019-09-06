/*    */ package com.jtzh.vo.key;
/*    */ import com.jtzh.util.Page;
import com.jtzh.entity.InspectRecord;

/*    */ import java.util.List;
/*    */ 
/*    */ public class InspectRecordQueryVO
/*    */ {
/*    */   private List<InspectRecord> records;
/*    */   private Page page;
/*    */   
/*    */   public List<InspectRecord> getRecords()
/*    */   {
/* 14 */     return this.records;
/*    */   }
/*    */   
/*    */   public void setRecords(List<InspectRecord> records) {
/* 18 */     this.records = records;
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


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\key\InspectRecordQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
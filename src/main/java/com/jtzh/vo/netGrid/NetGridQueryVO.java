/*    */ package com.jtzh.vo.netGrid;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class NetGridQueryVO
/*    */ {
/*    */   List<NetGridVO> grids;
/*    */   Page page;
/*    */   
/*    */   public List<NetGridVO> getGrids()
/*    */   {
/* 14 */     return this.grids;
/*    */   }
/*    */   
/*    */   public void setGrids(List<NetGridVO> grids) {
/* 18 */     this.grids = grids;
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


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\netGrid\NetGridQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
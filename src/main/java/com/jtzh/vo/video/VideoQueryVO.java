/*    */ package com.jtzh.vo.video;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class VideoQueryVO
/*    */ {
/*    */   private List<VideoInfoVO> vos;
/*    */   private Page page;
/*    */   
/*    */   public List<VideoInfoVO> getVos()
/*    */   {
/* 14 */     return this.vos;
/*    */   }
/*    */   
/*    */   public void setVos(List<VideoInfoVO> vos) {
/* 18 */     this.vos = vos;
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


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\video\VideoQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
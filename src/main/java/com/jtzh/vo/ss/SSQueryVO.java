/*    */ package com.jtzh.vo.ss;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import com.jtzh.vo.gis.SocietySecurityEventVO;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SSQueryVO
/*    */ {
/*    */   private List<SocietySecurityEventVO> vos;
/*    */   private Page page;
/*    */   
/*    */   public List<SocietySecurityEventVO> getVos()
/*    */   {
/* 14 */     return this.vos;
/*    */   }
/*    */   
/*    */   public void setVos(List<SocietySecurityEventVO> vos) {
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


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\ss\SSQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
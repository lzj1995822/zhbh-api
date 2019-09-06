/*    */ package com.jtzh.vo.orgMember;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ public class OrgBasicInfQueryVO
/*    */ {
/*    */   private List<OrgBasicInfExVO> vos;
/*    */   private Page page;
/*    */   
/*    */   public List<OrgBasicInfExVO> getVos()
/*    */   {
/* 13 */     return this.vos;
/*    */   }
/*    */   
/*    */   public void setVos(List<OrgBasicInfExVO> vos) {
/* 17 */     this.vos = vos;
/*    */   }
/*    */   
/*    */   public Page getPage() {
/* 21 */     return this.page;
/*    */   }
/*    */   
/*    */   public void setPage(Page page) {
/* 25 */     this.page = page;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\orgMember\OrgBasicInfQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
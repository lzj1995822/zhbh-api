/*    */ package com.jtzh.vo.nonpublic;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SocietyOrgQueryVO
/*    */ {
/*    */   List<SocietyOrgInfoVO> societyOrgInfos;
/*    */   Page p;
/*    */   
/*    */   public List<SocietyOrgInfoVO> getSocietyOrgInfos()
/*    */   {
/* 13 */     return this.societyOrgInfos;
/*    */   }
/*    */   
/*    */   public void setSocietyOrgInfos(List<SocietyOrgInfoVO> societyOrgInfos) {
/* 17 */     this.societyOrgInfos = societyOrgInfos;
/*    */   }
/*    */   
/*    */   public Page getP() {
/* 21 */     return this.p;
/*    */   }
/*    */   
/*    */   public void setP(Page p) {
/* 25 */     this.p = p;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\nonpublic\SocietyOrgQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
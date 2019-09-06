/*    */ package com.jtzh.vo.key;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ public class KeyVehiclesQueryVO
/*    */ {
/*    */   private List<KeyVehiclesInfoVO> vos;
/*    */   private Page page;
/*    */   
/*    */   public List<KeyVehiclesInfoVO> getVos()
/*    */   {
/* 13 */     return this.vos;
/*    */   }
/*    */   
/*    */   public void setVos(List<KeyVehiclesInfoVO> vos) {
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


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\key\KeyVehiclesQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
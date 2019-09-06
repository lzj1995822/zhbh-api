/*    */ package com.jtzh.vo.KeyPetitioners;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyPetitionersQueryVO
/*    */ {
/*    */   private List<KeyPetitionersVO> keyPetitioners;
/*    */   private Page page;
/*    */   
/*    */   public List<KeyPetitionersVO> getKeyPetitioners()
/*    */   {
/* 15 */     return this.keyPetitioners;
/*    */   }
/*    */   
/*    */   public void setKeyPetitioners(List<KeyPetitionersVO> keyPetitioners) {
/* 19 */     this.keyPetitioners = keyPetitioners;
/*    */   }
/*    */   
/*    */   public Page getPage() {
/* 23 */     return this.page;
/*    */   }
/*    */   
/*    */   public void setPage(Page page) {
/* 27 */     this.page = page;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\KeyPetitioners\KeyPetitionersQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
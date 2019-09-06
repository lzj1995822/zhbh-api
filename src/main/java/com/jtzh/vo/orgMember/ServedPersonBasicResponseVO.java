/*    */ package com.jtzh.vo.orgMember;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import com.jtzh.vo.served.ServedPersonBasicVO;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ServedPersonBasicResponseVO
/*    */ {
/*    */   private List<ServedPersonBasicVO> queryVO;
/*    */   private Page page;
/*    */   
/*    */   public Page getPage()
/*    */   {
/* 14 */     return this.page;
/*    */   }
/*    */   
/* 17 */   public void setPage(Page page) { this.page = page; }
/*    */   
/*    */   public List<ServedPersonBasicVO> getQueryVO() {
/* 20 */     return this.queryVO;
/*    */   }
/*    */   
/* 23 */   public void setQueryVO(List<ServedPersonBasicVO> queryVO) { this.queryVO = queryVO; }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\orgMember\ServedPersonBasicResponseVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
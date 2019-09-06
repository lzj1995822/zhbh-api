/*    */ package com.jtzh.vo.orgMember;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import java.util.List;
/*    */ 
/*    */ public class OrgMemberServedPersonRecoedQueryResponseVO
/*    */ {
/*    */   private List<OrgMemberServedPersonRecordQueryVO> queryVO;
/*    */   private Page page;
/*    */   
/*    */   public Page getPage()
/*    */   {
/* 13 */     return this.page;
/*    */   }
/*    */   
/* 16 */   public void setPage(Page page) { this.page = page; }
/*    */   
/*    */   public List<OrgMemberServedPersonRecordQueryVO> getQueryVO() {
/* 19 */     return this.queryVO;
/*    */   }
/*    */   
/* 22 */   public void setQueryVO(List<OrgMemberServedPersonRecordQueryVO> queryVO) { this.queryVO = queryVO; }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\orgMember\OrgMemberServedPersonRecoedQueryResponseVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
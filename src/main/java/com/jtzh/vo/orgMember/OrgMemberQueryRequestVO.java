/*    */ package com.jtzh.vo.orgMember;
/*    */ 
/*    */ 
/*    */ public class OrgMemberQueryRequestVO
/*    */ {
/*    */   private String name;
/*    */   
/*    */   private String positionTypeValue;
/*    */   private Integer status;
/*    */   private int page;
/*    */   private int pageSize;
/*    */   
/*    */   public String getName()
/*    */   {
/* 15 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 19 */     this.name = name;
/*    */   }
/*    */   
/*    */   public int getPage() {
/* 23 */     return this.page;
/*    */   }
/*    */   
/*    */   public void setPage(int page) {
/* 27 */     this.page = page;
/*    */   }
/*    */   
/*    */   public int getPageSize() {
/* 31 */     return this.pageSize;
/*    */   }
/*    */   
/*    */   public void setPageSize(int pageSize) {
/* 35 */     this.pageSize = pageSize;
/*    */   }
/*    */   
/*    */   public Integer getStatus() {
/* 39 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(Integer status) {
/* 43 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String getPositionTypeValue() {
/* 47 */     return this.positionTypeValue;
/*    */   }
/*    */   
/*    */   public void setPositionTypeValue(String positionTypeValue) {
/* 51 */     this.positionTypeValue = positionTypeValue;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\orgMember\OrgMemberQueryRequestVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
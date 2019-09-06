/*    */ package com.jtzh.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Page
/*    */ {
/*    */   private int everyPage;
/*    */   
/*    */ 
/*    */   private int totalCount;
/*    */   
/*    */ 
/*    */   private int totalPage;
/*    */   
/*    */ 
/*    */   private int currentPage;
/*    */   
/*    */ 
/*    */   private int beginIndex;
/*    */   
/*    */   private boolean hasPrePage;
/*    */   
/*    */   private boolean hasNextPage;
/*    */   
/*    */ 
/*    */   public Page(int everyPage, int totalCount, int totalPage, int currentPage, int beginIndex, boolean hasPrePage, boolean hasNextPage)
/*    */   {
/* 28 */     this.everyPage = everyPage;
/* 29 */     this.totalCount = totalCount;
/* 30 */     this.totalPage = totalPage;
/* 31 */     this.currentPage = currentPage;
/* 32 */     this.beginIndex = beginIndex;
/* 33 */     this.hasPrePage = hasPrePage;
/* 34 */     this.hasNextPage = hasNextPage;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Page() {}
/*    */   
/*    */ 
/*    */   public int getEveryPage()
/*    */   {
/* 44 */     return this.everyPage;
/*    */   }
/*    */   
/*    */   public void setEveryPage(int everyPage) {
/* 48 */     this.everyPage = everyPage;
/*    */   }
/*    */   
/*    */   public int getTotalCount() {
/* 52 */     return this.totalCount;
/*    */   }
/*    */   
/*    */   public void setTotalCount(int totalCount) {
/* 56 */     this.totalCount = totalCount;
/*    */   }
/*    */   
/*    */   public int getTotalPage() {
/* 60 */     return this.totalPage;
/*    */   }
/*    */   
/*    */   public void setTotalPage(int totalPage) {
/* 64 */     this.totalPage = totalPage;
/*    */   }
/*    */   
/*    */   public int getCurrentPage() {
/* 68 */     return this.currentPage;
/*    */   }
/*    */   
/*    */   public void setCurrentPage(int currentPage) {
/* 72 */     this.currentPage = currentPage;
/*    */   }
/*    */   
/*    */   public int getBeginIndex() {
/* 76 */     return this.beginIndex;
/*    */   }
/*    */   
/*    */   public void setBeginIndex(int beginIndex) {
/* 80 */     this.beginIndex = beginIndex;
/*    */   }
/*    */   
/*    */   public boolean isHasPrePage() {
/* 84 */     return this.hasPrePage;
/*    */   }
/*    */   
/*    */   public void setHasPrePage(boolean hasPrePage) {
/* 88 */     this.hasPrePage = hasPrePage;
/*    */   }
/*    */   
/*    */   public boolean isHasNextPage() {
/* 92 */     return this.hasNextPage;
/*    */   }
/*    */   
/*    */   public void setHasNextPage(boolean hasNextPage) {
/* 96 */     this.hasNextPage = hasNextPage;
/*    */   }
/*    */ }


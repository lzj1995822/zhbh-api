/*    */ package com.jtzh.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PageUtil
/*    */ {
/*    */   public static Page createPage(int everyPage, int totalCount, int currentPage)
/*    */   {
/* 15 */     everyPage = getEveryPage(everyPage);
/* 16 */     currentPage = getCurrentPage(currentPage);
/* 17 */     int totalPage = getTotalPage(everyPage, totalCount);
/* 18 */     int beginIndex = getBeginIndex(everyPage, currentPage);
/* 19 */     boolean hasPrePage = getHasPrePage(currentPage);
/* 20 */     boolean hasNextPage = getHasNextPage(totalPage, currentPage);
/* 21 */     return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
/*    */   }
/*    */   
/*    */   public static Page createPage(Page page, int totalCount)
/*    */   {
/* 26 */     int everyPage = getEveryPage(page.getEveryPage());
/* 27 */     int currentPage = getCurrentPage(page.getCurrentPage());
/* 28 */     int totalPage = getTotalPage(everyPage, totalCount);
/* 29 */     int beginIndex = getBeginIndex(everyPage, currentPage);
/* 30 */     boolean hasPrePage = getHasPrePage(currentPage);
/* 31 */     boolean hasNextPage = getHasNextPage(totalPage, currentPage);
/* 32 */     return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
/*    */   }
/*    */   
/*    */ 
/*    */   public static int getEveryPage(int everyPage)
/*    */   {
/* 38 */     return everyPage == 0 ? 10 : everyPage;
/*    */   }
/*    */   
/*    */   public static int getCurrentPage(int currentPage)
/*    */   {
/* 43 */     return currentPage == 0 ? 1 : currentPage;
/*    */   }
/*    */   
/*    */   public static int getTotalPage(int everyPage, int totalCount)
/*    */   {
/* 48 */     int totalPage = 0;
/* 49 */     if (totalCount % everyPage == 0) {
/* 50 */       totalPage = totalCount / everyPage;
/*    */     } else {
/* 52 */       totalPage = totalCount / everyPage + 1;
/*    */     }
/* 54 */     return totalPage;
/*    */   }
/*    */   
/*    */   public static int getBeginIndex(int everyPage, int currentPage)
/*    */   {
/* 59 */     return (currentPage - 1) * everyPage;
/*    */   }
/*    */   
/*    */   public static boolean getHasPrePage(int currentPage)
/*    */   {
/* 64 */     return currentPage != 1;
/*    */   }
/*    */   
/*    */   public static boolean getHasNextPage(int totalPage, int currentPage)
/*    */   {
/* 69 */     return (currentPage != totalPage) && (totalPage != 0);
/*    */   }
/*    */ }


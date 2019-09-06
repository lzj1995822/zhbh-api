/*    */ package com.jtzh.vo.user;
/*    */ 
/*    */ import com.jtzh.util.Page;
/*    */ import com.jtzh.vo.app.UserVO;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class UserQueryVO
/*    */ {
/*    */   private List<UserVO> list;
/*    */   private Page page;
/*    */   
/*    */   public List<UserVO> getList()
/*    */   {
/* 15 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<UserVO> list) {
/* 19 */     this.list = list;
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


/*    */ package com.jtzh.vo.log;
/*    */ import com.jtzh.util.Page;
import com.jtzh.entity.LoginLog;

/*    */ import java.util.List;
/*    */ 
/*    */ public class LoginLogQueryVO
/*    */ {
/*    */   private List<LoginLog> list;
/*    */   private Page page;
/*    */   
/*    */   public List<LoginLog> getList()
/*    */   {
/* 14 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<LoginLog> list) {
/* 18 */     this.list = list;
/*    */   }
/*    */   
/*    */   public Page getPage() {
/* 22 */     return this.page;
/*    */   }
/*    */   
/*    */   public void setPage(Page page) {
/* 26 */     this.page = page;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\log\LoginLogQueryVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package com.jtzh.interceptor;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ public class CorsInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
/*    */   {
/* 13 */     if (request.getHeader("Origin") != null) {
/* 14 */       response.setHeader("Access-Control-Allow-Origin", "*");
/* 15 */       response.setHeader("Access-Control-Allow-Methods", "*");
/* 16 */       response.setHeader("Access-Control-Max-Age", "*");
/* 17 */       response.setHeader("Access-Control-Allow-Headers", "*");
/* 18 */       response.setHeader("Access-Control-Allow-Credentials", "true");
/* 19 */       return true;
/*    */     }
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*    */     throws Exception
/*    */   {}
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\interceptor\CorsInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
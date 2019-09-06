/*    */ package com.jtzh.interceptor;
/*    */ 
/*    */ import com.jtzh.util.JWTUtils;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ public class HeaderTokenInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/* 18 */   private static final Logger logger = LoggerFactory.getLogger(HeaderTokenInterceptor.class);
/*    */   
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
/*    */   {
/* 22 */     String requestURI = request.getRequestURI();
/* 23 */     String token = "";
/* 24 */     if (requestURI.contains("/api")) {
/* 25 */       if (requestURI.contains("/login")) {
/* 26 */         return true;
/*    */       }
/* 28 */       String str = "{errorCode:201,message:token error,data:null}";
/* 29 */       token = request.getHeader("token");
/* 30 */       if (token == null) {
/* 31 */         dealErrorReturn(request, response, str);
/* 32 */         return false;
/*    */       }
/* 34 */       /*Map<String, Claim> claims = JWTUtils.verifyToken(token);
 35        if (claims == null) {
 36          dealErrorReturn(request, response, str);
 37          return false;
           }*/
/* 39 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */ 
/*    */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */ 
/*    */   public void dealErrorReturn(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj)
/*    */   {
/* 59 */     String json = (String)obj;
/* 60 */     PrintWriter writer = null;
/* 61 */     httpServletResponse.setCharacterEncoding("UTF-8");
/* 62 */     httpServletResponse.setContentType("text/html; charset=utf-8");
/* 63 */     httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
/* 64 */     httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
/* 65 */     httpServletResponse.setHeader("Access-Control-Max-Age", "*");
/* 66 */     httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
/* 67 */     httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
/*    */     try {
/* 69 */       writer = httpServletResponse.getWriter();
/* 70 */       writer.print(json);
/*    */     } catch (IOException ex) {
/* 72 */       logger.error("response error", ex);
/*    */     } finally {
/* 74 */       if (writer != null) {
/* 75 */         writer.close();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\interceptor\HeaderTokenInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
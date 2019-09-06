/*    */ package com.jtzh.websocket;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.http.server.ServerHttpRequest;
/*    */ import org.springframework.http.server.ServerHttpResponse;
/*    */ import org.springframework.http.server.ServletServerHttpRequest;
/*    */ import org.springframework.web.socket.WebSocketHandler;
/*    */ import org.springframework.web.socket.server.HandshakeInterceptor;
/*    */ 
/*    */ 
/*    */ public class WebSocketHandshakeInterceptor
/*    */   implements HandshakeInterceptor
/*    */ {
/* 19 */   private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);
/*    */   
/*    */   public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
/* 22 */     if ((request instanceof ServletServerHttpRequest)) {
/* 23 */       ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
/* 24 */       HttpSession session = servletRequest.getServletRequest().getSession(false);
/* 25 */       if (session != null)
/*    */       {
/* 27 */         String userName = (String)session.getAttribute("SESSION_USERNAME");
/* 28 */         if (userName == null) {
/* 29 */           userName = "system-" + session.getId();
/*    */         }
/* 31 */         attributes.put("WEBSOCKET_USERNAME", userName);
/*    */       }
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
/* 38 */     System.out.println("After Handshake");
/*    */   }
/*    */ }

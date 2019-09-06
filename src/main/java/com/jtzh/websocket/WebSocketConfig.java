/*    */ package com.jtzh.websocket;
/*    */ 
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ import org.springframework.web.socket.config.annotation.EnableWebSocket;
/*    */ import org.springframework.web.socket.config.annotation.SockJsServiceRegistration;
/*    */ import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
/*    */ import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
/*    */ import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
/*    */ import org.springframework.web.socket.handler.TextWebSocketHandler;
/*    */ import org.springframework.web.socket.server.HandshakeInterceptor;
/*    */ 
/*    */ @Configuration
/*    */ @EnableWebSocket
/*    */ public class WebSocketConfig implements WebSocketConfigurer
/*    */ {
/*    */   private static final long heartbeatTime = 60000L;
/*    */   @Override
/*    */   public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
/*    */   {
/* 25 */     String websocket_url = "/websocket/socketServer.do";
/* 26 */     registry.addHandler(webSocketHandler(), new String[] { websocket_url })
/* 27 */       .addInterceptors(new HandshakeInterceptor[] { new WebSocketHandshakeInterceptor() });
/*    */     
/* 29 */     String sockjs_url = "/sockjs/socketServer.do";
/* 30 */     registry.addHandler(webSocketHandler(), new String[] { sockjs_url })
/* 31 */       .addInterceptors(new HandshakeInterceptor[] { new WebSocketHandshakeInterceptor() })
/* 32 */       .withSockJS().setHeartbeatTime(60000L);
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public TextWebSocketHandler webSocketHandler()
/*    */   {
/* 38 */     return new WebSocketHandler();
/*    */   }
/*    */ }

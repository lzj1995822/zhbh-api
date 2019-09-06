/*     */ package com.jtzh.websocket;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;

import javax.websocket.server.ServerEndpoint;

/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
		  import org.springframework.stereotype.Component;
/*     */ import org.springframework.web.socket.CloseStatus;
/*     */ import org.springframework.web.socket.TextMessage;
/*     */ import org.springframework.web.socket.WebSocketSession;
/*     */ import org.springframework.web.socket.handler.TextWebSocketHandler;
/*     */ @Component
/*     */ public class WebSocketHandler
/*     */   extends TextWebSocketHandler
/*     */ {
		
/*  17 */   private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketHandler.class);
/*     */   
/*     */ 
/*  20 */   private static final ArrayList<WebSocketSession> users = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 	@Override
/*     */   protected void handleTextMessage(WebSocketSession session, TextMessage message)
/*     */     throws Exception
/*     */   {
/*  32 */     String username = (String)session.getAttributes().get("WEBSOCKET_USERNAME");
/*     */     
/*  34 */     String[] msg = message.toString().split(",");
/*     */     
/*     */ 
/*     */ 
/*  38 */     sendMessageToUser(msg[0], new TextMessage(msg[1]));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Override
/*     */   public void afterConnectionEstablished(WebSocketSession session)
/*     */     throws Exception
/*     */   {
/*  52 */     users.add(session);
/*  53 */     String username = (String)session.getAttributes().get("WEBSOCKET_USERNAME");
/*  54 */     System.out.println("用户 " + username + " Connection Established");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Override
/*     */   public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
/*     */     throws Exception
/*     */   {
/*  68 */     String username = (String)session.getAttributes().get("WEBSOCKET_USERNAME");
/*  69 */     System.out.println("用户 " + username + " Connection closed. Status: " + status);
/*  70 */     users.remove(session);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Override
/*     */   public void handleTransportError(WebSocketSession session, Throwable exception)
/*     */     throws Exception
/*     */   {
/*  82 */     String username = (String)session.getAttributes().get("WEBSOCKET_USERNAME");
/*  83 */     if (session.isOpen()) {
/*  84 */       session.close();
/*     */     }
/*  86 */     System.out.println("用户: " + username + " websocket connection closed......");
/*  87 */     users.remove(session);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sendMessageToUsers(TextMessage message)
/*     */   {
/*  96 */     for (WebSocketSession user : users) {
/*     */       try {
/*  98 */         if (user.isOpen()) {
/*  99 */           user.sendMessage(message);
/*     */         }
/*     */       } catch (IOException e) {
/* 102 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sendMessageToUser(String userName, TextMessage message)
/*     */   {
/* 114 */     if (users.size() > 0) {
/* 115 */       for (WebSocketSession user : users) {
/* 116 */         if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
/*     */           try {
/* 118 */             if (user.isOpen()) {
/* 119 */               user.sendMessage(message);
/*     */             }
/*     */           } catch (IOException e) {
/* 122 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

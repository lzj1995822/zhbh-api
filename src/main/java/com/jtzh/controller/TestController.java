/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
/*    */ import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.socket.TextMessage;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/test"})
/*    */ public class TestController
/*    */ {
/*    */   private WebSocketHandler webSocketHandler;
/*    */   
/*    */   @RequestMapping({"/send"})
/*    */   @ResponseBody
/*    */   public ExtResponse sendMessageToUser(String userid)
/*    */   {
/* 23 */     this.webSocketHandler.sendMessageToUser(userid, new TextMessage("你好，欢迎测试！！！！"));
/* 24 */     return ResponseUtil.success(null);
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\TestController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
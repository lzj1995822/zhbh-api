/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.util.CommonUtils;
/*     */ import com.jtzh.util.JWTUtils;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.app.UserVO;
/*     */ import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.LoginLog;
import com.jtzh.service.APPService;
import com.jtzh.service.LoginLogService;

/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.socket.TextMessage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @CrossOrigin
/*     */ @Controller
/*     */ @RequestMapping({"/api"})
/*     */ public class RootController
/*     */ {
/*     */   @Autowired
/*     */   private APPService appService;
/*     */   @Autowired
/*     */   private HttpSession session;
/*     */   @Autowired
/*     */   private LoginLogService loginLogService;
/*     */   @Autowired
/*     */   private HttpServletRequest request;
/*     */   @Autowired
/*     */   private HttpServletResponse response;
/*     */   private WebSocketHandler webSocketHandler;
/*     */   
/*     */   @RequestMapping({"/login"})
/*     */   @ResponseBody
/*     */   public ExtResponse userLogin(String username, String password, String source)
/*     */     throws IOException
/*     */   {
/*  55 */     UserVO user = this.appService.APPLogin(username, password);
/*  56 */     if (user != null) {
/*  57 */       Map map = new HashMap();
/*  58 */       String token = JWTUtils.createToken(user.getUserID(), user.getUserName());
/*  59 */       map.put("token", token);
/*  60 */       if (source.equals("web")) {
/*  61 */         if ((user.getUserRole() == null) || (user.getUserRole().equals(""))) {
/*  62 */           LoginLog loginLog = new LoginLog();
/*  63 */           loginLog.setUserName(username);
/*  64 */           loginLog.setDate(new Date());
/*  65 */           loginLog.setIP(CommonUtils.getIpAddr(this.request));
/*  66 */           loginLog.setResult("失败");
/*  67 */           this.loginLogService.addLog(loginLog);
/*  68 */           return ResponseUtil.error("无权限访问!");
/*     */         }
/*  70 */         if (user.getUserRole().equals("APP")) {
/*  71 */           LoginLog loginLog = new LoginLog();
/*  72 */           loginLog.setUserName(username);
/*  73 */           loginLog.setDate(new Date());
/*  74 */           loginLog.setIP(CommonUtils.getIpAddr(this.request));
/*  75 */           loginLog.setResult("失败");
/*  76 */           this.loginLogService.addLog(loginLog);
/*  77 */           return ResponseUtil.error("无权限访问!");
/*     */         }
/*  79 */         LoginLog loginLog = new LoginLog();
/*  80 */         loginLog.setUserName(username);
/*  81 */         loginLog.setDate(new Date());
/*  82 */         loginLog.setIP(CommonUtils.getIpAddr(this.request));
/*  83 */         loginLog.setResult("成功");
/*  84 */         this.loginLogService.addLog(loginLog);
/*  85 */         Map map1 = this.loginLogService.getLoginInfo(username);
/*  86 */         map.put("user", user);
/*  87 */         map.put("loginInfo", map1);
/*  88 */         this.session.setAttribute(token, user);
/*  89 */         this.session.setAttribute("SESSION_USERNAME", user.getUserID() + "");
/*     */       }
/*  91 */       else if (source.equals("APP")) {
/*  92 */         if ((user.getUserRole() == null) || (user.getUserRole().equals(""))) {
/*  93 */           return ResponseUtil.error("无权限访问!");
/*     */         }
/*  95 */         if (user.getUserRole().equals("APP")) {
/*  96 */           map.put("userid", user.getUserID());
/*  97 */           map.put("username", user.getUserName());
/*  98 */           map.put("realName", user.getRealName());
/*  99 */           map.put("certID", user.getCertID());
/* 100 */           map.put("mobileTel", user.getMobileTel());
/* 101 */           map.put("dept", user.getDept());
/* 102 */           map.put("netGridID", user.getNetGridID());
/*     */         } else {
/* 104 */           return ResponseUtil.error("无权限访问!");
/*     */         }
/*     */       }
/*     */       
/* 108 */       return ResponseUtil.success(map);
/*     */     }
/* 110 */     LoginLog loginLog = new LoginLog();
/* 111 */     loginLog.setUserName(username);
/* 112 */     loginLog.setDate(new Date());
/* 113 */     loginLog.setIP(CommonUtils.getIpAddr(this.request));
/* 114 */     loginLog.setResult("失败");
/* 115 */     this.loginLogService.addLog(loginLog);
/* 116 */     return ResponseUtil.error("用户名或密码错误!");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getLoginUserInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getLoginUserInfo(String token)
/*     */   {
/* 123 */     UserVO userVO = (UserVO)this.session.getAttribute(token);
/* 124 */     return ResponseUtil.success(userVO);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 

  @RequestMapping({"/send"})
  @ResponseBody
   public String send(String username, String message)
  {
     /*this.webSocketHandler.sendMessageToUser(username, new TextMessage(message));*/
     return null;
   }
 }

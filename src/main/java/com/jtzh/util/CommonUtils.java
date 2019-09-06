/*    */ package com.jtzh.util;
/*    */ 
/*    */ import com.jtzh.common.Constants;

import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
/*    */ import java.util.Properties;
/*    */ import java.util.UUID;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ public class CommonUtils
/*    */ {
/*    */   public static String getRootPath(String propName)
/*    */   {
///* 14 */     Properties prop = new Properties();
///* 15 */     java.io.InputStream in = CommonUtils.class.getResourceAsStream("/common.properties");
///*    */     try {
///* 17 */       prop.load(in);
///*    */     } catch (IOException e) {
///* 19 */       e.printStackTrace();
///*    */     }
///* 21 */     String root_path = prop.getProperty(propName);
/* 22 */     return Constants.ROOT_PATH;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean deleteFile(String fileName)
/*    */   {
/* 32 */     File file = new File(fileName);
/* 33 */     if ((file.isFile()) && (file.exists())) {
/* 34 */       return file.delete();
/*    */     }
/* 36 */     return false;
/*    */   }
/*    */   
/*    */   public static String getUUID() {
/* 40 */     return UUID.randomUUID().toString();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static String getIpAddr(HttpServletRequest request)
/*    */   {
/* 47 */     String ip = request.getHeader("x-forwarded-for");
/* 48 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 49 */       ip = request.getHeader("Proxy-Client-IP");
/*    */     }
/* 51 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 52 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*    */     }
/* 54 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 55 */       ip = request.getRemoteAddr();
/* 56 */       if (ip.equals("127.0.0.1"))
/*    */       {
/* 58 */         InetAddress inet = null;
/*    */         try {
/* 60 */           inet = InetAddress.getLocalHost();
/*    */         } catch (Exception e) {
/* 62 */           e.printStackTrace();
/*    */         }
/* 64 */         ip = inet.getHostAddress();
/*    */       }
/*    */     }
/*    */     
/* 68 */     if ((ip != null) && (ip.length() > 15) && 
/* 69 */       (ip.indexOf(",") > 0)) {
/* 70 */       ip = ip.substring(0, ip.indexOf(","));
/*    */     }
/*    */     
/* 73 */     return ip;
/*    */   }
/*    */ }



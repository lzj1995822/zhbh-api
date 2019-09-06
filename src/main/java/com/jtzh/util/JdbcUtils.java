/*    */ package com.jtzh.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JdbcUtils
/*    */ {
/* 18 */   static String url = "jdbc:mysql://127.0.0.1:3306/MSMIS_DB?useUnicode=true&characterEncoding=utf-8&useSSL=false";
/* 19 */   static String user = "root";
/* 20 */   static String password = "klxj001";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Connection getConnection()
/*    */   {
/* 28 */     Connection conn = null;
/*    */     try {
/* 30 */       Class.forName("com.mysql.jdbc.Driver");
/* 31 */       conn = DriverManager.getConnection(url, user, password);
/* 32 */       System.out.println("success");
/*    */     } catch (Exception e) {
/* 34 */       throw new RuntimeException();
/*    */     }
/* 36 */     return conn;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void close(ResultSet rs, Statement st, Connection conn)
/*    */   {
/*    */     try
/*    */     {
/* 47 */       if (rs != null) {
/* 48 */         rs.close();
/*    */       }
/*    */     } catch (SQLException localSQLException) {}
/*    */     try {
/* 52 */       if (st != null) {
/* 53 */         st.close();
/*    */       }
/*    */     } catch (SQLException localSQLException1) {}
/*    */     try {
/* 57 */       if (conn != null) {
/* 58 */         conn.close();
/*    */       }
/*    */     }
/*    */     catch (SQLException localSQLException2) {}
/*    */   }
/*    */ }



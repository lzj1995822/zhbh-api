/*    */ package com.jtzh.util;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DateUtil
/*    */ {
/*    */   public static Date strToDate(String str) throws java.text.ParseException
/*    */   {
/* 10 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 11 */     Date date = sdf.parse(str);
/* 12 */     return date;
/*    */   }
/*    */   
/*    */   public static String dateToStr(Date date) {
/* 16 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 17 */     String str = sdf.format(date);
/* 18 */     return str;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Date strToDateTime(String str)
/*    */     throws java.text.ParseException
/*    */   {
/* 29 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 30 */     Date date = sdf.parse(str);
/* 31 */     return date;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static String transferLongToDate(String dateFormat, Long millSec)
/*    */   {
/* 38 */     SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
/* 39 */     Date date = new Date(millSec.longValue());
/* 40 */     return sdf.format(date);
/*    */   }
/*    */ }


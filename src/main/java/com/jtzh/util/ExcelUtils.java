/*     */ package com.jtzh.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ import org.apache.poi.ss.usermodel.WorkbookFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExcelUtils
/*     */ {
/*     */   public static boolean exportExcel(int titleRows, String templetpath, List<String[]> datas, String outPath, int maxRow)
/*     */   {
/*  45 */     InputStream is = null;
/*  46 */     Workbook workbook = null;
/*  47 */     FileOutputStream os = null;
/*  48 */     Sheet sheet = null;
/*     */     try {
/*  50 */       is = new FileInputStream(new File(templetpath));
/*  51 */       workbook = WorkbookFactory.create(is);
/*     */       
/*     */ 
/*     */ 
/*  55 */       os = new FileOutputStream(new File(outPath));
/*     */       
/*  57 */       sheet = workbook.getSheetAt(0);
/*  58 */       int countRow = sheet.getLastRowNum();
/*     */       
/*  60 */       System.out.println("countRow==" + countRow);
/*     */       
/*  62 */       for (int i = titleRows; i <= countRow; i++) {
/*  63 */         Row row = sheet.getRow(i);
/*  64 */         if (row != null) {
/*  65 */           sheet.removeRow(row);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  70 */       for (int i = 0; i < datas.size(); i++) {
/*  71 */         String[] rowDatas = (String[])datas.get(i);
/*  72 */         Row row = sheet.createRow(i + titleRows);
/*  73 */         for (int j = 0; j < rowDatas.length; j++) {
/*  74 */           System.out.println(rowDatas[j]);
/*  75 */           row.createCell(j).setCellValue(rowDatas[j]);
/*     */         }
/*     */       }
/*  78 */       workbook.write(os);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  81 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/*  84 */         is.close();
/*     */       }
/*     */       catch (IOException e) {
/*  87 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */
return true;   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<String[]> importExcel(InputStream is, int endCol, int startRow)
/*     */     throws InvalidFormatException, IOException
/*     */   {
/* 108 */     List<String[]> list = new ArrayList();
/* 109 */     Workbook workbook = WorkbookFactory.create(is);
/*     */     
/*     */ 
/* 112 */     Sheet sheet = workbook.getSheetAt(0);
/* 113 */     System.out.println(sheet.getLastRowNum() + "====总行数");
/* 114 */     for (int i = 0; i <= sheet.getLastRowNum() - startRow; i++)
/*     */     {
/* 116 */       StringBuffer sb = new StringBuffer();
/* 117 */       String[] contents = new String[endCol];
/* 118 */       Row row = sheet.getRow(startRow);
/* 119 */       for (int j = 0; j < endCol; j++) {
/* 120 */         Cell cell = row.getCell(j);
/* 121 */         contents[j] = cell.getStringCellValue();
/* 122 */         sb.append(cell.getStringCellValue());
/*     */       }
/*     */       
/* 125 */       if (sb.length() > 0)
/*     */       {
/* 127 */         list.add(contents);
/*     */       }
/*     */     }
/* 130 */     is.close();
/*     */     
/* 132 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 144 */       List<String[]> datas = new ArrayList();
/* 145 */       String[] s = new String[127];
/* 146 */       for (int j = 0; j < 10; j++) {
/* 147 */         for (int i = 0; i < s.length; i++) {
/* 148 */           s[i] = (i + "数据");
/*     */         }
/* 150 */         datas.add(s);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */       InputStream is = new FileInputStream(new File("D:\\jy2_cppy.xls"));
/*     */       
/* 163 */       List<String[]> listString = importExcel(is, 127, 4);
/* 164 */       for (String[] strings : listString) {
/* 165 */         String s1 = "";
/* 166 */         for (int i = 0; i < strings.length; i++) {
/* 167 */           s1 = s1 + strings[i];
/*     */         }
/* 169 */         System.out.println(s1);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 173 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }



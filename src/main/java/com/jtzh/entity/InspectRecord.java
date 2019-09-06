/*     */ package com.jtzh.entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
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
/*     */ public class InspectRecord
/*     */ {
/*     */   private Long inspectRecID;
/*     */   private String inspecterCertID;
/*     */   private String inspecterName;
/*     */   private Date inspectDateTime;
/*     */   private String inspectContent;
/*     */   private String enterpriseUSCcode;
/*     */   private String remarks;
/*     */   
/*     */   public Long getInspectRecID()
/*     */   {
/*  81 */     return this.inspectRecID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInspectRecID(Long inspectRecID)
/*     */   {
/*  93 */     this.inspectRecID = inspectRecID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInspecterCertID()
/*     */   {
/* 105 */     return this.inspecterCertID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInspecterCertID(String inspecterCertID)
/*     */   {
/* 117 */     this.inspecterCertID = inspecterCertID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInspecterName()
/*     */   {
/* 129 */     return this.inspecterName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInspecterName(String inspecterName)
/*     */   {
/* 141 */     this.inspecterName = inspecterName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getInspectDateTime()
/*     */   {
/* 155 */     return this.inspectDateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInspectDateTime(Date inspectDateTime)
/*     */   {
/* 167 */     this.inspectDateTime = inspectDateTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getInspectContent()
/*     */   {
/* 179 */     return this.inspectContent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInspectContent(String inspectContent)
/*     */   {
/* 191 */     this.inspectContent = inspectContent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEnterpriseUSCcode()
/*     */   {
/* 203 */     return this.enterpriseUSCcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEnterpriseUSCcode(String enterpriseUSCcode)
/*     */   {
/* 215 */     this.enterpriseUSCcode = enterpriseUSCcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRemarks()
/*     */   {
/* 227 */     return this.remarks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemarks(String remarks)
/*     */   {
/* 239 */     this.remarks = remarks;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\InspectRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
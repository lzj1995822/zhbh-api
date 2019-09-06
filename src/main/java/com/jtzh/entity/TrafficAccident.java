/*     */ package com.jtzh.entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */

/*     */ public class TrafficAccident
/*     */ {
/*     */   private Long trafficAccidentID;
/*     */   private String trafficAccidentName;
/*     */   private String trafficAccidentKind;
/*     */   private String trafficAccidentTypeValue;
/*     */   private String trafficAccidentContent;
/*     */   private Date trafficAccidentStartDateTime;
/*     */   private Date trafficAccidentEndDateTime;
/*     */   private Double trafficAccidentHappenLongitude;
/*     */   private Double trafficAccidentHappenLatitude;
/*     */   private String trafficAccidentStatusTypeValue;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private String currentResponsiblePersonName;
/*     */   private String currentResponsiblePersonContact;
/*     */   private Long netGridID;
/*     */   
/*     */   public Long getTrafficAccidentID()
/*     */   {
/* 137 */     return this.trafficAccidentID;
/*     */   }

/*     */ 
/*     */   public void setTrafficAccidentID(Long trafficAccidentID)
/*     */   {
/* 148 */     this.trafficAccidentID = trafficAccidentID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTrafficAccidentName()
/*     */   {
/* 159 */     return this.trafficAccidentName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTrafficAccidentName(String trafficAccidentName)
/*     */   {
/* 170 */     this.trafficAccidentName = trafficAccidentName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTrafficAccidentKind()
/*     */   {
/* 181 */     return this.trafficAccidentKind;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTrafficAccidentKind(String trafficAccidentKind)
/*     */   {
/* 192 */     this.trafficAccidentKind = trafficAccidentKind;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTrafficAccidentTypeValue()
/*     */   {
/* 203 */     return this.trafficAccidentTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTrafficAccidentTypeValue(String trafficAccidentTypeValue)
/*     */   {
/* 214 */     this.trafficAccidentTypeValue = trafficAccidentTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTrafficAccidentContent()
/*     */   {
/* 225 */     return this.trafficAccidentContent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTrafficAccidentContent(String trafficAccidentContent)
/*     */   {
/* 236 */     this.trafficAccidentContent = trafficAccidentContent;
/*     */   }

/*     */ 
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getTrafficAccidentStartDateTime()
/*     */   {
/* 249 */     return this.trafficAccidentStartDateTime;
/*     */   }

/*     */ 
/*     */   public void setTrafficAccidentStartDateTime(Date trafficAccidentStartDateTime)
/*     */   {
/* 260 */     this.trafficAccidentStartDateTime = trafficAccidentStartDateTime;
/*     */   }

/*     */ 
/*     */   public Date getTrafficAccidentEndDateTime()
/*     */   {
/* 271 */     return this.trafficAccidentEndDateTime;
/*     */   }

/*     */ 
/*     */   public void setTrafficAccidentEndDateTime(Date trafficAccidentEndDateTime)
/*     */   {
/* 282 */     this.trafficAccidentEndDateTime = trafficAccidentEndDateTime;
/*     */   }

/*     */ 
/*     */   public Double getTrafficAccidentHappenLongitude()
/*     */   {
/* 293 */     return this.trafficAccidentHappenLongitude;
/*     */   }

/*     */ 
/*     */   public void setTrafficAccidentHappenLongitude(Double trafficAccidentHappenLongitude)
/*     */   {
/* 304 */     this.trafficAccidentHappenLongitude = trafficAccidentHappenLongitude;
/*     */   }

/*     */ 
/*     */   public Double getTrafficAccidentHappenLatitude()
/*     */   {
/* 315 */     return this.trafficAccidentHappenLatitude;
/*     */   }

/*     */ 
/*     */ 
/*     */   public void setTrafficAccidentHappenLatitude(Double trafficAccidentHappenLatitude)
/*     */   {
/* 326 */     this.trafficAccidentHappenLatitude = trafficAccidentHappenLatitude;
/*     */   }
/*     */   

/*     */ 
/*     */   public String getTrafficAccidentStatusTypeValue()
/*     */   {
/* 337 */     return this.trafficAccidentStatusTypeValue;
/*     */   }

/*     */ 
/*     */   public void setTrafficAccidentStatusTypeValue(String trafficAccidentStatusTypeValue)
/*     */   {
/* 348 */     this.trafficAccidentStatusTypeValue = trafficAccidentStatusTypeValue;
/*     */   }

/*     */   public String getCurrentRemarks()
/*     */   {
/* 359 */     return this.currentRemarks;
/*     */   }
/*     */   

/*     */   public void setCurrentRemarks(String currentRemarks)
/*     */   {
/* 370 */     this.currentRemarks = currentRemarks;
/*     */   }

/*     */   public String getCurrentResponsiblePersonCertID()
/*     */   {
/* 381 */     return this.currentResponsiblePersonCertID;
/*     */   }
/*     */
/*     */   public void setCurrentResponsiblePersonCertID(String currentResponsiblePersonCertID)
/*     */   {
/* 392 */     this.currentResponsiblePersonCertID = currentResponsiblePersonCertID;
/*     */   }
/*     */   

/*     */   public String getCurrentResponsiblePersonName()
/*     */   {
/* 403 */     return this.currentResponsiblePersonName;
/*     */   }

/*     */ 
/*     */   public void setCurrentResponsiblePersonName(String currentResponsiblePersonName)
/*     */   {
/* 414 */     this.currentResponsiblePersonName = currentResponsiblePersonName;
/*     */   }
/*     */
/*     */ 
/*     */   public String getCurrentResponsiblePersonContact()
/*     */   {
/* 425 */     return this.currentResponsiblePersonContact;
/*     */   }

/*     */   public void setCurrentResponsiblePersonContact(String currentResponsiblePersonContact)
/*     */   {
/* 436 */     this.currentResponsiblePersonContact = currentResponsiblePersonContact;
/*     */   }

/*     */   public Long getNetGridID()
/*     */   {
/* 447 */     return this.netGridID;
/*     */   }

/*     */   public void setNetGridID(Long netGridID)
/*     */   {
/* 458 */     this.netGridID = netGridID;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\TrafficAccident.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
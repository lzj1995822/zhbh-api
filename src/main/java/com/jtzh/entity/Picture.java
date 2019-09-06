/*     */ package com.jtzh.entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Picture
/*     */ {
/*     */   private Long pictureID;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String picturePath;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String pictureName;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String pictureSuffix;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getPictureID()
/*     */   {
/*  44 */     return this.pictureID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPictureID(Long pictureID)
/*     */   {
/*  55 */     this.pictureID = pictureID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPicturePath()
/*     */   {
/*  66 */     return this.picturePath;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPicturePath(String picturePath)
/*     */   {
/*  77 */     this.picturePath = picturePath;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPictureName()
/*     */   {
/*  88 */     return this.pictureName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPictureName(String pictureName)
/*     */   {
/*  99 */     this.pictureName = pictureName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPictureSuffix()
/*     */   {
/* 110 */     return this.pictureSuffix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPictureSuffix(String pictureSuffix)
/*     */   {
/* 121 */     this.pictureSuffix = pictureSuffix;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 126 */     return "Picture{pictureID=" + this.pictureID + ", picturePath='" + this.picturePath + '\'' + ", pictureName='" + this.pictureName + '\'' + ", pictureSuffix='" + this.pictureSuffix + '\'' + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\Picture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
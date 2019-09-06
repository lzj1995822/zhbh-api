/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.NonPublicEconomyOrg;
import com.jtzh.entity.SocietyOrg;
import com.jtzh.service.NonpublicService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @CrossOrigin
/*     */ @Controller
/*     */ @RequestMapping({"/api/Nonpublic"})
/*     */ public class NonpublicController
/*     */ {
/*     */   @Autowired
/*     */   private NonpublicService nonpublicService;
/*     */   
/*     */   @RequestMapping({"/getNopublicCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNopublicCode()
/*     */   {
/*  28 */     return ResponseUtil.success(this.nonpublicService.getNopublicCode());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNonPublicEconomyOrgInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse NonPublicEconomyOrgInfo(String name, String type, Long netGridID, Integer isLogisticsEnterprise, Integer isKeyEnterprise, int page, int pageSize)
/*     */   {
/*  35 */     return ResponseUtil.success(this.nonpublicService.getNonPublicEconomyOrgInfo(name, type, netGridID, isLogisticsEnterprise, isKeyEnterprise, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNonPublicEconomyOrgDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNonPublicEconomyOrgDetailByCode(String code)
/*     */   {
/*  42 */     return ResponseUtil.success(this.nonpublicService.getNonPublicEconomyOrgDetailByCode(code));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addNonpublic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNonpublic(@RequestBody NonPublicEconomyOrg org) {
/*  48 */     return ResponseUtil.success(Boolean.valueOf(this.nonpublicService.addNonpublic(org)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateNonpublic"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateNonpublic(@RequestBody NonPublicEconomyOrg org) {
/*  54 */     return ResponseUtil.success(Boolean.valueOf(this.nonpublicService.updateNonpublic(org)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteNonpublic"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteNonpublic(String code) {
/*  60 */     return ResponseUtil.success(Boolean.valueOf(this.nonpublicService.deleteNonpublic(code)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/uploadEnterprisePicture"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadEnterprisePicture(MultipartFile file, String code) {
/*  66 */     return ResponseUtil.success(Boolean.valueOf(this.nonpublicService.uploadEnterprisePicture(file, code)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getToUpdateInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getToUpdateInfo(String code) {
/*  72 */     return ResponseUtil.success(this.nonpublicService.getToUpdateInfo(code));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getEconomyHistogram"})
/*     */   @ResponseBody
/*     */   public ExtResponse getHistogram() {
/*  78 */     return ResponseUtil.success(this.nonpublicService.getEconomyHistogram());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSocietyOrgInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSocietyOrgInfo(String name, String type, Integer netGridID, int page, int pageSize) {
/*  84 */     return ResponseUtil.success(this.nonpublicService.getSocietyOrgInfo(name, type, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSocietyOrgDetailByCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSocietyOrgDetailByCode(String code) {
/*  90 */     return ResponseUtil.success(this.nonpublicService.getSocietyOrgDetailByCode(code));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSocietyOrg"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSocietyOrg(@RequestBody SocietyOrg org) {
/*  96 */     return ResponseUtil.success(Boolean.valueOf(this.nonpublicService.addSocietyOrg(org)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSocietyOrg"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSocietyOrg(@RequestBody SocietyOrg org) {
/* 102 */     return ResponseUtil.success(Boolean.valueOf(this.nonpublicService.updateSocietyOrg(org)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSocietyOrg"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSocietyOrg(String code) {
/* 108 */     return ResponseUtil.success(Boolean.valueOf(this.nonpublicService.deleteSocietyOrg(code)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getToUpdateSocietyOrgInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getToUpdateSocietyOrgInfo(String code) {
/* 114 */     return ResponseUtil.success(this.nonpublicService.getToUpdateSocietyOrgInfo(code));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSocietyOrgHistogram"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSocietyOrgHistogram() {
/* 120 */     return ResponseUtil.success(this.nonpublicService.getSocietyOrgHistogram());
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\NonpublicController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
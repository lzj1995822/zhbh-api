/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.SpecialPersonService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ @CrossOrigin
/*     */ @Controller
/*     */ @RequestMapping({"/api/specialPerson"})
/*     */ public class SpecialPersonController
/*     */ {
/*     */   @Autowired
/*     */   private SpecialPersonService personService;
/*     */   
/*     */   @RequestMapping({"/getSpecialPersonCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSpecialPersonCount()
/*     */   {
/*  25 */     return ResponseUtil.success(this.personService.getSpecialPersonCount());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getPsychoticInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getPsychoticInfo(String name, String certifID, Integer netGridID, int page, int pageSize) {
/*  31 */     return ResponseUtil.success(this.personService.getPsychoticInfo(name, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getEmancipistInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getEmancipistInfo(String name, String certifID, Integer netGridID, int page, int pageSize) {
/*  37 */     return ResponseUtil.success(this.personService.getEmancipistInfo(name, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDrugAddictsInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDrugAddictsInfo(String name, String certifID, Integer netGridID, int page, int pageSize) {
/*  43 */     return ResponseUtil.success(this.personService.getDrugAddictsInfo(name, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getCommunityCorrectionerInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getCommunityCorrectionerInfo(String name, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/*  50 */     return 
/*  51 */       ResponseUtil.success(this.personService.getCommunityCorrectionerInfo(name, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAIDSdiseasenfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAIDSdiseasenfo(String name, String certifID, Integer netGridID, int page, int pageSize) {
/*  57 */     return ResponseUtil.success(this.personService.getAIDSdiseasenfo(name, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSpecialDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSpecialDetail(String certifID, String type) {
/*  63 */     return ResponseUtil.success(this.personService.getSpecialDetail(certifID, type));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSpecialPerson"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSpecialPerson(String object, String type) {
/*  69 */     return ResponseUtil.success(Boolean.valueOf(this.personService.addSpecialPerson(object, type)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSpecialPersonCountByType"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSpecialPersonCountByType() {
/*  75 */     return ResponseUtil.success(this.personService.getSpecialPersonCountByType());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSpecialPersonPieCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSpecialPersonPieCount(String type) {
/*  81 */     return ResponseUtil.success(this.personService.getSpecialPersonPieCount(type));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSpecialPerson"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSpecialPerson(String object, String type) {
/*  87 */     return ResponseUtil.success(Boolean.valueOf(this.personService.updateSpecialPerson(object, type)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSpecialPerson"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSpecialPerson(Long id, String type) {
/*  93 */     return ResponseUtil.success(Boolean.valueOf(this.personService.deleteSpecialPerson(id, type)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/checkSpecialPersonByCertifID"})
/*     */   @ResponseBody
/*     */   public ExtResponse checkSpecialPersonByCertifID(String certifID, String type) {
/*  99 */     return ResponseUtil.success(Boolean.valueOf(this.personService.checkSpecialPersonByCertifID(certifID, type)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyYoungersQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyYoungersQuery(String name, String certifID, Integer netGridID, int page, int pageSize) {
/* 105 */     return ResponseUtil.success(this.personService.getKeyYoungersQuery(name, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyYoungerHistogramCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyYoungerHistogramCount() {
/* 111 */     return ResponseUtil.success(this.personService.getKeyYoungerHistogramCount());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyYoungerPieCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyYoungerPieCount() {
/* 117 */     return ResponseUtil.success(this.personService.getKeyYoungerPieCount());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyPetitionersQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyPetitionersQuery(String name, String certifID, Integer netGridID, int page, int pageSize) {
/* 123 */     return ResponseUtil.success(this.personService.getKeyPetitionersQuery(name, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyPetitionersPieCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyPetitionersPieCount() {
/* 129 */     return ResponseUtil.success(this.personService.getKeyPetitionersPieCount());
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\SpecialPersonController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
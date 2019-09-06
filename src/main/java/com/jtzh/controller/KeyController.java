/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.KeyDriver;
import com.jtzh.entity.KeyVehicles;
import com.jtzh.service.KeyService;

/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @org.springframework.web.bind.annotation.CrossOrigin
/*     */ @RequestMapping({"/api/key"})
/*     */ @org.springframework.stereotype.Controller
/*     */ public class KeyController
/*     */ {
/*     */   @org.springframework.beans.factory.annotation.Autowired
/*     */   private KeyService keyService;
/*     */   
/*     */   @RequestMapping({"/getVechiclesCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getVideoCode()
/*     */   {
/*  26 */     return ResponseUtil.success(this.keyService.getVechiclesCode());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getVehiclesInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getVehiclesInfo(String vehiclesHolderName, String vehiclesHolderCertID, String vechiclesNumber, Integer netGridID, int page, int pageSize)
/*     */   {
/*  33 */     return ResponseUtil.success(this.keyService.getVehiclesInfo(vehiclesHolderName, vehiclesHolderCertID, vechiclesNumber, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/getDetailByID"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDetailByID(Long id)
/*     */   {
/*  41 */     return ResponseUtil.success(this.keyService.getDetailByID(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addKeyVehicles"})
/*     */   @ResponseBody
/*     */   public ExtResponse addKeyVehicles(@RequestBody KeyVehicles vehicles) {
/*  47 */     return ResponseUtil.success(this.keyService.addKeyVehicles(vehicles));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/uploadKeyVehiclesPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadKeyVehiclesPictures(@RequestParam(value="file", required=false) MultipartFile[] file, Long id)
/*     */   {
/*  54 */     return ResponseUtil.success(Boolean.valueOf(this.keyService.uploadKeyVehiclesPictures(file, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateKeyVehicles"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateKeyVehicles(@RequestBody KeyVehicles vehicles) {
/*  60 */     return ResponseUtil.success(Boolean.valueOf(this.keyService.updateKeyVehicles(vehicles)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteKeyVehicles"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteKeyVehicles(Long id) {
/*  66 */     return ResponseUtil.success(Boolean.valueOf(this.keyService.deleteKeyVehicles(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDrivingLicenseCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDrivingLicenseCode() {
/*  72 */     return ResponseUtil.success(this.keyService.getDrivingLicenseCode());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyDriverInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyDriverInfo(String keyDriverName, String certifID, Integer netGridID, int page, int pageSize)
/*     */   {
/*  79 */     return ResponseUtil.success(this.keyService.getKeyDriverInfo(keyDriverName, certifID, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addKeyDriver"})
/*     */   @ResponseBody
/*     */   public ExtResponse addKeyDriver(@RequestBody KeyDriver driver) {
/*  85 */     return ResponseUtil.success(this.keyService.addKeyDriver(driver));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/uploadKeyDriverPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadKeyDriverPictures(@RequestParam(value="file", required=false) MultipartFile[] file, Long id) {
/*  91 */     return ResponseUtil.success(Boolean.valueOf(this.keyService.uploadKeyDriverPictures(file, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateKeyDriver"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateKeyDriver(@RequestBody KeyDriver driver) {
/*  97 */     return ResponseUtil.success(Boolean.valueOf(this.keyService.updateKeyDriver(driver)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteKeyDriver"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteKeyDriver(Long id) {
/* 103 */     return ResponseUtil.success(Boolean.valueOf(this.keyService.deleteKeyDriver(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDetaileByDriverID"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDetaileByDriverID(Long id) {
/* 109 */     return ResponseUtil.success(this.keyService.getDetaileByDriverID(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDetailToUpdateDriver"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDetailToUpdateDriver(Long id) {
/* 115 */     return ResponseUtil.success(this.keyService.getDetailToUpdateDriver(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyEnterpriseUSCcode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyEnterpriseUSCcode() {
/* 121 */     return ResponseUtil.success(this.keyService.getKeyEnterpriseUSCcode());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getInspectRecDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyEnterpriseUSCcode(Long id) {
/* 127 */     return ResponseUtil.success(this.keyService.getInspectRecDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addInspectRecord"})
/*     */   @ResponseBody
/*     */   public ExtResponse addInspectRecord(@RequestBody com.jtzh.entity.InspectRecord record) {
/* 133 */     return ResponseUtil.success(Boolean.valueOf(this.keyService.addInspectRecord(record)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getInspectRecInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getInspectRecInfo(String inspecterName, String inspectDateTime, String enterpriseUSCcode, int page, int pageSize)
/*     */   {
/* 140 */     return ResponseUtil.success(this.keyService
/* 141 */       .getInspectRecInfo(inspecterName, inspectDateTime, enterpriseUSCcode, page, pageSize));
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\KeyController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
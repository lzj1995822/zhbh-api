/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.ServedPersonService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ @CrossOrigin
/*    */ @Controller
/*    */ @RequestMapping({"/api/servedPerson"})
/*    */ public class ServedPersonController
/*    */ {
/*    */   @Autowired
/*    */   private ServedPersonService servedPersonService;
/*    */   
/*    */   @RequestMapping({"/getServedPersonCount"})
/*    */   @ResponseBody
/*    */   public ExtResponse getServedPersonCount()
/*    */   {
/* 27 */     return ResponseUtil.success(this.servedPersonService.getServedPersonCount());
/*    */   }
/*    */   
/*    */   @RequestMapping({"/checkServedPersonCertifID"})
/*    */   @ResponseBody
/*    */   public ExtResponse checkCertifID(@RequestParam("certifID") String certifID) {
/* 33 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonService.checkCertifID(certifID)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateServedPersonPhoto"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateServedPersonPhoto(MultipartFile file, Long id)
/*    */   {
/* 40 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonService.updateServedPersonPhoto(file, id)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateServedPerson"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateServedPerson(String object, String type) {
/* 46 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonService.updateServedPerson(object, type)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/deleteServedPerson"})
/*    */   @ResponseBody
/*    */   public ExtResponse deleteServedPerson(String id, String type) {
/* 52 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonService.deleteServedPerson(id, type)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/selectByNameAndCertifID"})
/*    */   @ResponseBody
/*    */   public ExtResponse selectByNameAndCertifID(String name, String certifID) {
/* 58 */     return ResponseUtil.success(this.servedPersonService.selectByNameAndCertifID(name, certifID));
/*    */   }
        @RequestMapping({"/selectByNameAndCertifIDGh"})
        @ResponseBody
       public ExtResponse selectByNameAndCertifID(String name, String certifID,int page, int pageSize) {
             return ResponseUtil.success(this.servedPersonService.selectByNameAndCertifIDGh(name, certifID,page,pageSize));
      }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\ServedPersonController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
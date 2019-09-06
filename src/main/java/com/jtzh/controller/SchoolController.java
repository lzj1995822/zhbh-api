/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.School;
import com.jtzh.entity.SchoolVideo;
import com.jtzh.service.SchoolService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;


/*     */
/*     */ @org.springframework.web.bind.annotation.CrossOrigin
/*     */ @Controller
/*     */ @RequestMapping({"/api/school"})
/*     */ public class SchoolController
/*     */ {
/*     */   @Autowired
/*     */   private SchoolService schoolService;
/*     */   
/*     */   @RequestMapping({"/getSchoolCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolCode()
/*     */   {
/*  26 */     return ResponseUtil.success(this.schoolService.getSchoolCode());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSchool"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSchool(@RequestBody School school) {
/*  32 */     return ResponseUtil.success(Boolean.valueOf(this.schoolService.addSchool(school)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSchool"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSchool(Long id) {
/*  38 */     return ResponseUtil.success(Boolean.valueOf(this.schoolService.deleteSchool(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSchool"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSchool(@RequestBody School school) {
/*  44 */     return ResponseUtil.success(Boolean.valueOf(this.schoolService.updateSchool(school)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSchoolDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolDetail(Long id) {
/*  50 */     return ResponseUtil.success(this.schoolService.getSchoolDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSchoolDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolDetailToUpdate(Long id) {
/*  56 */     return ResponseUtil.success(this.schoolService.getSchoolDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSchoolQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolQuery(String name, String type, Integer netGridID, int page, int pageSize) {
/*  62 */     return ResponseUtil.success(this.schoolService.getSchoolQuery(name, type, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSchoolVideoQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolVideoQuery(String schoolName, Integer netGridID, int page, int pageSize) {
/*  68 */     return ResponseUtil.success(this.schoolService.getSchoolVideoQuery(schoolName, netGridID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSchoolVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSchoolVideo(@RequestBody SchoolVideo schoolVideo)
/*     */   {
/*  75 */     return ResponseUtil.success(Boolean.valueOf(this.schoolService.addSchoolVideo(schoolVideo)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSchoolVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSchoolVideo(Long id) {
/*  81 */     return ResponseUtil.success(Boolean.valueOf(this.schoolService.deleteSchoolVideo(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSchoolVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSchoolVideo(@RequestBody SchoolVideo schoolVideo) {
/*  87 */     return ResponseUtil.success(Boolean.valueOf(this.schoolService.updateSchoolVideo(schoolVideo)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSchoolVideoDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolVideoDetail(Long id) {
/*  93 */     return ResponseUtil.success(this.schoolService.getSchoolVideoDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSchoolVideoDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolVideoDetailToUpdate(Long id) {
/*  99 */     return ResponseUtil.success(this.schoolService.getSchoolVideoDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getVideoForTree"})
/*     */   @ResponseBody
/*     */   public ExtResponse getVideoForTree(Long id)
/*     */   {
/* 106 */     return ResponseUtil.success(this.schoolService.getVideoForTree(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSchoolForTree"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSchoolForTree() {
/* 112 */     return ResponseUtil.success(this.schoolService.getSchoolForTree());
/*     */   }

/*    */ @RequestMapping({ "/getServedSchoolCount" })
/*    */ @ResponseBody
/*    */ public ExtResponse getServedSchoolCount(String type)
/*    */ {
/* 121 */ return ResponseUtil.success(this.schoolService.getServedSchoolCount());
/*    */ }






















/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\SchoolController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
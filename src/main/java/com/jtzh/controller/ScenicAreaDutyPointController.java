/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.ScenicAreaDutyPoint;
import com.jtzh.service.ScenicAreaDutyPointService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/api/dutyPoint"})
/*    */ public class ScenicAreaDutyPointController
/*    */ {
/*    */   @Autowired
/*    */   private ScenicAreaDutyPointService scenicAreaDutyPointService;
/*    */   
/*    */   @RequestMapping({"/addScenicAreaDutyPoint"})
/*    */   @ResponseBody
/*    */   public ExtResponse addScenicAreaDutyPoint(@RequestBody ScenicAreaDutyPoint point)
/*    */   {
/* 25 */     return ResponseUtil.success(this.scenicAreaDutyPointService.addScenicAreaDutyPoint(point));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/addScenicAreaDutyPointPicture"})
/*    */   @ResponseBody
/*    */   public ExtResponse addScenicAreaDutyPointPicture(MultipartFile file, Long ID) {
/* 31 */     return ResponseUtil.success(Boolean.valueOf(this.scenicAreaDutyPointService.addScenicAreaDutyPointPicture(file, ID)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getDutyPointQuery"})
/*    */   @ResponseBody
/*    */   public ExtResponse getDutyPointQuery(Integer netGridID, String name, int page, int pageSize)
/*    */   {
/* 38 */     return ResponseUtil.success(this.scenicAreaDutyPointService.getDutyPointQuery(netGridID, name, page, pageSize));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getDutyPointDetail"})
/*    */   @ResponseBody
/*    */   public ExtResponse getDutyPointDetail(Long id) {
/* 44 */     return ResponseUtil.success(this.scenicAreaDutyPointService.getDutyPointDetail(id));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getDutyDetailToUpdate"})
/*    */   @ResponseBody
/*    */   public ExtResponse getDutyDetailToUpdate(Integer scenicAreaDutyPointID) {
/* 50 */     return ResponseUtil.success(this.scenicAreaDutyPointService.getDutyDetailToUpdate(scenicAreaDutyPointID));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateDutyPoint"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateDutyPoint(@RequestBody ScenicAreaDutyPoint scenicAreaDutyPoint) {
/* 56 */     return ResponseUtil.success(Boolean.valueOf(this.scenicAreaDutyPointService.updateDutyPoint(scenicAreaDutyPoint)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/deleteDutyPoint"})
/*    */   @ResponseBody
/*    */   public ExtResponse deleteDutyPoint(Integer scenicAreaDutyPointID) {
/* 62 */     return ResponseUtil.success(Boolean.valueOf(this.scenicAreaDutyPointService.deleteDutyPoint(scenicAreaDutyPointID)));
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\ScenicAreaDutyPointController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
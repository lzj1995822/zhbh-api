/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.Video;
import com.jtzh.service.VideoService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @CrossOrigin
/*    */ @Controller
/*    */ @RequestMapping({"/api/video"})
/*    */ public class VideoController
/*    */ {
/*    */   @Autowired
/*    */   private VideoService videoService;
/*    */   
/*    */   @RequestMapping({"/getVideoCode"})
/*    */   @ResponseBody
/*    */   public ExtResponse getVideoCode()
/*    */   {
/* 26 */     return ResponseUtil.success(this.videoService.getVideoCode());
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getNetGrid"})
/*    */   @ResponseBody
/*    */   public ExtResponse getNetGrid() {
/* 32 */     return ResponseUtil.success(this.videoService.getAllNetGrid());
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getVideoInfo"})
/*    */   @ResponseBody
/*    */   public ExtResponse getVideoInfo(String videoName, Integer netGridID, int page, int pageSize) {
/* 38 */     return ResponseUtil.success(this.videoService.getVideoInfo(videoName, netGridID, page, pageSize));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getDetailByID"})
/*    */   @ResponseBody
/*    */   public ExtResponse getDetailByID(Long id) {
/* 44 */     return ResponseUtil.success(this.videoService.getDetailByID(id));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getToUpdateVideoInfo"})
/*    */   @ResponseBody
/*    */   public ExtResponse getToUpdateVideoInfo(Long id) {
/* 50 */     return ResponseUtil.success(this.videoService.getToUpdateVideoInfo(id));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/addVideo"})
/*    */   @ResponseBody
/*    */   public ExtResponse addVideo(@RequestBody Video v) {
/* 56 */     return ResponseUtil.success(Boolean.valueOf(this.videoService.addVideo(v)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateVideo"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateVideo(@RequestBody Video v) {
/* 62 */     return ResponseUtil.success(Boolean.valueOf(this.videoService.updateVideo(v)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/deleteVideo"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateVideo(Long id) {
/* 68 */     return ResponseUtil.success(Boolean.valueOf(this.videoService.deleteVideo(id)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getNetGridForTree"})
/*    */   @ResponseBody
/*    */   public ExtResponse getNetGridForTree() {
/* 74 */     return ResponseUtil.success(this.videoService.getNetGridForTree());
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getVideoForTree"})
/*    */   @ResponseBody
/*    */   public ExtResponse getVideoForTree(Long id) {
/* 80 */     return ResponseUtil.success(this.videoService.getVideoForTree(id));
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\VideoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
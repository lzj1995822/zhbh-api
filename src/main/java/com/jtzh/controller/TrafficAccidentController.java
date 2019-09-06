/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.jpush.Push;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.trafficAccident.DistributeVO;
/*     */ import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.TrafficAccident;
import com.jtzh.entity.TrafficAccidentChecked;
import com.jtzh.entity.TrafficAccidentDealing;
import com.jtzh.entity.TrafficAccidentInvolvedPersons;
import com.jtzh.service.TrafficAccidentService;
import com.jtzh.service.UserService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/api/trafficAccident"})
/*     */ public class TrafficAccidentController
/*     */ {
/*     */   @Autowired
/*     */   private TrafficAccidentService accidentService;
/*     */   @Autowired
/*     */   private UserService userService;
/*     */   private WebSocketHandler webSocketHandler;
/*     */   @Autowired
/*     */   private Push push;
/*     */   
/*     */   @RequestMapping({"/getTrafficCodes"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficCodes()
/*     */   {
/*  38 */     return ResponseUtil.success(this.accidentService.getTrafficCodes());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addTrafficAccidentBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentBasic(@RequestBody TrafficAccident accident) {
/*  44 */     return ResponseUtil.success(this.accidentService.addTrafficAccidentBasic(accident));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addTrafficAccidentInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentInvolvedPersons(@RequestBody TrafficAccidentInvolvedPersons persons) {
/*  50 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.addTrafficAccidentInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addTrafficAccidentPicture"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentPicture(MultipartFile file, Long ID) {
/*  56 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.addTrafficAccidentPicture(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addTrafficAccidentVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentVideo(MultipartFile file, Long ID) {
/*  62 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.addTrafficAccidentVideo(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getTrafficAccidentDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentDetail(Long id)
/*     */   {
/*  69 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteAccidentInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteAccidentInvolvedPersons(Long id) {
/*  75 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.deleteAccidentInvolvedPersons(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateAccidentInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateAccidentInvolvedPersons(@RequestBody TrafficAccidentInvolvedPersons persons) {
/*  81 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.updateAccidentInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateTrafficAccident"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateTrafficAccident(@RequestBody TrafficAccident trafficAccident) {
/*  87 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.updateTrafficAccident(trafficAccident)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteTrafficAccident"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteTrafficAccident(Long id) {
/*  93 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.deleteTrafficAccident(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getTrafficAccidentDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentDetailToUpdate(Long id)
/*     */   {
/* 100 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getTrafficAccidentHistogramCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentHistogramCount() {
/* 106 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentHistogramCount());
/*     */   }
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
/*     */   @RequestMapping({"/getTrafficAccidentReporterQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentReporterQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 123 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentReporterQuery(id, name, type, netGridID, status, page, pageSize));
/*     */   }
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
/*     */   @RequestMapping({"/getTrafficAccidentDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentDespatcherQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 140 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentDespatcherQuery(id, name, type, netGridID, status, page, pageSize));
/*     */   }
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
/*     */   @RequestMapping({"/getTrafficAccidentDeptDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentDeptDespatcherQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 157 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentDeptDespatcherQuery(id, name, type, netGridID, status, page, pageSize));
/*     */   }
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
/*     */   @RequestMapping({"/getTrafficAccidentHandlerQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentHandlerQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 174 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentHandlerQuery(id, name, type, netGridID, status, page, pageSize));
/*     */   }
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
/*     */   @RequestMapping({"/getTrafficAccidentAuditorQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentAuditorQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 191 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentAuditorQuery(id, name, type, netGridID, status, page, pageSize));
/*     */   }
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
/*     */   @RequestMapping({"/getTrafficAccidentAPPQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentAPPQuery(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 208 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentAPPQuery(id, name, type, netGridID, status, page, pageSize));
/*     */   }
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
/*     */   @RequestMapping({"/getTrafficAccidentForNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentForNetGrid(Long id, String name, String type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 225 */     return ResponseUtil.success(this.accidentService.getTrafficAccidentForNetGrid(id, name, type, netGridID, status, page, pageSize));
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   @RequestMapping({"/addTrafficAccidentDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentDistribute(@RequestBody DistributeVO distribute)
/*     */   {
/* 237 */     boolean result = this.accidentService.addTrafficAccidentDistribute(distribute);
/* 238 */     if (result) {
/* 239 */       String intent = distribute.getIntent();
/* 240 */       if ("1".equals(intent)) {
/* 241 */         Long userid = distribute.getAcceptedUserID();
/* 242 */         String role = this.userService.getRoleNameByUserID(userid);
/*     */       }
/*     */     }
/* 250 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */   @RequestMapping({"/addTrafficAccidetDealingBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidetDealingBasic(@RequestBody TrafficAccidentDealing dealing)
/*     */   {
/* 263 */     return ResponseUtil.success(this.accidentService.addTrafficAccidetDealingBasic(dealing));
/*     */   }
/*     */   
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   @RequestMapping({"/addTrafficAccidentDealingPicture"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentDealingPicture(MultipartFile file, Long ID)
/*     */   {
/* 276 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.addTrafficAccidentDealingPicture(file, ID)));
/*     */   }
/*     */   
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   @RequestMapping({"/addTrafficAccidentDealingVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 289 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.addTrafficAccidentDealingVideo(file, ID)));
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */   @RequestMapping({"/addTrafficAccidentChecked"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidentChecked(@RequestBody TrafficAccidentChecked checked)
/*     */   {
/* 301 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.addTrafficAccidentChecked(checked)));
/*     */   }
/*     */   
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */   @RequestMapping({"/updateTrafficAccidentStatus"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateTrafficAccidentStatus(String type, Long id)
/*     */   {
/* 314 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.updateTrafficAccidentStatus(type, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/isDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse isDistribute(Long id) {
/* 320 */     return ResponseUtil.success(Boolean.valueOf(this.accidentService.isDistribute(id)));
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\TrafficAccidentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
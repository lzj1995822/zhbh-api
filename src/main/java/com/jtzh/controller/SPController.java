/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.jpush.Push;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.skynet.DistributeVO;
/*     */ import com.jtzh.vo.skynet.SPQueryVO;
/*     */ import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.SPProcession;
import com.jtzh.entity.SPProcessionPerson;
import com.jtzh.entity.SPRegion;
import com.jtzh.entity.SkynetPatrolEvent;
import com.jtzh.entity.SkynetPatrolEventChecked;
import com.jtzh.entity.SkynetPatrolEventDealing;
import com.jtzh.entity.SkynetPatrolEventInvolvedPersons;
import com.jtzh.service.SkynetService;
import com.jtzh.service.UserService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.socket.TextMessage;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @CrossOrigin
/*     */ @RequestMapping({"/api/sp"})
/*     */ public class SPController
/*     */ {
/*     */   @Autowired
/*     */   private SkynetService skynetService;
/*     */   @Autowired
/*     */   private UserService userService;
/*     */   private WebSocketHandler webSocketHandler;
/*     */   @Autowired
/*     */   private Push push;
/*     */   
/*     */   @RequestMapping({"/addSPEventBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventBasic(@RequestBody SkynetPatrolEvent event)
/*     */   {
/*  47 */     return ResponseUtil.success(this.skynetService.insertSPEvent(event));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/getSPEventCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventCode()
/*     */   {
/*  58 */     return ResponseUtil.success(this.skynetService.getSPEventCode());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSPEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventInvolvedPersons(@RequestBody SkynetPatrolEventInvolvedPersons persons)
/*     */   {
/*  70 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.insertSPEventInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSPEventPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventPictures(MultipartFile file, Long ID)
/*     */   {
/*  83 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.addSPEventPictures(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSPEventVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventVideo(MultipartFile file, Long ID)
/*     */   {
/*  96 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.addSPEventVideo(file, ID)));
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
/*     */   @RequestMapping({"/getSPEventReporterQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventReporterQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 113 */     SPQueryVO vo = this.skynetService.getSPEventReporterQuery(id, name, type, netGridID, status, page, pageSize);
/* 114 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getSPEventDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventDespatcherQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 131 */     SPQueryVO vo = this.skynetService.getSPEventDespatcherQuery(id, name, type, netGridID, status, page, pageSize);
/* 132 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getSPEventDeptDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventDeptDespatcherQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 149 */     SPQueryVO vo = this.skynetService.getSPEventDeptDespatcherQuery(id, name, type, netGridID, status, page, pageSize);
/* 150 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getSPEventHandlerQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventHandlerQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 167 */     SPQueryVO vo = this.skynetService.getSPEventHandlerQuery(id, name, type, netGridID, status, page, pageSize);
/* 168 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getSPEventAuditorQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventAuditorQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 185 */     SPQueryVO vo = this.skynetService.getSPEventAuditorQuery(id, name, type, netGridID, status, page, pageSize);
/* 186 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getSPEventAPPQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventAPPQuery(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 203 */     SPQueryVO vo = this.skynetService.getSPEventAPPQuery(id, name, type, netGridID, status, page, pageSize);
/* 204 */     return ResponseUtil.success(vo);
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
/*     */ 
/*     */   @RequestMapping({"/getSPEventForNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventForNetGrid(Long id, String name, Integer type, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 222 */     SPQueryVO vo = this.skynetService.getSPEventForNetGrid(id, name, type, netGridID, status, page, pageSize);
/* 223 */     return ResponseUtil.success(vo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/getSPEventDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventDetail(Long id)
/*     */   {
/* 235 */     return ResponseUtil.success(this.skynetService.getSPEventDetail(id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/getUserInfoByKey"})
/*     */   @ResponseBody
/*     */   public ExtResponse getUserInfoByKey(String key)
/*     */   {
/* 247 */     return ResponseUtil.success(this.skynetService.getUserInfoByKey(key));
/*     */   }
/*     */   /*     */   @RequestMapping({"/getUserInfoByKeyDept"})
/*     */   @ResponseBody
/*     */   public ExtResponse getUserInfoByKeyDept(String key)
/*     */   {
    /* 247 */     return ResponseUtil.success(this.skynetService.getUserInfoByKeyDept(key));
    /*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/changeSPEventStatus"})
/*     */   @ResponseBody
/*     */   public ExtResponse changeSPEventStatus(String type, Long id)
/*     */   {
/* 260 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.changeSPEventStatus(type, id)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/insertSPEventDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertSPEventDistribute(@RequestBody DistributeVO distribute)
/*     */   {
/* 272 */     boolean result = this.skynetService.insertSPEventDistribute(distribute);
/* 273 */     if (result) {
/* 274 */       String intent = distribute.getIntent();
/* 275 */       if ("1".equals(intent)) {
/* 276 */         Long userid = distribute.getAcceptedUserID();
/* 277 */         String role = this.userService.getRoleNameByUserID(userid);
/* 278 */         if ("APP".equals(role)) {
/* 279 */           Push.sendMsgToAndroid("有新的矛盾纠纷事件需要处理", userid + "");
/*     */         } else {
/* 281 */           this.webSocketHandler.sendMessageToUser(userid + "", new TextMessage("有新的矛盾纠纷事件需要处理"));
/*     */         }
/*     */       }
/*     */     }
/* 285 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/insertSPEventChecked"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertSPEventChecked(@RequestBody SkynetPatrolEventChecked checked)
/*     */   {
/* 297 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.insertSPEventChecked(checked)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/insertSPEventDealing"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertSPEventDealing(@RequestBody SkynetPatrolEventDealing eventDealing)
/*     */   {
/* 309 */     return ResponseUtil.success(this.skynetService.insertSPEventDealing(eventDealing));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSPEventDealingPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventDealingPictures(MultipartFile file, Long ID)
/*     */   {
/* 322 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.addSPEventDealingPictures(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSPEventDealingVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 335 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.addSPEventDealingVideo(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDetailToUpdate(Long SPEventID)
/*     */   {
/* 342 */     return ResponseUtil.success(this.skynetService.getSPEventDetailToUpdate(SPEventID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSPEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSPEvent(@RequestBody SkynetPatrolEvent event) {
/* 348 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.updateSPEvent(event)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSPEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSPEventInvolvedPersons(@RequestBody SkynetPatrolEventInvolvedPersons persons) {
/* 354 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.updateSPEventInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSPEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSPEventInvolvedPersons(Long id) {
/* 360 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.deleteSPEventInvolvedPersons(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSPEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSPEvent(Long id) {
/* 366 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.deleteSPEvent(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSPEventCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventCount() {
/* 372 */     return ResponseUtil.success(this.skynetService.getSPEventCount());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/isDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse isDistribute(Long id) {
/* 378 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.isDistribute(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSPProcessionQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPProcessionQuery(String processionName, String processionLeaderName, Integer area, int page, int pageSize)
/*     */   {
/* 385 */     return ResponseUtil.success(this.skynetService.getSPProcessionQuery(processionName, processionLeaderName, area, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addProcession"})
/*     */   @ResponseBody
/*     */   public ExtResponse addProcession(@RequestBody SPProcession procession) {
/* 391 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.addProcession(procession)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateProcession"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateProcession(@RequestBody SPProcession procession) {
/* 397 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.updateProcession(procession)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getProcessionDetailByID"})
/*     */   @ResponseBody
/*     */   public ExtResponse getProcessionDetailByID(Long id) {
/* 403 */     return ResponseUtil.success(this.skynetService.getProcessionDetailByID(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getProcessionDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getProcessionDetailToUpdate(Long id) {
/* 409 */     return ResponseUtil.success(this.skynetService.getProcessionDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteProcession"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteProcession(Long id) {
/* 415 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.deleteProcession(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSPRegion"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPRegion(@RequestBody SPRegion region) {
/* 421 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.addSPRegion(region)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSPRegion"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSPRegion(@RequestBody SPRegion region) {
/* 427 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.updateSPRegion(region)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSPRegion"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSPRegion(Long id)
/*     */   {
/* 434 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.deleteSPRegion(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/selectByRegionName"})
/*     */   @ResponseBody
/*     */   public ExtResponse selectByRegionName(String name) {
/* 440 */     return ResponseUtil.success(this.skynetService.selectByRegionName(name));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/selectAllRegion"})
/*     */   @ResponseBody
/*     */   public ExtResponse selectAllRegion() {
/* 446 */     return ResponseUtil.success(this.skynetService.selectAllRegion());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAllProcession"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAllProcession() {
/* 452 */     return ResponseUtil.success(this.skynetService.getAllProcession());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getProcessionDetailByInspectionArea"})
/*     */   @ResponseBody
/*     */   public ExtResponse getProcessionDetailByInspectionArea(Long id) {
/* 458 */     return ResponseUtil.success(this.skynetService.getProcessionDetailByInspectionArea(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/uploadProcessionPersonPhoto"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadProcessionPersonPhoto(MultipartFile file) {
/* 464 */     return ResponseUtil.success(this.skynetService.uploadProcessionPersonPhoto(file));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addProcessionPerson"})
/*     */   @ResponseBody
/*     */   public ExtResponse addProcessionPerson(@RequestBody SPProcessionPerson person, Long id) {
/* 470 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.addProcessionPerson(person, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getProcessionPersonQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getProcessionPersonQuery(String name, Integer processionID, int page, int pageSize) {
/* 476 */     return ResponseUtil.success(this.skynetService.getProcessionPersonQuery(name, processionID, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getProcessionPersonDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getProcessionPersonDetail(Long id) {
/* 482 */     return ResponseUtil.success(this.skynetService.getProcessionPersonDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getProcessionPersonDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getProcessionPersonDetailToUpdate(Long id) {
/* 488 */     return ResponseUtil.success(this.skynetService.getProcessionPersonDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSPProcessionPerson"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSPProcessionPerson(Long id) {
/* 494 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.deleteSPProcessionPerson(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateProcessionPersonPhoto"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateProcessionPersonPhoto(MultipartFile file, Long id) {
/* 500 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.updateProcessionPersonPhoto(file, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSPProcessionPerson"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSPProcessionPerson(@RequestBody SPProcessionPerson person) {
/* 506 */     return ResponseUtil.success(Boolean.valueOf(this.skynetService.updateSPProcessionPerson(person)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSPTrailQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPTrailQuery(String name, String startTime, String endTime, int page, int pageSize) {
/* 512 */     return ResponseUtil.success(this.skynetService.getSPTrailQuery(name, startTime, endTime, page, pageSize));
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\SPController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.jpush.Push;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.ss.DistributeVO;
/*     */ import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.SSEventChecked;
import com.jtzh.entity.SSEventDealing;
import com.jtzh.entity.SSEventInvolvedPersons;
import com.jtzh.entity.SocietySecurityEvent;
import com.jtzh.service.SSEventService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @org.springframework.stereotype.Controller
/*     */ @RequestMapping({"/api/SSEvent"})
/*     */ public class SSEventController
/*     */ {
/*     */   @Autowired
/*     */   private SSEventService eventService;
/*     */   @Autowired
/*     */   private com.jtzh.service.UserService userService;
/*     */   private WebSocketHandler webSocketHandler;
/*     */   @Autowired
/*     */   private Push push;
/*     */   
/*     */   @RequestMapping({"/addSSEventBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEventBasic(@RequestBody SocietySecurityEvent event)
/*     */   {
/*  36 */     return ResponseUtil.success(this.eventService.addSSEventBasic(event));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSSEventCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventCode() {
/*  42 */     return ResponseUtil.success(this.eventService.getSSEventCode());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSSEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEventInvolvedPersons(@RequestBody SSEventInvolvedPersons persons) {
/*  48 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.addSSEventInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSSEventPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEventPictures(MultipartFile file, Long ID) {
/*  54 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.addSSEventPictures(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSSEventVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEventVideo(MultipartFile file, Long ID) {
/*  60 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.addSSEventVideo(file, ID)));
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
/*     */   @RequestMapping({"/getSSEventReporterQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventReporterQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/*  77 */     return ResponseUtil.success(this.eventService.getSSEventReporterQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getSSEventDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/*  94 */     return ResponseUtil.success(this.eventService.getSSEventDespatcherQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getSSEventDeptDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventDeptDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 111 */     return ResponseUtil.success(this.eventService.getSSEventDeptDespatcherQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getSSEventHandlerQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventHandlerQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 128 */     return ResponseUtil.success(this.eventService.getSSEventHandlerQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getSSEventAuditorQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventAuditorQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 145 */     return ResponseUtil.success(this.eventService.getSSEventAuditorQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getSSEventAPPQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventAPPQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 163 */     return ResponseUtil.success(this.eventService.getSSEventAPPQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getSSEventForNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventForNetGrid(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 181 */     return ResponseUtil.success(this.eventService.getSSEventForNetGrid(id, kind, name, netGridID, status, page, pageSize));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/insertSSEventDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertSSEventDistribute(@RequestBody DistributeVO distribute)
/*     */   {
/* 193 */     boolean result = this.eventService.insertSSEventDistribute(distribute);
/* 194 */     if (result) {
/* 195 */       String intent = distribute.getIntent();
/* 196 */       if ("1".equals(intent)) {
/* 197 */         Long userid = distribute.getAcceptedUserID();
/* 198 */         String role = this.userService.getRoleNameByUserID(userid);
/* 199 */         if ("APP".equals(role)) {
/* 200 */           Push.sendMsgToAndroid("有新的矛盾纠纷事件需要处理", userid + "");
/*     */         } else {
/* 202 */           this.webSocketHandler.sendMessageToUser(userid + "", new org.springframework.web.socket.TextMessage("有新的矛盾纠纷事件需要处理"));
/*     */         }
/*     */       }
/*     */     }
/* 206 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/insertSSEventDealingBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertSSEventDealingBasic(@RequestBody SSEventDealing dealing)
/*     */   {
/* 218 */     return ResponseUtil.success(this.eventService.insertSSEventDealingBasic(dealing));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSSEventDealingPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEventDealingPictures(MultipartFile file, Long ID)
/*     */   {
/* 231 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.addSSEventDealingPictures(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSSEventDealingVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEventDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 244 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.addSSEventDealingVideo(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/insertSSEventChecked"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertSSEventChecked(@RequestBody SSEventChecked checked)
/*     */   {
/* 256 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.insertSSEventChecked(checked)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/updateSSEventStatus"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSSEventStatus(String type, Long id)
/*     */   {
/* 269 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.updateSSEventStatus(type, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSSDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSDetail(Long id)
/*     */   {
/* 276 */     return ResponseUtil.success(this.eventService.getSSDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDetailToUpdate(Long SSEventID) {
/* 282 */     return ResponseUtil.success(this.eventService.getDetailToUpdate(SSEventID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSSEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSSEvent(@RequestBody SocietySecurityEvent societySecurityEvent) {
/* 288 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.updateSSEvent(societySecurityEvent)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateSSEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateSSEventInvolvedPersons(@RequestBody SSEventInvolvedPersons persons) {
/* 294 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.updateSSEventInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSSEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSSEventInvolvedPersons(Long id) {
/* 300 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.deleteSSEventInvolvedPersons(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteSSEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteSSEvent(Long id) {
/* 306 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.deleteSSEvent(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSSCountVO"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSCountVO() {
/* 312 */     return ResponseUtil.success(this.eventService.getSSCountVO());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/isDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse isDistribute(Long id) {
/* 318 */     return ResponseUtil.success(Boolean.valueOf(this.eventService.isDistribute(id)));
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\SSEventController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
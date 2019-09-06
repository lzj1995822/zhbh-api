/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.jpush.Push;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.dispute.DisputeEventQueryResponseVO;
/*     */ import com.jtzh.vo.dispute.DistributeVO;
/*     */ import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.DisputeEvent;
import com.jtzh.entity.DisputeEventChecked;
import com.jtzh.entity.DisputeEventDealing;
import com.jtzh.entity.DisputeEventInvolvedPersons;
import com.jtzh.service.DisputeEventService;
import com.jtzh.service.UserService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.socket.TextMessage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @CrossOrigin
/*     */ @Controller
/*     */ @RequestMapping({"/api/dispute"})
/*     */ public class DisputeEventController
/*     */ {
/*     */   @Autowired
/*     */   private DisputeEventService disputeEventService;
/*     */   @Autowired
/*     */   private UserService userService;
/*     */   private WebSocketHandler webSocketHandler;
/*     */   @Autowired
/*     */   private Push push;
/*     */   
/*     */   @RequestMapping({"/getDisputeEventReporterQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse<DisputeEventQueryResponseVO> getDisputeEventReporterQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/*  46 */     DisputeEventQueryResponseVO vo = this.disputeEventService.getDisputeEventReporterQuery(id, eventName, eventTypeValue, netGridID, status, page, pageSize);
/*     */     
/*  48 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getDisputeEventDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse<DisputeEventQueryResponseVO> getDisputeEventDespatcherQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/*  63 */     DisputeEventQueryResponseVO vo = this.disputeEventService.getDisputeEventDespatcherQuery(id, eventName, eventTypeValue, netGridID, page, pageSize);
/*     */     
/*  65 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getDisputeEventDeptDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse<DisputeEventQueryResponseVO> getDisputeEventDeptDespatcherQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/*  80 */     DisputeEventQueryResponseVO vo = this.disputeEventService.getDisputeEventDeptDespatcherQuery(id, eventName, eventTypeValue, netGridID, page, pageSize);
/*     */     
/*  82 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getDisputeEventHandlerQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse<DisputeEventQueryResponseVO> getDisputeEventHandlerQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/*  97 */     DisputeEventQueryResponseVO vo = this.disputeEventService.getDisputeEventHandlerQuery(id, eventName, eventTypeValue, netGridID, page, pageSize);
/*     */     
/*  99 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getDisputeEventAuditorQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse<DisputeEventQueryResponseVO> getDisputeEventAuditorQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/* 114 */     DisputeEventQueryResponseVO vo = this.disputeEventService.getDisputeEventAuditorQuery(id, eventName, eventTypeValue, netGridID, page, pageSize);
/*     */     
/* 116 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getDisputeEventForNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse<DisputeEventQueryResponseVO> getDisputeEventForNetGrid(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/* 131 */     DisputeEventQueryResponseVO vo = this.disputeEventService.getDisputeEventForNetGrid(id, eventName, eventTypeValue, netGridID, page, pageSize);
/*     */     
/* 133 */     return ResponseUtil.success(vo);
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
/*     */   @RequestMapping({"/getDisputeEventAPPQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse<DisputeEventQueryResponseVO> getDisputeEventAPPQuery(Long id, String eventName, String eventTypeValue, Integer netGridID, int page, int pageSize)
/*     */   {
/* 148 */     DisputeEventQueryResponseVO vo = this.disputeEventService.getDisputeEventAPPQuery(id, eventName, eventTypeValue, netGridID, page, pageSize);
/*     */     
/* 150 */     return ResponseUtil.success(vo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/getDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDisputeEventDetailByID(Long disputeEventID)
/*     */   {
/* 162 */     return ResponseUtil.success(this.disputeEventService.getDisputeEventDetail(disputeEventID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDisputeBasicDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDisputeBasicDetailToUpdate(Long id)
/*     */   {
/* 169 */     return ResponseUtil.success(this.disputeEventService.getDisputeBasicDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addDisputeEventPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventPictures(MultipartFile file, Long ID) {
/* 175 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.addDisputeEventPictures(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addDisputeEventVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventVideo(MultipartFile file, Long ID)
/*     */   {
/* 182 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.addDisputeEventVideo(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/insertDisputeEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertDisputeEvent(@RequestBody DisputeEvent disputeEvent) {
/* 188 */     return ResponseUtil.success(this.disputeEventService.insertDisputeEvent(disputeEvent));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateDisputeEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateDisputeEvent(@RequestBody DisputeEvent disputeEvent) {
/* 194 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.updateDisputeEvent(disputeEvent)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteDisputeEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteDisputeEvent(Long id) {
/* 200 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.deleteDisputeEvent(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDisputeEventCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDisputeEventCount() {
/* 206 */     return ResponseUtil.success(this.disputeEventService.getDisputeEventCount());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addDisputeEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventInvolvedPersons(@RequestBody DisputeEventInvolvedPersons persons)
/*     */   {
/* 218 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.addDisputeEventInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addDisputeEventDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventDistribute(@RequestBody DistributeVO distribute)
/*     */   {
/* 230 */     boolean result = this.disputeEventService.addDisputeEventDistribute(distribute);
/* 231 */     if (result) {
/* 232 */       String intent = distribute.getIntent();
/* 233 */       if ("1".equals(intent)) {
/* 234 */         Long userid = distribute.getAcceptedUserID();
/* 235 */         String role = this.userService.getRoleNameByUserID(userid);
/* 236 */         if ("APP".equals(role)) {
/* 237 */           Push.sendMsgToAndroid("有新的矛盾纠纷事件需要处理", userid + "");
/*     */         } else {
/* 239 */           /*this.webSocketHandler.sendMessageToUser(userid + "", new TextMessage("有新的矛盾纠纷事件需要处理"));*/
/*     */         }
/*     */       }
/*     */     }
/* 243 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addDisputeEventDealing"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventDealing(@RequestBody DisputeEventDealing dealing)
/*     */   {
/* 255 */     return ResponseUtil.success(this.disputeEventService.addDisputeEventDealing(dealing));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addDisputeEventDealingPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventDealingPictures(MultipartFile file, Long ID)
/*     */   {
/* 268 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.addDisputeEventDealingPictures(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addDisputeEventDealingVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 281 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.addDisputeEventDealingVideo(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addDisputeEventChecked"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEventChecked(@RequestBody DisputeEventChecked checked)
/*     */   {
/* 294 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.addDisputeEventChecked(checked)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/updateDisputeEventStatus"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateDisputeEventStatus(String status, Long id)
/*     */   {
/* 307 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.updateDisputeEventStatus(status, id)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/isDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse isDistribute(Long id)
/*     */   {
/* 319 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.isDistribute(id)));
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/uploadDisputeEventDealingMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadDisputeEventDealingMedia(@RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video, Long id)
/*     */   {
/* 327 */     return ResponseUtil.success(Boolean.valueOf(this.disputeEventService.uploadDisputeEventDealingMedia(pictures, video, id)));
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\DisputeEventController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
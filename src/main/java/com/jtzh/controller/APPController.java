/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.entity.RealTimeLocation;
import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.app.SpecialPopulationForTypeAndNetGrid;
/*     */ import com.jtzh.vo.netGrid.NetGridEventAPPUploadVO;
/*     */ import com.jtzh.vo.skynet.SPEventAPPUploadVO;
/*     */ import com.jtzh.vo.ss.SSEventAPPUploadVO;
/*     */ import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.SPTrail;
import com.jtzh.service.APPService;
import com.jtzh.service.DisputeEventService;
import com.jtzh.service.NetGridService;
import com.jtzh.service.SPTrailService;
import com.jtzh.service.SSEventService;
import com.jtzh.service.SkynetService;
import com.jtzh.service.TrafficAccidentService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.socket.TextMessage;
/*     */ 
/*     */ @org.springframework.stereotype.Controller
/*     */ @RequestMapping({"/api/app"})
/*     */ public class APPController
/*     */ {
/*     */   @Autowired
/*     */   private APPService appService;
/*     */   @Autowired
/*     */   private TrafficAccidentService trafficAccidentService;
/*     */   @Autowired
/*     */   private SPTrailService spTrailService;
/*     */   @Autowired
/*     */   private SSEventService ssEventService;
/*     */   @Autowired
/*     */   private NetGridService netGridService;
/*     */   @Autowired
/*     */   private SkynetService skynetService;
/*     */   @Autowired
/*     */   private DisputeEventService disputeEventService;
/*     */   private WebSocketHandler webSocketHandler;
/*     */   
/*     */   @RequestMapping({"/getByTypeAndGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse<java.util.List<SpecialPopulationForTypeAndNetGrid>> getByTypeAndGrid(String type, String netGrid, int page)
/*     */   {
/*  51 */     java.util.List<SpecialPopulationForTypeAndNetGrid> list = this.appService.getByTypeAndGrid(type, netGrid, page - 1);
/*  52 */     return ResponseUtil.success(list);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addServiceRecord"})
/*     */   @ResponseBody
/*     */   public ExtResponse addServiceRecord(@RequestParam("orgMemberName") String orgMemberName, @RequestParam("orgMemberCertID") String orgMemberCertID, @RequestParam("servedPersonName") String servedPersonName, @RequestParam("servedPersonCertID") String servedPersonCertID, @RequestParam("servedPersonType") String servedPersonType, @RequestParam("serverInf") String serverInf, @RequestParam("serverDate") String serverDate, @RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video)
/*     */   {
/*  65 */     boolean result = this.appService.addServiceRecord(orgMemberName, orgMemberCertID, servedPersonName, servedPersonCertID, servedPersonType, serverInf, serverDate, pictures, video);
/*     */     
/*  67 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addTrafficAccidetDealingFromAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccidetDealingFromAPP(@RequestParam("eventID") String eventID, @RequestParam("dealingUserID") String dealingUserID, @RequestParam("dealingTime") String dealingTime, @RequestParam("dealingInf") String dealingInf, @RequestParam("remark") String remark, @RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video)
/*     */   {
/*  79 */     boolean result = this.trafficAccidentService.addTrafficAccidetDealingFromAPP(eventID, dealingUserID, dealingTime, dealingInf, remark, pictures, video);
/*  82 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSSEventDealingFromAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEventDealingFromAPP(@RequestParam("eventID") String eventID, @RequestParam("dealingUserID") String dealingUserID, @RequestParam("dealingTime") String dealingTime, @RequestParam("dealingInf") String dealingInf, @RequestParam("remark") String remark, @RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video)
/*     */   {
/*  94 */     boolean result = this.ssEventService.addSSEventDealingFromAPP(eventID, dealingUserID, dealingTime, dealingInf, remark, pictures, video);
/*  95 */
/*  97 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventDealingFromAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventDealingFromAPP(@RequestParam("eventID") String eventID, @RequestParam("dealingUserID") String dealingUserID, @RequestParam("dealingTime") String dealingTime, @RequestParam("dealingInf") String dealingInf, @RequestParam("remark") String remark, @RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video)
/*     */   {
/* 109 */     boolean result = this.netGridService.addNetGridEventDealingFromAPP(eventID, dealingUserID, dealingTime, dealingInf, remark, pictures, video);
/* 110 */
/* 112 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addSPEventDealingFromAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventDealingFromAPP(@RequestParam("eventID") String eventID, @RequestParam("dealingUserID") String dealingUserID, @RequestParam("dealingTime") String dealingTime, @RequestParam("dealingInf") String dealingInf, @RequestParam("remark") String remark, @RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video)
/*     */   {
/* 124 */     boolean result = this.skynetService.addSPEventDealingFromAPP(eventID, dealingUserID, dealingTime, dealingInf, remark, pictures, video);
/* 125 */
/* 127 */     return ResponseUtil.success(Boolean.valueOf(result));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addDisputeEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDisputeEvent(@RequestBody com.jtzh.vo.dispute.DisputeEventAPPUploadVO uploadVO)
/*     */   {
/* 134 */     Long result = this.appService.addDisputeEvent(uploadVO);
/* 137 */     return ResponseUtil.success(result);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/uploadDisputeEventMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadDisputeEventMedia(@RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video, Long id)
/*     */   {
/* 144 */     return ResponseUtil.success(Boolean.valueOf(this.appService.uploadDisputeEventMedia(pictures, video, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addTrafficAccident"})
/*     */   @ResponseBody
/*     */   public ExtResponse addTrafficAccident(@RequestBody com.jtzh.vo.trafficAccident.TrafficAccidentAPPUploadVO uploadVO) {
/* 150 */     Long result = this.appService.addTrafficAccident(uploadVO);
/* 153 */     return ResponseUtil.success(result);
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/uploadTrafficAccidentMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadTrafficAccidentMedia(@RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video, Long id)
/*     */   {
/* 161 */     return ResponseUtil.success(Boolean.valueOf(this.appService.uploadTrafficAccidentMedia(pictures, video, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addNetGridEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEvent(@RequestBody NetGridEventAPPUploadVO uploadVO) {
/* 167 */     Long result = this.appService.addNetGridEvent(uploadVO);
/* 170 */     return ResponseUtil.success(result);
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventMedia(@RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video, Long id)
/*     */   {
/* 178 */     return ResponseUtil.success(Boolean.valueOf(this.appService.addNetGridEventMedia(pictures, video, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSSEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSSEvent(@RequestBody SSEventAPPUploadVO uploadVO)
/*     */   {
/* 185 */     Long result = this.appService.addSSEvent(uploadVO);
/* 188 */     return ResponseUtil.success(result);
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/uploadSSEventMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse uploadSSEventMedia(@RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video, Long id)
/*     */   {
/* 196 */     return ResponseUtil.success(Boolean.valueOf(this.appService.uploadSSEventMedia(pictures, video, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSPEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEvent(@RequestBody SPEventAPPUploadVO uploadVO) {
/* 202 */     Long result = this.appService.addSPEvent(uploadVO);
/* 205 */     return ResponseUtil.success(result);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/uploadSPEventMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPEventMedia(@RequestParam(value="pictures", required=false) MultipartFile[] pictures, @RequestParam(value="video", required=false) MultipartFile video, Long id)
/*     */   {
/* 212 */     return ResponseUtil.success(Boolean.valueOf(this.appService.addSPEventMedia(pictures, video, id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addSPTrail"})
/*     */   @ResponseBody
/*     */   public ExtResponse addSPTrail(@RequestBody SPTrail trail)
/*     */   {
/* 219 */     return ResponseUtil.success(Boolean.valueOf(this.spTrailService.addTrail(trail)));
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
/*     */ 
/*     */   @RequestMapping({"/insertData"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertData()
/*     */   {
/* 238 */     return ResponseUtil.success(Integer.valueOf(this.appService.insertData()));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAPPVersionInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAPPVersionInfo()
/*     */   {
/* 245 */     return ResponseUtil.success(this.appService.getAPPVersionInfo());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSPEventDetailForAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSPEventDetailForAPP(Long id)
/*     */   {
/* 252 */     return ResponseUtil.success(this.skynetService.getSPEventDetailForAPP(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSSDetailForAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSDetailForAPP(Long id) {
/* 258 */     return ResponseUtil.success(this.ssEventService.getSSDetailForAPP(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDisputeEventDetailForAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDisputeEventDetailForAPP(Long id) {
/* 264 */     return ResponseUtil.success(this.disputeEventService.getDisputeEventDetailForAPP(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getTrafficAccidentDetailForAPP"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentDetailForAPP(Long id) {
/* 270 */     return ResponseUtil.success(this.trafficAccidentService.getTrafficAccidentDetailForAPP(id));
/*     */   }

    @RequestMapping({"/addRealTimeLocation"})
    @ResponseBody
    public ExtResponse addRealTimeLocation(@RequestBody RealTimeLocation location)
    {
        return ResponseUtil.success(Boolean.valueOf(this.appService.addRealTimeLocation(location)));
    }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\APPController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
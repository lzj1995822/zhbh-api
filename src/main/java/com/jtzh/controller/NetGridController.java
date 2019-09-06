/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.detail.pojo.KeyproProblemDetail;
import com.jtzh.entity.*;
import com.jtzh.service.*;
import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.netGrid.DistributeVO;
/*     */ import com.jtzh.vo.netGrid.NetGridEventDetailVO;
import com.jtzh.vo.ss.FileUpdateVO;
import com.jtzh.websocket.WebSocketHandler;
import com.jtzh.common.ExtResponse;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*     */
/*     */ @org.springframework.stereotype.Controller
/*     */ @org.springframework.web.bind.annotation.CrossOrigin
/*     */ @RequestMapping({"/api/netGrid"})
/*     */ public class NetGridController
/*     */ {
/*     */   @Autowired
/*     */   private NetGridService netGridService;
/*     */   @Autowired
/*     */   private UserService userService;
/*     */   private WebSocketHandler webSocketHandler;
/*     */   @Autowired
/*     */   private com.jtzh.jpush.Push push;
            @Resource
            private CgshangbaoService cgshangbaoService;
            @Resource
/*     */   private HwshangbaoService hwshangbaoService;

            @Resource
            private KeyproProblemService keyproProblemService;
/*     */   @RequestMapping({"/getNetGridMemberQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridMemberQuery(Integer netGridID, String name, String certID, Integer isServicePerson, int page, int pageSize)
/*     */   {
/*  38 */     return ResponseUtil.success(this.netGridService.getNetGridMemberQuery(netGridID, name, certID, isServicePerson, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridMemberDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridMemberDetail(Long id) {
/*  44 */     return ResponseUtil.success(this.netGridService.getNetGridMemberDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/insertNetGridMember"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertNetGridMember(@RequestBody NetGridMember member) {
/*  50 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.insertNetGridMember(member)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateNetGridMember"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateNetGridMember(@RequestBody NetGridMember member) {
/*  56 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.updateNetGridMember(member)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridMemberHistogram"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridMemberHistogram()
/*     */   {
/*  63 */     return ResponseUtil.success(this.netGridService.getNetGridMemberHistogram());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/getNetGridEventCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventCode()
/*     */   {
/*  75 */     return ResponseUtil.success(this.netGridService.getNetGridEventCode());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/updateNetGridEventStatus"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateNetGridEventStatus(String type, Long id)
/*     */   {
/*  88 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.updateNetGridEventStatus(type, id)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/insertNetGridEventBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse insertNetGridEventBasic(@RequestBody NetGridEvent event)
/*     */   {
/* 100 */     return ResponseUtil.success(this.netGridService.insertNetGridEventBasic(event));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventPictures(MultipartFile file, Long ID)
/*     */   {
/* 113 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.addNetGridEventPictures(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventVideo(MultipartFile file, Long ID)
/*     */   {
/* 126 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.addNetGridEventVideo(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventInvolvedPersons"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventInvolvedPersons(@RequestBody NetGridEventInvolvedPersons persons)
/*     */   {
/* 138 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.addNetGridEventInvolvedPersons(persons)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
@RequestMapping({"/addNetGridEventDistribute"})
@ResponseBody
@Transactional
public ExtResponse addNetGridEventDistribute(@RequestBody DistributeVO distribute) {
    Long userid = distribute.getAcceptedUserID();
    User user = userService.getUserDetail(userid);
    user.setCertID("综治");
    Map map =  netGridService.getNetGridEventDetail(distribute.getEventID());
    NetGridEventDetailVO netGridEventDetailBasic  = (NetGridEventDetailVO)map.get("netGridEventDetailBasic");
    Map m = (Map) map.get("netGridEventMedia");
    List<FileUpdateVO> pictures = (List<FileUpdateVO>)m.get("pictures");
    if ("城管部门".equals(user.getDept())) {
        Cgshangbao param = new Cgshangbao();
        param.setSource("综治网格联动问题");
        param.setSourceId(netGridEventDetailBasic.getEventID().intValue());
        LoginUserTest loginuser = new LoginUserTest();
        loginuser.setLoginId("综治部门");
        param.setY(String.valueOf(netGridEventDetailBasic.getEventHappenLatitude()));
        param.setX(String.valueOf(netGridEventDetailBasic.getEventHappenLongitude()));
        param.setCategories("其他");
        param.setSmallcategories("其他");
        param.setDizhi1(netGridEventDetailBasic.getNetGridName());
        param.setDizhi2(netGridEventDetailBasic.getNetGridName());
        param.setPeople(netGridEventDetailBasic.getCurrentResponsiblePersonName());
        param.setPhone(netGridEventDetailBasic.getCurrentResponsiblePersonContact());
        param.setMiaoshu(netGridEventDetailBasic.getEventContent());
        param.setIsdeleted("1");
        String pic = getPic(pictures);
        param.setPhoto(pic);
        cgshangbaoService.addCgshangbao(param,loginuser);
        this.netGridService.updateNetGridEventStatus("05", distribute.getEventID());
    }else if ("环卫部门".equals(user.getDept())){
        Hwshangbao param = new Hwshangbao();
        param.setSource("综治网格联动问题");
        param.setSourceId(distribute.getEventID().intValue());
        LoginUserTest loginuser = new LoginUserTest();
        loginuser.setLoginId("综治部门");
        param.setY(String.valueOf(netGridEventDetailBasic.getEventHappenLatitude()));
        param.setX(String.valueOf(netGridEventDetailBasic.getEventHappenLongitude()));
        param.setCategories("其他");
        param.setSmallcategories("其他");
        param.setDizhi1(netGridEventDetailBasic.getNetGridName());
        param.setDizhi2(netGridEventDetailBasic.getNetGridName());
        param.setPeople(netGridEventDetailBasic.getCurrentResponsiblePersonName());
        param.setPhone(netGridEventDetailBasic.getCurrentResponsiblePersonContact());
        param.setMiaoshu(netGridEventDetailBasic.getEventContent());
        param.setIsdeleted("1");
        String pic = getPic(pictures);
        param.setPhoto(pic);
        hwshangbaoService.addHwshangbao(param,loginuser);
        this.netGridService.updateNetGridEventStatus("05", distribute.getEventID());
    }else if ("住建局".equals(user.getDept())){
        LoginUserTest loginuser = new LoginUserTest();
        loginuser.setLoginId("综治部门");
        KeyproProblemDetail detail = new KeyproProblemDetail();
        KeyproProblem problem = new KeyproProblem();
        List<KeyproSource> source = new ArrayList<KeyproSource>();
        problem.setSource("综治网格联动问题");
        problem.setSourceId(String.valueOf(distribute.getEventID()));
        problem.setKeyproProblemTitle(netGridEventDetailBasic.getEventName());
        problem.setKeyproProblemContent(netGridEventDetailBasic.getEventContent());
        problem.setKeyproProblemAddress(netGridEventDetailBasic.getNetGridName());
        problem.setKeyproProblemReportPerson(netGridEventDetailBasic.getCurrentResponsiblePersonName());
        problem.setKeyproProblemReportTime(new Date());
        problem.setKeyproProblemType(netGridEventDetailBasic.getEventStatusTypeName());
        problem.setAttachmentSource("02");
        problem.setProcessState("1");
        problem.setY(String.valueOf(netGridEventDetailBasic.getEventHappenLatitude()));
        problem.setX(String.valueOf(netGridEventDetailBasic.getEventHappenLongitude()));
        detail.setProblem(problem);
        if(pictures != null && pictures.size() > 0){
            for(FileUpdateVO p : pictures){
                KeyproSource s = new KeyproSource();
                s.setFileUrl(p.getUrl());
                source.add(s);
            }
        }
        detail.setSource(source);
        keyproProblemService.addProblem(detail,loginuser);
        this.netGridService.updateNetGridEventStatus("05", distribute.getEventID());
    }
    boolean result = this.netGridService.addNetGridEventDistribute(distribute);
    return ResponseUtil.success(Boolean.valueOf(result));
}

    private String getPic(List<FileUpdateVO> pictures) {
        String pic = ""; int mun = 0;
        if(pictures != null && pictures.size() > 0){
            for(FileUpdateVO p : pictures){
                pic += p.getUrl();
                mun ++;
                if(mun < pictures.size()){
                    pic += ",";
                }
            }
        }
        return pic;
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventDealingBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventDealingBasic(@RequestBody NetGridEventDealing dealing)
/*     */   {
/* 175 */     return ResponseUtil.success(this.netGridService.addNetGridEventDealingBasic(dealing));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventDealingPictures"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventDealingPictures(MultipartFile[] file, Long ID)
/*     */   {
/* 189 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.addNetGridEventDealingPictures(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventDealingVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventDealingVideo(MultipartFile file, Long ID)
/*     */   {
/* 202 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.addNetGridEventDealingVideo(file, ID)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/addNetGridEventChecked"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGridEventChecked(@RequestBody com.jtzh.entity.NetGridEventChecked checked)
/*     */   {
/* 214 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.addNetGridEventChecked(checked)));
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
/*     */   @RequestMapping({"/getNetGridEventReporterQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventReporterQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 232 */     return ResponseUtil.success(this.netGridService.getNetGridEventReporterQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getNetGridEventDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 250 */     return ResponseUtil.success(this.netGridService.getNetGridEventDespatcherQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getNetGridEventDeptDespatcherQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventDeptDespatcherQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 267 */     return ResponseUtil.success(this.netGridService.getNetGridEventDeptDespatcherQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getNetGridEventHandlerQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventHandlerQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 284 */     return ResponseUtil.success(this.netGridService.getNetGridEventHandlerQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getNetGridEventAuditorQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventAuditorQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 301 */     return ResponseUtil.success(this.netGridService.getNetGridEventAuditorQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getNetGridEventAPPQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventAPPQuery(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 318 */     return ResponseUtil.success(this.netGridService.getNetGridEventAPPQuery(id, kind, name, netGridID, status, page, pageSize));
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
/*     */   @RequestMapping({"/getNetGridEventForNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventForNetGrid(Long id, Integer kind, String name, Integer netGridID, String status, int page, int pageSize)
/*     */   {
/* 336 */     return ResponseUtil.success(this.netGridService.getNetGridEventForNetGrid(id, kind, name, netGridID, status, page, pageSize));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/getNetGridEventDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventDetail(Long id)
/*     */   {
/* 348 */     return ResponseUtil.success(this.netGridService.getNetGridEventDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridQuery"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridQuery(String netGridName, String netGridLeaderName, int page, int pageSize) {
/* 354 */     return ResponseUtil.success(this.netGridService.getNetGridQuery(netGridName, netGridLeaderName, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridDetail(Long id) {
/* 360 */     return ResponseUtil.success(this.netGridService.getNetGridDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteNetGrid(Long id) {
/* 366 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.deleteNetGrid(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse addNetGrid(@RequestBody NetGrid netGrid) {
/* 372 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.addNetGrid(netGrid)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateNetGrid(@RequestBody NetGrid netGrid) {
/* 378 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.updateNetGrid(netGrid)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridEventCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridEventCount() {
/* 384 */     return ResponseUtil.success(this.netGridService.getNetGridEventCount());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/isDistribute"})
/*     */   @ResponseBody
/*     */   public ExtResponse isDistribute(Long id) {
/* 390 */     return ResponseUtil.success(Boolean.valueOf(this.netGridService.isDistribute(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridMemberInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridMemberInfo(Long id) {
/* 396 */     return ResponseUtil.success(this.netGridService.getNetGridMemberInfo(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridMemberByFatherID"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridMemberByFatherID(Long id) {
/* 402 */     return ResponseUtil.success(this.netGridService.getNetGridMemberByFatherID(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridMemberDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridMemberDetailToUpdate(Long id) {
/* 408 */     return ResponseUtil.success(this.netGridService.getNetGridMemberDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNetGridByFaterID"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNetGridByFaterID(Long netGridID) {
/* 414 */     return ResponseUtil.success(this.netGridService.getNetGridByFaterID(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAllNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAllNetGrid() {
/* 420 */     return ResponseUtil.success(this.netGridService.getAllNetGrid());
/*     */   }
@RequestMapping({"/returnNetGirdEvent"})
@ResponseBody
public ExtResponse returnNetGirdEvent(@RequestBody Tenetgrideventreturn tenetgrideventreturn){
    return ResponseUtil.success(Boolean.valueOf(netGridService.deleteNetGridEventDistribute(tenetgrideventreturn)));
}

}

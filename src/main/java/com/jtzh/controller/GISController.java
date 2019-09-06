/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.gis.ServedPersonBasicVO;
/*     */ import com.jtzh.vo.gis.ServedPersonCountVO;
import com.jtzh.common.ExtResponse;
import com.jtzh.mapper.KeyPetitionersMapper;
import com.jtzh.service.GISService;
import com.jtzh.service.NonpublicService;

/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ @CrossOrigin
/*     */ @Controller
/*     */ @RequestMapping({"/api/gis"})
/*     */ public class GISController
/*     */ {
/*     */   @Autowired
/*     */   private GISService gisService;
/*     */   @Autowired
/*     */   private NonpublicService nonpublicService;
/*     */   @Autowired
/*     */   private KeyPetitionersMapper keyPetitionersMapper;
/*     */   
/*     */   @RequestMapping({"/getCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse<List<ServedPersonCountVO>> getCount(Long netGridID)
/*     */   {
/*  35 */     List<ServedPersonCountVO> counts = this.gisService.getCount(netGridID);
/*  36 */     return ResponseUtil.success(counts);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getCountByNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse<List<ServedPersonCountVO>> getCountByNetGrid(String servedPersonTypeValue, String netGridID) {
/*  42 */     List<ServedPersonCountVO> counts = this.gisService.getCountByNetGrid(servedPersonTypeValue, netGridID);
/*  43 */     return ResponseUtil.success(counts);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getServedPersonBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse<List<ServedPersonCountVO>> getServedPersonBasic(@RequestParam("servedPersonTypeValue") String servedPersonTypeValue)
/*     */   {
/*  50 */     List<ServedPersonBasicVO> ServedPersonBasic = this.gisService.getServedPersonBasic(servedPersonTypeValue);
/*  51 */     return ResponseUtil.success(ServedPersonBasic);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getServedPersonBasicByNetGrid"})
/*     */   @ResponseBody
/*     */   public ExtResponse<List<ServedPersonCountVO>> getServedPersonBasicByNetGrid(String servedPersonTypeValue, String netGridID)
/*     */   {
/*  58 */     List<ServedPersonBasicVO> ServedPersonBasic = this.gisService.getServedPersonBasicByNetGrid(servedPersonTypeValue, netGridID);
/*     */     
/*  60 */     return ResponseUtil.success(ServedPersonBasic);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSpecialPopulationCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSpecialPopulationCount(Long netGridID) {
/*  66 */     return ResponseUtil.success(this.gisService.getSpecialPopulationCount(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAIDSdiseaseWithLocation"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAIDSdiseaseWithLocation(Long netGridID) {
/*  72 */     return ResponseUtil.success(this.gisService.getAIDSdiseaseWithLocation(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getCommunityCorrectionerWithLocation"})
/*     */   @ResponseBody
/*     */   public ExtResponse getCommunityCorrectionerWithLocation(Long netGridID) {
/*  78 */     return ResponseUtil.success(this.gisService.getCommunityCorrectionerWithLocation(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getEmancipistWithLocation"})
/*     */   @ResponseBody
/*     */   public ExtResponse getEmancipistWithLocation(Long netGridID) {
/*  84 */     return ResponseUtil.success(this.gisService.getEmancipistWithLocation(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDrugAddictsWithLocation"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDrugAddictsWithLocation(Long netGridID) {
/*  90 */     return ResponseUtil.success(this.gisService.getDrugAddictsWithLocation(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSeverePsychoticWithLocation"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSeverePsychoticWithLocation(Long netGridID) {
/*  96 */     return ResponseUtil.success(this.gisService.getSeverePsychoticWithLocation(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyYoungersWithLocation"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyYoungersWithLocation(Integer netGridID) {
/* 102 */     return ResponseUtil.success(this.gisService.getKeyYoungersWithLocation(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyPetitionersWithLocation"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyPetitionersWithLocation(Integer netGridID) {
/* 108 */     return ResponseUtil.success(this.gisService.getKeyPetitionersWithLocation(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAllSocietyOrg"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAllSocietyOrg(Long netGridID) {
/* 114 */     return ResponseUtil.success(this.gisService.getAllSocietyOrg(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAllNonPublicEconomyOrg"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAllNonPublicEconomyOrg(Long netGridID) {
/* 120 */     return ResponseUtil.success(this.gisService.getAllNonPublicEconomyOrg(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getAllDisputeEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse getAllDisputeEvent() {
/* 126 */     return ResponseUtil.success(this.gisService.getAllDisputeEvent());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDisputeEventByConditional"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDisputeEventByConditional(String key) {
/* 132 */     return ResponseUtil.success(this.gisService.selectForGIS(key));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getOrgCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getOrgCount(Long netGridID) {
/* 138 */     return ResponseUtil.success(this.gisService.getOrgCount(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDisputeEventCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDisputeEventCount(Long netGridID) {
/* 144 */     return ResponseUtil.success(this.gisService.getDisputeEventCount(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSolveEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSolveEvent(Long netGridID) {
/* 150 */     return ResponseUtil.success(this.gisService.getSolveEvent(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getUnSolveEvent"})
/*     */   @ResponseBody
/*     */   public ExtResponse getUnSolveEvent(Long netGridID) {
/* 156 */     return ResponseUtil.success(this.gisService.getUnSolveEvent(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getVideoPieCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getVideoPieCount() {
/* 162 */     return ResponseUtil.success(this.gisService.getVideoPieCount());
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getVideoByNetGridID"})
/*     */   @ResponseBody
/*     */   public ExtResponse getVideoByNetGridID(Integer netGridID) {
/* 168 */     return ResponseUtil.success(this.gisService.getVideoByNetGridID(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getServedRecordForGIS"})
/*     */   @ResponseBody
/*     */   public ExtResponse getServedRecordForGIS(Integer netGridID) {
/* 174 */     return ResponseUtil.success(this.gisService.getServedRecordForGIS(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getTrafficAccidentCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentCount(Long netGridID) {
/* 180 */     return ResponseUtil.success(this.gisService.getTrafficAccidentCount(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getTrafficAccidentByStatus"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentByStatus(String type, Integer netGridID) {
/* 186 */     return ResponseUtil.success(this.gisService.getTrafficAccidentByStatus(type, netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getTrafficAccidentPieCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getTrafficAccidentPieCount(Long netGridID)
/*     */   {
/* 193 */     return ResponseUtil.success(this.gisService.getTrafficAccidentPieCount(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSSEventCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventCount(Long netGridID) {
/* 199 */     return ResponseUtil.success(this.gisService.getSSEventCount(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSSEventByType"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventByType(Integer netGridID, Integer type) {
/* 205 */     return ResponseUtil.success(this.gisService.getSSEventByType(netGridID, type));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSSEventMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse getSSEventMedia(Long id) {
/* 211 */     return ResponseUtil.success(this.gisService.getSSEventMedia(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDutyPoint"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDutyPoint(Integer netGridID) {
/* 217 */     return ResponseUtil.success(this.gisService.getDutyPoint(netGridID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getDutyPointMedia"})
/*     */   @ResponseBody
/*     */   public ExtResponse getDutyPointMedia(Long id) {
/* 223 */     return ResponseUtil.success(this.gisService.getDutyPointMedia(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNonPublicEconomyOrgDetailForGIS"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNonPublicEconomyOrgDetailForGIS(Integer netGridID, Integer isLogisticsEnterprise, Integer isKeyEnterprise)
/*     */   {
/* 230 */     return ResponseUtil.success(this.nonpublicService
/* 231 */       .getNonPublicEconomyOrgDetailForGIS(netGridID, isLogisticsEnterprise, isKeyEnterprise));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getNonPublicEconomyOrgDetailByCode"})
/*     */   @ResponseBody
/*     */   public ExtResponse getNonPublicEconomyOrgDetailByCode(String code) {
/* 237 */     return ResponseUtil.success(this.nonpublicService.getNonPublicEconomyOrgDetailByCode(code));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getKeyYoungersCountForGIS"})
/*     */   @ResponseBody
/*     */   public ExtResponse getKeyYoungersCountForGIS(Long netGridID) {
/* 243 */     return ResponseUtil.success(this.gisService.getKeyYoungersCountForGIS(netGridID));
/*     */   }

            @RequestMapping({"/getRealTimeLocation"})
            @ResponseBody
            public ExtResponse getRealTimeLocation(Long netGridID)
            {
                return ResponseUtil.success(this.gisService.getRealTimeLocation(netGridID));
            }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\GISController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
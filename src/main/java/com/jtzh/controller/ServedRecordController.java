/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.exception.MsmisException;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.orgMember.ServedPersonBasicResponseVO;
/*     */ import com.jtzh.vo.served.ServedPersonBasicAddVO;
/*     */ import com.jtzh.vo.served.ServedPersonBasicQueryVO;
/*     */ import com.jtzh.vo.served.SpecialAIDSAddVO;
/*     */ import com.jtzh.vo.served.SpecialDrugAddVO;
/*     */ import com.jtzh.vo.served.SpecialEmancipistAddVO;
/*     */ import com.jtzh.vo.served.SpecialPsychoticAddVO;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.CODEServedPersonType;
import com.jtzh.entity.ServedPersonBasic;
import com.jtzh.entity.ServedPersonExtendFloatingPopulation;
import com.jtzh.entity.ServedPersonExtendResident;
import com.jtzh.entity.ServedPersonExtendStayedPerson;
import com.jtzh.service.OrgMemberService;
import com.jtzh.service.ServedPersonRecordService;
import com.jtzh.service.ServedPersonService;

/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
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
/*     */ @CrossOrigin
/*     */ @RequestMapping({"/api/served"})
/*     */ @Controller
/*     */ public class ServedRecordController
/*     */ {
/*     */   @Autowired
/*     */   private ServedPersonService servedPersonService;
/*     */   @Autowired
/*     */   private OrgMemberService orgMemberService;
/*     */   @Autowired
/*     */   private ServedPersonRecordService servedPersonRecordService;
/*     */   
/*     */   @RequestMapping({"/spTypes"})
/*     */   @ResponseBody
/*     */   public ExtResponse<List<CODEServedPersonType>> getServedPersonType()
/*     */   {
/*  58 */     List<CODEServedPersonType> types = this.servedPersonService.getServedPersonType();
/*  59 */     return ResponseUtil.success(types);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/allTypes"})
/*     */   @ResponseBody
/*     */   public ExtResponse<List<CODEServedPersonType>> getAllTypes()
/*     */   {
/*  66 */     HashMap<String, List> types = this.servedPersonService.getAllTypes();
/*  67 */     return ResponseUtil.success(types);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/image/upload"})
/*     */   @ResponseBody
/*     */   public ExtResponse<Long> uploadImage(@RequestParam("file") MultipartFile file) {
/*  73 */     long i = this.servedPersonService.uploadServedPersonPhoto(file);
/*     */     
/*  75 */     if (i == 0L) {
/*  76 */       throw new MsmisException("图片上传失败!");
/*     */     }
/*     */     
/*  79 */     return ResponseUtil.success(Long.valueOf(i));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addServedPersonBasic(@RequestBody ServedPersonBasicAddVO vo) {
/*  85 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonService.addServedPersonBasic(vo)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/query"})
/*     */   @ResponseBody
/*     */   public ExtResponse query(@RequestBody ServedPersonBasicQueryVO vo) {
/*  91 */     ServedPersonBasicResponseVO vos = this.servedPersonService.query(vo);
/*  92 */     return ResponseUtil.success(vos);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addFloating"})
/*     */   @ResponseBody
/*     */   public ExtResponse addFloating(@RequestBody ServedPersonExtendFloatingPopulation request) {
/*  98 */     boolean flag = this.servedPersonService.addFloating(request);
/*  99 */     if (flag) {
/* 100 */       return ResponseUtil.success(null);
/*     */     }
/* 102 */     return ResponseUtil.error("添加失败");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addResident"})
/*     */   @ResponseBody
/*     */   public ExtResponse addResident(@RequestBody ServedPersonExtendResident request)
/*     */   {
/* 109 */     boolean flag = this.servedPersonService.addResident(request);
/* 110 */     if (flag) {
/* 111 */       return ResponseUtil.success(null);
/*     */     }
/* 113 */     return ResponseUtil.error("添加失败");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addStayed"})
/*     */   @ResponseBody
/*     */   public ExtResponse addStayed(@RequestBody ServedPersonExtendStayedPerson request)
/*     */   {
/* 120 */     boolean flag = this.servedPersonService.addStayed(request);
/* 121 */     if (flag) {
/* 122 */       return ResponseUtil.success(null);
/*     */     }
/* 124 */     return ResponseUtil.error("添加失败");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addAIDS"})
/*     */   @ResponseBody
/*     */   public ExtResponse addAIDS(@RequestBody SpecialAIDSAddVO request)
/*     */   {
/* 131 */     boolean flag = this.servedPersonService.addAIDS(request);
/* 132 */     if (flag) {
/* 133 */       return ResponseUtil.success(null);
/*     */     }
/* 135 */     return ResponseUtil.error("添加失败");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addDrug"})
/*     */   @ResponseBody
/*     */   public ExtResponse addDrug(@RequestBody SpecialDrugAddVO request)
/*     */   {
/* 142 */     boolean flag = this.servedPersonService.addDrug(request);
/* 143 */     if (flag) {
/* 144 */       return ResponseUtil.success(null);
/*     */     }
/* 146 */     return ResponseUtil.error("添加失败");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addEmancipist"})
/*     */   @ResponseBody
/*     */   public ExtResponse addEmancipist(@RequestBody SpecialEmancipistAddVO request)
/*     */   {
/* 153 */     boolean flag = this.servedPersonService.addEmancipist(request);
/* 154 */     if (flag) {
/* 155 */       return ResponseUtil.success(null);
/*     */     }
/* 157 */     return ResponseUtil.error("添加失败");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addPsychotic"})
/*     */   @ResponseBody
/*     */   public ExtResponse addPsychotic(@RequestBody SpecialPsychoticAddVO request)
/*     */   {
/* 164 */     boolean flag = this.servedPersonService.addPsychotic(request);
/* 165 */     if (flag) {
/* 166 */       return ResponseUtil.success(null);
/*     */     }
/* 168 */     return ResponseUtil.error("添加失败");
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getServedPersonInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse getServedPersonInfo(@RequestParam("certifID") String certifID)
/*     */   {
/* 175 */     return ResponseUtil.success(this.servedPersonService.getServedPersonInfo(certifID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getServedRecordCount"})
/*     */   @ResponseBody
/*     */   public ExtResponse getServedRecordCount() {
/* 181 */     return ResponseUtil.success(this.orgMemberService.getServedRecordCount());
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
/*     */   public ExtResponse addServiceRecord(@RequestParam("orgMemberName") String orgMemberName, @RequestParam("orgMemberCertID") String orgMemberCertID, @RequestParam("servedPersonName") String servedPersonName, @RequestParam("servedPersonCertID") String servedPersonCertID, @RequestParam("servedPersonType") String servedPersonType, @RequestParam("serverInf") String serverInf, @RequestParam("serverDate") String serverDate)
/*     */   {
/* 194 */     return ResponseUtil.success(this.servedPersonRecordService.addServiceRecord(orgMemberName, orgMemberCertID, servedPersonName, servedPersonCertID, servedPersonType, serverInf, serverDate));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addRecordPicture"})
/*     */   @ResponseBody
/*     */   public ExtResponse addRecordPicture(MultipartFile file, Long ID)
/*     */   {
/* 201 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonRecordService.addRecordPicture(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addRecordVideo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addRecordVideo(MultipartFile file, Long ID) {
/* 207 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonRecordService.addRecordVideo(file, ID)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteRecord"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteRecord(Long id) {
/* 213 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonRecordService.deleteRecord(id)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateRecord"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateRecord(Long id, String content, String date) {
/* 219 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonRecordService.updateRecord(id, content, date)));
/*     */   }

			@RequestMapping({"/updateBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateBasic(ServedPersonBasic basic) {
/* 219 */     return ResponseUtil.success(servedPersonService.updateBasic(basic));
/*     */   }
			
			@RequestMapping({"/updateExtendRecord"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateExtendRecord(ServedPersonExtendResident extend) {
/* 219 */     return ResponseUtil.success(servedPersonService.updateExtendRecord(extend));
/*     */   }
			
			@RequestMapping({"/deleteBasic"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteBasic(Long ServedPersonID) {
/* 213 */     return ResponseUtil.success(Boolean.valueOf(this.servedPersonService.deleteBasic(ServedPersonID)));
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\ServedRecordController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
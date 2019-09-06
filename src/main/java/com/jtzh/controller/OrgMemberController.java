/*     */ package com.jtzh.controller;
/*     */ import com.jtzh.util.ResponseUtil;
/*     */ import com.jtzh.vo.orgMember.OrgMemberQueryRequestVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberQueryResponseVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberServedPersonRecoedQueryResponseVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberServedPersonRecordQueryVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberTypesVO;
/*     */ import com.jtzh.vo.orgMember.OrgMemberVO;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.OrgBasicInf;
import com.jtzh.entity.OrgMember;
import com.jtzh.service.OrgMemberService;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @org.springframework.web.bind.annotation.CrossOrigin
/*     */ @Controller
/*     */ @RequestMapping({"/api/orgMember"})
/*     */ public class OrgMemberController
/*     */ {
/*     */   @Autowired
/*     */   private OrgMemberService orgMemberService;
/*     */   
/*     */   @RequestMapping(value={"/get/{orgMemberID}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   public ExtResponse<OrgMemberVO> getByOrgMemberId(@PathVariable long orgMemberID)
/*     */   {
/*  33 */     OrgMemberVO orgMember = this.orgMemberService.getByOrgMemberId(orgMemberID);
/*  34 */     ExtResponse<OrgMemberVO> response = new ExtResponse(orgMember, "", 200);
/*  35 */     return response;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/query"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public ExtResponse<OrgMemberQueryResponseVO> query(@RequestBody OrgMemberQueryRequestVO query) {
/*  41 */     OrgMemberQueryResponseVO result = this.orgMemberService.query(query);
/*  42 */     ExtResponse<OrgMemberQueryResponseVO> response = new ExtResponse(result, "", 200);
/*  43 */     return response;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/updateStatus"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   public String updateStatus(long orgMemberID, int status) {
/*  49 */     boolean flag = this.orgMemberService.updateStatus(orgMemberID, status);
/*  50 */     return !flag ? "error" : "OK";
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public String update(@RequestBody OrgMember member) {
/*  56 */     boolean flag = this.orgMemberService.update(member);
/*  57 */     return !flag ? "error" : "OK";
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getSpecs"})
/*     */   @ResponseBody
/*     */   public OrgMemberTypesVO getSpecs() {
/*  63 */     OrgMemberTypesVO vo = this.orgMemberService.getSpecs();
/*  64 */     return vo;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/add"})
/*     */   @ResponseBody
/*     */   public String add(@RequestBody OrgMemberVO member) {
/*  70 */     boolean flag = this.orgMemberService.add(member);
/*  71 */     return !flag ? "error" : "OK";
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getServiceRecord"})
/*     */   @ResponseBody
/*     */   public ExtResponse<OrgMemberServedPersonRecoedQueryResponseVO> getServiceRecord(@RequestBody OrgMemberServedPersonRecordQueryVO query)
/*     */   {
/*  78 */     OrgMemberServedPersonRecoedQueryResponseVO result = this.orgMemberService.getServiceRecord(query);
/*  79 */     ExtResponse<OrgMemberServedPersonRecoedQueryResponseVO> response = new ExtResponse(result, "", 200);
/*     */     
/*  81 */     return response;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getServedRecordDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getServedRecordDetail(Long orgMServedPID) {
/*  87 */     return ResponseUtil.success(this.orgMemberService.getServedRecordDetail(orgMServedPID));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getOrgMemberByNameAndCertID"})
/*     */   @ResponseBody
/*     */   public ExtResponse getOrgMemberByNameAndCertID(String name, String id)
/*     */   {
/*  94 */     return ResponseUtil.success(this.orgMemberService.getOrgMemberByNameAndCertID(name, id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getOrgBasicInf"})
/*     */   @ResponseBody
/*     */   public ExtResponse getOrgBasicInf(String orgName, String orgType, Integer netGridID, String levelType, int page, int pageSize)
/*     */   {
/* 101 */     return ResponseUtil.success(this.orgMemberService.getOrgBasicInf(orgName, orgType, netGridID, levelType, page, pageSize));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getOrgBasicInfDetail"})
/*     */   @ResponseBody
/*     */   public ExtResponse getOrgBasicInfDetail(Long id) {
/* 107 */     return ResponseUtil.success(this.orgMemberService.getOrgBasicInfDetail(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/getOrgBasicInfDetailToUpdate"})
/*     */   @ResponseBody
/*     */   public ExtResponse getOrgBasicInfDetailToUpdate(Long id) {
/* 113 */     return ResponseUtil.success(this.orgMemberService.getOrgBasicInfDetailToUpdate(id));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/addOrgBasicInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse addOrgBasicInfo(@RequestBody OrgBasicInf inf) {
/* 119 */     return ResponseUtil.success(Boolean.valueOf(this.orgMemberService.addOrgBasicInfo(inf)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/updateOrgBasicInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse updateOrgBasicInfo(@RequestBody OrgBasicInf inf) {
/* 125 */     return ResponseUtil.success(Boolean.valueOf(this.orgMemberService.updateOrgBasicInfo(inf)));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/deleteOrgBasicInfo"})
/*     */   @ResponseBody
/*     */   public ExtResponse deleteOrgBasicInfo(Long id)
/*     */   {
/* 132 */     return ResponseUtil.success(Boolean.valueOf(this.orgMemberService.deleteOrgBasicInfo(id)));
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\OrgMemberController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.service.NetGridMemberService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ @CrossOrigin
/*    */ @Controller
/*    */ @RequestMapping({"/api/netGridMember"})
/*    */ public class NetGridMemberController
/*    */ {
/*    */   @Autowired
/*    */   private NetGridMemberService netGridMemberService;
/*    */   
/*    */   @RequestMapping({"/addNetGridMember"})
/*    */   @ResponseBody
/*    */   public ExtResponse addNetGridMember(@RequestParam(value="file", required=false) MultipartFile file, String netGridMember)
/*    */   {
/* 26 */     return ResponseUtil.success(Boolean.valueOf(this.netGridMemberService.addNetGridMember(file, netGridMember)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateNetGridMember"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateNetGridMember(@RequestParam(value="file", required=false) MultipartFile file, String netGridMember) {
/* 32 */     return ResponseUtil.success(Boolean.valueOf(this.netGridMemberService.updateNetGridMember(file, netGridMember)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/deleteNetGridMember"})
/*    */   @ResponseBody
/*    */   public ExtResponse deleteNetGridMember(Long id) {
/* 38 */     return ResponseUtil.success(Boolean.valueOf(this.netGridMemberService.deleteNetGridMember(id)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getNetGridMemberForOrg"})
/*    */   @ResponseBody
/*    */   public ExtResponse getNetGridMemberForOrg(Long id) {
/* 44 */     return ResponseUtil.success(this.netGridMemberService.getNetGridMemberForOrg(id));
/*    */   }

    @RequestMapping({"/getNetGridMemberByNetGridID"})
    @ResponseBody
    public ExtResponse getNetGridMemberByNetGridID(Long id)
    {
        return ResponseUtil.success(this.netGridMemberService.getNetGridMemberByNetGridID(id));
    }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\NetGridMemberController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
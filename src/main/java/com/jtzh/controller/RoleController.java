/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.Role;
import com.jtzh.service.RoleService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @CrossOrigin
/*    */ @RequestMapping({"/api/role"})
/*    */ public class RoleController
/*    */ {
/*    */   @Autowired
/*    */   private RoleService roleService;
/*    */   
/*    */   @RequestMapping({"/addRoleMenu"})
/*    */   @ResponseBody
/*    */   public ExtResponse addRoleMenu(@RequestBody Role role)
/*    */   {
/* 32 */     return ResponseUtil.success(Boolean.valueOf(this.roleService.addRoleMenu(role)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping({"/updateRoleMenu"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateRoleMenu(@RequestBody Role role)
/*    */   {
/* 44 */     return ResponseUtil.success(Boolean.valueOf(this.roleService.updateRoleMenu(role)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping({"/getAllRoleMenu"})
/*    */   @ResponseBody
/*    */   public ExtResponse getAllRoleMenu()
/*    */   {
/* 56 */     return ResponseUtil.success(this.roleService.getAllRoleMenu());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @RequestMapping({"/deleteRoleMenu"})
/*    */   @ResponseBody
/*    */   public ExtResponse deleteRoleMenu(Long id)
/*    */   {
/* 68 */     return ResponseUtil.success(Boolean.valueOf(this.roleService.deleteRoleMenu(id)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getRoleInfoByID"})
/*    */   @ResponseBody
/*    */   public ExtResponse getRoleInfoByID(Long id) {
/* 74 */     return ResponseUtil.success(this.roleService.getRoleInfoByID(id));
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\RoleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
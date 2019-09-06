/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.User;
import com.jtzh.service.UserService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @CrossOrigin
/*    */ @Controller
/*    */ @RequestMapping({"/api/user"})
/*    */ public class UserController
/*    */ {
/*    */   @Autowired
/*    */   private UserService userService;
/*    */   
/*    */   @RequestMapping({"/addUser"})
/*    */   @ResponseBody
/*    */   public ExtResponse addUser(@RequestBody User user)
/*    */   {
/* 26 */     return ResponseUtil.success(Boolean.valueOf(this.userService.addUser(user)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateUser"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateUser(@RequestBody User user) {
/* 32 */     return ResponseUtil.success(Boolean.valueOf(this.userService.updateUser(user)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/deleteUser"})
/*    */   @ResponseBody
/*    */   public ExtResponse deleteUser(Long id)
/*    */   {
/* 39 */     return ResponseUtil.success(Boolean.valueOf(this.userService.deleteUser(id)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getUserQuery"})
/*    */   @ResponseBody
/*    */   public ExtResponse getUserQuery(String key, int page, int pageSize) {
/* 45 */     return ResponseUtil.success(this.userService.getUserQuery(key, page, pageSize));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getUserDetail"})
/*    */   @ResponseBody
/*    */   public ExtResponse getUserDetail(Long id)
/*    */   {
/* 52 */     return ResponseUtil.success(this.userService.getUserDetail(id));
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\UserController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
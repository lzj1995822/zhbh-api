/*    */ package com.jtzh.controller;
/*    */ import com.jtzh.util.ResponseUtil;
import com.jtzh.common.ExtResponse;
import com.jtzh.entity.House;
import com.jtzh.service.HouseService;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @org.springframework.web.bind.annotation.CrossOrigin
/*    */ @Controller
/*    */ @RequestMapping({"/api/house"})
/*    */ public class HouseController
/*    */ {
/*    */   @Autowired
/*    */   private HouseService houseService;
/*    */   
/*    */   @RequestMapping({"/addHouse"})
/*    */   @ResponseBody
/*    */   public ExtResponse addHouse(@RequestBody House house)
/*    */   {
/* 25 */     return ResponseUtil.success(Boolean.valueOf(this.houseService.addHouse(house)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/updateHouse"})
/*    */   @ResponseBody
/*    */   public ExtResponse updateHouse(@RequestBody House house) {
/* 31 */     return ResponseUtil.success(Boolean.valueOf(this.houseService.updateHouse(house)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/deleteHouse"})
/*    */   @ResponseBody
/*    */   public ExtResponse deleteHouse(Long id) {
/* 37 */     return ResponseUtil.success(Boolean.valueOf(this.houseService.deleteHouse(id)));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getHouseQuery"})
/*    */   @ResponseBody
/*    */   public ExtResponse getHouseQuery(String name, String address, int page, int pageSize) {
/* 43 */     return ResponseUtil.success(this.houseService.getHouseQuery(name, address, page, pageSize));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getHouseDetail"})
/*    */   @ResponseBody
/*    */   public ExtResponse getHouseDetail(Long id) {
/* 49 */     return ResponseUtil.success(this.houseService.getHouseDetail(id));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getHouseDetailToUpdate"})
/*    */   @ResponseBody
/*    */   public ExtResponse getHouseDetailToUpdate(Long id) {
/* 55 */     return ResponseUtil.success(this.houseService.getHouseDetailToUpdate(id));
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getHouseCode"})
/*    */   @ResponseBody
/*    */   public ExtResponse getHouseCode() {
/* 61 */     return ResponseUtil.success(this.houseService.getHouseCode());
/*    */   }
/*    */   
/*    */   @RequestMapping({"/getHouseForGIS"})
/*    */   @ResponseBody
/*    */   public ExtResponse getHouseForGIS() {
/* 67 */     return ResponseUtil.success(this.houseService.getHouseDetailForGIS());
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\controller\HouseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */